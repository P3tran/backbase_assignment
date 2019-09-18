package gr.efthymiou.petros.backbaseassignment.features.weather;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.PagerAdapter;

import java.util.List;

import gr.efthymiou.petros.backbaseassignment.features.weather.models.Forecast;

public class ForecastDaysPagerAdapter extends FragmentPagerAdapter {

    private FragmentManager fm;
    private List<Forecast> forecasts;

    public ForecastDaysPagerAdapter(@NonNull FragmentManager fm, FragmentManager fm1, List<Forecast> forecasts) {
        super(fm);
        this.fm = fm1;
        this.forecasts = forecasts;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return null;
    }

    @Override
    public int getCount() {
        return 5;
    }
}
