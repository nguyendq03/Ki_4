/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import entity.Order;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Formatter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author admin
 */
public class DAOOrder extends DBConnect {

    public int insertOrder(Order ord) {
        int n = 0;
        String sql = "INSERT INTO [Orders]\n"
                + "           ([CustomerID]\n"
                + "           ,[EmployeeID]\n"
                + "           ,[OrderDate]\n"
                + "           ,[RequiredDate]\n"
                + "           ,[ShippedDate]\n"
                + "           ,[ShipVia]\n"
                + "           ,[Freight]\n"
                + "           ,[ShipName]\n"
                + "           ,[ShipAddress]\n"
                + "           ,[ShipCity]\n"
                + "           ,[ShipRegion]\n"
                + "           ,[ShipPostalCode]\n"
                + "           ,[ShipCountry])\n"
                + "     VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, ord.getCustomerID());
            pre.setInt(2, ord.getEmployeeID());
            pre.setString(3, ord.getOrderDate());
            pre.setString(4, ord.getRequiredDate());
            pre.setString(5, ord.getShippedDate());
            pre.setInt(6, ord.getShipVia());
            pre.setDouble(7, ord.getFreight());
            pre.setString(8, ord.getShipName());
            pre.setString(9, ord.getShipAddress());
            pre.setString(10, ord.getShipCity());
            pre.setString(11, ord.getShipRegion());
            pre.setString(12, ord.getShipPostalCode());
            pre.setString(13, ord.getShipCountry());
            n = pre.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOOrder.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }

