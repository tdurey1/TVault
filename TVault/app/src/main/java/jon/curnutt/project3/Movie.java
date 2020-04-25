package jon.curnutt.project3;

public class Movie {

    private String mMovieName;
    private String mMovieYear;
    private String mMoviePlot;
    private long mUpdateTime;

    public Movie() {}

    public Movie(String name, String year, String plot) {
        mMovieName = name;
        mMovieYear = year;
        mMoviePlot = plot;
        mUpdateTime = System.currentTimeMillis();
    }

    public String getName() {
        return mMovieName;
    }

    public void setName(String name) {
        mMovieName = name;
    }

    public String getYear() {
        return mMovieYear;
    }

    public void setYear(String year) {
        mMovieYear = year;
    }

    public String getPlot() {
        return mMoviePlot;
    }

    public void setPlot(String plot) {
        mMoviePlot = plot;
    }

    public long getUpdateTime() {
        return mUpdateTime;
    }

    public void setUpdateTime(long updateTime) {
        mUpdateTime = updateTime;
    }
}
