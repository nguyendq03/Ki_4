/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author admin
 */
public class Territory {
    private String TerritoryID, TerritoryDescription;
    private int RegionID;

    public Territory(String TerritoryID, String TerritoryDescription, int RegionID) {
        this.TerritoryID = TerritoryID;
        this.TerritoryDescription = TerritoryDescription;
        this.RegionID = RegionID;
    }

    public String getTerritoryID() {
        return TerritoryID;
    }

    public void setTerritoryID(String TerritoryID) {
        this.TerritoryID = TerritoryID;
    }

    public String getTerritoryDescription() {
        return TerritoryDescription;
    }

    public void setTerritoryDescription(String TerritoryDescription) {
        this.TerritoryDescription = TerritoryDescription;
    }

    public int getRegionID() {
        return RegionID;
    }

    public void setRegionID(int RegionID) {
        this.RegionID = RegionID;
    }

    public Territory(String TerritoryDescription, int RegionID) {
        this.TerritoryDescription = TerritoryDescription;
        this.RegionID = RegionID;
    }

    @Override
    public String toString() {
        return "Territory{" + "TerritoryID=" + TerritoryID + ", TerritoryDescription=" + TerritoryDescription + ", RegionID=" + RegionID + '}';
    }
}
