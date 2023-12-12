/*
 * Copyright(C) 2022, Nguyen The Minh.
 * Code: J1.S.P0071 (150 LOC)
 * Title: Task management program of CCRM project.
 */
package dal;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Account;
import model.Certificate;

/**
 *
 * @author vietd
 */
public class DAO extends DBContext {

    public Account findAccount(String username, String password) {
        try {
            String sql = "select * from Account where username = ? and password = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, username);
            stm.setString(2, password);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                return new Account(rs.getString(1), rs.getString(2), rs.getString(3));
            }
        } catch (SQLException e) {
            System.out.println("loi function find account");
        }
        return null;
    }

    public ArrayList<Certificate> findAllCertificate() {
        ArrayList<Certificate> certificates = new ArrayList<>();
        try {
            String sql = "select * from Certificate";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                certificates.add(new Certificate(rs.getInt(1), rs.getString(2)));
            }
        } catch (SQLException e) {
            System.out.println("loi function find all certificate");
        }
        return certificates;
    }

    public boolean insertEmployee(String eid, String ename, String edob, String gender, String createBy, String[] cerId, String[] cerDate) {
        try {
            String sql = "insert into Employee (empid, empname,empdob, empgender, createdby) values (?,?,?,?,?)";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, Integer.parseInt(eid));
            stm.setString(2, ename);
            stm.setDate(3, Date.valueOf(edob));
            stm.setBoolean(4, gender.equals("1"));
            stm.setString(5, createBy);
            stm.executeUpdate();
            String sql2 = "insert into Employee_Certificate (empid,certid,issueddate) values (?,?,?)";
            PreparedStatement stm2 = connection.prepareStatement(sql2);
            for (String id : cerId) {
                int indexCerId = Integer.parseInt(id.split("\\s+")[0]);
                int cid = Integer.parseInt(id.split("\\s+")[1]);
                stm2.setInt(1, Integer.parseInt(eid));
                stm2.setInt(2, cid);
                stm2.setDate(3, Date.valueOf(cerDate[indexCerId]));
                stm2.executeUpdate();
            }
            return true;
        } catch (NumberFormatException | SQLException e) {
            System.out.println("loi insert employee");
        }
        return false;
    }
}
