package gr.efthymiou.petros.backbaseassignment.features.bookmarks.map;

import android.content.Context;

import com.google.android.gms.maps.model.LatLng;

import gr.efthymiou.petros.backbaseassignment.R;
import gr.efthymiou.petros.backbaseassignment.features.bookmarks.Bookmark;
import gr.efthymiou.petros.backbaseassignment.features.bookmarks.BookmarksInteractor;
import gr.efthymiou.petros.backbaseassignment.features.bookmarks.BookmarksInteractorImpl;
import gr.efthymiou.petros.backbaseassignment.features.bookmarks.Coord;

public class MapPresenterImpl implements MapPresenter,
        MapInteractor.OnGetTargetLocationFinishedListener,
        MapInteractor.OnGetUserLocationFinishedListener,
        BookmarksInteractor.AddBookmarkFinishListener {

    private MapView mapView;
    private MapInteractor mapInteractor;
    private BookmarksInteractor bookmarksInteractor;

    public MapPresenterImpl(MapView loginView) {
        this.mapView = loginView;
        this.mapInteractor = new MapInteractorImpl();
        this.bookmarksInteractor = new BookmarksInteractorImpl();
    }

    @Override
    public void getTargetLocation(LatLng latLng, Context context) {
        if (mapView != null) {
            mapView.showLoader();
        }
        mapInteractor.getTargetLocation(new Coord(latLng.latitude, latLng.longitude), context, this);
    }

    @Override
    public void onTargetLocationError() {
        if (mapView != null) {
            mapView.hideLoader();
            mapView.emptyAddress();
        }
    }

    @Override
    public void onTargetLocationSuccess(String address) {
        if (mapView != null) {
            mapView.hideLoader();
            mapView.updateLocation(address);
        }
    }

    @Override
    public void getCurrentUserLocation(Context context) {
        mapInteractor.getCurrentUserLocation(context, this);
    }

    @Override
    public void addBookmark(LatLng latLng, String name, Context ctx) {
        bookmarksInteractor.addBookmark(new Bookmark(name, new Coord(latLng.latitude, latLng.longitude)), this, ctx);
    }

    @Override
    public void onGetCurrentUserLocationSuccess(Coord coord) {
        if (mapView != null) {
            mapView.moveMapToCurrentUserLocation(coord);
        }
    }

    @Override
    public void onGetCurrentUserLocationError() {
        //TODO
    }

    @Override
    public void onAddSuccess(String name) {
        if (mapView != null)
            mapView.bookmarkAdded(name);
    }

    @Override
    public void onAddFailure() {
        if (mapView != null)
            mapView.displayError(R.string.general_error);
    }
}
