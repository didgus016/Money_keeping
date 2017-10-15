package com.example.didgu.money_keeping;

import android.content.Context;
import android.preference.Preference;
import android.text.Layout;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by didgu on 10/15/2017.
 */

public class NumberPickerPreference extends Preference {
    public NumberPickerPreference(Context context, AttributeSet attrs) {
        super(context, attrs);

        setLayoutResource(R.layout.numberpick_preference);
    }
}
