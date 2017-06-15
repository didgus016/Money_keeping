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

    public Expenditure(String name, float amount, Date date, String desc) {
        this.expenditureName = name;
        this.expenditureAmount = amount;
        this.expenditureDate = date;
        this.description = desc;
    }

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
