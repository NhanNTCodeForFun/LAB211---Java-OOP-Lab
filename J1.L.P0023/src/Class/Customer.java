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
public class Customer {

    private String phone;
    private String name;
    private Double totalPay;

    public Customer(String phone, String name, Double totalPay) {
        this.phone = phone;
        this.name = name;
        this.totalPay = totalPay;
    }

    public String getPhone() {
        return phone;
    }

    public String getName() {
        return name;
    }

    public Double getTotalPay() {
        return totalPay;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTotalPay(Double totalPay) {
        this.totalPay = totalPay;
    }

    public double discount() {
        if (totalPay >= 5000) {
            return 0.3;
        } else if (totalPay > 2000) {
            return 0.2;
        } else if (totalPay > 500) {
            return 0.1;
        }
        return 0;

    }

    @Override
    public String toString() {
        return phone + ";" + name + ";" + totalPay;
    }

}
