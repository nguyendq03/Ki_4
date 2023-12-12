/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author admin
 */
public class Region {
    private int RegionID;
    private String RegionDescription;

    public Region(int RegionID, String RegionDescription) {
        this.RegionID = RegionID;
        this.RegionDescription = RegionDescription;
    }

    public Region(String RegionDescription) {
        this.RegionDescription = RegionDescription;
    }

    public int getRegionID() {
        return RegionID;
    }

    public void setRegionID(int RegionID) {
        this.RegionID = RegionID;
    }

    public String getRegionDescription() {
        return RegionDescription;
    }

    public void setRegionDescription(String RegionDescription) {
        this.RegionDescription = RegionDescription;
    }

    @Override
    public String toString() {
        return "Region{" + "RegionID=" + RegionID + ", RegionDescription=" + RegionDescription + '}';
    }
}
