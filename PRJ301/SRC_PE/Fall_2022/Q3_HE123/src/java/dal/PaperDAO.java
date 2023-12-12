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
import model.Author;
import model.Paper;
import model.User;

/**
 *
 * @author ezse.net
 */
public class PaperDAO extends DBContext{
    public Paper getPaperByID(int id){
        try {
            String sql = "SELECT * FROM Paper\n" +
                    "WHERE pid = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                return new Paper(rs.getInt(1), rs.getString(2), rs.getDate(3), rs.getBoolean(4));
            }
        } catch (SQLException ex) {
            Logger.getLogger(PaperDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public ArrayList<Author> getAllAuthorByPaperID(int id) {
        try {
            String sql = "SELECT a.*, corresponding_author FROM Author a\n" +
                    "JOIN Paper_Author pa\n" +
                    "ON a.auid = pa.auid\n" +
                    "WHERE pa.pid = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            ArrayList<Author> list = new ArrayList<>();
            while(rs.next()) {
                list.add(new Author(rs.getInt(1), rs.getString(2),rs.getBoolean(3)));
            }
            return  list;
        } catch (SQLException ex) {
            Logger.getLogger(PaperDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public ArrayList<Author> getNoAssignAuthorByPaperID(int id) {
        try {
            String sql = "SELECT * FROM Author a\n" +
                "WHERE a.auid NOT IN (SELECT auid FROM Paper_Author WHERE pid = ?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            ArrayList<Author> list = new ArrayList<>();
            while(rs.next()) {
                list.add(new Author(rs.getInt(1), rs.getString(2),true));
            }
            return  list;
        } catch (SQLException ex) {
            Logger.getLogger(PaperDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public void assign(int pid, int auid, int isCorresponding) {
        try {
            String sql = "INSERT INTO Paper_Author\n" +
                            "VALUES(?, ?, ?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, pid);
            ps.setInt(2, auid);
            ps.setInt(3, isCorresponding);
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(PaperDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
