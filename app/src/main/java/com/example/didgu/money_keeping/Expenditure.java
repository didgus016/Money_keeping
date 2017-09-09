package com.example.didgu.money_keeping;

import android.os.Build;
import android.support.annotation.RequiresApi;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by didgu on 2017-06-13.
 */

public class Expenditure {
    private String name;
    private String amount;
    private String date;
    private String description;
    private String uid;

    // Non-valid Default Object initialization
    public Expenditure() {}

    // Constructor
    public Expenditure(String name, String amount, String date, String desc, String uid)
    {
        this.name = name;
        this.amount = amount;
        this.date = date;
        this.description = desc;
        this.uid = uid;
    }

    // Instantiate a new Object
    public static Expenditure createExpenditure(String name, String amount, String date, String desc, String uid)
    {
        return new Expenditure(name, amount, date, desc, uid);
    }

    // Getters and Setters
    public String getName() {
        return this.name;
    }
    public String getAmount()
    {
        return this.amount;
    }
    public String getDate()
    {
        return this.date;
    }
    public String getDescription()
    {
        return this.description;
    }
    public String getUid()
    {
        return this.uid;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setAmount(String amount) {
        this.amount = amount;
    }

    public float amountOut() {
        return Float.parseFloat(amount);
    }
    @RequiresApi(api = Build.VERSION_CODES.N)
    public Date dateOut() throws ParseException {
        // parses and formats the date and converts into Date class
        DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
        return df.parse(date);
    }

}
