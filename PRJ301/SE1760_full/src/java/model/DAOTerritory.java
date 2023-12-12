/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import entity.Territory;
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
public class DAOTerritory extends DBConnect {

    public int insertTerritory(Territory territory) {
        int n = 0;
        String sql = "INSERT INTO [Territories]\n"
                + "           ([TerritoryID]\n"
                + "           ,[TerritoryDescription]\n"
                + "           ,[RegionID])\n"
                + "     VALUES(?, ?, ?)";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, territory.getTerritoryID());
            pre.setString(2, territory.getTerritoryDescription());
            pre.setInt(3, territory.getRegionID());
            n = pre.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOTerritory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }

    public int updateTerritory(Territory territory) {
        int n = 0;
        String sql = "UPDATE [Territories]\n"
                + "   SET [TerritoryID] = ?\n"
                + "      ,[TerritoryDescription] = ?\n"
                + "      ,[RegionID] = ?\n"
                + " WHERE TerritoryID = ?";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, territory.getTerritoryID());
            pre.setString(2, territory.getTerritoryDescription());
            pre.setInt(3, territory.getRegionID());
            n = pre.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOTerritory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }

    public int deleteTerritory(String id) {
        int n = 0;
        String sql = "DELETE from Territories WHERE TerritoryID =" + id;
        try {
            Statement state = conn.createStatement();
            n = state.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(DAOTerritory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }

    public Vector<Territory> getTerritory(String sql) {
        Vector<Territory> vector = new Vector<Territory>();
        ResultSet rs = getData(sql);
        try {
            while (rs.next()) {
                String TerritoryID = rs.getString(1);
                String TerritoryDescription = rs.getString(2);
                int regionID = rs.getInt(3);
                Territory territory = new Territory(TerritoryID, TerritoryDescription, regionID);
                vector.add(territory);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOTerritory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return vector;
    }

    public static void main(String[] args) {
        DAOTerritory dao = new DAOTerritory();

    }
}
