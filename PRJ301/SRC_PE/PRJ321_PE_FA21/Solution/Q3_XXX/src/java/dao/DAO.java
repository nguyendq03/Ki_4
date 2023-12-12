/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dal.DBContext;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Employee;
import model.Skill;

/**
 *
 * @author area1
 */
public class DAO extends DBContext {

    public ArrayList<Skill> getSkills() {
        try {
            ArrayList<Skill> skills = new ArrayList<>();

            String sql = "SELECT [id]\n"
                    + "      ,[name]\n"
                    + "  FROM [Skill]";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Skill s = new Skill();
                s.setId(rs.getInt("id"));
                s.setName(rs.getString("name"));
                skills.add(s);
            }
            return skills;
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void setEmployee(Employee employee) {
        try {
            String sql = "INSERT INTO[Employee]\n"
                    + "           ([id]\n"
                    + "           ,[name]\n"
                    + "           ,[dob]\n"
                    + "           ,[gender])\n"
                    + "     VALUES\n"
                    + "           (?, ? ,? ,?)";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, employee.getId());
            stm.setString(2, employee.getName());
            stm.setDate(3, employee.getDob());
            stm.setBoolean(4, employee.isGender());
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void setEmployeeSkills(int eId, int sId) {
        try {
            String sql = "INSERT INTO [Employee_Skill]\n"
                    + "           ([eid]\n"
                    + "           ,[sid])\n"
                    + "     VALUES (?, ?)";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, eId);
            stm.setInt(2, sId);
            
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
