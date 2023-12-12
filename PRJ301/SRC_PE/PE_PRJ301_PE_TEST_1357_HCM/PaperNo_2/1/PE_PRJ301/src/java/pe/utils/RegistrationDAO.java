package pe.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RegistrationDAO {
    public boolean authenticateUser(String userID, String password) {
        try (Connection conn = DBUtils.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement("SELECT COUNT(*) as count FROM tblUsers WHERE userID = ? AND password = ?")) {
            preparedStatement.setString(1, userID);
            preparedStatement.setString(2, password);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                int count = resultSet.getInt("count");
                if (count > 0) {
                    return true; // Người dùng tồn tại với userID và password cung cấp.
                }
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }

    public String getFullName(String userID) {
        String fullName = "";
        try (Connection conn = DBUtils.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement("SELECT fullName FROM tblUsers WHERE userID = ?")) {
            preparedStatement.setString(1, userID);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                fullName = resultSet.getString("fullName");
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return fullName;
    }
}
