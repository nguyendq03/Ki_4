/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import entity.Region;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author admin
 */
public class DAORegion extends DBConnect {

    public int insertRegion(Region region) {
        int n = 0;
        String sql = "INSERT INTO [Region]\n"
                + "           ([RegionID]\n"
                + "           ,[RegionDescription])\n"
                + "     VALUES(?, ?)";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setInt(1, region.getRegionID());
            pre.setString(2, region.getRegionDescription());
            n = pre.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAORegion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }

    public int updateRegion(Region region) {
        int n = 0;
        String sql = "UPDATE [Region]\n"
                + "   SET [RegionID] = ?\n"
                + "      ,[RegionDescription] = ?\n"
                + " WHERE RegionID = ?";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setInt(1, region.getRegionID());
            pre.setString(2, region.getRegionDescription());
            pre.setInt(3, region.getRegionID());
            n = pre.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAORegion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }

    public int deleteRegion(int id) {
        int n = 0;
        String sql = "DELETE from Region WHERE RegionID =" + id;
        try {
            Statement state = conn.createStatement();
            n = state.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(DAORegion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }

    public Vector<Region> getRegion(String sql) {
        Vector<Region> vector = new Vector<Region>();
        ResultSet rs = getData(sql);
        try {
            while (rs.next()) {
                int RegionID = rs.getInt(1);
                String RegionDescription = rs.getString(2);
                Region region = new Region(RegionID, RegionDescription);
                vector.add(region);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAORegion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return vector;
    }

    public static void main(String[] args) {
        DAORegion dao = new DAORegion();
        Vector<Region> vector = dao.getRegion("select * from Region");
        for (Region region : vector) {
            System.out.println(region);
        }
    }
}
