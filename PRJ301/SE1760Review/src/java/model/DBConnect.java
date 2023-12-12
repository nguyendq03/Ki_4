/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBConnect {

    Connection conn = null;

    public DBConnect(String url, String user, String pass) {
        try {
            //call Driver
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            //connect
            conn = DriverManager.getConnection(url, user, pass);
        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
        }
    }

    public ResultSet getData(String sql) {
        ResultSet rs = null;
        try {
            Statement state = conn.createStatement(
                    ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            rs = state.executeQuery(sql);
        } catch (SQLException | NullPointerException ex) {
            Logger.getLogger(DAOProduct.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }

    public DBConnect() {
        this("jdbc:sqlserver://localhost:1433;databaseName=SE1760", "sa", "123456");
    }

    public static void main(String[] args) {
        DBConnect dao = new DBConnect();
        ResultSet rs = dao.getData("select p.ProductID, p.ProductName, s.CompanyName, \n"
                + "	c.CategoryName, p.QuantityPerUnit, p.UnitPrice,\n"
                + "	p.UnitsInStock, p.UnitsOnOrder, p.ReorderLevel, p.Discontinued\n"
                + "from Products p join Suppliers s on p.SupplierID = s.SupplierID\n"
                + "	join Categories c on p.CategoryID = c.CategoryID");
        try {
            while(rs.next()) {
                System.out.println(rs.getInt("ProductID"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
