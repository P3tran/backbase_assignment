package gr.efthymiou.petros.backbaseassignment.features.bookmarks.home;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.util.List;

import gr.efthymiou.petros.backbaseassignment.R;
import gr.efthymiou.petros.backbaseassignment.application.BaseFragment;
import gr.efthymiou.petros.backbaseassignment.application.MainActivity;
import gr.efthymiou.petros.backbaseassignment.features.bookmarks.Bookmark;
import gr.efthymiou.petros.backbaseassignment.features.bookmarks.map.AddBookmarkMapFragment;
import gr.efthymiou.petros.backbaseassignment.features.weather.WeatherForecastFragment;


public class BookmarksFragment extends BaseFragment implements BookmarksView {

    private RecyclerView mBookmarksRv;
    private BookmarksPresenter presenter;
    private FloatingActionButton mAddBookmarkFab;
    private ViewGroup mRoot, mEmptyState;
    private BookmarksRecyclerAdapter rvAdapter;

    public BookmarksFragment() {
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_bookmarks;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mBookmarksRv = view.findViewById(R.id.bookmarks_rv);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        mBookmarksRv.setLayoutManager(layoutManager);
        mRoot = view.findViewById(R.id.bookmarks_root);
        mAddBookmarkFab = view.findViewById(R.id.fab);
        mEmptyState = view.findViewById(R.id.bookmarks_empty_state);
        //setupRecyclerView();
        setupFab();
        presenter = new BookmarksPresenterImpl(this);
        presenter.getBookmarks(getContext());
    }

    private void setupFab() {
        mAddBookmarkFab.setOnClickListener(view1 -> {
            flipOpenFragment(new AddBookmarkMapFragment());
        });
    }

    //TODO Refactor
    void setupRecyclerView(List<Bookmark> bookmarks) {
        rvAdapter = new BookmarksRecyclerAdapter(bookmarks, new BookmarkClickListener() {

            @Override
            public void onBookmarkClicked(Bookmark bookmark) {
                flipOpenFragment(WeatherForecastFragment.newInstance(bookmark));
            }

            @Override
            public void onBookmarkDeleted(Bookmark bookmark) {
                presenter.deleteBookmark(bookmark, getContext());
            }
        });
        mBookmarksRv.setAdapter(rvAdapter);
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(new SwipeToDeleteCallback(rvAdapter, getContext()));
        itemTouchHelper.attachToRecyclerView(mBookmarksRv);
    }

    @Override
    public void displayBookmarks(List<Bookmark> bookmarks) {
        setupRecyclerView(bookmarks);
    }

    private void showUndoSnackbar(final Bookmark bookmark) {
        Snackbar snackbar = Snackbar.make(mRoot, getString(R.string.removed) + " " + bookmark.getName(), Snackbar.LENGTH_LONG);
        snackbar.setAction(R.string.snack_bar_undo, v -> undoDelete(bookmark));
        snackbar.show();
    }

    private void undoDelete(Bookmark bookmark) {
        presenter.restoreBookmark(bookmark, getContext());
        rvAdapter.undoDelete(bookmark);
        hideEmptyState();
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.menu_main, menu);
    }

    @Override
    public void bookmarkDeletedSuccess(Bookmark bookmark) {
        showUndoSnackbar(bookmark);
        if (rvAdapter.getBookmarks().size() == 0)
            displayEmptyState();
    }

    @Override
    public void bookmarkDeletedFailure() {
        displayError(R.string.general_error);
    }

    @Override
    public void displayError(int errorMessageId) {
        Snackbar.make(mRoot, getString(R.string.general_error), Snackbar.LENGTH_LONG).show();
    }

    @Override
    public void displayEmptyState() {
        mEmptyState.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideEmptyState() {
        mEmptyState.setVisibility(View.GONE);
    }
}
