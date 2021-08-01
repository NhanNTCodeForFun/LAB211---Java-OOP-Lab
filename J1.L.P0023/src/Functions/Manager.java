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
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Scanner;

/**
 *
 * @author NhanNT
 */
public class Manager {

    Scanner in = new Scanner(System.in);
    /**
     * Start Menu
     * @return 
     */
    static int startMenu() {
        System.out.println("Are you Customer or Staff?");
        System.out.println("");
        System.out.println("1. Staff.");
        System.out.println("2. Customer.");
        System.out.println("3. Exit.");
        System.out.println("");
        System.out.println("Your chocie: ");
        int choice = Validation.checkInputIntLimit(1, 3);
        return choice;
    }
    /**
     * Manage menu
     * @return 
     */
    static int managerMenu() {
        System.out.println("1. Fruit manager.");
        System.out.println("2. Staff manager.");
        System.out.println("3. Order manager.");
        System.out.println("4. Customer manager.");
        System.out.println("5. Change password.");
        System.out.println("6. Exit.");
        System.out.println("");
        System.out.println("Your choice: ");
        int choice = Validation.checkInputIntLimit(1, 6);
        return choice;
    }
    /**
     * Manage Fruit Menu
     * @return 
     */
    static int FruitManagerMenu() {
        System.out.println("1. Create Fruit.");
        System.out.println("2. Add Quantity.");
        System.out.println("3. Reduce Quantity.");
        System.out.println("4. Update price.");
        System.out.println("5. Delete Fruit.");
        System.out.println("6. Check Fruit.");
        System.out.println("7. View all Fruit.");

        System.out.println("8. Exit.");
        System.out.println("");
        System.out.println("Your choice: ");
        int choice = Validation.checkInputIntLimit(1, 8);
        return choice;
    }
    /**
     * Manage Staff menu
     * @return 
     */
    static int StaffManagerMenu() {
        System.out.println("1. List Staff.");
        System.out.println("2. Create Staff.");
        System.out.println("3. Remove Staff.");
        System.out.println("4. Update Staff.");
        System.out.println("5. Exit.");
        System.out.println("");
        System.out.println("Your choice: ");
        int choice = Validation.checkInputIntLimit(1, 5);
        return choice;
    }
    /**
     * Manage order menu
     * @return 
     */

