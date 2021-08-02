/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Class;

/**
 *
 * @author NhanNT
 */
public class Fruit {

    private String FruitId;
    private String FruitName;
    private double price;
    private int quantity;
    private String Origin;

    public Fruit() {
    }

    public Fruit(String FruitId, String FruitName, double price, int quantity, String Origin) {
        this.FruitId = FruitId;
        this.FruitName = FruitName;
        this.price = price;
        this.quantity = quantity;
        this.Origin = Origin;
    }

    public String getFruitId() {
        return FruitId;
    }

    public void setFruitId(String FruitID) {
        this.FruitId = FruitId;
    }

    public String getFruitName() {
        return FruitName;
    }

    public void setFruitName(String FruitName) {
        this.FruitName = FruitName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getOrigin() {
        return Origin;
    }

    public void setOrigin(String Origin) {
        this.Origin = Origin;
    }

    @Override
    public String toString() {
        return FruitId + ";" + FruitName + ";" + price + ";" + quantity + ";" + Origin;
    }
}
