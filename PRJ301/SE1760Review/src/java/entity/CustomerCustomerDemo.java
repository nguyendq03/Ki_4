package entity;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author admin
 */
public class CustomerCustomerDemo {
    private String CustomerID, CustomerTypeID;

    public CustomerCustomerDemo(String CustomerID, String CustomerTypeID) {
        this.CustomerID = CustomerID;
        this.CustomerTypeID = CustomerTypeID;
    }

    public CustomerCustomerDemo(String CustomerTypeID) {
        this.CustomerTypeID = CustomerTypeID;
    }
    
    public String getCustomerID() {
        return CustomerID;
    }

    public void setCustomerID(String CustomerID) {
        this.CustomerID = CustomerID;
    }

    public String getCustomerTypeID() {
        return CustomerTypeID;
    }

    public void setCustomerTypeID(String CustomerTypeID) {
        this.CustomerTypeID = CustomerTypeID;
    }

    @Override
    public String toString() {
        return "CustomerCustomerDemo{" + "CustomerID=" + CustomerID + ", CustomerTypeID=" + CustomerTypeID + '}';
    }


}
