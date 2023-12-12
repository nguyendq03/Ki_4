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
import model.User;

/**
 *
 * @author Hoang Hiep
 */
public class InsertDAO extends DBContext{
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
            Logger.getLogger(InsertDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public void insertCandidate(String name, int gender, String dob, int gid, String createdBy) {
        try {
            String sql ="INSERT INTO [CandidateTBL]\n" +
                        "           ([cname]\n" +
                        "           ,[gender]\n" +
                        "           ,[dob]\n" +
                        "           ,[gid]\n" +
                        "           ,[created_by])\n" +
                        "     VALUES\n" +
                        "           (?, ?, ?, ?, ?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, name);
            ps.setInt(2, gender);
            ps.setString(3, dob);
            ps.setInt(4, gid);
            ps.setString(5, createdBy);
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(InsertDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