    static int OrderManagerMenu() {
        System.out.println("1. View Allorder(all).");
        System.out.println("2. View Allorder (today).");
        System.out.println("3. Check order(all).");
        System.out.println("4. Check order(today).");
        System.out.println("5. Exit.");
        System.out.println("");
        System.out.println("Your choice: ");
        int choice = Validation.checkInputIntLimit(1, 5);
        return choice;
    }
    /**
     * Manage customer menu
     * @return 
     */
    static int CustomerManagerMenu() {
        System.out.println("1. All customer.");
        System.out.println("2. Find customer.");
        System.out.println("3. Exit.");
        System.out.println("");
        System.out.println("Your choice: ");
        int choice = Validation.checkInputIntLimit(1, 3);
        return choice;
    }
    /**
     * Staff menu
     * @return 
     */
    static int menuStaff() {
        System.out.println("-----NTN FRUIT SHOP-----");
        System.out.println("");
        System.out.println("1. Payment.");
        System.out.println("2. View Allorder(today).");
        System.out.println("3. Change Password.");
        System.out.println("4. Exit.");
        System.out.println("");
        System.out.println("Your chocie: ");
        int choice = Validation.checkInputIntLimit(1, 4);
        return choice;
    }
    /**
     * Customer menu
     * @return 
     */
    static int menuCustomer() {
        System.out.println("-----NTN FRUIT SHOP-----");
        System.out.println("");
        System.out.println("1. Shopping.");
        System.out.println("2. View your order.");
        System.out.println("3. Stop Shopping.");
        System.out.println("");
        System.out.println("Your choice: ");
        int choice = Validation.checkInputIntLimit(1, 3);
        return choice;
    }
    /**
     * Order menu
     * @return 
     */
    static int menuOrder() {
        System.out.println("1. Delete order.");
        System.out.println("2. Update order.");
        System.out.println("3. Continue Shopping.");
        System.out.println("Your choice: ");
        int choice = Validation.checkInputIntLimit(1, 3);
        return choice;
    }
    /**
     * Main menu
     * @return 
     */
    static int menu() {
        System.out.println("1. Create Fruit");
        System.out.println("2. Shopping");
        System.out.println("3. View order");
        System.out.println("4. Exit");
        System.out.print("Enter your choice: ");
        int choice = Validation.checkInputIntLimit(1, 4);
        return choice;
    }
    /**
     * Create new fruit
     * @param listFruit 
     */
    static void createFruit(ArrayList<Fruit> listFruit) {
        System.out.println("Enter EXIT to Exit.");
        while (true) {
            System.out.print("Enter fruit id: ");
            String fruitId = Validation.checkInputString();
            if (fruitId.equalsIgnoreCase("exit")) {
                return;
            }
            if (!Validation.checkIdExist(listFruit, fruitId)) {
                System.out.println("Id exist");
                return;
            }
            System.out.print("Enter fruit name: ");
            String fruitName = Validation.checkInputString();
            if (fruitName.equalsIgnoreCase("exit")) {
                return;
            }
            System.out.print("Enter price: ");
            String priceString = Validation.checkInputString();
            if (priceString.equalsIgnoreCase("exit")) {
                return;
            }
            double price = Double.parseDouble(priceString);

            System.out.print("Enter quantity: ");
            String quantityString = Validation.checkInputString();
            if (quantityString.equalsIgnoreCase("exit")) {
                return;
            }
            int quantity = Integer.parseInt(quantityString);
            System.out.print("Enter origin: ");
            String origin = Validation.checkInputString();
            if (origin.equalsIgnoreCase("exit")) {
                return;
            }
            listFruit.add(new Fruit(fruitId, fruitName, price, quantity, origin));

        }
    }
    /**
     * View order
     * @param hashTable 
     */
    static void viewOrder(Hashtable<Customer, ArrayList<Order>> hashTable) {
        for (Customer cus : hashTable.keySet()) {
            System.out.println("Customer: " + cus.getName());
            ArrayList<Order> lo = hashTable.get(cus);
            displayListOrder(lo, cus);
        }
    }
    /**
     * Display view order all
     * @param hashTableAll 
     */
    static void viewOrderAll(Hashtable<Customer, ArrayList<Order>> hashTableAll) {
        for (Customer cus : hashTableAll.keySet()) {
            System.out.println("Customer: " + cus.getName());
            ArrayList<Order> lo = hashTableAll.get(cus);
            displayListOrder(lo);
        }
    }
    /**
     * Check order all
     * @param hashTableAll 
     */
    static void checkOrderAll(Hashtable<Customer, ArrayList<Order>> hashTableAll) {
        System.out.println("Enter Customer phonenumer to check: ");
        String phone = Validation.checkInputString();
        for (Customer cus : hashTableAll.keySet()) {
            if (cus.getPhone().equals(phone)) {
                displayListOrder(hashTableAll.get(cus));
                return;
            }
        }
        System.out.println("Not Fond!");
    }
    /**
     * Check Order
     * @param hashTable 
     */
    static void checkOrder(Hashtable<Customer, ArrayList<Order>> hashTable) {
        System.out.println("Enter Customer phonenumer to check: ");
        String phone = Validation.checkInputString();
        for (Customer cus : hashTable.keySet()) {
            if (cus.getPhone().equals(phone)) {
                displayListOrder(hashTable.get(cus), cus);
                return;
            }
        }
        System.out.println("Not Fond!");
    }
    /**
     * Payment function
     * @param hashTable 
     */
    static void Payment(Hashtable<Customer, ArrayList<Order>> hashTable) {
        System.out.println("Enter Customer phone number: ");
        String phone = Validation.checkInputString();
        for (Customer cus : hashTable.keySet()) {
            if (cus.getPhone().equals(phone)) {
                ArrayList<Order> lo = hashTable.get(cus);
                displayListOrder(lo, cus);
                return;
            }
        }
        System.out.println("Not have order!");
    }
    /**
     * Shopping function
     * @param listFruit
     * @param hashTable
     * @param customer
     * @param listOrder 
     */
    static void shopping(ArrayList<Fruit> listFruit, Hashtable<Customer, ArrayList<Order>> hashTable, Customer customer, ArrayList<Order> listOrder) {
        if (listFruit.isEmpty()) {
            System.out.println("Item not availaible.");
            return;
        }

        while (true) {
            displayListFruit(listFruit);
            System.out.print("Enter item: ");
            int item = Validation.checkInputIntLimit(1, listFruit.size());
            Fruit fruit = getFruitByItem(listFruit, item);
            System.out.print("Enter quantity: ");
            int quantity = Validation.checkInputIntLimit(1, fruit.getQuantity());
            fruit.setQuantity(fruit.getQuantity() - quantity);
            if (!Validation.checkItemExist(listOrder, fruit.getFruitId())) {
                updateOrder(listOrder, fruit.getFruitId(), quantity);
            } else {
                listOrder.add(new Order(customer.getPhone(), fruit.getFruitId(), fruit.getFruitName(),
                        quantity, fruit.getPrice()));
            }

            if (!Validation.checkInputYN()) {
                break;
            }
        }
        displayListOrder(listOrder, customer);
        hashTable.remove(customer);
        hashTable.put(customer, listOrder);
        System.out.println("Add successfull");
    }
    /**
     * Display list fruit
     * @param listFruit 
     */
    static void displayListFruit(ArrayList<Fruit> listFruit) {
        int countItem = 1;
        System.out.printf("%-10s%-20s%-10s%-20s%-15s\n", "Item", "Fruit name", "Quantity", "Origin", "Price");
        for (Fruit fruit : listFruit) {
            if (fruit.getQuantity() != 0) {
                System.out.printf("%-10d%-20s%-10s%-20s%1.0f$\n", countItem++,
                        fruit.getFruitName(), fruit.getQuantity(), fruit.getOrigin(), fruit.getPrice());
            }
        }
    }
    /**
     * Get fruit by item
     * @param listFruit
     * @param item
     * @return fruit
     */
    static Fruit getFruitByItem(ArrayList<Fruit> listFruit, int item) {
        int countItem = 1;
        for (Fruit fruit : listFruit) {
            if (fruit.getQuantity() != 0) {
                countItem++;
            }
            if (countItem - 1 == item) {
                return fruit;
            }
        }
        return null;
    }
    /**
     * Display list order
     * @param listOrder
     * @param customer 
     */
    static void displayListOrder(ArrayList<Order> listOrder, Customer customer) {
        double total = 0;
        System.out.printf("%15s%15s%15s%15s\n", "Product", "Quantity", "Price", "Total");
        for (Order order : listOrder) {
            System.out.printf("%15s%15d%15.0f$%15.0f$\n", order.getFruitName(),
                    order.getQuantity(), order.getPrice(),
                    order.getPrice() * order.getQuantity());
            total += order.getPrice() * order.getQuantity();
        }
        double discount = total * customer.discount();
        System.out.println("Discount: " + discount + "( " + customer.discount() * 100 + "%" + " )");
        System.out.println("Must pay: " + (total - discount));
    }
    /**
     * Display list order
     * @param listOrder 
     */
    static void displayListOrder(ArrayList<Order> listOrder) {

        System.out.printf("%15s%15s%15s%15s\n", "Product", "Quantity", "Price", "Total");
        for (Order order : listOrder) {
            System.out.printf("%15s%15d%15.0f$%15.0f$\n", order.getFruitName(),
                    order.getQuantity(), order.getPrice(),
                    order.getPrice() * order.getQuantity());

        }
    }
    /**
     * Update order
     * @param listOrder
     * @param id
     * @param quantity 
     */
    static void updateOrder(ArrayList<Order> listOrder, String id, int quantity) {
        for (Order order : listOrder) {
            if (order.getFruitId().equalsIgnoreCase(id)) {
                order.setQuantity(order.getQuantity() + quantity);
                return;
            }
        }
    }
    /**
     * Staff login function
     * @param listStaff
     * @return staff
     */
    public static Staff staffLogin(ArrayList<Staff> listStaff) {
        System.out.println("Login to continue!");
        System.out.println("Account: ");
        String account = Validation.checkInputString();
        System.out.println("Password: ");
        String passwork = Validation.checkInputString();
        for (Staff staff : listStaff) {
            if (staff.getAccount().equals(account) && staff.getPassword().equals(passwork)) {
                return staff;
            }
        }
        System.out.println("Login false!");
        return null;
    }
    /**
     * Customer login function
     * @param listCustomer
     * @return customer
     */
    public static Customer customerLogin(ArrayList<Customer> listCustomer) {
        System.out.println("Enter your phone number to connect with System: ");
        String phoneNumber = Validation.checkInputString();
        while (!Validation.checkPhoneNumber(phoneNumber)) {
            System.out.println("Please Enter valid phone number: ");
            phoneNumber = Validation.checkInputString();
        }
        for (Customer customer : listCustomer) {
            if (customer.getPhone().equals(phoneNumber)) {
                return customer;
            }
        }

        System.out.println("You are new Customer!");
        System.out.println("Enter your Name to continue: ");
        String name = Validation.checkInputString();
        listCustomer.add(new Customer(phoneNumber, name, 0.0));
        return listCustomer.get(listCustomer.size() - 1);
    }
    /**
     * Delete order
     * @param listFruit
     * @param listOrder
     * @param count
     * @param hashTable
     * @param customer 
     */
    public static void deleteOrder(ArrayList<Fruit> listFruit, ArrayList<Order> listOrder, int count, Hashtable<Customer, ArrayList<Order>> hashTable, Customer customer) {
        Order or = listOrder.get(count);
        for (Fruit fruit : listFruit) {
            if (or.getFruitId().equals(fruit.getFruitId())) {
                fruit.setQuantity(fruit.getQuantity() + or.getQuantity());
            }
        }
        listOrder.remove(count);
        hashTable.remove(customer);
        hashTable.put(customer, listOrder);

        System.out.println("Deleted!");
    }
    
