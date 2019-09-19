package gr.efthymiou.petros.backbaseassignment.weatherforecastsuite;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import gr.efthymiou.petros.backbaseassignment.application.mockobjects.MockForecasts;
import gr.efthymiou.petros.backbaseassignment.application.mockobjects.MockForecastsRawValidator;
import gr.efthymiou.petros.backbaseassignment.features.weather.ForecastMapperDomain;
import gr.efthymiou.petros.backbaseassignment.features.weather.models.ForecastDomain;

import static org.junit.Assert.assertEquals;

public class DayForecastMapperDomainShould {

    private ForecastMapperDomain mapper = new ForecastMapperDomain(new MockForecastsRawValidator());

    @Test
    public void mapForecast5DaysRawToForecastDomainList() {
        List<ForecastDomain> result = mapper.apply(MockForecasts.forecast5DaysRaw);
        assertEquals(result, new ArrayList<ForecastDomain>(){{ add(MockForecasts.forecastDomain); add(MockForecasts.forecastDomain); add(MockForecasts.forecastDomain); }} );
    }
}
