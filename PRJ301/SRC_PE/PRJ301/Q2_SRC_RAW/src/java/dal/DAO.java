/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.CandidateTBL;
import model.GroupTBL;
import model.UserTBL;

/**
 *
 * @author LENOVO
 */
public class DAO extends DBContext {

    public UserTBL getUserTBL(String username, String password) {
        String sql = "select*from UserTBL where username = ? and password = ?";
        UserTBL u = null;

        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                u = new UserTBL(rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("displayname"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return u;
    }

    public List<GroupTBL> getAllGroup() {
        String sql = "select*from GroupTBL";
        List<GroupTBL> listG = new ArrayList<>();
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                GroupTBL g = new GroupTBL(rs.getInt("gid"), rs.getString("gname"));
                listG.add(g);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listG;
    }

    public void insert(CandidateTBL cd) {
        String sql = "insert CandidateTBL(cname, gender, dob, gid, created_by) values(?, ?, ?, ?, ?)";

        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, cd.getCname());
            ps.setBoolean(2, cd.isGender());
            ps.setDate(3, (Date) cd.getDob());
            ps.setInt(4, cd.getGid());
            ps.setString(5, cd.getCreated_by());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
