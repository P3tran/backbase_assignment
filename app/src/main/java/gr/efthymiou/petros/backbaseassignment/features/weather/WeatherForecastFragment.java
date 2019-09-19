package gr.efthymiou.petros.backbaseassignment.features.weather;


import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.ViewPager;

import java.util.List;

import gr.efthymiou.petros.backbaseassignment.R;
import gr.efthymiou.petros.backbaseassignment.base.BaseFragment;
import gr.efthymiou.petros.backbaseassignment.base.MainActivity;
import gr.efthymiou.petros.backbaseassignment.features.bookmarks.Bookmark;
import gr.efthymiou.petros.backbaseassignment.features.weather.models.Forecast;

public class WeatherForecastFragment extends BaseFragment implements WeatherForecastView {
    private static final String BOOKMARK = "BOOKMARK";

    private Bookmark bookmark;
    private WeatherForecastPresenter presenter;
    private ForecastDaysPagerAdapter adapter;
    private ViewPager forecastsViewPager;

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
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        forecastsViewPager = view.findViewById(R.id.days_pager);
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
        if (getActivity() != null) {
            adapter = new ForecastDaysPagerAdapter(getActivity().getSupportFragmentManager(), forecast);
            forecastsViewPager.setAdapter(adapter);
        }
    }

    @Override
    public void displayError(int errorMessageId) {
        if (getActivity() != null)
            ((MainActivity) getActivity()).displaySnackbar(getString(R.string.general_error));
    }
}