package com.mobitrack.model;

import java.time.LocalDate;

public class ExpenseTransaction
        extends Transaction {

    public ExpenseTransaction(
            int id,
            double amount,
            String description,
            LocalDate date) {

        super(id, amount, description, date);
    }

    @Override
    public String getType() {

        return "EXPENSE";
    }
}