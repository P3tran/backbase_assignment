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
            for (ForecastDomain domain : input) {
                if (domain.getDate().equals(date))
                    domainsToAddInDay.add(domain);
            }
            result.add(mapToDayForecast(domainsToAddInDay));
        }
        return result;
    }

    private DayForecast mapToDayForecast(List<ForecastDomain> inputs) {
        return new DayForecast(
                inputs.get(0).getDate(),
                mapTempMinMax(inputs),
                mapForecasts(inputs)
        );
    }

    private List<Forecast> mapForecasts(List<ForecastDomain> input) {
        List<Forecast> forecasts = new ArrayList<>();

        for (ForecastDomain domain : input) {
            forecasts.add(mapDomainToUI(domain));
        }
        return forecasts;
    }

    private Forecast mapDomainToUI(ForecastDomain input) {
        return new Forecast(
                mapTime(input.getTimestamp()),
                input.getTitle(),
                input.getDescription(),
                mapTemperature(input.getTemp()),
                mapHumidity(input.getHumidity()),
                mapIcon(input.getIcon()),
                mapWindInfo(input.getWindSpeed(), input.getWindDeg()),
                mapRainInfo(input.getThreeHourRain()),
                mapRainVisibility(input.getThreeHourRain())
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

    private int mapRainVisibility( Double threeHourRain) {
        if (threeHourRain == null)
            return View.GONE;
        return View.VISIBLE;
    }

    private String mapRainInfo(Double threeHourRain) {
        String result = "";
        if (threeHourRain != null)
            result = String.valueOf(threeHourRain);
        return result;
    }

    private String mapWindInfo(Double windSpeed, Double deg) {
        String direction = "";
        if (deg >= 0.0 && deg <= 90.0)
            direction = ", N/E";
        else if (deg >= 90.0 && deg <= 180.0)
            direction = ", S/E";
        else if (deg >= 180 && deg <= 270)
            direction = ", S/W";
        else if (deg >= 270 && deg <= 396)
            direction = ", N/W";
        if (windSpeed != null)
            return windSpeed + " m/s" + direction;
        return "-";
    }

    private String mapHumidity(int humidity) {
        return humidity + " %";
    }

    private String mapTempMinMax(List<ForecastDomain> inputs) {
        double min = 1000.0;
        double max = -1000.0;
        for (ForecastDomain dm : inputs) {
            if (dm.getTempMin() < min)
                min = dm.getTempMin();
            if(dm.getTempMax() > max)
                max = dm.getTempMax();
        }

        return Math.round(min) + " ℃ - " + Math.round(max) + " ℃";
    }

    private String mapTemperature(double temp) {
        return Math.round(temp) + " ℃";
    }

    private String mapTime(long timestamp) {
        return DateUtils.formatDate(timestamp, "HH:mm");
    }


}
