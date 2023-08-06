package ClassPackage;

import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Rafael
 */

public class Main {

    public static void main(String[] args) {
        
        
       
        MSystem mSystem = MSystem.getInstance(); // Singleton Pattern Access
        Scanner scanner = new Scanner(System.in);
        LotAction lotHandler = new LotAction(mSystem, scanner);

        // Display a menu to the user and handle their choices
        int choice;
        do {
            displayMenu();
            choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    // Lot Searching
                    lotHandler.handleLotSearchAndBuy();
                    break;
                case 2:
                    // Lot Selling
                    handleLotSelling(scanner, mSystem);
                    break;
                case 3:
                    // Generate a report
                    handleFileReport(scanner, mSystem);
                    break;
                case 4:
                    // Exit the program
                    System.out.println("Exiting the MSystem. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 4);

        // Close the scanner
        scanner.close();
    }

    private static void displayMenu() {
        System.out.println("REAL ESTATE SALES & MANAGEMENT SYSTEM");
        System.out.println("1. Search lots");
        System.out.println("2. Sell a lot");
        System.out.println("3. Generate report");
        System.out.println("4. Exit");
        System.out.print("Enter your choice: ");
    }

    private static void handleLotSelling(Scanner scanner, MSystem mSystem) {
        // Code to handle lot selling, similar to the previous implementation
        // ...
    }

    private static void handleFileReport(Scanner scanner, MSystem mSystem) {
        mSystem.saveLotsToFile();
    }
    
}
