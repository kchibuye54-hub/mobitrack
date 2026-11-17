package com.mobitrack.model;

import java.time.LocalDate;

public class IncomeTransaction
        extends Transaction {

    public IncomeTransaction(
            int id,
            double amount,
            String description,
            LocalDate date) {

        super(id, amount, description, date);
    }

    @Override
    public String getType() {

        return "INCOME";
    }
}