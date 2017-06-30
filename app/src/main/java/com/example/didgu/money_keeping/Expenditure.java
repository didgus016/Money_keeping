package com.example.didgu.money_keeping;

import java.util.Date;

/**
 * Created by didgu on 2017-06-13.
 */

public class Expenditure {
    private String expenditureName;
    private float expenditureAmount;
    private Date expenditureDate;
    private String description;

    // Non-valid Default Object initialization
    public Expenditure()
    {
        this.expenditureName = "void";
        this.expenditureAmount = 0;
        this.description = "void";
    }

    // Constructor
    public Expenditure(String name, float amount, Date date, String desc)
    {
        this.expenditureName = name;
        this.expenditureAmount = amount;
        this.expenditureDate = date;
        this.description = desc;
    }

    // Instantiate a new Object
    public static Expenditure createExpenditure(String name, float amount, Date date, String desc)
    {
        return new Expenditure(name, amount, date, desc);
    }

    // Getters and Setters
    public String getName() {
        return this.expenditureName;
    }
    public void setName(String name) {
        this.expenditureName = name;
    }
    public float getAmount() {
        return this.expenditureAmount;
    }
    public void setAmount(float amount) {
        this.expenditureAmount = amount;
    }

}
