package gr.efthymiou.petros.backbaseassignment.features.weather;

import java.util.List;

import gr.efthymiou.petros.backbaseassignment.base.GenericView;
import gr.efthymiou.petros.backbaseassignment.features.weather.models.Forecast;

public interface WeatherForecastView extends GenericView {

    void displayForecast(List<Forecast> forecast);
}
