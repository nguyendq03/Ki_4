/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import entity.Product;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author admin
 */
public class DAOProduct extends DBConnect {

    /*
    DAO: Database Access Object
            service: add, delete, update, select...
     */
 /* 
    Statement method:
    .executeUpate: insert, update, delete
    .executeQuery: select
    .execute: create, drop, alter
     */
    public int insertProduct(Product pro) {
        int n = 0;
        String sql = "INSERT INTO [Products]\n"
                + "           ([ProductName]\n"
                + "           ,[SupplierID]\n"
                + "           ,[CategoryID]\n"
                + "           ,[QuantityPerUnit]\n"
                + "           ,[UnitPrice]\n"
                + "           ,[UnitsInStock]\n"
                + "           ,[UnitsOnOrder]\n"
                + "           ,[ReorderLevel]\n"
                + "           ,[Discontinued])\n"
                + "     VALUES('" + pro.getProductName() + "'," + pro.getSupplierID()
                + "," + pro.getCategoryID() + ",'" + pro.getQuantityPerUnit()
                + "'," + pro.getUnitPrice() + "," + pro.getUnitsInStock()
                + "," + pro.getUnitsOnOrder() + "," + pro.getReorderLevel()
                + "," + pro.getDiscontinued() + ")";
        System.out.println(sql);
        try {
            // statement
            Statement state = conn.createStatement();
            n = state.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(DAOProduct.class.getName()).log(Level.SEVERE, null, ex);
        }

        return n;
    }

    public int insertProductByPrepared(Product pro) {
        int n = 0;
        String sql = "INSERT INTO [Products]\n"
                + "           ([ProductName]\n"
                + "           ,[SupplierID]\n"
                + "           ,[CategoryID]\n"
                + "           ,[QuantityPerUnit]\n"
                + "           ,[UnitPrice]\n"
                + "           ,[UnitsInStock]\n"
                + "           ,[UnitsOnOrder]\n"
                + "           ,[ReorderLevel]\n"
                + "           ,[Discontinued])\n"
                + "     VALUES(?,?,?,?,?,?,?,?,?)";
        //number of ? is number of fields
        //??index of ? start with 1
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            //pre.setDataType(indexOf?, para);
            pre.setString(1, pro.getProductName());
            pre.setInt(2, pro.getSupplierID());
            pre.setInt(3, pro.getCategoryID());
            pre.setString(4, pro.getQuantityPerUnit());
            pre.setDouble(5, pro.getUnitPrice());
            pre.setInt(6, pro.getUnitsInStock());
            pre.setInt(7, pro.getUnitsOnOrder());
            pre.setInt(8, pro.getReorderLevel());
            pre.setInt(9, pro.getDiscontinued());

            n = pre.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOProduct.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }

    public int updateProduct(Product pro) {
        int n = 0;
        String sql = "UPDATE [Products]\n"
                + "   SET [ProductName] = ?\n"
                + "      ,[SupplierID] = ?\n"
                + "      ,[CategoryID] = ?\n"
                + "      ,[QuantityPerUnit] = ?\n"
                + "      ,[UnitPrice] = ?\n"
                + "      ,[UnitsInStock] = ?\n"
                + "      ,[UnitsOnOrder] = ?\n"
                + "      ,[ReorderLevel] = ?\n"
                + "      ,[Discontinued] = ?\n"
                + " WHERE ProductID=?";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            //pre.setDataType(indexOf?, para);
            pre.setString(1, pro.getProductName());
            pre.setInt(2, pro.getSupplierID());
            pre.setInt(3, pro.getCategoryID());
            pre.setString(4, pro.getQuantityPerUnit());
            pre.setDouble(5, pro.getUnitPrice());
            pre.setInt(6, pro.getUnitsInStock());
            pre.setInt(7, pro.getUnitsOnOrder());
            pre.setInt(8, pro.getReorderLevel());
            pre.setInt(9, pro.getDiscontinued());
            pre.setInt(10, pro.getProductID());
            n = pre.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOProduct.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }

    public int deleteProduct(int id) {
        int n = 0;
        String sql = "DELETE from Products WHERE ProductID =" + id;
        try {
            Statement state = conn.createStatement();
            n = state.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(DAOProduct.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }

    public Vector<Product> getProduct(String sql) {
        Vector<Product> vector = new Vector<Product>();
        ResultSet rs = getData(sql);
        try {
            while (rs.next()) {
                int id = rs.getInt("ProductID"); // or id = rs.getInt(1) since the index of id is 1 in ResultSet
                String name = rs.getString(2);
                int supid = rs.getInt(3);
                int cateid = rs.getInt(4);
                String perUnit = rs.getString(5);
                double price = rs.getDouble(6);
                int unitIn = rs.getInt(7);
                int unitOut = rs.getInt(8);
                int reOrder = rs.getInt(9);
                int diss = rs.getInt(10);
                Product pro = new Product(id, name, supid, cateid, perUnit, price, unitIn, unitOut, reOrder, diss);
                vector.add(pro);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOProduct.class.getName()).log(Level.SEVERE, null, ex);
        }
        return vector;
    }

    /**
     * searchProduct functin will search following with input of user
     * @param name
     * @return name
     */
    public ArrayList<String> searchProduct(String name) {
        ArrayList<String> list = new ArrayList<>();
        String sql = "select p.ProductName, c.CategoryName, s.CompanyName\n"
                + "from Products p join Categories c on p.CategoryID = c.CategoryID\n"
                + "	join Suppliers s on p.SupplierID = s.SupplierID\n"
                + "where p.ProductName = '" + name +"'";
        ResultSet rs = getData(sql);
        try {
            if (rs.next()) {
                String pro = rs.getString("ProductName");
                String sup = rs.getString("CategoryName");
                String cate = rs.getString("CompanyName");
                list.add(pro);
                list.add(cate);
                list.add(sup);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOProduct.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public static void main(String[] args) {
        DAOProduct dao = new DAOProduct();
        Vector<Product> vector = dao.getProduct("select * from Products");
        for(Product pro : vector) {
            System.out.println(pro);
        }
//        dao.deleteProduct(85);

//        for (String string : dao.searchProduct("Chai")) {
//            System.out.println(string);
//        }
    }
}
