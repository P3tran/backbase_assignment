package gr.efthymiou.petros.backbaseassignment.features.settings;

import android.content.Context;

import gr.efthymiou.petros.backbaseassignment.R;
import gr.efthymiou.petros.backbaseassignment.features.bookmarks.BookmarksInteractor;
import gr.efthymiou.petros.backbaseassignment.features.bookmarks.BookmarksInteractorImpl;

public class SettingsPresenterImpl implements SettingsPresenter,
        BookmarksInteractor.DeleteAllBookmarksFinishListener {

    private SettingsView view;
    private BookmarksInteractor interactor;

    public SettingsPresenterImpl(SettingsView view) {
        this.view = view;
        interactor = new BookmarksInteractorImpl();
    }

    @Override
    public void deleteAllBookmarks(Context ctx) {
        interactor.deleteAllBookmarks(this, ctx);
    }

    @Override
    public void onDeleteSuccess() {
        if (view != null)
            view.bookmarksDeleted();
    }

    @Override
    public void onDeleteFailure() {
        if(view !=null)
            view.displayError(R.string.general_error);
    }
}
