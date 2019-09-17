package gr.efthymiou.petros.backbaseassignment.features.bookmarks.map;

import android.content.Context;

import com.google.android.gms.maps.model.LatLng;

import gr.efthymiou.petros.backbaseassignment.features.bookmarks.Coord;

public interface MapPresenter {

    void getTargetLocation(LatLng latLng, Context context);

    void getCurrentUserLocation(Context context);

    void addBookmark(LatLng latLng, String name, Context ctx);
}
