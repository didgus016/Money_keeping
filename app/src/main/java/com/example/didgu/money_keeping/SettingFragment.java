package com.example.didgu.money_keeping;

import android.os.Bundle;
import android.preference.PreferenceFragment;

/**
 * Created by didgu on 10/8/2017.
 */

public class SettingFragment extends PreferenceFragment {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.preferences);
    }
}
