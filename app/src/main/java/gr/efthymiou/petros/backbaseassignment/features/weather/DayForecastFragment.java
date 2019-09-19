package gr.efthymiou.petros.backbaseassignment.features.weather;


import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import gr.efthymiou.petros.backbaseassignment.R;
import gr.efthymiou.petros.backbaseassignment.application.BaseFragment;
import gr.efthymiou.petros.backbaseassignment.features.weather.models.DayForecast;

public class DayForecastFragment extends BaseFragment {
    private static final String DAY_FORECAST = "DAY_FORECAST";

    private DayForecast dayForecast;
    private TextView mDate, mTemperatureMinMax;
    private RecyclerView forecastsRv;


    public DayForecastFragment() {
    }

    public static DayForecastFragment newInstance(DayForecast dayForecast) {
        DayForecastFragment fragment = new DayForecastFragment();
        Bundle args = new Bundle();
        args.putParcelable(DAY_FORECAST, dayForecast);
        fragment.setArguments(args);
        return fragment;
    }

    public static DayForecastFragment newInstance() {
        DayForecastFragment fragment = new DayForecastFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        instantiateViews(view);
        addValuesToViews();
        setupRecyclerView();
    }

    private void addValuesToViews() {
        if (dayForecast != null) {
            mDate.setText(dayForecast.getDate());
            mTemperatureMinMax.setText(dayForecast.getTempMinMax());
        }
    }

    private void setupRecyclerView() {
        if (dayForecast != null) {
            forecastsRv.setLayoutManager(new LinearLayoutManager(getContext()));
            ForecastsRecyclerAdapter adapter = new ForecastsRecyclerAdapter(dayForecast.getHourlyForecasts(), getContext());
            forecastsRv.setAdapter(adapter);
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            dayForecast = getArguments().getParcelable(DAY_FORECAST);
        }
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_day_forecast;
    }

    private void instantiateViews(@NonNull View view) {
        mDate = view.findViewById(R.id.date);
        mTemperatureMinMax = view.findViewById(R.id.temp_min_max);
        forecastsRv = view.findViewById(R.id.forecasts_rv);
    }
}
