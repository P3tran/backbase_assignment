package gr.efthymiou.petros.backbaseassignment.features.weather;


import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.ViewPager;

import java.util.List;

import gr.efthymiou.petros.backbaseassignment.R;
import gr.efthymiou.petros.backbaseassignment.base.BaseFragment;
import gr.efthymiou.petros.backbaseassignment.base.MainActivity;
import gr.efthymiou.petros.backbaseassignment.features.bookmarks.Bookmark;
import gr.efthymiou.petros.backbaseassignment.features.weather.models.DayForecast;

public class WeatherForecastFragment extends BaseFragment implements WeatherForecastView {
    private static final String BOOKMARK = "BOOKMARK";

    private Bookmark bookmark;
    private ForecastDaysPagerAdapter adapter;
    private ViewPager forecastsViewPager;
    private ProgressBar progressBar;


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
        initilizeViews(view);
    }

    private void initilizeViews(@NonNull View view) {
        forecastsViewPager = view.findViewById(R.id.days_pager);
        ImageView mArrowLeft = view.findViewById(R.id.left);
        ImageView mArrowRight = view.findViewById(R.id.right);
        mArrowLeft.setOnClickListener(v -> {
            forecastsViewPager.setCurrentItem(forecastsViewPager.getCurrentItem() - 1);
        });

        mArrowRight.setOnClickListener(v -> {
            forecastsViewPager.setCurrentItem(forecastsViewPager.getCurrentItem() + 1);
        });
        progressBar = view.findViewById(R.id.progressbar);
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            bookmark = getArguments().getParcelable(BOOKMARK);
        }
        WeatherForecastPresenter presenter = new WeatherForecastPresenterImpl(this);
        presenter.getForecast(bookmark);
    }

    @Override
    public void displayForecast(List<DayForecast> forecast) {
        if (getActivity() != null) {
            adapter = new ForecastDaysPagerAdapter(getActivity().getSupportFragmentManager(), forecast);
            getActivity().runOnUiThread(() -> {
                forecastsViewPager.setAdapter(adapter);
                progressBar.setVisibility(View.GONE);
            });

        }
    }

    @Override
    public void displayError(int errorMessageId) {
        if (getActivity() != null)
            ((MainActivity) getActivity()).displaySnackbar(getString(R.string.general_error));
    }
}
