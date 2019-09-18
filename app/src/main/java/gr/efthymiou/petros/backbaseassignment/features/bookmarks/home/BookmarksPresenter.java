package gr.efthymiou.petros.backbaseassignment.features.bookmarks.home;

import android.content.Context;

import gr.efthymiou.petros.backbaseassignment.features.bookmarks.Bookmark;

public interface BookmarksPresenter {

    void getBookmarks(Context ctx);

    void deleteBookmark(Bookmark bookmark, Context ctx);

    void restoreBookmark(Bookmark bookmark, Context ctx);
}
