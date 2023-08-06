package ClassPackage;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Rafael
 */
import java.util.List;
import java.util.Scanner;

public class LotAction{
    private MSystem mSystem;
    private Scanner scanner;

    public LotAction(MSystem mSystem, Scanner scanner) {
        this.mSystem = mSystem;
        this.scanner = scanner;
    }

    public void handleLotSearchAndBuy() {
        System.out.println("Do you want to search lots based on a preferred size?");
        System.out.println("1. Yes");
        System.out.println("2. No (Display all lot sizes)");

        int choice = scanner.nextInt();
        scanner.nextLine(); 

        switch (choice) {
            case 1:
                handleLotSearch();
                break;
            case 2:
                displayAllLots();
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }

    private void handleLotSearch() {
        System.out.print("Enter the size of the lot: ");
        int size = scanner.nextInt();
        System.out.print("Enter the block number: ");
        int block = scanner.nextInt();

        List<Lot> searchResult = mSystem.searchLots(size, block);
        if (searchResult.isEmpty()) {
            System.out.println("No lots matching the criteria found.");
        } else {
            System.out.println("Lots matching the criteria:");
            for (Lot lot : searchResult) {
                System.out.println("ID: " + lot.getId() + ", Size: " + lot.getSize() + " sq. meters, Location: Block " + lot.getLocation() + ", Price: $" + lot.getPrice() + ", Status: " + lot.getStatus());
            }

  
            System.out.print("Do you want to buy any of the listed lots? (Y/N): ");
            String buyChoice = scanner.next();
            if (buyChoice.equalsIgnoreCase("Y")) {
                handleLotBuying();
            }
        }
    }

    private void displayAllLots() {
        List<Lot> allLots = mSystem.getLots();
        if (allLots.isEmpty()) {
            System.out.println("No lots available.");
        } else {
            System.out.println("All available lots:");
            for (Lot lot : allLots) {
                System.out.println("ID: " + lot.getId() + ", Size: " + lot.getSize() + " sq. meters, Location: Block " + lot.getLocation() + ", Price: $" + lot.getPrice() + ", Status: " + lot.getStatus());
            }

      
            System.out.print("Do you want to buy any of the listed lots? (Y/N): ");
            String buyChoice = scanner.next();
            if (buyChoice.equalsIgnoreCase("Y")) {
                handleLotBuying();
            }
        }
    }

    private void handleLotBuying() {
        System.out.print("Enter the ID of the lot you want to buy: ");
        int lotId = scanner.nextInt();


        Lot selectedLot = null;
        for (Lot lot : mSystem.getLots()) {
            if (lot.getId() == lotId) {
                selectedLot = lot;
                break;
            }
        }

        if (selectedLot == null) {
            System.out.println("Invalid lot ID. Please try again.");
        } else {
    
            if (selectedLot.getStatus().equals("available")) {
                System.out.println("You have successfully purchased the following lot:");
                System.out.println("ID: " + selectedLot.getId() + ", Size: " + selectedLot.getSize() + " sq. meters, Location: Block " + selectedLot.getLocation() + ", Price: $" + selectedLot.getPrice());


                System.out.println("Please provide your Buyer ID: ");
                int buyerId = scanner.nextInt();
                Buyer selectedBuyer = null;
                for (Buyer buyer : mSystem.getBuyers()) {
                    if (buyer.getId() == buyerId) {
                        selectedBuyer = buyer;
                        break;
                    }
                }

                if (selectedBuyer != null) {
               
                    mSystem.sellLot(selectedLot, selectedBuyer);
                } else {
                    System.out.println("Invalid buyer ID. Please try again.");
                }
            } else {
                System.out.println("Sorry, Lot with ID " + selectedLot.getId() + " is not available for sale.");
            }
        }
    }
}