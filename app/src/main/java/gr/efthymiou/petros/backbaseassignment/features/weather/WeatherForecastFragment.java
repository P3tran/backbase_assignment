package gr.efthymiou.petros.backbaseassignment.features.weather;


import android.os.Bundle;

import java.util.List;

import gr.efthymiou.petros.backbaseassignment.R;
import gr.efthymiou.petros.backbaseassignment.base.BaseFragment;
import gr.efthymiou.petros.backbaseassignment.features.bookmarks.Bookmark;
import gr.efthymiou.petros.backbaseassignment.features.weather.models.Forecast;

public class WeatherForecastFragment extends BaseFragment implements WeatherForecastView {
    private static final String BOOKMARK = "BOOKMARK";

    private Bookmark bookmark;
    private WeatherForecastPresenter presenter;

    public WeatherForecastFragment() {
    }

    public static WeatherForecastFragment newInstance(Bookmark bookmark) {
        WeatherForecastFragment fragment = new WeatherForecastFragment();
        Bundle args = new Bundle();
        args.putParcelable(BOOKMARK, bookmark);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_weather_forecast;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            bookmark = getArguments().getParcelable(BOOKMARK);
        }
        presenter = new WeatherForecastPresenterImpl(this);
        presenter.getForecast(bookmark);
    }

    @Override
    public void displayForecast(List<Forecast> forecast) {
        //TODO
    }

    @Override
    public void displayError(int errorMessageId) {
        //TODO
    }
}
