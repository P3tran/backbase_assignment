package gr.efthymiou.petros.backbaseassignment.features.weather;

import androidx.arch.core.util.Function;

import gr.efthymiou.petros.backbaseassignment.features.weather.models.network.ForecastRaw;

public class ForecastRawValidator implements Function<ForecastRaw, Boolean> {

    @Override
    public Boolean apply(ForecastRaw raw) {
        return raw.getMain() != null
                && raw.getWeather() != null
                && !raw.getWeather().isEmpty()
                && raw.getWeather().get(0).getTitle() != null
                && raw.getDate() != null
                && raw.getTimestamp() != 0
                && raw.getMain() != null;
    }
}
