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
import model.Student;

/**
 *
 * @author area1
 */
public class DAO extends DBContext {

    public ArrayList<Student> getStudents(String name) {
        try {
            PreparedStatement stm = null;

            ArrayList<Student> students = new ArrayList<>();
            String sql = "SELECT [id]\n"
                    + "      ,[name]\n"
                    + "      ,[dob]\n"
                    + "      ,[gender]\n"
                    + "  FROM [Student]\n"
                    + "  WHERE name LIKE ?+'%'";
            stm = connection.prepareStatement(sql);
            stm.setString(1, name);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Student s = new Student();
                s.setId(rs.getInt("id"));
                s.setName(rs.getString("name"));
                s.setDob(rs.getDate("dob"));
                s.setGender(rs.getBoolean("gender"));
                students.add(s);
            }
            return students;
        } catch (SQLException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
//    public static void main(String[] args) {
//        DAO dao = new DAO();
//        for (Student student : dao.getStudents("m")) {
//            System.out.println(student.getId() + student.getName()+student.getDob()+student.isGender());
//        }
// 
//    }
}
