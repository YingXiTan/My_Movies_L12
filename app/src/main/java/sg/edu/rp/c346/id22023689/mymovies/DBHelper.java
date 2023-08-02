package sg.edu.rp.c346.id22023689.mymovies;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VER = 1;
    private static final String DATABASE_NAME = "Movies.db";
    private static final String TABLE_MOVIES = "Movies";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_TITLE = "Title";
    private static final String COLUMN_GENRE = "Genre";
    private static final String COLUMN_YEAR = "Year";
    private static final String COLUMN_RATING = "Rating";


    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VER);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableSql = "CREATE TABLE " + TABLE_MOVIES + "(" + COLUMN_TITLE + " TEXT," + COLUMN_GENRE + " TEXT," + COLUMN_YEAR + "INTEGER PRIMARY KEY AUTOINCREMENT," + COLUMN_RATING + " TEXT )";
        db.execSQL(createTableSql);
        Log.i("info", "created tables");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_MOVIES);
        onCreate(db);

    }

    public void insertTask (String title, String genre, int year, String rating) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_TITLE, title);
        values.put(COLUMN_GENRE, genre);
        values.put(COLUMN_YEAR, year);
        values.put(COLUMN_RATING, rating);

        db.insert(TABLE_MOVIES, null, values);
        db.close();
    }

    public ArrayList<String> getTaskContent() {
        ArrayList<String> tasks = new ArrayList<String>();
        SQLiteDatabase db = this.getReadableDatabase();
        String[] columns = {COLUMN_TITLE, COLUMN_GENRE, COLUMN_YEAR, COLUMN_RATING};
        Cursor cursor = db.query(TABLE_MOVIES, columns, null, null, null, null, null, null);

        if (cursor.moveToFirst()) {
            do {
                tasks.add(cursor.getString(1));
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return tasks;
    }

    public ArrayList<MoviesList> getMovies() {
        ArrayList<MoviesList> tasks = new ArrayList<MoviesList>();
        SQLiteDatabase db = this.getReadableDatabase();
        String[] columns = {COLUMN_TITLE, COLUMN_GENRE, COLUMN_YEAR, COLUMN_RATING};
        Cursor cursor = db.query(TABLE_MOVIES, columns, null, null, null, null, null, null);

        if (cursor.moveToFirst()) {
            do {
                String title = cursor.getString(0);
                String genre = cursor.getString(1);
                int year = cursor.getInt(2);
                String rating = cursor.getString(3);

                MoviesList obj = new MoviesList(title, genre, year, rating);
                tasks.add(obj);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return tasks;
    }


    public int updateMovies(Movies data) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_TITLE, data.getTitle());
        values.put(COLUMN_GENRE, data.getGenre());
        values.put(COLUMN_YEAR, data.getYear());
        values.put(COLUMN_RATING, data.getRating());
        values.put(COLUMN_ID, data.getRating());
        String condition = COLUMN_ID + "= ?";
        String[] args = {String.valueOf(data.getId())};
        int result = db.update(TABLE_MOVIES, values, condition, args);
        db.close();
        return result;
    }
}
