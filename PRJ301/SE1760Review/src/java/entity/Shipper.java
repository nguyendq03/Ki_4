/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author admin
 */
public class Shipper {
    private int ShipperID;
    private String CompanyName, Phone;
    
    public Shipper(int ShipperID, String CompanyName, String Phone) {
        this.ShipperID = ShipperID;
        this.CompanyName = CompanyName;
        this.Phone = Phone;
    }

    public Shipper(String CompanyName, String Phone) {
        this.CompanyName = CompanyName;
        this.Phone = Phone;
    }
    
    public int getShipperID() {
        return ShipperID;
    }

    public void setShipperID(int ShipperID) {
        this.ShipperID = ShipperID;
    }
    public String getCompanyName() {
        return CompanyName;
    }

    public void setCompanyName(String CompanyName) {
        this.CompanyName = CompanyName;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String Phone) {
        this.Phone = Phone;
    }

    @Override
    public String toString() {
        return "Shipper{" + "CompanyName=" + CompanyName + ", Phone=" + Phone + '}';
    }
}
