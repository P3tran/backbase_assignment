package gr.efthymiou.petros.backbaseassignment.base.mockobjects;

import gr.efthymiou.petros.backbaseassignment.features.weather.ForecastRawValidator;
import gr.efthymiou.petros.backbaseassignment.features.weather.models.network.ForecastRaw;

public class MockForecastsRawValidator extends ForecastRawValidator {

    @Override
    public Boolean apply(ForecastRaw raw) {
        return true;
    }
}