    /**
     * Customer update order
     * @param listFruit
     * @param listOrder
     * @param count
     * @param hastTable
     * @param customer 
     */

    public static void cusUpdateOrder(ArrayList<Fruit> listFruit, ArrayList<Order> listOrder, int count, Hashtable<Customer, ArrayList<Order>> hastTable, Customer customer) {
        Order or = listOrder.get(count);
        int FruitQuan = 0;
        for (Fruit fruit : listFruit) {
            if (or.getFruitId().equals(fruit.getFruitId())) {
                fruit.setQuantity(fruit.getQuantity() + or.getQuantity());
                FruitQuan = fruit.getQuantity();
            }
        }
        System.out.println("Enter quantity: ");
        int quantity = Validation.checkInputIntLimit(1, FruitQuan);
        listOrder.get(count).setQuantity(quantity);
        for (Fruit fruit : listFruit) {
            if (or.getFruitId().equals(fruit.getFruitId())) {
                fruit.setQuantity(fruit.getQuantity() - quantity);
            }
        }
        hastTable.remove(customer);
        hastTable.put(customer, listOrder);
        System.out.println("Updated!");
    }
    /**
     * Get index of order from list all orders
     * @param listOrder
     * @return 
     */
    public static int getIndexOrderFromList(ArrayList<Order> listOrder) {
        int count = 1;
        System.out.printf("%10s%15s%15s%15s\n", "Product", "Quantity", "Price", "Total");
        for (Order order : listOrder) {
            System.out.printf("%10s%15s%15d%15.0f$\n", count, order.getFruitName(),
                    order.getQuantity(), order.getPrice(),
                    order.getPrice() * order.getQuantity());
            count++;

        }
        System.out.println("Your choice: ");
        int choice = Validation.checkInputIntLimit(1, listOrder.size());
        return choice - 1;

    }
    /**
     * Load fruit from file
     * @param filename
     * @param listFruit 
     */
    public static void loadFruit(String filename, ArrayList<Fruit> listFruit) {
        FileReader f = null;
        BufferedReader bf = null;
        try {
            f = new FileReader(filename);
            bf = new BufferedReader(f);
            while (bf.ready()) {
                String tmp = bf.readLine();
                String[] arr = tmp.split(";");
                if (arr.length == 5) {
                    Fruit fr = new Fruit(arr[0], arr[1], Double.parseDouble(arr[2]), Integer.parseInt(arr[3]), arr[4]);
                    listFruit.add(fr);
                }
            }
        } catch (IOException | NumberFormatException e) {
            System.out.println(e);
        } finally {
            try {
                if (f != null) {
                    f.close();
                }
                if (bf != null) {
                    bf.close();
                }
            } catch (IOException e) {
                System.out.println(e);
            }
        }
    }
    /**
     * Write Fruit to file
     * @param listFruit
     * @param filename 
     */
    public static void writeFruit(ArrayList<Fruit> listFruit, String filename) {
        if (listFruit == null || listFruit.isEmpty()) {
            return;
        }
        PrintWriter w = null;
        try {
            w = new PrintWriter(filename);
            
            for (Fruit fr : listFruit) {
                w.println(fr.toString());
            }

        } catch (FileNotFoundException e) {
            System.out.println(e);
        } finally {
            try {
                if (w != null) {
                    w.close();
                }
            } catch (Exception e) {
            }
        }
    }
    /**
     * Load Staff from file
     * @param filename
     * @param listStaff 
     */
    public static void loadStaff(String filename, ArrayList<Staff> listStaff) {
        FileReader f = null;
        BufferedReader bf = null;
        try {
            f = new FileReader(filename);
            bf = new BufferedReader(f);
            while (bf.ready()) {
                String tmp = bf.readLine();
                String[] arr = tmp.split(";");
                if (arr.length == 6) {
                    Staff st = new Staff(arr[0], arr[1], arr[2], arr[3], arr[4], arr[5]);
                    listStaff.add(st);
                }
            }
        } catch (IOException e) {
            System.out.println(e);
        } finally {
            try {
                if (f != null) {
                    f.close();
                }
                if (bf != null) {
                    bf.close();
                }
            } catch (IOException e) {
                System.out.println(e);
            }
        }
    }
    /**
     * Write staff to file
     * @param listStaff
     * @param filename 
     */
    public static void writeStaff(ArrayList<Staff> listStaff, String filename) {
        if (listStaff == null || listStaff.isEmpty()) {
            return;
        }
        PrintWriter w = null;
        try {
            w = new PrintWriter(filename);
            //TO DO: your code write list of Stock to file
            for (Staff staff : listStaff) {
                w.println(staff.toString());
            }

        } catch (FileNotFoundException e) {
            System.out.println(e);
        } finally {
            try {
                if (w != null) {
                    w.close();
                }
            } catch (Exception e) {
            }
        }
    }
    /**
     * Load Customer from file
     * @param filename
     * @param listCustomer 
     */
    public static void loadCustomer(String filename, ArrayList<Customer> listCustomer) {
        FileReader f = null;
        BufferedReader bf = null;
        try {
            f = new FileReader(filename);
            bf = new BufferedReader(f);
            while (bf.ready()) {
                String tmp = bf.readLine();
                String[] arr = tmp.split(";");
                if (arr.length == 3) {
                    Customer cus = new Customer(arr[0], arr[1], Double.parseDouble(arr[2]));
                    listCustomer.add(cus);
                }
            }
        } catch (IOException | NumberFormatException e) {
            System.out.println(e);
        } finally {
            try {
                if (f != null) {
                    f.close();
                }
                if (bf != null) {
                    bf.close();
                }
            } catch (IOException e) {
                System.out.println(e);
            }
        }
    }
    /**
     * Write customer to file
     * @param listCustomer
     * @param filename 
     */
    public static void writeCustomer(ArrayList<Customer> listCustomer, String filename) {
        if (listCustomer == null || listCustomer.isEmpty()) {
            return;
        }
        PrintWriter w = null;
        try {
            w = new PrintWriter(filename);
            //TO DO: your code write list of Stock to file
            for (Customer cus : listCustomer) {
                w.println(cus.toString());
            }

        } catch (FileNotFoundException e) {
            System.out.println(e);
        } finally {
            try {
                if (w != null) {
                    w.close();
                }
            } catch (Exception e) {
            }
        }
    }
    
