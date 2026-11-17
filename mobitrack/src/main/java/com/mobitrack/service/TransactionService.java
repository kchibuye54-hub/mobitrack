package com.mobitrack.service;

import java.util.Scanner;
import com.mobitrack.repository.TransactionRepository;

public class TransactionService {

    private final TransactionRepository repository =
            new TransactionRepository();

    private final Scanner scanner =
            new Scanner(System.in);

    public void addIncome() {

        System.out.print("Amount: ");

        double amount =
                Double.parseDouble(
                        scanner.nextLine());

        System.out.print("Description: ");

        String description =
                scanner.nextLine();

        repository.addTransaction(
                amount,
                description,
                "INCOME");
    }

    public void addExpense() {

        System.out.print("Amount: ");

        double amount =
                Double.parseDouble(
                        scanner.nextLine());

        System.out.print("Description: ");

        String description =
                scanner.nextLine();

        repository.addTransaction(
                amount,
                description,
                "EXPENSE");
    }

    public void viewTransactions() {

        repository.viewTransactions();
    }

    public void generateReport() {

        repository.generateReport();
    }

    public void deleteTransaction() {

        System.out.print("Transaction ID: ");

        int id =
                Integer.parseInt(
                        scanner.nextLine());

        repository.deleteTransaction(id);
    }

    public void searchTransaction() {

        System.out.print("Keyword: ");

        String keyword =
                scanner.nextLine();

        repository.searchTransaction(keyword);
    }
}