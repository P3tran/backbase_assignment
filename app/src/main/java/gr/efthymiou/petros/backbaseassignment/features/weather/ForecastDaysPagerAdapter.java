package gr.efthymiou.petros.backbaseassignment.features.weather;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import java.util.List;

import gr.efthymiou.petros.backbaseassignment.features.weather.models.DayForecast;

public class ForecastDaysPagerAdapter extends FragmentStatePagerAdapter {

    private List<DayForecast> dayForecasts;

    public ForecastDaysPagerAdapter(@NonNull FragmentManager fm, List<DayForecast> dayForecasts) {
        super(fm);
        this.dayForecasts = dayForecasts;
    }


    @NonNull
    @Override
    public Fragment getItem(int position) {
        if (position < dayForecasts.size())
            return DayForecastFragment.newInstance(dayForecasts.get(position));
        return DayForecastFragment.newInstance();
    }

    @Override
    public int getCount() {
        return dayForecasts.size();
    }
}
