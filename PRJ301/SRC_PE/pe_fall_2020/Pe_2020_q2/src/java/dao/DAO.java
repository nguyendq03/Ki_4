/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import context.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author trinh
 */
public class DAO {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public Account login(String id, String pass) {
        String query = "select * from account\n"
                + "where accountid = ?\n"
                + "and [password] = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, id);
            ps.setString(2, pass);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Account(rs.getString(1),
                        rs.getString(2));
            }
        } catch (Exception e) {
        }
        return null;
    }

    public List<Employee> getEmployeeByAccount(String id) {
        List<Employee> list = new ArrayList<>();
        String query = "select * from Employee\n"
                + "where createdby = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, id);
            rs = ps.executeQuery();
            while(rs.next()){
                list.add(new Employee(rs.getInt(1), 
                        rs.getString(2), 
                        rs.getInt(3),
                        rs.getDate(4)));
            }
        } catch (Exception e) {
        }
        return list;
    }
}
