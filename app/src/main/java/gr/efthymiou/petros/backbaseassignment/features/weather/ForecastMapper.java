package gr.efthymiou.petros.backbaseassignment.features.weather;


import android.view.View;

import androidx.arch.core.util.Function;

import java.util.ArrayList;
import java.util.List;

import gr.efthymiou.petros.backbaseassignment.R;
import gr.efthymiou.petros.backbaseassignment.features.weather.models.Forecast;
import gr.efthymiou.petros.backbaseassignment.features.weather.models.ForecastDomain;
import gr.efthymiou.petros.backbaseassignment.utils.DateUtils;

public class ForecastMapper implements Function<List<ForecastDomain>, List<Forecast>> {

    @Override
    public List<Forecast> apply(List<ForecastDomain> input) {

        List<Forecast> result = new ArrayList<>();
        for (ForecastDomain domain : input) {
            result.add(mapToUI(domain));
        }
        return result;
    }

    private Forecast mapToUI(ForecastDomain input) {
        return new Forecast(
                mapDate(input.getTimestamp()),
                input.getTitle(),
                input.getDescription(),
                mapTemperature(input.getTemp()),
                mapTempMinMax(input.getTempMin(), input.getTempMax()),
                mapHumidity(input.getHumidity()),
                mapIcon(input.getIcon()),
                mapWindInfo(input.getWindSpeed()),
                mapRainInfo(input.getOneHourRain(), input.getThreeHourRain()),
                mapRainVisibility(input.getOneHourRain(), input.getThreeHourRain())
        );
    }

    private int mapIcon(String icon) {
        switch (icon) {
            case "01d":
                return R.mipmap.ic_01d;
            case "01n":
                return R.mipmap.ic_01n;
            case "02d":
                return R.mipmap.ic_02d;
            case "02n":
                return R.mipmap.ic_02n;
            case "03d":
                return R.mipmap.ic_03d;
            case "03n":
                return R.mipmap.ic_03n;
            case "04d":
                return R.mipmap.ic_04d;
            case "04n":
                return R.mipmap.ic_04n;
            case "09n":
                return R.mipmap.ic_09n;
            case "09d":
                return R.mipmap.ic_09d;
            case "10d":
                return R.mipmap.ic_10d;
            case "10n":
                return R.mipmap.ic_10n;
            case "11d":
                return R.mipmap.ic_11d;
            case "11n":
                return R.mipmap.ic_11n;
            case "13d":
                return R.mipmap.ic_13d;
            case "13n":
                return R.mipmap.ic_13n;
            case "50n":
                return R.mipmap.ic_50n;
            default:
                return R.mipmap.ic_50d;

        }
    }

    private int mapRainVisibility(double oneHourRain, double threeHourRain) {
        return View.VISIBLE;
    }

    private String mapRainInfo(double oneHourRain, double threeHourRain) {
        return "1h: " + oneHourRain + ", 3h: " + threeHourRain;
    }

    private String mapWindInfo(double windSpeed) {
        return windSpeed + " m/s";
    }

    private String mapHumidity(int humidity) {
        return humidity + " %";
    }

    private String mapTempMinMax(double tempMin, double tempMax) {
        return Math.round(tempMin) + " &#8451; - " + Math.round(tempMax) + " &#8451;";
    }

    private String mapTemperature(double temp) {
        return Math.round(temp) + " &#8451;";
    }

    private String mapDate(long timestamp) {
        return DateUtils.formatDate(timestamp, "dd/MM/yyyy");
    }


}
