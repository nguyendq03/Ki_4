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

    public ArrayList<Paper> getPapers(int authorId) {
        try {
            ArrayList<Paper> papers = new ArrayList<>();

            String sql = "SELECT P.[paperid], P.title,P.publisheddate \n"
                    + "  FROM [Author_Paper] AS AP JOIN Paper AS P\n"
                    + "  ON AP.paperid=P.paperid\n"
                    + "WHERE AP.authorid=?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, authorId);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Paper p = new Paper();
                p.setId(rs.getInt("paperid"));
                p.setTitle(rs.getString("title"));
                p.setPublished(rs.getDate("publisheddate"));
                papers.add(p);
            }
            return papers;
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }return null;
    }
}
