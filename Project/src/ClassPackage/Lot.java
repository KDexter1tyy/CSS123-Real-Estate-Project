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
public class Lot {
    private int id;
    private int size;
    private int location;
    private double price;
    private String status;

    public Lot(int id, int size, int location, double price, String status) {
        this.id = id;
        this.size = size;
        this.location = location;
        this.price = price;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public int getSize() {
        return size;
    }

    public int getLocation() {
        return location;
    }

    public double getPrice() {
        return price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
