package gr.efthymiou.petros.backbaseassignment.application;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String TABLE_BOOKMARKS = "bookmarks";

    public static final String COLUMN_BOOKMARK_ID = "_id";
    public static final String COLUMN_BOOKMARK_NAME = "name";
    public static final String COLUMN_BOOKMARK_LAT = "lat";
    public static final String COLUMN_BOOKMARK_LON = "lon";

    private static final String DATABASE_NAME = "app.db";
    private static final int DATABASE_VERSION = 1;

    private static final String DATABASE_CREATE = "CREATE TABLE " + TABLE_BOOKMARKS + " (" +
            COLUMN_BOOKMARK_ID + " INTEGER PRIMARY KEY," +
            COLUMN_BOOKMARK_NAME + " TEXT," +
            COLUMN_BOOKMARK_LAT + " INTEGER," +
            COLUMN_BOOKMARK_LON + " INTEGER)";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase database) {
        database.execSQL(DATABASE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.w(DatabaseHelper.class.getName(), "Upgrading database from version " + oldVersion + " to " + newVersion + ", which will destroy all old data");
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_BOOKMARKS);
        onCreate(db);
    }
}
