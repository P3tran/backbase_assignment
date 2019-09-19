package gr.efthymiou.petros.backbaseassignment.features.weather;

import android.content.Context;

import java.util.List;

import gr.efthymiou.petros.backbaseassignment.features.bookmarks.Coord;
import gr.efthymiou.petros.backbaseassignment.features.weather.models.ForecastDomain;

public interface WeatherForecastInteractor {

    void getForecast(Coord coord, GetForecastFinishListener listener, Context ctx);

    interface GetForecastFinishListener {

        void onSuccess(List<ForecastDomain> forecast);

        void onFailure();

    }
}
