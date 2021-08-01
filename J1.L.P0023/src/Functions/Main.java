/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Functions;

import Class.Customer;
import Class.Fruit;
import Class.Order;
import Class.Staff;
import java.util.ArrayList;
import java.util.Hashtable;

/**
 *
 * @author NhanNT
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ArrayList<Fruit> listfr = new ArrayList<>();
        ArrayList<Staff> listst = new ArrayList<>();
        ArrayList<Customer> listct = new ArrayList<>();

        ArrayList<Order> listorAll = new ArrayList<>();
        Hashtable<Customer, ArrayList<Order>> htAll = new Hashtable<>();
        Hashtable<Customer, ArrayList<Order>> ht = new Hashtable<>();

        Manager.loadCustomer("Customer.txt", listct);
        Manager.loadOrder("Order.txt", listorAll);
        Manager.loadStaff("Staff.txt", listst);
        Manager.loadFruit("Fruit.txt", listfr);
        Manager.loadToHashtable(htAll, listorAll, listct);
        boolean loginst = false;
        boolean logincus = false;
        while (true) {
            int choice = Manager.startMenu();

            switch (choice) {
                case 1:

                    Staff staff = null;

                    while (!loginst) {
                        staff = Manager.staffLogin(listst);
                        if (staff == null) {
                            break;
                        } else {
                            loginst = true;
                        }
                    }
                    if (staff == null) {
                        break;
                    }
                    if (staff.getRole().equalsIgnoreCase("manager")) {
                        int choiceManager = 0;
                        do {
                            choiceManager = Manager.managerMenu();
                            switch (choiceManager) {
                                case 1:
                                    int choiceManager1 = 0;
                                    do {
                                        choiceManager1 = Manager.FruitManagerMenu();
                                        switch (choiceManager1) {
                                            case 1:
                                                Manager.createFruit(listfr);
                                                break;
                                            case 2:
                                                Manager.Addquantity(listfr);
                                                break;
                                            case 3:
                                                Manager.reduceQuantity(listfr);
                                                break;
                                            case 4:
                                                Manager.updatePrice(listfr);
                                                break;
                                            case 5:
                                                Manager.deleteFruit(listfr);
                                                break;
                                            case 6:
                                                Manager.checkFruit(listfr);
                                                break;
                                            case 7:
                                                Manager.displayListFruit(listfr);
                                                break;
                                            case 8:

                                                break;

                                        }
                                    } while (choiceManager1 != 8);
                                    break;
                                case 2:
                                    int choiceManager2;
                                    do {
                                        choiceManager2 = Manager.StaffManagerMenu();
                                        switch (choiceManager2) {
                                            case 1:
                                                Manager.ListStaff(listst);
                                                break;
                                            case 2:
                                                Manager.CreateStaff(listst);

                                                break;
                                            case 3:
                                                Manager.removeStaff(listst);
                                                break;
                                            
                                            case 4:
                                                Manager.updateStaff(listst);
                                                break;
                                            case 5:
                                                break;
                                        }

                                    } while (choiceManager2 != 5);
                                    break;
                                case 3:
                                    int choiceManager3;
                                    do {
                                        choiceManager3 = Manager.OrderManagerMenu();
                                        switch (choiceManager3) {
                                            case 1:
                                                Manager.viewOrderAll(htAll);
                                                break;
                                            case 2:
                                                Manager.viewOrder(ht);
                                                break;
                                            case 3:
                                                Manager.checkOrderAll(htAll);
                                                break;
                                            case 4:
                                                Manager.checkOrder(ht);
                                                break;
                                            case 5:
                                                break;

                                        }

                                    } while (choiceManager3 != 5);
                                    break;
                                case 4:
                                    int choiceManager4;
                                    do {
                                        choiceManager4 = Manager.CustomerManagerMenu();
                                        switch (choiceManager4) {
                                            case 1:
                                                Manager.AllCustomer(listct);
                                                break;
                                            case 2:
                                                Manager.findCustomer(listct);
                                                break;
                                            case 3:
                                                break;

                                        }
                                    } while (choiceManager4 != 3);
                                    break;
                                case 5:
                                    Manager.ChangePassword(listst, staff);
                                    break;
                                case 6:
                                    Manager.writeFruit(listfr, "Fruit.txt");
                                    Manager.writeStaff(listst, "Staff.txt");
                                    loginst=false;
                                    break;
                            }
                        } while (choiceManager != 6);
                    } else {
                        int choiceStaff;
                        do {
                            choiceStaff = Manager.menuStaff();
                            switch (choiceStaff) {
                                case 1:
                                    Manager.Payment(ht);
                                    break;
                                case 2:
                                    Manager.viewOrder(ht);
                                    break;
                                case 3:
                                    Manager.ChangePassword(listst, staff);
                                    break;
                                case 4:
                                    loginst=false;
                                    break;
                            }

                        } while (choiceStaff != 4);
                    }

                    break;
                case 2:

                    int choice2;
                    double totalPay = 0.0;
                    Customer cus = null;
                    while (!logincus) {
                        cus = Manager.customerLogin(listct);
                        logincus = true;
                    }
                    ArrayList<Order> lo = new ArrayList<>();
                    do {
                        choice2 = Manager.menuCustomer();
                        switch (choice2) {
                            case 1:
                                Manager.shopping(listfr, ht, cus, lo);
                                break;
                            case 2:
                                int choice3;

                                do {
                                    Manager.displayListOrder(lo, cus);
                                    choice3 = Manager.menuOrder();
                                    switch (choice3) {
                                        case 1:
                                            int idx1 = Manager.getIndexOrderFromList(lo);
                                            Manager.deleteOrder(listfr, lo, idx1, ht, cus);
                                            break;
                                        case 2:
                                            int idx2 = Manager.getIndexOrderFromList(lo);
                                            Manager.cusUpdateOrder(listfr, lo, idx2, ht, cus);
                                            break;

                                    }
                                } while (choice3 != 3);
                                break;
                            case 3:
                                for (Order order : lo) {

                                    totalPay += order.getPrice() * order.getQuantity();
                                }
                                totalPay = cus.getTotalPay() + totalPay - totalPay * cus.discount();
                                for (Customer customer : listct) {
                                    if (customer.getPhone().equals(cus.getPhone())) {
                                        customer.setTotalPay(totalPay);
                                    }
                                }
                                Manager.updateHashTable(htAll, lo, cus);
                                Manager.updateListOrderAll(listorAll, lo);
                                System.out.println("Thanks for Shoping!");
                                logincus = false;
                                Manager.writeCustomer(listct, "Customer.txt");
                                break;
                        }
                    } while (choice2 != 3);
                    break;
                case 3:
                    Manager.writeFruit(listfr, "Fruit.txt");
                    Manager.writeOrder(listorAll, "Order.txt");
                    return;
            }
        }

    }
}
