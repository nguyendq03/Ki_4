/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import entity.Employee;
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
public class DAOEmployee extends DBConnect {

    public int insertEmployee(Employee emp) {
        int n = 0;
        String sql = "INSERT INTO [Employees]\n"
                + "           ([LastName]\n"
                + "           ,[FirstName]\n"
                + "           ,[Title]\n"
                + "           ,[TitleOfCourtesy]\n"
                + "           ,[BirthDate]\n"
                + "           ,[HireDate]\n"
                + "           ,[Address]\n"
                + "           ,[City]\n"
                + "           ,[Region]\n"
                + "           ,[PostalCode]\n"
                + "           ,[Country]\n"
                + "           ,[HomePhone]\n"
                + "           ,[Extension]\n"
                + "           ,[Photo]\n"
                + "           ,[Notes]\n"
                + "           ,[ReportsTo]\n"
                + "           ,[PhotoPath])\n"
                + "     VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, null, ?, ?, ?)";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, emp.getLastName());
            pre.setString(2, emp.getFirstName());
            pre.setString(3, emp.getTitle());
            pre.setString(4, emp.getTitleOfCourtesy());
            pre.setString(5, emp.getBirthDate());
            pre.setString(6, emp.getHireDate());
            pre.setString(7, emp.getAddress());
            pre.setString(8, emp.getCity());
            pre.setString(9, emp.getRegion());
            pre.setString(10, emp.getPostalCode());
            pre.setString(11, emp.getCountry());
            pre.setString(12, emp.getHomePhone());
            pre.setString(13, emp.getExtension());
            pre.setString(14, emp.getNotes());
            pre.setInt(15, emp.getReportsTo());
            pre.setString(16, emp.getPhotoPath());
            n = pre.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOEmployee.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }

    public int updateEmployee(Employee emp) {
        int n = 0;
        String sql = "UPDATE [Employees]\n"
                + "   SET [LastName] = ?\n"
                + "      ,[FirstName] = ?\n"
                + "      ,[Title] = ?\n"
                + "      ,[TitleOfCourtesy] = ?\n"
                + "      ,[Address] = ?\n"
                + "      ,[City] = ?\n"
                + "      ,[Region] = ?\n"
                + "      ,[PostalCode] = ?\n"
                + "      ,[Country] = ?\n"
                + "      ,[HomePhone] = ?\n"
                + "      ,[Extension] = ?\n"
                + "      ,[Notes] = ?\n"
                + "      ,[ReportsTo] = ?\n"
                + "      ,[PhotoPath] = ?\n"
                + " WHERE EmployeeID = ?";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, emp.getLastName());
            pre.setString(2, emp.getFirstName());
            pre.setString(3, emp.getTitle());
            pre.setString(4, emp.getTitleOfCourtesy());
            pre.setString(5, emp.getAddress());
            pre.setString(6, emp.getCity());
            pre.setString(7, emp.getRegion());
            pre.setString(8, emp.getPostalCode());
            pre.setString(9, emp.getCountry());
            pre.setString(10, emp.getHomePhone());
            pre.setString(11, emp.getExtension());
            pre.setString(12, emp.getNotes());
            pre.setInt(13, emp.getReportsTo());
            pre.setString(14, emp.getPhotoPath());
            pre.setInt(15, emp.getEmployeeID());
            n = pre.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOEmployee.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }

    public int deleteEmployee(int id) {
        int n = 0;
        String sql = "DELETE from Employees WHERE EmployeeID =" + id;
        try {
            Statement state = conn.createStatement();
            n = state.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(DAOEmployee.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }

    public Vector<Employee> getEmployee(String sql) {
        Vector<Employee> vector = new Vector<Employee>();
        
            ResultSet rs = getData(sql);
        try {
            while (rs.next()) {
                int id = rs.getInt(1);
                String lastName = rs.getString(2);
                String firstName = rs.getString(3);
                String title = rs.getString(4);
                String titleOfCourtesy = rs.getString(5);
                String birthDate = rs.getString(6);
                String hireDate = rs.getString(7);
                String address = rs.getString(8);
                String city = rs.getString(9);
                String region = rs.getString(10);
                String postalCode = rs.getString(11);
                String country = rs.getString(12);
                String homePhone = rs.getString(13);
                String extension = rs.getString(14);
                String photo = rs.getString(15);
                String notes = rs.getString(16);
                int reportsTo = rs.getInt(17);
                String photoPath = rs.getString(18);
                Employee employee = new Employee(lastName, firstName, title, titleOfCourtesy, birthDate, hireDate, address, 
                        city, region, postalCode, country, homePhone, extension, photo, notes, reportsTo, photoPath);
                vector.add(employee);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOEmployee.class.getName()).log(Level.SEVERE, null, ex);
        }
        return vector;
    }
    
    public static void main(String[] args) {
        DAOEmployee dao = new DAOEmployee();
//        Vector<Employee> vector = dao.getEmployee("select * from Employees");
//        for(Employee employee : vector) {
//            System.out.println(employee);
//        }
//        dao.insertEmployee(new Employee("test", "test","test", "test","2014-01-01", "2003-01-01","test", "test","test", "test","test", "test","test", "test", "test",1, "test"));
        dao.updateEmployee(new Employee(11,"test", "test","test", "test","2014-01-01", "2003-01-01","test", "test","test", "test","test", "test","test", "test", "test",6, "test"));
    }
}
