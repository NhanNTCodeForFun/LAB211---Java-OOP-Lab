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
public class Staff {

    private String account;
    private String password;
    private String Name;
    private final String role;
    private String phone;
    private String Address;

    public Staff(String account, String password, String Name, String role, String Phone, String Address) {
        this.account = account;
        this.password = password;
        this.Name = Name;
        this.role = role;
        this.phone = Phone;
        this.Address = Address;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getAccount() {
        return account;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return Name;
    }

    public String getRole() {
        return role;
    }

    @Override
    public String toString() {
        return account + ";" + password + ";" + Name + ";" + role + ";" + phone + ";" + Address;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return Address;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

}
