package gr.efthymiou.petros.backbaseassignment.features.bookmarks.home;

import java.util.List;

import gr.efthymiou.petros.backbaseassignment.base.GenericView;
import gr.efthymiou.petros.backbaseassignment.features.bookmarks.Bookmark;

public interface BookmarksView extends GenericView {

    void displayBookmarks(List<Bookmark> bookmarks);

    void displayEmptyState();

    void hideEmptyState();

    void bookmarkDeletedSuccess(Bookmark bookmark);

    void bookmarkDeletedFailure();

}
