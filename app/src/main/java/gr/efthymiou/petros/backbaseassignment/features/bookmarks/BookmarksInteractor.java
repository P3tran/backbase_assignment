package gr.efthymiou.petros.backbaseassignment.features.bookmarks;

import android.content.Context;

import java.util.List;

public interface BookmarksInteractor {

    void getBookmarks(GetBookmarksFinishListener listener, Context ctx);

    void addBookmark(Bookmark bookmark, AddBookmarkFinishListener listener, Context ctx);

    void restoreBookmark(Bookmark bookmark, Context ctx);

    void deleteBookmark(DeleteBookmarkFinishListener listener, Bookmark bookmark, Context ctx);

    void deleteAllBookmarks(DeleteAllBookmarksFinishListener listener, Context ctx);

    interface GetBookmarksFinishListener {

        void onSuccess(List<Bookmark> bookmarks);

        void onFailure();

    }

    interface AddBookmarkFinishListener {

        void onAddSuccess(String name);

        void onAddFailure();

    }

    interface DeleteBookmarkFinishListener {

        void onDeleteSuccess(Bookmark bookmark);

        void onDeleteFailure();
    }

    interface DeleteAllBookmarksFinishListener {

        void onDeleteSuccess();

        void onDeleteFailure();
    }
}
