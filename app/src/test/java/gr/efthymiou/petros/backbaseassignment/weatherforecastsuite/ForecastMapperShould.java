package gr.efthymiou.petros.backbaseassignment.weatherforecastsuite;

import org.junit.Test;

import gr.efthymiou.petros.backbaseassignment.R;
import gr.efthymiou.petros.backbaseassignment.features.weather.ForecastMapper;
import gr.efthymiou.petros.backbaseassignment.features.weather.models.Forecast;

import static gr.efthymiou.petros.backbaseassignment.base.mockobjects.MockForecasts.*;
import static org.junit.Assert.assertEquals;

public class ForecastMapperShould {

    private ForecastMapper mapper = new ForecastMapper();
    private Forecast result = mapper.apply(forecastsDomain).get(0);


    @Test
    public void mapTemperature() {
        assertEquals("10 &#8451;", result.getTemp());
    }

    @Test
    public void mapTemperatureMinMax() {
        assertEquals("5 &#8451; - 15 &#8451;", result.getTempMinMax());
    }

    @Test
    public void mapDateToddMMyyyy() {
        assertEquals("22/09/2019", result.getDate());
    }

    @Test
    public void mapHumidity() {
        assertEquals("40 %", result.getHumidity());
    }

    @Test
    public void mapWind() {
        assertEquals("10.0 m/s", result.getWindInfo());
    }

    @Test
    public void mapRainInfo() {
        assertEquals("1h: 2.0, 3h: 1.1", result.getRainInfo());
    }

    @Test
    public void mapIconId() {
        assertEquals(R.mipmap.ic_01d, result.getIconId());
    }

    @Test public void keepSameTitle() {
        assertEquals(forecastsDomain.get(0).getTitle(), result.getTitle());
    }

    @Test public void keepSameDescription() {
        assertEquals(forecastsDomain.get(0).getDescription(), result.getDescription());
    }
}
