package com.example.didgu.money_keeping;

import android.annotation.TargetApi;
import android.os.Build;

import java.text.ParseException;
import java.util.Comparator;

/**
 * Created by didgu on 10/7/2017.
 */

public class ExpenditureDateComparator implements Comparator<Expenditure> {
    @TargetApi(Build.VERSION_CODES.N)
    public int compare(Expenditure left, Expenditure right) {
        try {
            return right.dateOut().compareTo(left.dateOut());
        } catch (ParseException e) {
            e.printStackTrace();
            return -1;
        }
    }
}