    /**
     * Load order from file
     * @param filename
     * @param listOrderAll 
     */

    public static void loadOrder(String filename, ArrayList<Order> listOrderAll) {
        FileReader f = null;
        BufferedReader bf = null;
        try {
            f = new FileReader(filename);
            bf = new BufferedReader(f);
            while (bf.ready()) {
                String tmp = bf.readLine();
                String[] arr = tmp.split(";");
                if (arr.length == 5) {
                    Order or = new Order(arr[0], arr[1], arr[2], Integer.parseInt(arr[3]), Double.parseDouble(arr[4]));
                    listOrderAll.add(or);
                }
            }
        } catch (IOException | NumberFormatException e) {
            System.out.println(e);
        } finally {
            try {
                if (f != null) {
                    f.close();
                }
                if (bf != null) {
                    bf.close();
                }
            } catch (IOException e) {
                System.out.println(e);
            }
        }

    }

    /**
     * Write order to file
     * @param listOrderAll
     * @param filename 
     */
    public static void writeOrder(ArrayList<Order> listOrderAll, String filename) {
        if (listOrderAll == null || listOrderAll.isEmpty()) {
            return;
        }
        PrintWriter w = null;
        try {
            w = new PrintWriter(filename);
            
            for (Order or : listOrderAll) {
                w.println(or.toString());
            }

        } catch (FileNotFoundException e) {
            System.out.println(e);
        } finally {
            try {
                if (w != null) {
                    w.close();
                }
            } catch (Exception e) {
            }
        }
    }
    /**
     * Load data to hashTable
     * @param hashTableAll
     * @param listOrderAll
     * @param listCustomer 
     */
    public static void loadToHashtable(Hashtable<Customer, ArrayList<Order>> hashTableAll, ArrayList<Order> listOrderAll, ArrayList<Customer> listCustomer) {
        for (Customer customer : listCustomer) {
            ArrayList<Order> list = new ArrayList<>();
            for (Order order : listOrderAll) {
                if (order.getCusPhone().equals(customer.getPhone())) {
                    list.add(order);
                }
            }
            if (!list.isEmpty()) {
                hashTableAll.put(customer, list);
            }
        }
    }
    /**
     * Update hashTable
     * @param hashTableAll
     * @param listOrder
     * @param Customer 
     */
    public static void updateHashTable(Hashtable<Customer, ArrayList<Order>> hashTableAll, ArrayList<Order> listOrder, Customer Customer) {

        ArrayList<Order> ls = hashTableAll.get(Customer);
        for (Order order : listOrder) {
            ls.add(order);
        }
        hashTableAll.remove(Customer);
        hashTableAll.put(Customer, ls);
    }
    
