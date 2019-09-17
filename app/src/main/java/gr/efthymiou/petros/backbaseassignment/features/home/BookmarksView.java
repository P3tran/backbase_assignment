package gr.efthymiou.petros.backbaseassignment.features.home;

import java.util.List;

public interface BookmarksView {

    void displayBookmarks(List<Bookmark> bookmarks);

    void displayEmptyState();

    void displayError(int errorMessageId);

}
