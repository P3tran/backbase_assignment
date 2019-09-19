package gr.efthymiou.petros.backbaseassignment.features.weather.day;


import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import gr.efthymiou.petros.backbaseassignment.R;
import gr.efthymiou.petros.backbaseassignment.base.BaseFragment;
import gr.efthymiou.petros.backbaseassignment.features.weather.models.Forecast;

public class DayForecastFragment extends BaseFragment {
    private static final String FORECAST = "FORECAST";

    private Forecast forecast;
    private TextView mDate, mTitle, mDescription, mTemperature, mTemperatureMinMax, mHumidity, mWindInfo, mRainInfo;
    private ImageView mIcon;

    public DayForecastFragment() { }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        instantiateViews(view);
        mDate.setText(forecast.getDate());
        mTitle.setText(forecast.getTitle());
        mDescription.setText(forecast.getDescription());
        mTemperature.setText(forecast.getTemp());
        mIcon.setImageDrawable(getResources().getDrawable(forecast.getIconId()));
        mTemperatureMinMax.setText(forecast.getTempMinMax());
    }


    public static DayForecastFragment newInstance(Forecast forecast) {
        DayForecastFragment fragment = new DayForecastFragment();
        Bundle args = new Bundle();
        args.putParcelable(FORECAST, forecast);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            forecast = getArguments().getParcelable(FORECAST);
        }
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_day_forecast;
    }

    private void instantiateViews(@NonNull View view) {
        mDate = view.findViewById(R.id.date);
        mTitle = view.findViewById(R.id.title);
        mDescription = view.findViewById(R.id.description);
        mIcon = view.findViewById(R.id.icon);
        mTemperature = view.findViewById(R.id.temperature);
        mTemperatureMinMax = view.findViewById(R.id.temp_min_max);
    }
}
