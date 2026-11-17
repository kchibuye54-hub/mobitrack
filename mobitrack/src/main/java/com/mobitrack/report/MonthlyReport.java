package com.mobitrack.report;

public class MonthlyReport
        implements Reportable {

    @Override
    public String generateReport() {

        return "Monthly Report";
    }
}