    /**
     * Update order list
     * @param listOrderAll
     * @param listOrder 
     */
    public static void updateListOrderAll(ArrayList<Order> listOrderAll, ArrayList<Order> listOrder) {
        for (Order order : listOrder) {
            listOrderAll.add(order);
        }
    }
    
    /**
     * Display all Customer
     * @param listCustomer 
     */
    public static void AllCustomer(ArrayList<Customer> listCustomer) {
        int count = 1;
        System.out.printf("%10s%20s%25s%15s%10s\n", "Count", "Phone", "Name", "TotalPay", "Discount");
        for (Customer customer : listCustomer) {
            System.out.printf("%10d%20s%25s%15.0f%10s\n", count, customer.getPhone(), customer.getName(), customer.getTotalPay(), (customer.discount() * 100) + "%");
            count++;
        }
    }
    /**
     * Find Customer by phone number
     * @param listCustomer 
     */
    public static void findCustomer(ArrayList<Customer> listCustomer) {
        System.out.println("Enter Customer phone: ");
        String phone = Validation.checkInputString();
        if (!Validation.checkPhoneNumber(phone)) {
            System.out.println("Not Valid phonenumber!");
            return;
        }
        for (Customer customer : listCustomer) {
            if (customer.getPhone().equals(phone)) {
                System.out.printf("%20s%25s%15s%10s\n", "Phone", "Name", "TotalPay", "Discount");
                System.out.printf("%20s%25s%15.0f%10s\n", customer.getPhone(), customer.getName(), customer.getTotalPay(), (customer.discount() * 100) + "%");
                return;
            }
        }
        System.out.println("Do not exist Customer.");
    }
    
