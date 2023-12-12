package pe.controllers;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/UserManagementServlet")
public class UserManagementServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Thay thế mã bên dưới bằng mã thực hiện lấy dữ liệu từ cơ sở dữ liệu
        String userID = "userID"; // Thay thế bằng userID thực tế của người dùng
        String fullName = ""; // Khởi tạo là chuỗi rỗng

        // Truy vấn fullName từ cơ sở dữ liệu sử dụng userID
        // Thay thế phần này bằng truy vấn cơ sở dữ liệu thực tế

        // Đặt fullName làm thuộc tính của phiên (session attribute)
        HttpSession session = request.getSession();
        session.setAttribute("fullName", fullName);

        // Chuyển hướng đến trang admin.jsp
        response.sendRedirect("admin.jsp");
    }
}
