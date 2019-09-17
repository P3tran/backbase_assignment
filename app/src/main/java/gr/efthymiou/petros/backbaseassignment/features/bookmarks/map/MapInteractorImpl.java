package gr.efthymiou.petros.backbaseassignment.features.bookmarks.map;

import android.content.Context;
import android.location.Geocoder;
import android.location.Location;
import android.util.Log;
import java.util.Locale;

import gr.efthymiou.petros.backbaseassignment.features.bookmarks.Coord;
import gr.efthymiou.petros.backbaseassignment.utils.LocationHelper;

/**
 * Created by petros on 17/9/2017.
 */

public class MapInteractorImpl implements MapInteractor {

    private static final String TAG = MapInteractor.class.getName();

    @Override
    public void getTargetLocation(Coord coord, Context ctx, OnGetTargetLocationFinishedListener listener) {
        Geocoder geocoder = new Geocoder(ctx, Locale.getDefault());
        try {
            android.location.Address address = geocoder.getFromLocation(
                    coord.getLat(),
                    coord.getLon(),
                    1).get(0);
            listener.onTargetLocationSuccess(address.getLocality());
        } catch (Exception e) {
            listener.onTargetLocationError();
        }
    }

    @Override
    public void getCurrentUserLocation(Context context, OnGetUserLocationFinishedListener listener) {
        Location location = LocationHelper.getLocation(context);
        if (location != null) {
            Log.i(TAG, "on get location success, location" + location.toString());
            listener.onGetCurrentUserLocationSuccess(new Coord(location.getLatitude(), location.getLongitude()));
        } else {
            Log.e(TAG, "on get location error");
            listener.onGetCurrentUserLocationError();
        }
    }
}