    /**
     * Get list Staff
     * @param listStaff 
     */

    public static void ListStaff(ArrayList<Staff> listStaff) {
        int count = 1;
        System.out.printf("%-6s%-10s%-23s%-10s%-12s%-20s\n", "Count", "Account", "Name", "Role", "Phone", "Address");
        for (Staff staff : listStaff) {
            System.out.printf("%-6s%-10s%-23s%-10s%-12s%-20s\n", count, staff.getAccount(), staff.getName(), staff.getRole(), staff.getPhone(), staff.getAddress());
            count++;
        }
    }
    /**
     * Update Staff
     * @param listStaff 
     */

    public static void updateStaff(ArrayList<Staff> listStaff) {
        Scanner sc = new Scanner(System.in);
        int choice;
        if (listStaff.isEmpty()) {
            System.out.println("List Staff is empty!");
        } else {
            ListStaff(listStaff);
            System.out.println("Your choice: ");
            choice = Validation.checkInputIntLimit(1, listStaff.size());
            System.out.println("Enter phone Number: ");
            String phone = sc.nextLine().trim();
            if (phone.equals("")) {
                phone = listStaff.get(choice - 1).getPhone();
            }
            System.out.println("Enter Address: ");
            String address = sc.nextLine().trim();
            if (address.equals("")) {
                address = listStaff.get(choice - 1).getAddress();
            }
            listStaff.get(choice - 1).setPhone(phone);
            listStaff.get(choice - 1).setAddress(address);
            System.out.println("Updated!");

        }
        writeStaff(listStaff, "Staff.txt");

    }
    
