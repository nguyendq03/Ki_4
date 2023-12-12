/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Group;
import model.Member;

/**
 *
 * @author Hoang Hiep
 */
public class GroupDAO extends DBContext{
    public ArrayList<Group> getAllGroup(){
        try {
            String sql ="SELECT * FROM GroupTBL";
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            ArrayList<Group> list = new ArrayList<>();
            while(rs.next()) {
                list.add(new Group(rs.getInt(1), rs.getString(2)));
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(GroupDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public ArrayList<Member> getMembersByGroupID(int gid){
        try {
            String sql ="SELECT [mid]\n" +
                        "      ,[mname]\n" +
                        "      ,[gender]\n" +
                        "      ,[dob]\n" +
                        "  FROM [MemberTBL] ";
            if(gid != 0){
                sql += " WHERE gid = ?";
            }
            
            PreparedStatement ps = connection.prepareStatement(sql);
            
            if(gid != 0){
                ps.setInt(1, gid);
            }
            
            ResultSet rs = ps.executeQuery();
            ArrayList<Member> list = new ArrayList<>();
            while(rs.next()) {
                list.add(new Member(rs.getInt(1), rs.getString(2), rs.getBoolean(3), rs.getDate(4)));
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(GroupDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
