package gr.efthymiou.petros.backbaseassignment.features.weather;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.List;

import gr.efthymiou.petros.backbaseassignment.features.weather.day.DayForecastFragment;
import gr.efthymiou.petros.backbaseassignment.features.weather.models.Forecast;

public class ForecastDaysPagerAdapter extends FragmentPagerAdapter {

    private List<Forecast> forecasts;

    public ForecastDaysPagerAdapter(@NonNull FragmentManager fm, List<Forecast> forecasts) {
        super(fm);
        this.forecasts = forecasts;
    }


    @NonNull
    @Override
    public Fragment getItem(int position) {
        return DayForecastFragment.newInstance(forecasts.get(position));
    }

    @Override
    public int getCount() {
        return 5;
    }
}