    /**
     * Create new Staff
     * @param listStaff 
     */

    public static void CreateStaff(ArrayList<Staff> listStaff) {
        System.out.println("Enter Acount: ");
        String account = Validation.checkInputString();
        System.out.println("Enter Name: ");
        String name = Validation.checkInputString();
        System.out.println("Enter Phonenumber: ");
        String phone = Validation.checkInputString();
        System.out.println("Enter Address: ");
        String address = Validation.checkInputString();
        listStaff.add(new Staff(account, "12345678", name, "Staff", phone, address));
        System.out.println("Added!");
        writeStaff(listStaff, "Staff.txt");
    }
    /**
     * Remove Staff
     * @param listStaff 
     */
    public static void removeStaff(ArrayList<Staff> listStaff) {
        ListStaff(listStaff);
        System.out.println("Choice a Staff: ");
        int choice = Validation.checkInputIntLimit(1, listStaff.size());
        listStaff.remove(choice - 1);
        System.out.println("Removed!");
        writeStaff(listStaff, "Staff.txt");
    }
    /**
     * Change Password for Staff
     * @param listStaff
     * @param staff 
     */
    public static void ChangePassword(ArrayList<Staff> listStaff, Staff staff) {

        System.out.println("Enter new password: ");
        String pw = Validation.checkInputString();
        System.out.println("ReEnter new password: ");
        String repw = Validation.checkInputString();
        if (!pw.equals(repw)) {
            System.out.println("Not match!");
            return;
        }
        System.out.println("Enter current password to Change: ");
        String curpw = Validation.checkInputString();
        if (!curpw.equals(staff.getPassword())) {
            System.out.println("Change fail!");
            return;
        }
        staff.setPassword(pw);
        for (Staff staff1 : listStaff) {
            if (staff1.getAccount().equals(staff.getAccount())) {
                staff1.setPassword(pw);
            }
        }
        System.out.println("Changed!");
        writeStaff(listStaff, "Staff.txt");
    }
    /**
     * Add quantity of fruit
     * @param listFruit 
     */

    public static void Addquantity(ArrayList<Fruit> listFruit) {
        displayListFruit(listFruit);
        System.out.println("Enter your add.");
        System.out.println("Fomat: item-quantity");
        System.out.println("Ex: 1-30,2-10");
        String s = Validation.checkInputString();
        String[] arrSt = s.split(",");
        for (String string : arrSt) {
            String[] arr = string.split("-");
            int item = Integer.parseInt(arr[0]);
            int quantity = Integer.parseInt(arr[1]);
            listFruit.get(item - 1).setQuantity(listFruit.get(item - 1).getQuantity() + quantity);
        }
        System.out.println("Added!");
    }
    
