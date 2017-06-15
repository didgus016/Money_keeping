package com.example.didgu.money_keeping;

import android.content.Intent;
import android.icu.text.NumberFormat;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void addExpend(View view) {
        EditText name_field = (EditText) findViewById(R.id.expenditure_name);
        String name = name_field.getText().toString();
        String amount_str = ((EditText) findViewById(R.id.money_amount)).getText().toString();
        float amount = Float.parseFloat(amount_str);

        /*
        Convert float amount to String of currency
         */
        //NumberFormat form = NumberFormat.getCurrencyInstance();
        //String temp = form.format(amount);
    }

}
