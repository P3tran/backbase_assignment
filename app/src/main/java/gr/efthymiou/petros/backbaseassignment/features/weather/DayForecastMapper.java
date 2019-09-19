package gr.efthymiou.petros.backbaseassignment.features.weather;


import android.view.View;

import androidx.arch.core.util.Function;

import java.util.ArrayList;
import java.util.List;

import gr.efthymiou.petros.backbaseassignment.R;
import gr.efthymiou.petros.backbaseassignment.features.weather.models.DayForecast;
import gr.efthymiou.petros.backbaseassignment.features.weather.models.Forecast;
import gr.efthymiou.petros.backbaseassignment.features.weather.models.ForecastDomain;
import gr.efthymiou.petros.backbaseassignment.utils.DateUtils;

public class DayForecastMapper implements Function<List<ForecastDomain>, List<DayForecast>> {

    @Override
    public List<DayForecast> apply(List<ForecastDomain> input) {

        List<DayForecast> result = new ArrayList<>();

        List<String> allDates = new ArrayList<>();
        for (ForecastDomain domain : input) {
            if (!allDates.contains(domain.getDate()))
                allDates.add(domain.getDate());
        }

        for (String date : allDates) {
            List<ForecastDomain> domainsToAddInDay = new ArrayList<>();
            for (ForecastDomain domain: input) {
                if(domain.getDate().equals(date))
                    domainsToAddInDay.add(domain);
            }
            result.add(mapToDayForecast(domainsToAddInDay));
        }
        return result;
    }

    private DayForecast mapToDayForecast(List<ForecastDomain> inputs) {
        return new DayForecast(
                inputs.get(0).getDate(),
                mapTempMinMax(inputs.get(0).getTempMin(), inputs.get(0).getTempMax()),
                mapForecasts(inputs)
        );
    }

    private List<Forecast> mapForecasts(List<ForecastDomain> input) {
        List<Forecast> forecasts = new ArrayList<>();

        for(ForecastDomain domain: input) {
            forecasts.add(mapDomainToUI(domain));
        }
        return forecasts;
    }

    private Forecast mapDomainToUI(ForecastDomain input) {
        return new Forecast(
                mapDate(input.getTimestamp()),
                input.getTitle(),
                input.getDescription(),
                mapTemperature(input.getTemp()),
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

    private int mapRainVisibility(Double oneHourRain, Double threeHourRain) {
        if (oneHourRain == null && threeHourRain == null)
            return View.GONE;
        return View.VISIBLE;
    }

    private String mapRainInfo(Double oneHourRain, Double threeHourRain) {
        String result = "";
        if (oneHourRain != null)
            result = "1h: " + oneHourRain;
        if (threeHourRain != null)
            result = result + " 3h: " + threeHourRain;
        return result;
    }

    private String mapWindInfo(Double windSpeed) {
        if (windSpeed != null)
            return windSpeed + " m/s";
        return "-";
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
