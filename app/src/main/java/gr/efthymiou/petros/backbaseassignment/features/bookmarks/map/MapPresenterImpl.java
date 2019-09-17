package gr.efthymiou.petros.backbaseassignment.features.bookmarks.map;

import android.content.Context;

import com.google.android.gms.maps.model.LatLng;

import gr.efthymiou.petros.backbaseassignment.features.bookmarks.Coord;

public class MapPresenterImpl implements MapPresenter,
        MapInteractor.OnGetTargetLocationFinishedListener, MapInteractor.OnGetUserLocationFinishedListener {

    private MapView mapView;
    private MapInteractor mapInteractor;

    public MapPresenterImpl(MapView loginView) {
        this.mapView = loginView;
        this.mapInteractor = new MapInteractorImpl();
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
            mapView.hideAddress();
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
    public void onGetCurrentUserLocationSuccess(Coord coord) {
        if (mapView != null) {
            mapView.moveMapToCurrentUserLocation(coord);
        }
    }

    @Override
    public void onGetCurrentUserLocationError() {
        //TODO
    }
}
