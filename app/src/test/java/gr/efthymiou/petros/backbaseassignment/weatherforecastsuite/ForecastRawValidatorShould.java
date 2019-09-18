package gr.efthymiou.petros.backbaseassignment.weatherforecastsuite;

import org.junit.Test;

import gr.efthymiou.petros.backbaseassignment.base.mockobjects.MockForecasts;
import gr.efthymiou.petros.backbaseassignment.features.weather.ForecastRawValidator;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ForecastRawValidatorShould {

    private ForecastRawValidator validator= new ForecastRawValidator();

    @Test
    public void returnTrueOnFullObject() {
        assertTrue(validator.apply(MockForecasts.forecastRawFull));
    }

    @Test
    public void returnFalseWhenWeatherIsNull() {
        assertFalse(validator.apply(MockForecasts.forecastRawNullWeather));
    }

    @Test
    public void returnFalseWhenWeatherIsEmpty() {
        assertFalse(validator.apply(MockForecasts.forecastRawEmptyWeather));
    }

    @Test
    public void returnFalseWhenMainIsEmpty() {
        assertFalse(validator.apply(MockForecasts.forecastNullMain));
    }

    @Test
    public void returnFalseWheTitleIsNull() {
        assertFalse(validator.apply(MockForecasts.forecastRawWeatherMissingTitle));
    }

    @Test
    public void returnFalseWhenDateIsNull() {
        assertFalse(validator.apply(MockForecasts.forecastRawDateNull));
    }

    @Test
    public void returnTrueWhenRainIsNull() {
        assertTrue(validator.apply(MockForecasts.forecastRawNullRain));
    }

    @Test
    public void returnTrueWhenWindIsNull() {
        assertTrue(validator.apply(MockForecasts.forecastRawNullWind));
    }

}
