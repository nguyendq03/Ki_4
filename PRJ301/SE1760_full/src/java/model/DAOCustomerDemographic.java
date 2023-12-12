/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import entity.CustomerDemographic;
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
public class DAOCustomerDemographic extends DBConnect {

    public int insertCustomerDemographic(CustomerDemographic cus) {
        int n = 0;
        String sql = "INSERT INTO [CustomerDemographics]\n"
                + "           ([CustomerTypeID]\n"
                + "           ,[CustomerDesc])\n"
                + "     VALUES(?, ?)";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, cus.getCustomerTypeID());
            pre.setString(2, cus.getCustomerDesc());
            n = pre.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOCustomer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }

    public int updateCustomerDemographic(CustomerDemographic cus) {
        int n = 0;
        String sql = "UPDATE [CustomerDemographics]\n"
                + "   SET [CustomerTypeID] = ?\n"
                + "      ,[CustomerDesc] = ?\n"
                + " WHERE CustomerTypeID = ?";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            //pre.setDataType(indexOf?, para);
            pre.setString(1, cus.getCustomerTypeID());
            pre.setString(2, cus.getCustomerDesc());
            pre.setString(3, cus.getCustomerTypeID());
            n = pre.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOCustomer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }

    public int deleteCustomerDemographic(String id) {
        int n = 0;
        String sql = "DELETE from CustomerDemographics WHERE CustomerTypeID =" + id;
        try {
            Statement state = conn.createStatement();
            n = state.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(DAOCustomer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }

    public Vector<CustomerDemographic> getCustomerDemographic(String sql) {
        Vector<CustomerDemographic> vector = new Vector<CustomerDemographic>();
        ResultSet rs = getData(sql);
        try {
            while (rs.next()) {
                String customerTypeID = rs.getString(1);
                String customerDesc = rs.getString(2);
                CustomerDemographic cus = new CustomerDemographic(customerTypeID, customerDesc);
                vector.add(cus);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOCustomerDemographic.class.getName()).log(Level.SEVERE, null, ex);
        }

        return vector;
    }

    public static void main(String[] args) {
        DAOCustomerDemographic dao = new DAOCustomerDemographic();
        Vector<CustomerDemographic> vector = dao.getCustomerDemographic("select * from CustomerDemographics");
        for (CustomerDemographic customer : vector) {
            System.out.println(customer);
        }
    }
}
