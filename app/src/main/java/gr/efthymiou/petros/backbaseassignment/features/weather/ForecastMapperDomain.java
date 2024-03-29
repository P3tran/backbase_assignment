package gr.efthymiou.petros.backbaseassignment.features.weather;

import androidx.arch.core.util.Function;

import java.util.ArrayList;
import java.util.List;

import gr.efthymiou.petros.backbaseassignment.features.weather.models.ForecastDomain;
import gr.efthymiou.petros.backbaseassignment.features.weather.models.network.Forecast5daysRaw;
import gr.efthymiou.petros.backbaseassignment.features.weather.models.network.ForecastRaw;
import gr.efthymiou.petros.backbaseassignment.utils.DateUtils;

public class ForecastMapperDomain implements Function<Forecast5daysRaw, List<ForecastDomain>> {

    private ForecastRawValidator validator;

    public ForecastMapperDomain(ForecastRawValidator validator) {
        this.validator = validator;
    }

    @Override
    public List<ForecastDomain> apply(Forecast5daysRaw input) {
        List<ForecastDomain> forecasts = new ArrayList<>();
        for (ForecastRaw raw : input.getList()) {
            if (validator.apply(raw))
                forecasts.add(mapRawToDomain(raw));
        }
        return forecasts;
    }

    private ForecastDomain mapRawToDomain(ForecastRaw raw) {
        ForecastDomain result = new ForecastDomain(
                raw.getTimestamp(),
                mapDate(raw.getTimestamp()),
                raw.getWeather().get(0).getId(),
                raw.getWeather().get(0).getTitle(),
                raw.getWeather().get(0).getDescription(),
                raw.getMain().getTemp(),
                raw.getMain().getTempMin(),
                raw.getMain().getTempMax(),
                raw.getMain().getHumidity(),
                raw.getWeather().get(0).getIcon()
        );
        if (raw.getRain() != null) {
            result.setOneHourRain(raw.getRain().getOneHour());
            result.setThreeHourRain(raw.getRain().getThreeHours());
        }
        if (raw.getWind() != null) {
            result.setWindSpeed(raw.getWind().getSpeed());
            result.setWindDeg(raw.getWind().getDeg());
        }
        return result;
    }

    private String mapDate(long timestamp) {
        return DateUtils.formatDate(timestamp, "dd/MM/yyyy");
    }
}
