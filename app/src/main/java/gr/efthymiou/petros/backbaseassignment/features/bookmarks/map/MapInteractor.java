package gr.efthymiou.petros.backbaseassignment.features.bookmarks.map;

import android.content.Context;

import gr.efthymiou.petros.backbaseassignment.features.bookmarks.Coord;

public interface MapInteractor {


    interface OnGetTargetLocationFinishedListener {

        void onTargetLocationError();

        void onTargetLocationSuccess(String location);

    }

    interface OnGetUserLocationFinishedListener {
        void onGetCurrentUserLocationError();

        void onGetCurrentUserLocationSuccess(Coord coord);
    }

    void getTargetLocation(Coord coord, Context ctx, OnGetTargetLocationFinishedListener listener);

    void getCurrentUserLocation(Context context, OnGetUserLocationFinishedListener listener);

}
