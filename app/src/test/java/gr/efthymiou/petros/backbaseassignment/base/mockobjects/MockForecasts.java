package gr.efthymiou.petros.backbaseassignment.base.mockobjects;

import java.util.ArrayList;
import java.util.List;

import gr.efthymiou.petros.backbaseassignment.features.weather.models.ForecastDomain;
import gr.efthymiou.petros.backbaseassignment.features.weather.models.network.Forecast5daysRaw;
import gr.efthymiou.petros.backbaseassignment.features.weather.models.network.ForecastRaw;
import gr.efthymiou.petros.backbaseassignment.features.weather.models.network.ForecastRawMain;
import gr.efthymiou.petros.backbaseassignment.features.weather.models.network.ForecastRawRain;
import gr.efthymiou.petros.backbaseassignment.features.weather.models.network.ForecastRawWeather;
import gr.efthymiou.petros.backbaseassignment.features.weather.models.network.ForecastRawWind;

public class MockForecasts {


    private static final ForecastRawMain mainFull = new ForecastRawMain(
            10.0,
            5.4,
            15.0,
            40
    );

    private static final ForecastRawWeather weatherFull = new ForecastRawWeather(
            800,
            "All good",
            "Best day ever",
            "01d"
    );

    private static final ForecastRawWeather weatherMissingTitle = new ForecastRawWeather(
            800,
            null,
            "Best day ever",
            "01d"
    );

    private static final ForecastRawWind wind = new ForecastRawWind(
            10,
            90
    );

    private static final ForecastRawRain rain =  new ForecastRawRain(
            1.1,
            2.0
    );

    public static final ForecastRaw forecastRawFull = new ForecastRaw (
            1569121200,
            mainFull,
            new ArrayList<ForecastRawWeather>() {{ add(weatherFull); }},
            wind,
            rain,
            "2019-09-22 03:00:00"
    );

    public static final ForecastRaw forecastRawNullWind = new ForecastRaw (
            1569121200,
            mainFull,
            new ArrayList<ForecastRawWeather>() {{ add(weatherFull); }},
            null,
            rain,
            "2019-09-22 03:00:00"
    );

    public static final ForecastRaw forecastRawNullRain = new ForecastRaw (
            1569121200,
            mainFull,
            new ArrayList<ForecastRawWeather>() {{ add(weatherFull); }},
            wind,
            null,
            "2019-09-22 03:00:00"
    );

    public static final ForecastRaw forecastRawNullWeather = new ForecastRaw(
            1569121200,
            mainFull,
            new ArrayList<>(),
            wind,
            rain,
            "2019-09-22 03:00:00"
    );

    public static final ForecastRaw forecastRawEmptyWeather = new ForecastRaw(
            1569121200,
            mainFull,
            null,
            wind,
            rain,
            "2019-09-22 03:00:00"
    );

    public static final ForecastRaw forecastRawWeatherMissingTitle = new ForecastRaw(
            1569121200,
            mainFull,
            new ArrayList<ForecastRawWeather>() {{ add(weatherMissingTitle); }},
            wind,
            rain,
            "2019-09-22 03:00:00"
    );

    public static final ForecastRaw forecastNullMain = new ForecastRaw (
            1569121200,
            null,
            new ArrayList<ForecastRawWeather>() {{ add(weatherFull); }},
            wind,
            rain,
            "2019-09-22 03:00:00"
    );

    public static final ForecastRaw forecastRawDateNull= new ForecastRaw (
            1569121200,
            mainFull,
            new ArrayList<ForecastRawWeather>() {{ add(weatherFull); }},
            wind,
            rain,
            null
    );

    public static final Forecast5daysRaw forecast5DaysRaw = new Forecast5daysRaw(
            new ArrayList<ForecastRaw>() {{ add(forecastRawFull); add(forecastRawFull); add(forecastRawFull); }}
    );

    public static final ForecastDomain forecastDomain = new ForecastDomain(
            1569121200,
            "22/09/2019",
            800,
            "All good",
            "Best day ever",
            10.0,
            5.4,
            15.0,
            40,
            "01d",
            10,
            90,
            1.1,
            2.0
    );

    public static final List<ForecastDomain> forecastsDomain = new ArrayList<ForecastDomain>() {{
        add(forecastDomain); add(forecastDomain); }
    };

}
