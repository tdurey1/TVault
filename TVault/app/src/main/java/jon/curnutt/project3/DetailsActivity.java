package jon.curnutt.project3;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


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
    private TextView mWriterText;
    private TextView mActorsText;
    private TextView mRuntimeText;
    private TextView mReleasedText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        // Hosting activity provides the subject of the questions to display
        Intent intent = getIntent();
        mMovie = intent.getStringExtra(MOVIE_DETAILS);

        // Load all questions for this subject
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

    public void displayDetails() {
        mDetails = mMovieDb.getMovieDetails(mMovie);
        mTitleText.setText(mDetails.getTitle());
        mYearText.setText(mDetails.getYear());
        mPlotText.setText(mDetails.getPlot());
        mPosterView.setImageURI(Uri.parse(mDetails.getPoster()));
        mRatingText.setText(mDetails.getRating());
        mGenreText.setText(mDetails.getGenre());
        mMetascoreText.setText(mDetails.getMetascore());
        mImdbRatingText.setText(mDetails.getImdbRating());
        mProductionText.setText(mDetails.getProduction());
        mWriterText.setText(mDetails.getWriter());
        mActorsText.setText(mDetails.getActors());
        mRuntimeText.setText(mDetails.getRuntime());
        mReleasedText.setText(mDetails.getReleased());

    }
}
