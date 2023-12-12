/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import entity.CustomerCustomerDemo;
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
public class DAOCustomerCustomerDemo extends DBConnect {

    public int insertCustomerCustomerDemo(CustomerCustomerDemo cusCusDemo) {
        int n = 0;
        String sql = "INSERT INTO [dbo].[CustomerCustomerDemo]\n"
                + "           ([CustomerID]\n"
                + "           ,[CustomerTypeID])\n"
                + "     VALUES(?, ?)";
        //number of ? is number of fields
        //??index of ? start with 1
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            //pre.setDataType(indexOf?, para);
            pre.setString(1, cusCusDemo.getCustomerID());
            pre.setString(2, cusCusDemo.getCustomerTypeID());
            n = pre.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOCustomerCustomerDemo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }

    public int updateCustomerCustomerDemo(CustomerCustomerDemo cusCusDemo) {
        int n = 0;
        String sql = "UPDATE [CustomerCustomerDemo]\n"
                + "   SET [CustomerID] = ?\n"
                + "      ,[CustomerTypeID] = ?\n"
                + " WHERE CustomerID = ?";
        //number of ? is number of fields
        //??index of ? start with 1
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            //pre.setDataType(indexOf?, para);
            pre.setString(1, cusCusDemo.getCustomerID());
            pre.setString(2, cusCusDemo.getCustomerTypeID());
            pre.setString(3, cusCusDemo.getCustomerID());
            n = pre.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOCustomerCustomerDemo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }

    public int deleteCustomerCustomerDemo(String id) {
        int n = 0;
        String sql = "DELETE from CustomerCustomerDemo WHERE CustomerID =" + id;
        try {
            Statement state = conn.createStatement();
            n = state.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(DAOCustomerCustomerDemo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }

    public Vector<CustomerCustomerDemo> getCustomerCustomerDemo(String sql) {
        Vector<CustomerCustomerDemo> vector = new Vector<CustomerCustomerDemo>();
        ResultSet rs = getData(sql);
        try {
            while (rs.next()) {
                String customerID = rs.getString(1); // or id = rs.getInt(1) since the index of id is 1 in ResultSet
                String customerTypeID = rs.getString(2);
                CustomerCustomerDemo cusCusDemo = new CustomerCustomerDemo(customerID, customerTypeID);
                vector.add(cusCusDemo);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOCustomerCustomerDemo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return vector;
    }

    public static void main(String[] args) {
        DAOCustomerCustomerDemo dao = new DAOCustomerCustomerDemo();
        Vector<CustomerCustomerDemo> vector = (Vector<CustomerCustomerDemo>) dao.getData("select * from CustomerCustomerDemo");
        for (CustomerCustomerDemo cusCusDemo : vector) {
            System.out.println(cusCusDemo);
        }
    }
}
