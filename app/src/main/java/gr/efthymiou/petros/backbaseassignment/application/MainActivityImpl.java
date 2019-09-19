package gr.efthymiou.petros.backbaseassignment.application;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.ViewGroup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.snackbar.Snackbar;

import gr.efthymiou.petros.backbaseassignment.R;
import gr.efthymiou.petros.backbaseassignment.features.bookmarks.home.BookmarksFragment;
import gr.efthymiou.petros.backbaseassignment.features.bookmarks.map.AddBookmarkMapFragment;
import gr.efthymiou.petros.backbaseassignment.features.help.HelpFragment;
import gr.efthymiou.petros.backbaseassignment.features.settings.SettingsFragment;
import gr.efthymiou.petros.backbaseassignment.features.weather.WeatherForecastFragment;

public class MainActivityImpl extends AppCompatActivity implements MainActivity {

    private ViewGroup mRoot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mRoot = findViewById(R.id.activity_root);
        if (savedInstanceState == null)
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.fragment_container, new BookmarksFragment())
                    .commit();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case android.R.id.home:
                onBackPressed();
                return true;
            case R.id.action_settings:
                flipOpenFragment(SettingsFragment.newInstance());
                return true;
            case R.id.action_help:
                flipOpenFragment(HelpFragment.newInstance());
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void flipOpenFragment(BaseFragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .setCustomAnimations(
                        R.animator.card_flip_right_in, R.animator.card_flip_right_out,
                        R.animator.card_flip_left_in, R.animator.card_flip_left_out)
                .replace(R.id.fragment_container, fragment)
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void updateNavigation(String fragmentName) {
        if (fragmentName.equals(BookmarksFragment.class.getSimpleName())) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(false);
            setTitle(R.string.bookmarks_fragment_title);
        } else if (fragmentName.equals(AddBookmarkMapFragment.class.getSimpleName())) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            setTitle(R.string.add_bookmark_map_fragment_title);
        } else if (fragmentName.equals(WeatherForecastFragment.class.getSimpleName())) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            setTitle(R.string.weather_forecast_fragment_title);
        } else if (fragmentName.equals(HelpFragment.class.getSimpleName())) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            setTitle(R.string.help_fragment_title);
        } else if (fragmentName.equals(SettingsFragment.class.getSimpleName())) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            setTitle(R.string.settings_fragment_title);
        }
    }

    @Override
    public void displaySnackbar(String message) {
        Snackbar.make(mRoot, message, Snackbar.LENGTH_LONG).show();
    }

}
