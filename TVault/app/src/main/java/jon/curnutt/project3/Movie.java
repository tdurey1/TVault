package jon.curnutt.project3;

public class Movie {

    private String mMovieTitle;
    private String mMovieYear;
    private String mMoviePlot;
    private String mMoviePoster;
    private String mMovieRating;
    private String mMovieGenre;
    private String mMovieMetascore;
    private String mMovieImdbRating;
    private String mMovieProduction;
    private String mMovieWriter;
    private String mMovieActors;
    private String mMovieRuntime;
    private String mMovieReleased;
    private long mUpdateTime;

    public Movie() {}

    public Movie(String title, String year, String plot, String poster, String rating, String genre, String metascore,
                 String imdbRating, String production, String writer, String actors, String runtime, String released) {
        mMovieTitle = title;
        mMovieYear = year;
        mMoviePlot = plot;
        mMoviePoster = poster;
        mMovieRating = rating;
        mMovieGenre = genre;
        mMovieMetascore = metascore;
        mMovieImdbRating = imdbRating;
        mMovieProduction = production;
        mMovieWriter = writer;
        mMovieActors = actors;
        mMovieRuntime = runtime;
        mMovieReleased = released;
        mUpdateTime = System.currentTimeMillis();
    }

    public String getTitle() {
        return mMovieTitle;
    }

    public void setTitle(String title) {
        mMovieTitle = title;
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

    public String getPoster() {return mMoviePoster; }

    public void setPoster(String poster) {mMoviePoster = poster;}

    public  String getRating() {return mMovieRating; }

    public void setRating(String rating) {mMovieRating = rating;}

    public String getGenre() {return mMovieGenre;}

    public void setGenre(String genre) {mMovieGenre = genre;}

    public String getImdbRating() {return mMovieImdbRating;}

    public void setImdbRating(String imdbRating) {mMovieImdbRating = imdbRating;}

    public String getMetascore() {return mMovieMetascore;}

    public void setMetascore(String metascore) {mMovieMetascore = metascore;}

    public String getProduction() {return mMovieProduction;}

    public void setProduction(String production) {mMovieProduction = production;}

    public String getWriter() {return mMovieWriter;}

    public void setWriter(String writer) {mMovieWriter = writer;}

    public String getActors() {return mMovieActors;}

    public void setActors(String actors) {mMovieActors = actors;}

    public String getRuntime() {return mMovieRuntime;}

    public void setRuntime(String runtime) {mMovieRuntime = runtime;}

    public String getReleased() {return mMovieReleased;}

    public void setReleased(String realeased) {mMovieReleased = realeased;}

    public long getUpdateTime() {
        return mUpdateTime;
    }

    public void setUpdateTime(long updateTime) {
        mUpdateTime = updateTime;
    }
}
