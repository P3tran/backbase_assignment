package gr.efthymiou.petros.backbaseassignment.weatherforecastsuite;

import org.junit.Test;

import gr.efthymiou.petros.backbaseassignment.R;
import gr.efthymiou.petros.backbaseassignment.features.weather.DayForecastMapper;
import gr.efthymiou.petros.backbaseassignment.features.weather.models.DayForecast;
import gr.efthymiou.petros.backbaseassignment.features.weather.models.Forecast;

import static gr.efthymiou.petros.backbaseassignment.base.mockobjects.MockForecasts.*;
import static org.junit.Assert.assertEquals;

public class DayForecastMapperShould {

    private DayForecastMapper mapper = new DayForecastMapper();
    private DayForecast resultDay = mapper.apply(forecastsDomain).get(0);
    private Forecast resultForecast = resultDay.getHourlyForecasts().get(0);


    @Test
    public void mapTemperature() {
        assertEquals("10 &#8451;", resultForecast.getTemp());
    }

    @Test
    public void mapTemperatureMinMax() {
        assertEquals("5 &#8451; - 15 &#8451;", resultDay.getTempMinMax());
    }

    @Test
    public void mapDateToddMMyyyy() {
        assertEquals("22/09/2019", resultForecast.getTime());
    }

    @Test
    public void mapHumidity() {
        assertEquals("40 %", resultForecast.getHumidity());
    }

    @Test
    public void mapWind() {
        assertEquals("10.0 m/s", resultForecast.getWindInfo());
    }

    @Test
    public void mapRainInfo() {
        assertEquals("1h: 2.0 3h: 1.1", resultForecast.getRainInfo());
    }

    @Test
    public void mapIconId() {
        assertEquals(R.mipmap.ic_01d, resultForecast.getIconId());
    }

    @Test public void keepSameTitle() {
        assertEquals(forecastsDomain.get(0).getTitle(), resultForecast.getTitle());
    }

    @Test public void keepSameDescription() {
        assertEquals(forecastsDomain.get(0).getDescription(), resultForecast.getDescription());
    }
}
