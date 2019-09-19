package gr.efthymiou.petros.backbaseassignment.features.weather;

import android.content.Context;

import java.util.List;

import gr.efthymiou.petros.backbaseassignment.R;
import gr.efthymiou.petros.backbaseassignment.application.PreferenceDao;
import gr.efthymiou.petros.backbaseassignment.features.bookmarks.Bookmark;
import gr.efthymiou.petros.backbaseassignment.features.weather.models.ForecastDomain;

public class WeatherForecastPresenterImpl implements WeatherForecastPresenter,
        WeatherForecastInteractor.GetForecastFinishListener {

    private WeatherForecastView view;
    private WeatherForecastInteractor interactor;
    private DayForecastMapper mapper;

    public WeatherForecastPresenterImpl(WeatherForecastView view, Context context) {
        this.view = view;
        interactor = new WeatherForecastInteractorImpl();
        mapper = new DayForecastMapper((Boolean) PreferenceDao.USER_IMPERIAL_SYSTEM.getValue(context));
    }

    @Override
    public void getForecast(Bookmark bookmark, Context ctx) {
        interactor.getForecast(bookmark.getCoord(), this, ctx);
    }

    @Override
    public void onSuccess(List<ForecastDomain> forecast) {
        if (view != null)
            view.displayForecast(mapper.apply(forecast));
    }

    @Override
    public void onFailure() {
        if (view != null)
            view.displayError(R.string.general_error);
    }
}
