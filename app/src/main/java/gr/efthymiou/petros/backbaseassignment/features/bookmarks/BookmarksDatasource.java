package gr.efthymiou.petros.backbaseassignment.features.bookmarks;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import gr.efthymiou.petros.backbaseassignment.base.DatabaseHelper;
import gr.efthymiou.petros.backbaseassignment.utils.LogUtils;

public class BookmarksDatasource {

    private SQLiteDatabase database;
    private DatabaseHelper dbHelper;
    private String[] allBookmarkColumns = {dbHelper.COLUMN_BOOKMARK_ID, dbHelper.COLUMN_BOOKMARK_NAME, dbHelper.COLUMN_BOOKMARK_LAT, dbHelper.COLUMN_BOOKMARK_LON};

    public BookmarksDatasource(Context context) {
        dbHelper = new DatabaseHelper(context);
    }

    public void open() throws SQLException {
        database = dbHelper.getWritableDatabase();
    }

    public void close() {
        dbHelper.close();
    }


    public Bookmark createBookmark(Bookmark bookmark) {
        ContentValues values = new ContentValues();
        values.put(DatabaseHelper.COLUMN_BOOKMARK_NAME, bookmark.getName());
        values.put(DatabaseHelper.COLUMN_BOOKMARK_LAT, bookmark.getCoord().getLat());
        values.put(DatabaseHelper.COLUMN_BOOKMARK_LON, bookmark.getCoord().getLon());

        long insertId = database.insert(DatabaseHelper.TABLE_BOOKMARKS, null, values);
        Cursor cursor = database.query(DatabaseHelper.TABLE_BOOKMARKS, allBookmarkColumns, DatabaseHelper.COLUMN_BOOKMARK_ID + " = " + insertId, null, null, null, null);
        cursor.moveToFirst();
        Bookmark retrievedBookmark = cursorToComment(cursor);
        cursor.close();
        Log.i(LogUtils.DATABASE_TAG, "created bookmark: " + retrievedBookmark.toString());
        return retrievedBookmark;
    }

    public void deleteBookmark(int bookmarkId) {
        database.delete(DatabaseHelper.TABLE_BOOKMARKS, DatabaseHelper.COLUMN_BOOKMARK_ID + " = " + bookmarkId, null);
        Log.i(LogUtils.DATABASE_TAG, "deleted bookmark with id $bookmarkId: " + bookmarkId);
    }

    public List<Bookmark> getAllBookmarks() {
        List<Bookmark> bookmarks = new ArrayList<>();
        Cursor cursor = database.query(DatabaseHelper.TABLE_BOOKMARKS, allBookmarkColumns, null, null, null, null, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            Bookmark comment = cursorToComment(cursor);
            bookmarks.add(comment);
            cursor.moveToNext();
        }
        cursor.close();
        Log.i(LogUtils.DATABASE_TAG, "retrieved bookmarks " + bookmarks.toString());
        return bookmarks;
    }

    public void deleteAllBookmarks() {
        List<Bookmark> bookmarks = getAllBookmarks();
        for (Bookmark bm : bookmarks) {
            deleteBookmark(bm.getId());
        }
        Log.i(LogUtils.DATABASE_TAG, "deleted all bookmarks");
    }

    private Bookmark cursorToComment(Cursor cursor) {
        Bookmark bookmark = new Bookmark(
                cursor.getInt(0),
                cursor.getString(1),
                new Coord(
                        cursor.getDouble(2),
                        cursor.getDouble(3)
                )
        );
        return bookmark;
    }
}
