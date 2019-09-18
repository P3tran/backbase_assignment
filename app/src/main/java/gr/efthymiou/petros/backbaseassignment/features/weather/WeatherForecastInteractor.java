package gr.efthymiou.petros.backbaseassignment.features.weather;

import java.util.List;

import gr.efthymiou.petros.backbaseassignment.features.bookmarks.Coord;
import gr.efthymiou.petros.backbaseassignment.features.weather.models.ForecastDomain;

public interface WeatherForecastInteractor {

    void getForecast(Coord coord, GetForecastFinishListener listener);

    interface GetForecastFinishListener {

        void onSuccess(List<ForecastDomain> forecast);

        void onFailure();

    }
}
