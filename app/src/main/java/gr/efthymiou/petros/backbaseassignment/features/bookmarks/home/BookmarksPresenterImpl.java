package gr.efthymiou.petros.backbaseassignment.features.bookmarks.home;

import android.content.Context;

import java.util.List;

import gr.efthymiou.petros.backbaseassignment.R;
import gr.efthymiou.petros.backbaseassignment.features.bookmarks.Bookmark;
import gr.efthymiou.petros.backbaseassignment.features.bookmarks.BookmarksInteractor;
import gr.efthymiou.petros.backbaseassignment.features.bookmarks.BookmarksInteractorImpl;

public class BookmarksPresenterImpl implements BookmarksPresenter, BookmarksInteractor.GetBookmarksFinishListener {

    private BookmarksView view;
    private BookmarksInteractor interactor;

    public BookmarksPresenterImpl(BookmarksView view) {
        this.view = view;
        interactor = new BookmarksInteractorImpl();
    }

    @Override
    public void getBookmarks(Context ctx) {
        interactor.getBookmarks(this, ctx);
    }

    @Override
    public void onSuccess(List<Bookmark> bookmarks) {
        view.displayBookmarks(bookmarks);
    }

    @Override
    public void onFailure() {
        view.displayError(R.string.general_error);
        view.displayEmptyState();
    }
}
