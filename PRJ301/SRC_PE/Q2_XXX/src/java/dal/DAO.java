/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.CandidateTBL;
import model.GroupTBL;
import model.UserTBL;

/**
 *
 * @author ASUS PC
 */
public class DAO extends DBContext{
    
    public UserTBL Login(String username, String password) {
        String sql = "select * from UserTBL WHERE username = ? AND password = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, username);
            st.setString(2, password);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                UserTBL user = new UserTBL();
                user.setUsername(rs.getString("username")); 
                user.setPassword(rs.getString("password")); 
                user.setDisplayname(rs.getString("displayname")); 
                 return user;
            }
        } catch (SQLException exception) {
            System.out.println(exception);
        }
        return null;
    }
    
     public List<GroupTBL> getAllGroup() {
        String sql = "select * from GroupTBL";
        List<GroupTBL> list = new ArrayList();
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                GroupTBL group = new GroupTBL();
                group.setGid(rs.getInt("gid"));
                group.setGname(rs.getString("gname"));
                list.add(group);
            }
        } catch (SQLException exception) {
            System.out.println(exception);
        }
        return list;
    }
     
     public boolean insertCandidate(CandidateTBL candidate) {
        String sql = "insert CandidateTBL(cname, gender, dob, gid, created_by) values(?, ?, ?, ?, ?)"; // (accountID, orderDate, address, totalPrice,
                                                             // status)
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, candidate.getCname());
            ps.setBoolean(2, candidate.getGender());
            ps.setDate(3, candidate.getDob());
            ps.setInt(4, candidate.getGid());
            ps.setString(5, candidate.getCreated_by());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return false;
    }
}
