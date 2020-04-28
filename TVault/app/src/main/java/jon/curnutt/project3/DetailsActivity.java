package jon.curnutt.project3;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.Picasso;


public class DetailsActivity extends AppCompatActivity {
    public static final String MOVIE_DETAILS = "jon.curnutt.project3.movie";
    private MovieDatabase mMovieDb;
    private String mMovie;
    private Movie mDetails;
    private TextView mTitleText;
    private TextView mYearText;
    private TextView mPlotText;
    private ImageView mPosterView;
    private TextView mRatingText;
    private TextView mGenreText;
    private TextView mMetascoreText;
    private TextView mImdbRatingText;
    private TextView mProductionText;
    private TextView mProductionLabel;
    private TextView mWriterText;
    private TextView mActorsText;
    private TextView mRuntimeText;
    private TextView mReleasedText;
    private String mTheme;
    private SharedPreferences mSharedPrefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        mSharedPrefs = PreferenceManager.getDefaultSharedPreferences(this);
        mTheme = mSharedPrefs.getString(SettingsFragment.PREFERENCE_THEME, "0");
        switch (mTheme) {
            case "0":
                setTheme(R.style.AppTheme);
                break;
            case "1":
                setTheme(R.style.DarkTheme);
                break;
            case "2":
                setTheme(R.style.RedTheme);
                break;
            case "3":
                setTheme(R.style.BlueTheme);
                break;
        }

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        Intent intent = getIntent();
        mMovie = intent.getStringExtra(MOVIE_DETAILS);

        mMovieDb = MovieDatabase.getInstance(getApplicationContext());

        mTitleText = findViewById(R.id.titleText);
        mYearText = findViewById(R.id.yearText);
        mPlotText = findViewById(R.id.plotText);
        mPosterView = findViewById(R.id.posterView);
        mRatingText = findViewById(R.id.ratingText);
        mGenreText = findViewById(R.id.genreText);
        mMetascoreText = findViewById(R.id.metascoreText);
        mImdbRatingText = findViewById(R.id.imdbRatingText);
        mProductionText = findViewById(R.id.productionText);
        mProductionLabel = findViewById(R.id.productionLabel);
        mWriterText = findViewById(R.id.writerText);
        mActorsText = findViewById(R.id.actorsText);
        mRuntimeText = findViewById(R.id.runtimeText);
        mReleasedText = findViewById(R.id.releasedText);
    }

    @Override
    protected void onStart() {
        super.onStart();

        displayDetails();
    }

    // Picasso resource: https://stackoverflow.com/questions/2471935/how-to-load-an-imageview-by-url-in-android
    // "No Poster" image: https://www.auro-3d.com/wp-content/uploads/2016/08/no-poster-available.jpg
    public void displayDetails() {
        mDetails = mMovieDb.getMovieDetails(mMovie);
        mTitleText.setText(mDetails.getTitle());
        mYearText.setText(mDetails.getYear());
        mPlotText.setText(mDetails.getPlot());

        // If length is less than 4, it is "N/A"
        if (mDetails.getPoster().length() > 4)
            Picasso.get().load(mDetails.getPoster()).into(mPosterView);
        else
            mPosterView.setImageResource(R.drawable.no_poster_available);
        mRatingText.setText(mDetails.getRating());
        mGenreText.setText(mDetails.getGenre());
        mMetascoreText.setText(mDetails.getMetascore());
        mImdbRatingText.setText(mDetails.getImdbRating());
        mProductionText.setText(mDetails.getProduction());
        mWriterText.setText(mDetails.getWriter());
        mActorsText.setText(mDetails.getActors());
        mRuntimeText.setText(mDetails.getRuntime());
        mReleasedText.setText(mDetails.getReleased());

        if (mDetails.getRating().contains("TV-"))
            mProductionLabel.setText(R.string.total_seasons);
    }
}
