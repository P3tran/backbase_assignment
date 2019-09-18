package gr.efthymiou.petros.backbaseassignment.features.bookmarks.map;

import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.material.snackbar.Snackbar;

import gr.efthymiou.petros.backbaseassignment.R;
import gr.efthymiou.petros.backbaseassignment.base.BaseFragment;
import gr.efthymiou.petros.backbaseassignment.base.MainActivity;
import gr.efthymiou.petros.backbaseassignment.features.bookmarks.Coord;
import gr.efthymiou.petros.backbaseassignment.utils.Const;
import gr.efthymiou.petros.backbaseassignment.utils.LocationHelper;

public class AddBookmarkMapFragment extends BaseFragment implements OnMapReadyCallback, MapView {

    private TextView mLocation;
    private GoogleMap mMap;
    private MapPresenter presenter;
    private ProgressBar progressBar;
    private Float mapZoom = 8F;
    private ViewGroup mRoot;

    private GoogleMap.OnCameraIdleListener mCameraIdleListener = new GoogleMap.OnCameraIdleListener() {
        @Override
        public void onCameraIdle() {
            presenter.getTargetLocation(mMap.getCameraPosition().target, getContext());
        }
    };

    private GoogleMap.OnCameraMoveStartedListener mCameraMoveStartedListener = new GoogleMap.OnCameraMoveStartedListener() {
        @Override
        public void onCameraMoveStarted(int i) {
            showLoader();
        }
    };

    public AddBookmarkMapFragment() {
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_add_bookmark_map;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        SupportMapFragment mapFragment = (SupportMapFragment) getChildFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        presenter = new MapPresenterImpl(this);
        progressBar = view.findViewById(R.id.loader);
        mLocation = view.findViewById(R.id.location);
        mRoot = view.findViewById(R.id.add_bookmark_root);

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mMap.setOnCameraIdleListener(mCameraIdleListener);
        mMap.setOnCameraMoveStartedListener(mCameraMoveStartedListener);
        checkLocationPermission();
    }

    @Override
    public void moveMapToCurrentUserLocation(Coord coord) {
        if (mMap != null) {
            CameraUpdate cameraUpdate = CameraUpdateFactory.newLatLngZoom(new LatLng(coord.getLat(), coord.getLon()), mapZoom);
            mMap.animateCamera(cameraUpdate);
        }
    }

    @Override
    public void updateLocation(String location) {
        mLocation.setText(location);
    }

    @Override
    public void showLoader() {
        mLocation.setVisibility(View.INVISIBLE);
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoader() {
        mLocation.setVisibility(View.VISIBLE);
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void bookmarkAdded(String bookmarkName) {
        if (getActivity() != null) {
            getActivity().onBackPressed();
            ((MainActivity) getActivity()).displaySnackbar(getString(R.string.bookmarked) + " " + bookmarkName);
        }
    }

    @Override
    public void emptyAddress() {
        mLocation.setText("");
    }

    private void checkLocationPermission() {

        if (ContextCompat.checkSelfPermission(getContext(),
                android.Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(getActivity(),
                    new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION},
                    Const.MY_PERMISSIONS_REQUEST_ACCESS_FINE_LOCATION);

        } else {
            if (LocationHelper.isLocationEnabled(getContext()))
                presenter.getCurrentUserLocation(getContext());

        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        switch (requestCode) {
            case Const.MY_PERMISSIONS_REQUEST_ACCESS_FINE_LOCATION: {
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    if (LocationHelper.isLocationEnabled(getContext()))
                        presenter.getCurrentUserLocation(getContext());
                    else
                        displayError(R.string.location_permission_denied);
                } else {
                    moveMapToAmsterdamCenter();
                }
                return;
            }
        }
    }

    public void moveMapToAmsterdamCenter() {
        mMap.moveCamera(CameraUpdateFactory.newCameraPosition(CameraPosition.builder()
                .target(new LatLng(52.3667, 4.8945)).zoom(mapZoom).build()));
    }

    @Override
    public void displayError(int errorMessageId) {
        Snackbar.make(mRoot, getString(errorMessageId), Snackbar.LENGTH_LONG).show();
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.menu_add_bookmark, menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.action_add_bookmark) {
            addBookmark();
        }
        return super.onOptionsItemSelected(item);
    }

    private void addBookmark() {
        if (mLocation.getText().toString().isEmpty())
            displayError(R.string.no_bookmark_name);
        else
            presenter.addBookmark(mMap.getCameraPosition().target, mLocation.getText().toString(), getContext());
    }
}
