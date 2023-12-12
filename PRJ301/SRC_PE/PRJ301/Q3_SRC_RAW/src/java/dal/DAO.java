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
import java.util.logging.Level;
import java.util.logging.Logger;
import model.GroupTBL;
import model.MemberTBL;

/**
 *
 * @author LENOVO
 */
public class DAO extends DBContext{
    public List<GroupTBL> getAll(){
        String sql = "select*from GroupTBL";
        List<GroupTBL> listG = new ArrayList<>();
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                GroupTBL g = new GroupTBL(rs.getInt("gid"), rs.getString("gname"));
                listG.add(g);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return listG;
    }
    public List<MemberTBL> getByGid(int gid){
        String sql = "select*from MemberTBL";
        List<MemberTBL> listM = new ArrayList<>();
        try {
            if(gid!=-1){
                sql = sql + " where gid = " +gid;
            }
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                MemberTBL m = new MemberTBL(rs.getInt("mid"), 
                        rs.getString("mname"), 
                        rs.getBoolean("gender"), 
                        rs.getDate("dob"), 
                        rs.getInt("gid"), 
                        rs.getString("created_by"));
                listM.add(m);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listM;
    }
    
}
