package com.mobitrack;

import java.util.Scanner;

import com.mobitrack.repository.TransactionRepository;
import com.mobitrack.service.TransactionService;

public class App {

    public static void main(String[] args) {

        TransactionRepository repository =
                new TransactionRepository();

        repository.createTables();

        TransactionService service =
                new TransactionService();

        Scanner scanner =
                new Scanner(System.in);

        while (true) {

            System.out.println();
            System.out.println("=================================");
            System.out.println(" MOBITRACK ");
            System.out.println("=================================");
            System.out.println("1. Add Income");
            System.out.println("2. Add Expense");
            System.out.println("3. View Transactions");
            System.out.println("4. Monthly Report");
            System.out.println("5. Delete Transaction");
            System.out.println("6. Search Transaction");
            System.out.println("7. Exit");
            System.out.print("Choice: ");

            int choice =
                    Integer.parseInt(scanner.nextLine());

            switch (choice) {

                case 1:
                    service.addIncome();
                    break;

                case 2:
                    service.addExpense();
                    break;

                case 3:
                    service.viewTransactions();
                    break;

                case 4:
                    service.generateReport();
                    break;

                case 5:
                    service.deleteTransaction();
                    break;

                case 6:
                    service.searchTransaction();
                    break;

                case 7:
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid Option");
            }
        }
    }
}