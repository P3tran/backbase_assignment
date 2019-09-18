package gr.efthymiou.petros.backbaseassignment.features.bookmarks.home;

import gr.efthymiou.petros.backbaseassignment.features.bookmarks.Bookmark;

public interface BookmarkClickListener {

    void onBookmarkClicked(Bookmark bookmark);

    void onBookmarkDeleted(Bookmark bookmark);

}
