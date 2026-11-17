package com.mobitrack.report;

public class CategoryReport
        implements Reportable {

    @Override
    public String generateReport() {

        return "Category Report";
    }
}