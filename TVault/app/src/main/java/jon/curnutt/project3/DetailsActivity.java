package jon.curnutt.project3;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class DetailsActivity extends AppCompatActivity {
    public static final String MOVIE_DETAILS = "jon.curnutt.project3.movie";
    private final int REQUEST_CODE_NEW_QUESTION = 0;
    private final int REQUEST_CODE_UPDATE_QUESTION = 1;
    private MovieDatabase mMovieDb;
    private String mMovie;
    private TextView mTitleText;
    private TextView mYearText;
    private TextView mTitleYearText;
    private TextView mPlotText;
    private int mCurrentQuestionIndex;

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
        mTitleYearText = findViewById(R.id.titleYearText);
        mPlotText = findViewById(R.id.plotText);
    }

//    @Override
//    protected void onStart() {
//        super.onStart();
//
//        // Are there questions to display?
//        if (mQuestionList.size() == 0) {
//            updateAppBarTitle();
//            displayQuestion(false);
//        } else {
//            displayQuestion(true);
//            toggleAnswerVisibility();
//        }
//    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//
//        // Inflate menu for the app bar
//        MenuInflater inflater = getMenuInflater();
//        inflater.inflate(R.menu.question_menu, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//
//        // Determine which app bar item was chosen
//        switch (item.getItemId()) {
//            case R.id.previous:
//                showQuestion(mCurrentQuestionIndex - 1);
//                return true;
//            case R.id.next:
//                showQuestion(mCurrentQuestionIndex + 1);
//                return true;
//            case R.id.add:
//                addQuestion();
//                return true;
//            case R.id.edit:
//                editQuestion();
//                return true;
//            case R.id.delete:
//                deleteQuestion();
//                return true;
//            default:
//                return super.onOptionsItemSelected(item);
//        }
//    }


//    private void displayQuestion(boolean display) {
//
//        // Show or hide the appropriate screen
//        if (display) {
//            mShowQuestionsLayout.setVisibility(View.VISIBLE);
//            mNoQuestionsLayout.setVisibility(View.GONE);
//        } else {
//            mShowQuestionsLayout.setVisibility(View.GONE);
//            mNoQuestionsLayout.setVisibility(View.VISIBLE);
//        }
//    }

//    private void updateAppBarTitle() {
//
//        // Display subject and number of questions in app bar
//        ActionBar actionBar = getSupportActionBar();
//        if (actionBar != null) {
//            String title = getResources().getString(R.string.question_number,
//                    mMovie, mCurrentQuestionIndex + 1, mQuestionList.size());
//            setTitle(title);
//        }
//    }

//    private void showQuestion(int questionIndex) {
//
//        // Show question at the given index
//        if (mQuestionList.size() > 0) {
//            if (questionIndex < 0) {
//                questionIndex = mQuestionList.size() - 1;
//            } else if (questionIndex >= mQuestionList.size()) {
//                questionIndex = 0;
//            }
//
//            mCurrentQuestionIndex = questionIndex;
//            updateAppBarTitle();
//
//            Question question = mQuestionList.get(mCurrentQuestionIndex);
//            mQuestionText.setText(question.getText());
//            mAnswerText.setText(question.getAnswer());
//        }
//        else {
//            // No questions yet
//            mCurrentQuestionIndex = -1;
//        }
//    }

//    private void toggleAnswerVisibility() {
//        if (mAnswerText.getVisibility() == View.VISIBLE) {
//            mAnswerButton.setText(R.string.show_answer);
//            mAnswerText.setVisibility(View.INVISIBLE);
//            mAnswerLabel.setVisibility(View.INVISIBLE);
//        }
//        else {
//            mAnswerButton.setText(R.string.hide_answer);
//            mAnswerText.setVisibility(View.VISIBLE);
//            mAnswerLabel.setVisibility(View.VISIBLE);
//        }
//    }
}
