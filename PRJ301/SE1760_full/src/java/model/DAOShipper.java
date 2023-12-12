/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import entity.Shipper;
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
public class DAOShipper extends DBConnect {

    public int insertShipper(Shipper shipper) {
        int n = 0;
        String sql = "INSERT INTO [Shippers]\n"
                + "           ([CompanyName]\n"
                + "           ,[Phone])\n"
                + "     VALUES(?, ?)";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, shipper.getCompanyName());
            pre.setString(2, shipper.getPhone());
            n = pre.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOShipper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }

    public int updateShipper(Shipper shipper) {
        int n = 0;
        String sql = "UPDATE [Shippers]\n"
                + "   SET [CompanyName] = ?\n"
                + "      ,[Phone] = ?\n"
                + " WHERE ShipperID = ?";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, shipper.getCompanyName());
            pre.setString(2, shipper.getPhone());
            pre.setInt(3, shipper.getShipperID());
            n = pre.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOShipper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }

    public int deleteShipper(int id) {
        int n = 0;
        String sql = "DELETE from Shippers WHERE ShipperID =" + id;
        try {
            Statement state = conn.createStatement();
            n = state.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(DAOShipper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }

    public Vector<Shipper> getShipper(String sql) {
        Vector<Shipper> vector = new Vector<Shipper>();
        ResultSet rs = getData(sql);
        try {
            while (rs.next()) {
                int shipperID = rs.getInt(1);
                String companyName = rs.getString(2);
                String phone = rs.getString(3);
                Shipper shipper = new Shipper(shipperID, companyName, phone);
                vector.add(shipper);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOShipper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return vector;
    }

    public static void main(String[] args) {
        DAOShipper dao = new DAOShipper();
        Vector<Shipper> vector = dao.getShipper("select * from Shippers");
        for (Shipper shipper : vector) {
            System.out.println(shipper);
        }
    }
}
