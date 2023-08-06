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
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class MSystem implements FileReport {
    private static MSystem instance; 
    private List<Lot> lots;
    private List<Buyer> buyers;
    private List<Seller> sellers;


    private MSystem() {
        lots = new ArrayList<>(); 
        buyers = new ArrayList<>();
        sellers = new ArrayList<>();

   
        addPreloadedLots();
    }
       //Singleton design pattern

    public static MSystem getInstance() {
        if (instance == null) {
            instance = new MSystem();
        }
        return instance;
    }

    // Getters and setters for lots
    public List<Lot> getLots() {
        return lots;
    }

    public void setLots(List<Lot> lots) {
        this.lots = lots;
    }


    public List<Buyer> getBuyers() {
        return buyers;
    }

    public void setBuyers(List<Buyer> buyers) {
        this.buyers = buyers;
    }


    public List<Seller> getSellers() {
        return sellers;
    }

    public void setSellers(List<Seller> sellers) {
        this.sellers = sellers;
    }


    public List<Lot> searchLots(int size, int block) {
        List<Lot> result = new ArrayList<>();
        for (Lot lot : lots) {
            if (lot.getSize() == size && lot.getLocation() == block) {
                result.add(lot);
            }
        }
        return result;
    }


      public void sellLot(Lot lot, Buyer buyer) {
        if (lot.getStatus().equals("available")) {
            // Set the lot's status to "sold"
            lot.setStatus("sold");

            // Add the lot to the buyer's list of purchased lots
            buyer.getLotsPurchased().add(lot);

            System.out.println("Lot with ID " + lot.getId() + " has been sold to Buyer with ID " + buyer.getId());
        } else {
            System.out.println("Sorry, Lot with ID " + lot.getId() + " is not available for sale.");
        }
    }


    @Override
    public void generateReport() {
      
    }

    public void saveLotsToFile() {
        String filename = "Lot.txt";
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            for (Lot lot : lots) {
         
                writer.println("ID: " + lot.getId());
                writer.println("Lot: " + lot.getSize() + " sq. meters");
                writer.println("Location: Block " + lot.getLocation());
                writer.println("Price: $" + lot.getPrice());
                writer.println("Status: " + lot.getStatus());
                writer.println(); 
            }
            System.out.println("Lot Report Generated To " + filename);
        } catch (IOException e) {
            System.err.println("Unable to Write: " + e.getMessage());
        }
    }
    private void addPreloadedLots() {

        lots.add(new Lot(1, 50, 1, 250000, "Available"));
        lots.add(new Lot(2, 100, 2, 350000, "Available"));
        lots.add(new Lot(3, 150, 5, 450000, "Available"));
    }
}