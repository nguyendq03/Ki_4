/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import entity.Supplier;
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
public class DAOSupplier extends DBConnect {

    public int insertSupplier(Supplier supplier) {
        int n = 0;
        String sql = "INSERT INTO [Suppliers]\n"
                + "           ([CompanyName]\n"
                + "           ,[ContactName]\n"
                + "           ,[ContactTitle]\n"
                + "           ,[Address]\n"
                + "           ,[City]\n"
                + "           ,[Region]\n"
                + "           ,[PostalCode]\n"
                + "           ,[Country]\n"
                + "           ,[Phone]\n"
                + "           ,[Fax]\n"
                + "           ,[HomePage])\n"
                + "     VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, supplier.getCompanyName());
            pre.setString(2, supplier.getContactName());
            pre.setString(3, supplier.getContactTitle());
            pre.setString(4, supplier.getAddress());
            pre.setString(5, supplier.getCity());
            pre.setString(6, supplier.getRegion());
            pre.setString(7, supplier.getPostalCode());
            pre.setString(8, supplier.getCountry());
            pre.setString(9, supplier.getPhone());
            pre.setString(10, supplier.getFax());
            pre.setString(11, supplier.getHomePage());
            n = pre.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOSupplier.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }

    public int updateSupplier(Supplier supplier) {
        int n = 0;
        String sql = "UPDATE [Suppliers]\n"
                + "   SET [CompanyName] = ?\n"
                + "      ,[ContactName] = ?\n"
                + "      ,[ContactTitle] = ?\n"
                + "      ,[Address] = ?\n"
                + "      ,[City] = ?\n"
                + "      ,[Region] = ?\n"
                + "      ,[PostalCode] = ?\n"
                + "      ,[Country] = ?\n"
                + "      ,[Phone] = ?\n"
                + "      ,[Fax] = ?\n"
                + "      ,[HomePage] = ?\n"
                + " WHERE SupplierID = ?";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, supplier.getCompanyName());
            pre.setString(2, supplier.getContactName());
            pre.setString(3, supplier.getContactTitle());
            pre.setString(4, supplier.getAddress());
            pre.setString(5, supplier.getCity());
            pre.setString(6, supplier.getRegion());
            pre.setString(7, supplier.getPostalCode());
            pre.setString(8, supplier.getCountry());
            pre.setString(9, supplier.getPhone());
            pre.setString(10, supplier.getFax());
            pre.setString(11, supplier.getHomePage());
            pre.setInt(12, supplier.getSupplierID());
            n = pre.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOSupplier.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }

    public int deleteSupplier(int id) {
        int n = 0;
        String sql = "DELETE from Suppliers WHERE SupplierID =" + id;
        try {
            Statement state = conn.createStatement();
            n = state.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(DAOSupplier.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }

    public Vector<Supplier> getSupplier(String sql){
        Vector<Supplier> vector = new Vector<Supplier>();
        ResultSet rs = getData(sql);
        try {
            while (rs.next()) {
                int id = rs.getInt(1);
                String companyName = rs.getString(2);
                String contactName = rs.getString(3);
                String contactTitle = rs.getString(4);
                String address = rs.getString(5);
                String city = rs.getString(6);
                String region = rs.getString(7);
                String postalCode = rs.getString(8);
                String country = rs.getString(9);
                String phone = rs.getString(10);
                String fax = rs.getString(11);
                String homePage = rs.getString(12);
                Supplier supplier = new Supplier(id, companyName, contactName, contactTitle, address, city, region, postalCode, country, phone, fax, homePage);
                vector.add(supplier);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOSupplier.class.getName()).log(Level.SEVERE, null, ex);
        }
        return vector;
    }

    public static void main(String[] args) {
        DAOSupplier dao = new DAOSupplier();
        dao.insertSupplier(new Supplier("test", "test", "test", "test", "test", "test", "test", "test", "test", "test", "test"));
        
    }
}
