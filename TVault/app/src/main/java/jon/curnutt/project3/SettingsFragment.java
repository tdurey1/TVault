package jon.curnutt.project3;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceFragment;
import android.preference.PreferenceManager;

public class SettingsFragment extends PreferenceFragment
        implements SharedPreferences.OnSharedPreferenceChangeListener {

    public static String PREFERENCE_THEME = "pref_theme";
    public static String PREFERENCE_ITEM_ORDER = "pref_subject_order";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Load the preferences from an XML resource
        addPreferencesFromResource(R.xml.preferences);

        // Access the default shared prefs
        SharedPreferences sharedPrefs =
                PreferenceManager.getDefaultSharedPreferences(getActivity());

        setPrefSummaryItemOrder(sharedPrefs);
        setPrefSummaryTheme(sharedPrefs);
    }

    // Set the summary to the currently selected movie order
    private void setPrefSummaryItemOrder(SharedPreferences sharedPrefs) {
        String order = sharedPrefs.getString(PREFERENCE_ITEM_ORDER, "1");
        String[] itemOrders = getResources().getStringArray(R.array.pref_item_order);
        Preference itemOrderPref = findPreference(PREFERENCE_ITEM_ORDER);
        itemOrderPref.setSummary(itemOrders[Integer.parseInt(order)]);
    }

    // Set the summary to the currently selected movie order
    private void setPrefSummaryTheme(SharedPreferences sharedPrefs) {
        String theme = sharedPrefs.getString(PREFERENCE_THEME, "0");
        String[] themes = getResources().getStringArray(R.array.pref_theme);
        Preference themePref = findPreference(PREFERENCE_THEME);
        themePref.setSummary(themes[Integer.parseInt(theme)]);
    }

    @Override
    public void onResume() {
        super.onResume();
        getPreferenceManager().getSharedPreferences().registerOnSharedPreferenceChangeListener(this);
    }

    @Override
    public void onPause() {
        getPreferenceManager().getSharedPreferences().unregisterOnSharedPreferenceChangeListener(this);
        super.onPause();
    }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
        if (key.equals(PREFERENCE_THEME)) {
            // Recreate the activity so the theme takes effect
            setPrefSummaryTheme(sharedPreferences);
            getActivity().recreate();
        }
        else if (key.equals(PREFERENCE_ITEM_ORDER)) {
            setPrefSummaryItemOrder(sharedPreferences);
        }
    }
}