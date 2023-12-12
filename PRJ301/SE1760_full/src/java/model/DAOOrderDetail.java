/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import entity.OrderDetail;
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
public class DAOOrderDetail extends DBConnect {

    public int insertOrderDetail(OrderDetail ord) {
        int n = 0;
        String sql = "INSERT INTO [Order Details]\n"
                + "           ([OrderID]\n"
                + "           ,[ProductID]\n"
                + "           ,[UnitPrice]\n"
                + "           ,[Quantity]\n"
                + "           ,[Discount])\n"
                + "     VALUES(?, ?, ?, ?, ?)";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setInt(1, ord.getOrderID());
            pre.setInt(2, ord.getProductID());
            pre.setDouble(3, ord.getUnitPrice());
            pre.setInt(4, ord.getQuantity());
            pre.setDouble(5, ord.getDiscount());
            n = pre.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOOrderDetail.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }

    public int updateOrderDetail(OrderDetail ord) {
        int n = 0;
        String sql = "UPDATE [Order Details]\n"
                + "   SET [OrderID] = ?\n"
                + "      ,[ProductID] = ?\n"
                + "      ,[UnitPrice] = ?\n"
                + "      ,[Quantity] = ?\n"
                + "      ,[Discount] = ?\n"
                + " WHERE OrderID = ?";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setInt(1, ord.getOrderID());
            pre.setInt(2, ord.getProductID());
            pre.setDouble(3, ord.getUnitPrice());
            pre.setInt(4, ord.getQuantity());
            pre.setDouble(5, ord.getDiscount());
            pre.setInt(6, ord.getOrderID());
            n = pre.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOOrderDetail.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }

    public int deleteOrderDetail(int id) {
        int n = 0;
        String sql = "DELETE from [Order Details] WHERE OrderID =" + id;
        try {
            Statement state = conn.createStatement();
            n = state.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(DAOOrderDetail.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }

    public Vector<OrderDetail> getOrderDetail(String sql) {
        Vector<OrderDetail> vector = new Vector<OrderDetail>();
            ResultSet rs = getData(sql);
        try {
            while (rs.next()) {
                int orderID = rs.getInt(1);
                int productID = rs.getInt(2);
                double unitPrice = rs.getDouble(3);
                int quantity = rs.getInt(4);
                double discount = rs.getDouble(5);
                OrderDetail orderDetail = new OrderDetail(orderID, productID, unitPrice, quantity, discount);
                vector.add(orderDetail);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOOrderDetail.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return vector;
    }

    public static void main(String[] args) {
        DAOOrderDetail dao = new DAOOrderDetail();
        Vector<OrderDetail> vector = dao.getOrderDetail("select * from [Order Details]");
        for (OrderDetail orderDetail : vector) {
            System.out.println(orderDetail);
        }
    }
}
