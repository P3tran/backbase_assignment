package gr.efthymiou.petros.backbaseassignment.features.weather.day;


import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import gr.efthymiou.petros.backbaseassignment.R;
import gr.efthymiou.petros.backbaseassignment.base.BaseFragment;
import gr.efthymiou.petros.backbaseassignment.features.weather.models.DayForecast;
import gr.efthymiou.petros.backbaseassignment.features.weather.models.Forecast;

public class DayForecastFragment extends BaseFragment {
    private static final String DAY_FORECAST = "DAY_FORECAST";

    private DayForecast dayForecast;
    private TextView mDate, mTitle, mDescription, mTemperature, mTemperatureMinMax, mHumidity, mWindInfo, mRainInfo;
    private ImageView mIcon;
    private ViewGroup mRainLl;

    public DayForecastFragment() { }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        instantiateViews(view);
        /*mDate.setText(dayForecast.getTime());
        mTitle.setText(dayForecast.getTitle());
        mDescription.setText(dayForecast.getDescription());
        mTemperature.setText(dayForecast.getTemp());
        mIcon.setImageDrawable(getResources().getDrawable(dayForecast.getIconId()));
        mTemperatureMinMax.setText(dayForecast.getTempMinMax());
        mHumidity.setText(dayForecast.getHumidity());
        mWindInfo.setText(dayForecast.getWindInfo());
        mRainInfo.setText(dayForecast.getRainInfo());
        mRainLl.setVisibility(dayForecast.getRainSelectionVisibility());*/
    }


    public static DayForecastFragment newInstance(DayForecast dayForecast) {
        DayForecastFragment fragment = new DayForecastFragment();
        Bundle args = new Bundle();
        args.putParcelable(DAY_FORECAST, dayForecast);
        fragment.setArguments(args);
        return fragment;
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
        //mDate = view.findViewById(R.id.date);
        mTitle = view.findViewById(R.id.title);
        mDescription = view.findViewById(R.id.description);
        mIcon = view.findViewById(R.id.icon);
        mTemperature = view.findViewById(R.id.temperature);
        mTemperatureMinMax = view.findViewById(R.id.temp_min_max);
        mHumidity = view.findViewById(R.id.humidity);
        mWindInfo = view.findViewById(R.id.wind);
        mRainInfo = view.findViewById(R.id.rain);
        mRainLl = view.findViewById(R.id.rain_ll);
    }
}