    public int updateOrder(Order ord) {
        int n = 0;
        String sql = "UPDATE [Orders]\n"
                + "   SET [CustomerID] = ?\n"
                + "      ,[EmployeeID] = ?\n"
                + "      ,[OrderDate] = ?\n"
                + "      ,[RequiredDate] = ?\n"
                + "      ,[ShippedDate] = ?\n"
                + "      ,[ShipVia] = ?\n"
                + "      ,[Freight] = ?\n"
                + "      ,[ShipName] = ?\n"
                + "      ,[ShipAddress] = ?\n"
                + "      ,[ShipCity] = ?\n"
                + "      ,[ShipRegion] = ?\n"
                + "      ,[ShipPostalCode] = ?\n"
                + "      ,[ShipCountry] = ?\n"
                + " WHERE OrderID = ?";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, ord.getCustomerID());
            pre.setInt(2, ord.getEmployeeID());
            pre.setString(3, ord.getOrderDate());
            pre.setString(4, ord.getRequiredDate());
            pre.setString(5, ord.getShippedDate());
            pre.setInt(6, ord.getShipVia());
            pre.setDouble(7, ord.getFreight());
            pre.setString(8, ord.getShipName());
            pre.setString(9, ord.getShipAddress());
            pre.setString(10, ord.getShipCity());
            pre.setString(11, ord.getShipRegion());
            pre.setString(12, ord.getShipPostalCode());
            pre.setString(13, ord.getShipCountry());
            pre.setInt(14, ord.getOrderID());
            n = pre.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOOrder.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }

    public int deleteOrder(int id) {
        int n = 0;
        String sql = "DELETE from Orders WHERE OrderID =" + id;
        try {
            Statement state = conn.createStatement();
            n = state.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(DAOOrder.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }

    public Vector<Order> getOrder(String sql) {
        Vector<Order> vector = new Vector<Order>();
        ResultSet rs = getData(sql);
        try {
            while (rs.next()) {
                int orderID = rs.getInt(1);
                String customerID = rs.getString(2);
                int employeeID = rs.getInt(3);
                String orderDate = rs.getString(4);
                String requiredDate = rs.getString(5);
                String shippedDate = rs.getString(6);
                int shipVia = rs.getInt(7);
                double freight = rs.getDouble(8);
                String shipName = rs.getString(9);
                String shipAddress = rs.getString(10);
                String shipCity = rs.getString(11);
                String shipRegion = rs.getString(12);
                String shipPostalCode = rs.getString(13);
                String shipCountry = rs.getString(14);
                Order order = new Order(orderID, customerID, employeeID, orderDate, requiredDate, shippedDate, shipVia,
                        freight, shipName, shipAddress, shipCity, shipRegion, shipPostalCode, shipCountry);
                vector.add(order);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOOrder.class.getName()).log(Level.SEVERE, null, ex);
        }
        return vector;
    }

    public Vector<ArrayList<String>> viewOrderOfCustomerById(String id) {
        Vector<ArrayList<String>> vector = new Vector();
        String sql = "select o.OrderID, o.OrderDate as Date, c.ContactName as CustomerName, \n"
                + "	e.FirstName + ' ' + e.LastName as EmployeeName, p.ProductName, od.Quantity,\n"
                + "	od.UnitPrice, od.Discount, (od.Quantity*od.UnitPrice)*(1-od.Discount) as SubTotal\n"
                + " from Orders o join [Order Details] od on o.OrderID = od.OrderID\n"
                + "	join Products p on od.ProductID = p.ProductID\n"
                + "	join Customers c on o.CustomerID = c.CustomerID\n"
                + "	join Employees e on e.EmployeeID = o.EmployeeID\n"
                + "where c.CustomerID = '" + id + "'";
        ResultSet rs = getData(sql);
        try {
            while (rs.next()) {
                String orderID = Integer.toString(rs.getInt("OrderID"));
                String date = (String) rs.getString("Date");
                String customerName = rs.getString("CustomerName");
                String employeeName = rs.getString("employeeName");
                String productName = rs.getString("ProductName");
                String quantity = Integer.toString(rs.getInt("Quantity"));
                String unitPrice = String.format("%,.2f", rs.getDouble("UnitPrice"));
                String discount = String.format("%,.2f", rs.getDouble("Discount"));
                String subTotal = String.format("%,.2f", rs.getDouble("SubTotal"));
                ArrayList<String> list = new ArrayList<>();
                list.add(orderID);
                list.add(date);
                list.add(customerName);
                list.add(employeeName);
                list.add(productName);
                list.add(quantity);
                list.add(unitPrice);
                list.add(discount);
                list.add(subTotal);
                vector.add(list);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOCustomer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return vector;
    }
    
    public Vector<ArrayList<String>> viewOrderOfCustomerByIdInDay(String id, String day) {
        Vector<ArrayList<String>> vector = new Vector();
        String sql = "select o.OrderID, o.OrderDate as Date, c.ContactName as CustomerName, \n"
                + "	e.FirstName + ' ' + e.LastName as EmployeeName, p.ProductName, od.Quantity,\n"
                + "	od.UnitPrice, od.Discount, (od.Quantity*od.UnitPrice)*(1-od.Discount) as SubTotal\n"
                + " from Orders o join [Order Details] od on o.OrderID = od.OrderID\n"
                + "	join Products p on od.ProductID = p.ProductID\n"
                + "	join Customers c on o.CustomerID = c.CustomerID\n"
                + "	join Employees e on e.EmployeeID = o.EmployeeID\n"
                + "where c.CustomerID = '" + id + "' and o.OrderDate = '" + day + "'";
        ResultSet rs = getData(sql);
        try {
            while (rs.next()) {
                String orderID = Integer.toString(rs.getInt("OrderID"));
                String date = (String) rs.getString("Date");
                String customerName = rs.getString("CustomerName");
                String employeeName = rs.getString("employeeName");
                String productName = rs.getString("ProductName");
                String quantity = Integer.toString(rs.getInt("Quantity"));
                String unitPrice = String.format("%,.2f", rs.getDouble("UnitPrice"));
                String discount = String.format("%,.2f", rs.getDouble("Discount"));
                String subTotal = String.format("%,.2f", rs.getDouble("SubTotal"));
                ArrayList<String> list = new ArrayList<>();
                list.add(orderID);
                list.add(date);
                list.add(customerName);
                list.add(employeeName);
                list.add(productName);
                list.add(quantity);
                list.add(unitPrice);
                list.add(discount);
                list.add(subTotal);
                vector.add(list);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOCustomer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return vector;
    }

    public static void main(String[] args) {
        DAOOrder dao = new DAOOrder();
        Vector<ArrayList<String>> vector = dao.viewOrderOfCustomerById("VINET");
        for (ArrayList<String> list : vector) {
            for (String string : list) {
                System.out.print(string + " ");
            }
            System.out.println(" ");
        }
    }
}
