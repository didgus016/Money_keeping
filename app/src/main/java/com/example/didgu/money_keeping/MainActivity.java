package com.example.didgu.money_keeping;

import android.content.Intent;
import android.icu.text.DateFormat;
import android.icu.text.NumberFormat;
import android.icu.text.SimpleDateFormat;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.text.ParseException;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void addExpend(View view) throws ParseException {
        String name = ((EditText) findViewById(R.id.expenditure_name)).getText().toString();

        String amount_str = ((EditText) findViewById(R.id.money_amount)).getText().toString();
        float amount = Float.parseFloat(amount_str);

        String date_str = ((EditText) findViewById(R.id.expenditure_date)).getText().toString();
        DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
        Date date = df.parse(date_str);

        EditText desc_field = (EditText) findViewById(R.id.description);
        String description = desc_field.getText().toString();

        Expenditure newExpenditure = Expenditure.createExpenditure(name, amount, date, description);

        /*
        Convert float amount to String of currency
         */
        //NumberFormat form = NumberFormat.getCurrencyInstance();
        //String temp = form.format(amount);
    }
}
