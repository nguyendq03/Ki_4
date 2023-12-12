/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author admin
 */
public class EmployeeTerritory {
    private int EmployeeID;
    private String TerritoryID;

    public EmployeeTerritory(int EmployeeID, String TerritoryID) {
        this.EmployeeID = EmployeeID;
        this.TerritoryID = TerritoryID;
    }

    public int getEmployeeID() {
        return EmployeeID;
    }

    public void setEmployeeID(int EmployeeID) {
        this.EmployeeID = EmployeeID;
    }

    public String getTerritoryID() {
        return TerritoryID;
    }

    public void setTerritoryID(String TerritoryID) {
        this.TerritoryID = TerritoryID;
    }

    @Override
    public String toString() {
        return "EmployeeTerritory{" + "EmployeeID=" + EmployeeID + ", TerritoryID=" + TerritoryID + '}';
    }
    
    
}
