package gr.efthymiou.petros.backbaseassignment.base;

import android.os.Bundle;

import com.google.android.gms.maps.MapFragment;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import gr.efthymiou.petros.backbaseassignment.R;
import gr.efthymiou.petros.backbaseassignment.features.bookmarks.home.BookmarksFragment;
import gr.efthymiou.petros.backbaseassignment.features.bookmarks.map.AddBookmarkMapFragment;

public class MainActivityImpl extends AppCompatActivity implements MainActivity {

    private FloatingActionButton mAddBookmarkFab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mAddBookmarkFab= findViewById(R.id.fab);
        mAddBookmarkFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                flipOpenFragment(new AddBookmarkMapFragment());

/*                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();*/
            }
        });

        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.fragment_container, new BookmarksFragment())
                .commit();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
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
        if(fragmentName.equals(BookmarksFragment.class.getSimpleName())) {
            mAddBookmarkFab.show();
            getSupportActionBar().setDisplayHomeAsUpEnabled(false);
            setTitle(R.string.app_name);
        } else if(fragmentName.equals(AddBookmarkMapFragment.class.getSimpleName())) {
            mAddBookmarkFab.hide();
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            setTitle(R.string.add_bookmark_map_fragment_title);
        }
    }
}
