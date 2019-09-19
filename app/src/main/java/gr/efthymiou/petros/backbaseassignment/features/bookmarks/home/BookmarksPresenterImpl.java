package gr.efthymiou.petros.backbaseassignment.features.bookmarks.home;

import android.content.Context;

import java.util.List;

import gr.efthymiou.petros.backbaseassignment.R;
import gr.efthymiou.petros.backbaseassignment.features.bookmarks.Bookmark;
import gr.efthymiou.petros.backbaseassignment.features.bookmarks.BookmarksInteractor;
import gr.efthymiou.petros.backbaseassignment.features.bookmarks.BookmarksInteractorImpl;

public class BookmarksPresenterImpl implements BookmarksPresenter,
        BookmarksInteractor.GetBookmarksFinishListener,
        BookmarksInteractor.DeleteBookmarkFinishListener {

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
    public void deleteBookmark(Bookmark bookmark, Context ctx) {
        interactor.deleteBookmark(this, bookmark, ctx);
    }

    @Override
    public void restoreBookmark(Bookmark bookmark, Context ctx) {
        interactor.restoreBookmark(bookmark, ctx);
    }

    @Override
    public void onSuccess(List<Bookmark> bookmarks) {
        if (view != null) {
            if (bookmarks.size() > 0) {
                view.displayBookmarks(bookmarks);
                view.hideEmptyState();
            }else
                view.displayEmptyState();
        }
    }

    @Override
    public void onFailure() {
        if (view != null) {
            view.displayError(R.string.general_error);
            view.displayEmptyState();
        }
    }

    @Override
    public void onDeleteSuccess(Bookmark bookmark) {
        if (view != null)
            view.bookmarkDeletedSuccess(bookmark);
    }

    @Override
    public void onDeleteFailure() {
        if (view != null)
            view.bookmarkDeletedFailure();
    }
}
