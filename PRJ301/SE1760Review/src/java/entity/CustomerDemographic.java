/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author admin
 */
public class CustomerDemographic {
    private String CustomerTypeID, CustomerDesc;

    public String getCustomerTypeID() {
        return CustomerTypeID;
    }

    public CustomerDemographic(String CustomerTypeID, String CustomerDesc) {
        this.CustomerTypeID = CustomerTypeID;
        this.CustomerDesc = CustomerDesc;
    }

    public CustomerDemographic(String CustomerDesc) {
        this.CustomerDesc = CustomerDesc;
    }

    public void setCustomerTypeID(String CustomerTypeID) {
        this.CustomerTypeID = CustomerTypeID;
    }

    public String getCustomerDesc() {
        return CustomerDesc;
    }

    public void setCustomerDesc(String CustomerDesc) {
        this.CustomerDesc = CustomerDesc;
    }
    
    @Override
    public String toString() {
        return "CustomerDemographic{" + "CustomerTypeID=" + CustomerTypeID + ", CustomerDesc=" + CustomerDesc + '}';
    }    
}
