package jon.curnutt.project3;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;

import java.util.ArrayList;
import java.util.List;

public class MovieDatabase extends SQLiteOpenHelper {

    private static final int VERSION = 1;
    private static final String DATABASE_NAME = "movie.db";

    private static MovieDatabase mMovieDb;

    public enum MovieSortOrder { ALPHABETIC, UPDATE_DESC, UPDATE_ASC }

    public static MovieDatabase getInstance(Context context) {
        if (mMovieDb == null) {
            mMovieDb = new MovieDatabase(context);
        }
        return mMovieDb;
    }

    private MovieDatabase(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    private static final class MovieTable {
        private static final String TABLE = "movies";
        private static final String COL_NAME = "name";
        private static final String COL_YEAR = "year";
        private static final String COL_PLOT = "plot";
        private static final String COL_POSTER = "poster";
        private static final String COL_RATING= "rating";
        private static final String COL_GENRE = "genre";
        private static final String COL_METASCORE = "metascore";
        private static final String COL_IMDB_RATING = "imdbrating";
        private static final String COL_PRODUCTION = "production";
        private static final String COL_WRITER = "writer";
        private static final String COL_ACTORS = "actors";
        private static final String COL_RUNTIME = "runtime";
        private static final String COL_RELEASED = "released";
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        // Create movies table
        db.execSQL("create table " + MovieTable.TABLE + " (" +
                MovieTable.COL_NAME + " primary key, " +
                MovieTable.COL_YEAR + ", " +
                MovieTable.COL_PLOT + ", " +
                MovieTable.COL_POSTER + ", " +
                MovieTable.COL_RATING + ", " +
                MovieTable.COL_GENRE + ", " +
                MovieTable.COL_METASCORE + ", " +
                MovieTable.COL_IMDB_RATING + ", " +
                MovieTable.COL_PRODUCTION + ", " +
                MovieTable.COL_WRITER + ", " +
                MovieTable.COL_ACTORS + ", " +
                MovieTable.COL_RUNTIME + ", " +
                MovieTable.COL_RELEASED + ")");

        // Add an example movie
        Movie movie = new Movie(
                "Star Wars: Episode IV - A New Hope",
                "1977",
                "Luke Skywalker joins forces with a Jedi Knight, a cocky pilot, a Wookiee and two droids " +
                        "to save the galaxy from the Empire's world-destroying battle station, while also " +
                        "attempting to rescue Princess Leia from the mysterious Darth Vader.",
                "https://m.media-amazon.com/images/M/MV5BNzVlY2MwMjktM2E4OS00Y2Y3LWE3ZjctYzhkZGM3YzA1ZWM2XkEyXkFqcGdeQXVyNzkwMjQ5NzM@._V1_SX300.jpg",
                "PG",
                "Action, Adventure, Fantasy, Sci-Fi",
                "90",
                "8.6",
                "20th Century Fox",
                "George Lucas",
                "Mark Hamil, Harrison Ford, Carrie Fisher, Peter Cushing",
                "121 min",
                "25 May 1977"
                );

        ContentValues values = new ContentValues();
        values.put(MovieTable.COL_NAME, movie.getTitle());
        values.put(MovieTable.COL_YEAR, movie.getYear());
        values.put(MovieTable.COL_PLOT, movie.getPlot());
        values.put(MovieTable.COL_POSTER, movie.getPoster());
        values.put(MovieTable.COL_RATING, movie.getRating());
        values.put(MovieTable.COL_GENRE, movie.getGenre());
        values.put(MovieTable.COL_METASCORE, movie.getMetascore());
        values.put(MovieTable.COL_IMDB_RATING, movie.getImdbRating());
        values.put(MovieTable.COL_PRODUCTION, movie.getProduction());
        values.put(MovieTable.COL_WRITER, movie.getWriter());
        values.put(MovieTable.COL_ACTORS, movie.getActors());
        values.put(MovieTable.COL_RUNTIME, movie.getRuntime());
        values.put(MovieTable.COL_RELEASED, movie.getReleased());
        db.insert(MovieTable.TABLE, null, values);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists " + MovieTable.TABLE);
        onCreate(db);
    }

    @Override
    public void onOpen(SQLiteDatabase db) {
        super.onOpen(db);
        if (!db.isReadOnly()) {
            // Enable foreign key constraints
            if (Build.VERSION.SDK_INT < Build.VERSION_CODES.JELLY_BEAN) {
                db.execSQL("pragma foreign_keys = on;");
            } else {
                db.setForeignKeyConstraintsEnabled(true);
            }
        }
    }

    public List<Movie> getMovies(MovieSortOrder order) {

        List<Movie> movies = new ArrayList<>();

        SQLiteDatabase db = this.getReadableDatabase();

        String orderBy;
        switch (order) {
//            case ALPHABETIC:
//                orderBy = MovieTable.COL_NAME + " collate nocase";
//                break;
//            case UPDATE_DESC:
//                orderBy = MovieTable.COL_UPDATE_TIME + " desc";
//                break;
            default:
                orderBy = MovieTable.COL_NAME + " collate nocase";
                break;
        }

        String sql = "select * from " + MovieTable.TABLE + " order by " + orderBy;
        Cursor cursor = db.rawQuery(sql, null);
        if (cursor.moveToFirst()) {
            do {
                Movie movie = new Movie();
                movie.setTitle(cursor.getString(0));
                movie.setPoster(cursor.getString(3));
                movies.add(movie);
            } while (cursor.moveToNext());
        }
        cursor.close();

        return movies;
    }

    public boolean addMovie(Movie movie) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(MovieTable.COL_NAME, movie.getTitle());
        values.put(MovieTable.COL_YEAR, movie.getYear());
        values.put(MovieTable.COL_PLOT, movie.getPlot());
        values.put(MovieTable.COL_POSTER, movie.getPoster());
        values.put(MovieTable.COL_RATING, movie.getRating());
        values.put(MovieTable.COL_GENRE, movie.getGenre());
        values.put(MovieTable.COL_METASCORE, movie.getMetascore());
        values.put(MovieTable.COL_IMDB_RATING, movie.getImdbRating());
        values.put(MovieTable.COL_PRODUCTION, movie.getProduction());
        values.put(MovieTable.COL_WRITER, movie.getWriter());
        values.put(MovieTable.COL_ACTORS, movie.getActors());
        values.put(MovieTable.COL_RUNTIME, movie.getRuntime());
        values.put(MovieTable.COL_RELEASED, movie.getReleased());
        long id = db.insert(MovieTable.TABLE, null, values);
        return id != -1;
    }

