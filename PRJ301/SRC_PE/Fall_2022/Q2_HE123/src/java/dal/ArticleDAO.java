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
import model.Article;

/**
 *
 * @author ezse.net
 */
public class ArticleDAO extends DBContext{
    public ArrayList<Article> getAll(){
        try {
            String sql = "SELECT * FROM Article";
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            ArrayList<Article> list = new ArrayList<>();
            while(rs.next()) {
                Article article = new Article(rs.getInt(1), rs.getString(2),
                        rs.getDate(3), rs.getBoolean(4));
                list.add(article);
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(ArticleDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
