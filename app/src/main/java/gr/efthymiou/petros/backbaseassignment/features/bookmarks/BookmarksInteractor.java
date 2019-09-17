package gr.efthymiou.petros.backbaseassignment.features.bookmarks;

import android.content.Context;

import java.util.List;

public interface BookmarksInteractor {

    void getBookmarks(GetBookmarksFinishListener listener, Context ctx);

    void addBookmark(Bookmark bookmark, AddBookmarkFinishListener listener, Context ctx);

    void deleteBookmark(DeleteBookmarksFinishListener listener, int bookmarkId, Context ctx);

    void deleteAllBookmarks(DeleteBookmarksFinishListener listener, Context ctx);

    interface GetBookmarksFinishListener {

        void onSuccess(List<Bookmark> bookmarks);

        void onFailure();

    }

    interface AddBookmarkFinishListener {

        void onAddSuccess(String name);

        void onAddFailure();

    }

    interface DeleteBookmarksFinishListener {

        void onDeleteSuccess();

        void onDeleteFailure();
    }
}
