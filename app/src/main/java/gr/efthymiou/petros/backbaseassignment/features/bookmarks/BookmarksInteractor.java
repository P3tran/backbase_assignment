package gr.efthymiou.petros.backbaseassignment.features.bookmarks;

import android.content.Context;

import java.util.List;

public interface BookmarksInteractor {

    void getBookmarks(GetBookmarksFinishListener listener, Context ctx);

    void deleteBookmark(DeleteBookmarksFinishListener listener, int bookmarkId, Context ctx);

    void deleteAllBookmarks(DeleteBookmarksFinishListener listener, Context ctx);

    interface GetBookmarksFinishListener {

        void onSuccess(List<Bookmark> bookmarks);

        void onFailure();

    }

    interface DeleteBookmarksFinishListener {

        void onSuccess();

        void onFailure();
    }
}