    public void deleteMovie(Movie movie) {
        SQLiteDatabase db = getWritableDatabase();
        db.delete(MovieTable.TABLE,
                MovieTable.COL_NAME + " = ?", new String[] { movie.getTitle() });
    }

    public Movie getMovieDetails(String movieName) {
        SQLiteDatabase db = this.getReadableDatabase();
        String sql = "select * from " + MovieTable.TABLE +
                " where " + MovieTable.COL_NAME + " = ?";
        Cursor cursor = db.rawQuery(sql, new String[] { movieName });

        Movie movie = new Movie();
        if (cursor.moveToFirst()) {
            movie.setTitle(cursor.getString(0));
            movie.setYear(cursor.getString(1));
            movie.setPlot(cursor.getString(2));
            movie.setPoster(cursor.getString(3));
            movie.setRating(cursor.getString(4));
            movie.setGenre(cursor.getString(5));
            movie.setMetascore(cursor.getString(6));
            movie.setImdbRating(cursor.getString(7));
            movie.setProduction(cursor.getString(8));
            movie.setWriter(cursor.getString(9));
            movie.setActors(cursor.getString(10));
            movie.setRuntime(cursor.getString(11));
            movie.setReleased(cursor.getString(12));
        }
        cursor.close();

        return movie;
    }
}
