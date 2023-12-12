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
import model.CandidateTBL;
import model.GroupTBL;
import model.MemberTBL;

/**
 *
 * @author ASUS PC
 */
public class DAO extends DBContext {

    public List<GroupTBL> getAllGroup() {
        String sql = "select * from GroupTBL";
        List<GroupTBL> list = new ArrayList();
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                GroupTBL group = new GroupTBL();
                group.setGid(rs.getInt("gid"));
                group.setGname(rs.getString("gname"));
                list.add(group);
            }
        } catch (SQLException exception) {
            System.out.println(exception);
        }
        return list;
    }

    public List<MemberTBL> getAllMember(int gid) {
        String sql = "select * from MemberTBL  ";
        if (gid != -1) {
            sql += "WHERE gid = ?";
        }
        List<MemberTBL> list = new ArrayList();
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            if (gid != -1) {
                st.setInt(1, gid);

            }
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                MemberTBL m = new MemberTBL(rs.getInt("mid"),
                        rs.getString("mname"),
                        rs.getBoolean("gender"),
                        rs.getDate("dob"),
                        rs.getInt("gid"),
                        rs.getString("created_by"));
                list.add(m);
            }
        } catch (SQLException exception) {
            System.out.println(exception);
        }
        return list;
    }
}
