package ClassPackage;


import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Rafael
 */
public class Buyer {
    private int id;
    private String name;
    private String phone;
    private List<Lot> lotsReserved;
    private List<Lot> lotsPurchased;


    public Buyer(int id, String name, String phone) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.lotsReserved = new ArrayList<>();
        this.lotsPurchased = new ArrayList<>();
    }

    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<Lot> getLotsReserved() {
        return lotsReserved;
    }

    public void setLotsReserved(List<Lot> lotsReserved) {
        this.lotsReserved = lotsReserved;
    }

    public List<Lot> getLotsPurchased() {
        return lotsPurchased;
    }

    public void setLotsPurchased(List<Lot> lotsPurchased) {
        this.lotsPurchased = lotsPurchased;
    } 
}

