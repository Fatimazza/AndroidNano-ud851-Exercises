package android.example.com.visualizerpreferences;

import android.os.Bundle;
import android.support.v7.preference.PreferenceFragmentCompat;

/**
 * Created by fatimazza on 1/22/18.
 */

public class SettingsFragment extends PreferenceFragmentCompat {

    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        // Add visualizer preferences, defined in the XML file in res->xml->pref_visualizer
        addPreferencesFromResource(R.xml.pref_visualizer);
    }
}
