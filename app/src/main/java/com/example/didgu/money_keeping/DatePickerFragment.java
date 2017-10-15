package com.example.didgu.money_keeping;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.widget.DatePicker;
import android.widget.EditText;

import java.util.Calendar;

import static android.R.style.Theme_DeviceDefault_Light_Dialog_Alert;

/**
 * Created by didgu on 2017-06-27.
 */

public class DatePickerFragment extends DialogFragment implements DatePickerDialog.OnDateSetListener {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);
        return new DatePickerDialog(getActivity(),
                Theme_DeviceDefault_Light_Dialog_Alert, this, year, month, day);
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int day) {
        EditText dateEditText = (EditText) getActivity().findViewById(R.id.expenditure_date);
        dateEditText.setText(month+1 +"/" + day + "/" + year);
    }
}
