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
import model.Author;
import model.Paper;

/**
 *
 * @author area1
 */
public class DAO extends DBContext {

    public ArrayList<Author> getAuthors() {
        try {
            ArrayList<Author> authors = new ArrayList<>();

            String sql = "SELECT [authorid]\n"
                    + "      ,[authorname]\n"
                    + "  FROM [Author]";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Author a = new Author();
                a.setId(rs.getInt("authorid"));
                a.setName(rs.getString("authorname"));
                authors.add(a);
            }
            return authors;
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void setPaper(Paper paper) {
        try {
            String sql = "INSERT INTO [Paper]\n"
                    + "           ([paperid]\n"
                    + "           ,[title]\n"
                    + "           ,[publisheddate])\n"
                    + "     VALUES (?,?,?)";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, paper.getId());
            stm.setString(2, paper.getTitle());
            stm.setDate(3, paper.getPublished());
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void setAuthorPaper(int authorId, int paperid) {
        try {
            String sql = "INSERT INTO [Author_Paper]\n"
                    + "           ([paperid]\n"
                    + "           ,[authorid])\n"
                    + "     VALUES\n"
                    + "           (?, ?)";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, paperid);
            stm.setInt(2, authorId);
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