    /**
     * Reduce quantity of fruit
     * @param listFruit 
     */
    public static void reduceQuantity(ArrayList<Fruit> listFruit) {
        displayListFruit(listFruit);
        System.out.println("Enter your add.");
        System.out.println("Fomat: item-quantity");
        System.out.println("Ex: 1-30,2-10");
        String s = Validation.checkInputString();
        String[] arrSt = s.split(",");
        for (String string : arrSt) {
            String[] arr = string.split("-");
            int item = Integer.parseInt(arr[0]);
            int quantity = Integer.parseInt(arr[1]);
            if (quantity <= listFruit.get(item - 1).getQuantity()) {
                listFruit.get(item - 1).setQuantity(listFruit.get(item - 1).getQuantity() - quantity);
            }
        }
        System.out.println("Reduced!");
    }
    /**
     * Delete Fruit
     * @param listFruit 
     */

    public static void deleteFruit(ArrayList<Fruit> listFruit) {
        displayListFruit(listFruit);

        System.out.println("EX Fomat: 1-4,5,7-10");
        System.out.println("Enter your choice: ");
        String s = Validation.checkInputString();
        if (s != null) {
            String[] arr = s.split(",");

            int length = arr.length;
            for (int i = 0; i < arr.length; i++) {
                if (arr[i].contains("-")) {
                    String[] arr2 = arr[i].split("-");
                    int from = Integer.parseInt(arr2[0]);
                    int to = Integer.parseInt(arr2[1]);
                    length = length + to - from;
                }
            }
            int[] choice = new int[length];
            int index = 0;
            for (int i = 0; i < arr.length; i++) {

                if (arr[i].contains("-")) {
                    String[] arr2 = arr[i].split("-");
                    int from = Integer.parseInt(arr2[0]);
                    int to = Integer.parseInt(arr2[1]);
                    for (int j = from; j <= to; j++) {
                        choice[index] = j;
                        index++;
                    }

                } else {
                    choice[index] = Integer.parseInt(arr[i]);
                    index++;

                }
            }
            ArrayList<Fruit> deletelist = new ArrayList<Fruit>();

            for (int i = 0; i < choice.length; i++) {
                System.out.println(choice[i]);
            }
            for (Integer integer : choice) {
                int idx = integer - 1;
                deletelist.add(listFruit.get(idx));
            }

            System.out.println(deletelist.get(0).toString());
            System.out.println(deletelist.get(1).toString());
            for (Fruit fruit : deletelist) {
                listFruit.remove(fruit);
            }

            System.out.println("Removed!");
        }
    }
    /**
     * Check information of fruit by id
     * @param listFruit 
     */
    public static void checkFruit(ArrayList<Fruit> listFruit) {
        System.out.println("Enter fruit id: ");
        String id = Validation.checkInputString();
        for (Fruit fruit : listFruit) {
            if (fruit.getFruitId().equals(id)) {
                System.out.printf("%-10s%-20s%-20s%-20s%-15s\n", "ID", "Fruit name", "Quantity", "Origin", "Price");
                System.out.printf("%-10s%-20s%-20s%-20s%1.0f$\n", fruit.getFruitId(),
                        fruit.getFruitName(), fruit.getQuantity(), fruit.getOrigin(), fruit.getPrice());
                return;
            }
        }
        System.out.println("No exist Fruit");
    }
    /**
     * Update price of Fruit
     * @param listFruit 
     */
    public static void updatePrice(ArrayList<Fruit> listFruit) {
        displayListFruit(listFruit);

        System.out.println("Fomat: item-price");
        System.out.println("Ex: 1-30.0,2-10.0");
        System.out.println("Enter your Update: ");
        String s = Validation.checkInputString();
        String[] arrSt = s.split(",");
        for (String string : arrSt) {
            String[] arr = string.split("-");
            int item = Integer.parseInt(arr[0]);
            Double price = Double.parseDouble(arr[1]);

            listFruit.get(item - 1).setPrice(price);

        }
        System.out.println("Updated!");
    }

}
