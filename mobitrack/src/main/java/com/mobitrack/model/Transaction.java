package com.mobitrack.model;

import java.time.LocalDate;

public abstract class Transaction {

    protected int id;
    protected double amount;
    protected String description;
    protected LocalDate date;

    public Transaction(int id,
                       double amount,
                       String description,
                       LocalDate date) {

        this.id = id;
        this.amount = amount;
        this.description = description;
        this.date = date;
    }

    public abstract String getType();
}