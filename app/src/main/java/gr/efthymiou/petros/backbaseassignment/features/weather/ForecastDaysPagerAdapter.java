package gr.efthymiou.petros.backbaseassignment.features.weather;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.List;

import gr.efthymiou.petros.backbaseassignment.features.weather.day.DayForecastFragment;
import gr.efthymiou.petros.backbaseassignment.features.weather.models.DayForecast;

public class ForecastDaysPagerAdapter extends FragmentPagerAdapter {

    private List<DayForecast> dayForecasts;

    public ForecastDaysPagerAdapter(@NonNull FragmentManager fm, List<DayForecast> dayForecasts) {
        super(fm);
        this.dayForecasts = dayForecasts;
    }


    @NonNull
    @Override
    public Fragment getItem(int position) {
        return DayForecastFragment.newInstance(dayForecasts.get(position));
    }

    @Override
    public int getCount() {
        return 5;
    }
}
