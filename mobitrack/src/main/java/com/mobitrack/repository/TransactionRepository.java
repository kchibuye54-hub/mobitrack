package com.mobitrack.repository;

import com.mobitrack.database.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class TransactionRepository {

    public void createTables() {

        try {

            Connection connection =
                    DatabaseConnection.connect();

            Statement statement =
                    connection.createStatement();

            statement.execute(
                    """
                    CREATE TABLE IF NOT EXISTS users(
                        id INTEGER PRIMARY KEY,
                        name TEXT,
                        phone TEXT
                    )
                    """);

            statement.execute(
                    """
                    CREATE TABLE IF NOT EXISTS categories(
                        id INTEGER PRIMARY KEY,
                        name TEXT
                    )
                    """);

            statement.execute(
                    """
                    CREATE TABLE IF NOT EXISTS transactions(
                        id INTEGER PRIMARY KEY,
                        amount REAL,
                        description TEXT,
                        date TEXT,
                        type TEXT
                    )
                    """);

            System.out.println(
                    "All tables created successfully.");

        } catch(Exception e) {

            System.out.println(
                    e.getMessage());
        }
    }

    public void addTransaction(
            double amount,
            String description,
            String type) {

        try {

            Connection connection =
                    DatabaseConnection.connect();

            String sql =
                    "INSERT INTO transactions " +
                    "(amount, description, date, type) " +
                    "VALUES (?, ?, date('now'), ?)";

            PreparedStatement statement =
                    connection.prepareStatement(sql);

            statement.setDouble(1, amount);
            statement.setString(2, description);
            statement.setString(3, type);

            statement.executeUpdate();

            System.out.println(
                    "Transaction Saved");

        } catch(Exception e) {

            System.out.println(
                    e.getMessage());
        }
    }

    public void viewTransactions() {

        try {

            Connection connection =
                    DatabaseConnection.connect();

            Statement statement =
                    connection.createStatement();

            ResultSet result =
                    statement.executeQuery(
                            "SELECT * FROM transactions");

            while(result.next()) {

                System.out.println(
                        result.getInt("id")
                        + " | "
                        + result.getString("description")
                        + " | "
                        + result.getDouble("amount")
                        + " | "
                        + result.getString("type"));
            }

        } catch(Exception e) {

            System.out.println(
                    e.getMessage());
        }
    }

    public void generateReport() {

        try {

            Connection connection =
                    DatabaseConnection.connect();

            Statement statement =
                    connection.createStatement();

            ResultSet income =
                    statement.executeQuery(
                            "SELECT SUM(amount) total FROM transactions WHERE type='INCOME'");

            double totalIncome =
                    income.getDouble("total");

            ResultSet expense =
                    statement.executeQuery(
                            "SELECT SUM(amount) total FROM transactions WHERE type='EXPENSE'");

            double totalExpense =
                    expense.getDouble("total");

            double balance =
                    totalIncome - totalExpense;

            System.out.println();
            System.out.println(
                    "===== MONTHLY REPORT =====");

            System.out.println(
                    "Total Income : K"
                    + totalIncome);

            System.out.println(
                    "Total Expense: K"
                    + totalExpense);

            System.out.println(
                    "Balance      : K"
                    + balance);

        } catch(Exception e) {

            System.out.println(
                    e.getMessage());
        }
    }

    public void deleteTransaction(
            int id) {

        try {

            Connection connection =
                    DatabaseConnection.connect();

            String sql =
                    "DELETE FROM transactions WHERE id=?";

            PreparedStatement statement =
                    connection.prepareStatement(sql);

            statement.setInt(1, id);

            int rows =
                    statement.executeUpdate();

            if(rows > 0) {

                System.out.println(
                        "Transaction Deleted");

            } else {

                System.out.println(
                        "Transaction Not Found");
            }

        } catch(Exception e) {

            System.out.println(
                    e.getMessage());
        }
    }

    public void searchTransaction(
            String keyword) {

        try {

            Connection connection =
                    DatabaseConnection.connect();

            String sql =
                    "SELECT * FROM transactions " +
                    "WHERE description LIKE ?";

            PreparedStatement statement =
                    connection.prepareStatement(sql);

            statement.setString(
                    1,
                    "%" + keyword + "%");

            ResultSet result =
                    statement.executeQuery();

            while(result.next()) {

                System.out.println(
                        result.getInt("id")
                        + " | "
                        + result.getString("description")
                        + " | "
                        + result.getDouble("amount")
                        + " | "
                        + result.getString("type"));
            }

        } catch(Exception e) {

            System.out.println(
                    e.getMessage());
        }
    }
}