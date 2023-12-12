/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import entity.Category;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author admin
 */
public class DAOCategory extends DBConnect {

    public int insertCategory(Category cate) {
        int n = 0;
        String sql = "INSERT INTO [Categories]\n"
                + "           ([CategoryName]\n"
                + "           ,[Description]\n"
                + "           ,[Picture])\n"
                + "     VALUES\n"
                + "           ('" + cate.getCategoryName() + "', '" + cate.getDescription() + "', '" + cate.getPicture() + "')";
        System.out.println(sql);
        try {
            // statement
            Statement state = conn.createStatement();
            n = state.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(DAOCategory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }

    public int updateCategory(Category cate) {
        int n = 0;
        String sql = "UPDATE [Categories]\n"
                + "   SET [CategoryName] = ?\n"
                + "      ,[Description] = ?\n"
                + " WHERE CategoryID=?";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            //pre.setDataType(indexOf?, para);
            pre.setString(1, cate.getCategoryName());
            pre.setString(2, cate.getDescription());
            pre.setInt(3, cate.getCategoryID());
            n = pre.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOCategory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }

    public int deleteCategory(int id) {
        int n = 0;
        String sql = "DELETE from Categories WHERE CategoryID =" + id;
        try {
            Statement state = conn.createStatement();
            n = state.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(DAOCategory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }

    public Vector<Category> getCategory(String sql) {
        Vector<Category> vector = new Vector<Category>();
        ResultSet rs = getData(sql);
        try {
            while (rs.next()) {
                int id = rs.getInt("CategoryID"); // or id = rs.getInt(1) since the index of id is 1 in ResultSet
                String name = rs.getString(2);
                String description = rs.getString(3);
                String picture = rs.getString(4);
                Category cate = new Category(id, name, description, picture);
                vector.add(cate);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOCategory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return vector;
    }

    public static void main(String[] args) {
        DAOCategory dao = new DAOCategory();
//        dao.insertCategory(new Category("test", "test", "test"));
//        Vector<Category> vector = dao.getCategory("select * from Categories");
//        for(Category cate : vector) {
//            System.out.println(cate);
//        }
        dao.deleteCategory(11);
    }
}
