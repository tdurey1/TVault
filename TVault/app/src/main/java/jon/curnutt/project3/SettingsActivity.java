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
        switch (theme) {
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

        // Display the fragment as the main content
        getFragmentManager().beginTransaction()
                .replace(android.R.id.content, new SettingsFragment())
                .commit();
    }
}
