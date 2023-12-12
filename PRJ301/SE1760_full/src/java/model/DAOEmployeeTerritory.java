/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import entity.EmployeeTerritory;
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
public class DAOEmployeeTerritory extends DBConnect {

    
    
    /**
     * insertEmployeeTerritory function insert a EmployeeTerritory 
     * @param empTer
     * @return EmployeeTerritory
     */
    public int insertEmployeeTerritory(EmployeeTerritory empTer) {
        int n = 0;
        String sql = "INSERT INTO [EmployeeTerritories]\n"
                + "           ([EmployeeID]\n"
                + "           ,[TerritoryID])\n"
                + "     VALUES(?, ?)";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setInt(1, empTer.getEmployeeID());
            pre.setString(2, empTer.getTerritoryID());
            n = pre.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOEmployeeTerritory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }

    /**
     * updateEmployeeTerritory function will update employee information
     * @param empTer
     * @return employeeTerritory
     */
    public int updateEmployeeTerritory(EmployeeTerritory empTer) {
        int n = 0;
        String sql = "UPDATE [EmployeeTerritories]\n"
                + "   SET [EmployeeID] = ?\n"
                + "      ,[TerritoryID] = ?\n"
                + " WHERE EmployeeID = ?";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            //pre.setDataType(indexOf?, para);
            //Input employeeID
            pre.setInt(1, empTer.getEmployeeID());
            //Input TerritoryID
            pre.setString(2, empTer.getTerritoryID());
            //Inoput EmployeeID
            pre.setInt(3, empTer.getEmployeeID());
            n = pre.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOEmployeeTerritory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }

    public int deleteEmployeeTerritory(int id) {
        int n = 0;
        String sql = "DELETE from EmployeeTerritories WHERE EmployeeID =" + id;
        try {
            Statement state = conn.createStatement();
            n = state.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(DAOEmployeeTerritory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }

    
    
    public Vector<EmployeeTerritory> getEmployeeTerritory(String sql) {
        Vector<EmployeeTerritory> vector = new Vector<EmployeeTerritory>();

        ResultSet rs = getData(sql);
        try {
            while (rs.next()) {
                int empId = rs.getInt(1);
                String terID = rs.getString(2);
                EmployeeTerritory empTer = new EmployeeTerritory(empId, terID);
                vector.add(empTer);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOEmployeeTerritory.class.getName()).log(Level.SEVERE, null, ex);
        }

        return vector;
    }

    public static void main(String[] args) {
        DAOEmployeeTerritory dao = new DAOEmployeeTerritory();
        
    }
}
