package jon.curnutt.project3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;

public class SettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        SharedPreferences sharedPrefs = PreferenceManager.getDefaultSharedPreferences(this);
        String theme = sharedPrefs.getString(SettingsFragment.PREFERENCE_THEME, "0");
        if (theme == "0") {
            setTheme(R.style.AppTheme);
        }
        else if(theme == "1") {
            setTheme(R.style.DarkTheme);
        }
        else if(theme == "2") {
            setTheme(R.style.RedTheme);
        }
        else if(theme == "3") {
            setTheme(R.style.BlueTheme);
        }

        super.onCreate(savedInstanceState);

        // Display the fragment as the main content
        getFragmentManager().beginTransaction()
                .replace(android.R.id.content, new SettingsFragment())
                .commit();
    }
}
