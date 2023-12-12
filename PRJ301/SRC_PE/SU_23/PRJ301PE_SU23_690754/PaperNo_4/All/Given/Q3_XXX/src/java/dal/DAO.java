/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Student;
import model.Class;

/**
 *
 * @author admin
 */
public class DAO extends DBContext {

    public ResultSet getData(String sql) {
        ResultSet rs = null;
        try {
            Statement state = connection.createStatement(
                    ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            rs = state.executeQuery(sql);
        } catch (SQLException | NullPointerException ex) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }

    public Vector<Student> getAllStudent() {
        Vector<Student> list = new Vector<>();
        String sql = "select * from Students";
        ResultSet rs = this.getData(sql);
        try {
            while (rs.next()) {
                Student student = new Student(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5));
                list.add(student);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public Vector<Class> getAllClass() {
        Vector<Class> list = new Vector<>();
        String sql = "select * from Classes";
        ResultSet rs = this.getData(sql);
        try {
            while (rs.next()) {
                Class cla = new Class(rs.getInt(1), rs.getString(2), rs.getString(3));
                list.add(cla);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public int updateStudent(Student student) {
        int n = 0;
        String sql = "UPDATE [dbo].[Students]\n"
                + "   SET [StudentID] = ?\n"
                + "      ,[StudentName] = ?\n"
                + "      ,[BirthDate] = ?\n"
                + "      ,[Gender] = ?\n"
                + "      ,[ClassID] = ?\n"
                + " WHERE StudentID = ?";
        try {
            PreparedStatement pre = connection.prepareStatement(sql);
            pre.setString(1, student.getStudentID());
            pre.setString(2, student.getStudentName());
            pre.setString(3, student.getBirthday());
            pre.setInt(4, student.getGenderInt());
            pre.setInt(5, student.getClassID());
            pre.setString(6, student.getStudentID());
            n = pre.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }
}
