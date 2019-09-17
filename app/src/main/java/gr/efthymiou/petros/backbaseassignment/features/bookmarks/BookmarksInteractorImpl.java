package gr.efthymiou.petros.backbaseassignment.features.bookmarks;

import android.content.Context;

import java.util.List;

public class BookmarksInteractorImpl implements BookmarksInteractor {

    @Override
    public void getBookmarks(GetBookmarksFinishListener listener, Context ctx) {
        try {
            BookmarksDatasource dataSource = new BookmarksDatasource(ctx);
            dataSource.open();
            List<Bookmark> bookmarks = dataSource.getAllBookmarks();
            if (bookmarks.size() > 0)
                listener.onSuccess(bookmarks);
            dataSource.close();
        } catch (Exception e) {
            listener.onFailure();
        }
    }

    @Override
    public void deleteBookmark(DeleteBookmarksFinishListener listener, int bookmarkId, Context ctx) {
        try {
            BookmarksDatasource dataSource = new BookmarksDatasource(ctx);
            dataSource.open();
            dataSource.deleteBookmark(bookmarkId);
            dataSource.close();
        } catch (Exception e) {
            listener.onFailure();
        }
    }

    @Override
    public void deleteAllBookmarks(DeleteBookmarksFinishListener listener, Context ctx) {
        try {
            BookmarksDatasource dataSource = new BookmarksDatasource(ctx);
            dataSource.open();
            dataSource.deleteAllBookmarks();
            dataSource.close();
        } catch (Exception e) {
            listener.onFailure();
        }
    }
}
