package gr.efthymiou.petros.backbaseassignment.features.bookmarks;

import android.content.Context;
import android.util.Log;

import java.util.List;

public class BookmarksInteractorImpl implements BookmarksInteractor {

    private static final String TAG = BookmarksInteractorImpl.class.getName();

    @Override
    public void getBookmarks(GetBookmarksFinishListener listener, Context ctx) {
        try {
            BookmarksDatasource dataSource = new BookmarksDatasource(ctx);
            dataSource.open();
            List<Bookmark> bookmarks = dataSource.getAllBookmarks();
            listener.onSuccess(bookmarks);
            dataSource.close();
        } catch (Exception e) {
            listener.onFailure();
            Log.e(TAG, "Failed to retrieve all bookmarks");
        }
    }

    @Override
    public void addBookmark(Bookmark bookmark, AddBookmarkFinishListener listener, Context ctx) {
        try {
            BookmarksDatasource dataSource = new BookmarksDatasource(ctx);
            dataSource.open();
            Bookmark savedBookmark = dataSource.createBookmark(bookmark);
            if (savedBookmark != null)
                listener.onAddSuccess(savedBookmark.getName());
            else
                listener.onAddFailure();
            dataSource.close();
        } catch (Exception e) {
            listener.onAddFailure();
            Log.e(TAG, "Failed to add bookmark" + bookmark.toString());
        }
    }

    @Override
    public void restoreBookmark(Bookmark bookmark, Context ctx) {
        try {
            BookmarksDatasource dataSource = new BookmarksDatasource(ctx);
            dataSource.open();
            dataSource.createBookmark(bookmark);
            dataSource.close();
        } catch (Exception e) {
            Log.e(TAG, "Failed to restore bookmark" + bookmark.toString());
        }
    }

    @Override
    public void deleteBookmark(DeleteBookmarkFinishListener listener, Bookmark bookmark, Context ctx) {
        try {
            BookmarksDatasource dataSource = new BookmarksDatasource(ctx);
            dataSource.open();
            dataSource.deleteBookmark(bookmark.getId());
            listener.onDeleteSuccess(bookmark);
            dataSource.close();
        } catch (Exception e) {
            listener.onDeleteFailure();
            Log.e(TAG, "Failed to delete bookmark" + bookmark.toString());
        }
    }

    @Override
    public void deleteAllBookmarks(DeleteAllBookmarksFinishListener listener, Context ctx) {
        try {
            BookmarksDatasource dataSource = new BookmarksDatasource(ctx);
            dataSource.open();
            dataSource.deleteAllBookmarks();
            listener.onDeleteSuccess();
            dataSource.close();
        } catch (Exception e) {
            listener.onDeleteSuccess();
            Log.e(TAG, "Failed to delete all bookmarks");
        }
    }

    @Override
    public void filterBookmarks(String filterText, GetFilteredBookmarksFinishListener listener, Context ctx) {
        try {
            BookmarksDatasource dataSource = new BookmarksDatasource(ctx);
            dataSource.open();
            List<Bookmark> bookmarks = dataSource.filterBookmarks(filterText.toUpperCase());
            listener.onFilterSuccess(bookmarks);
            dataSource.close();
        } catch (Exception e) {
            listener.onFilter();
            Log.e(TAG, "Failed to retrieve all bookmarks");
        }
    }
}
