package pe.controllers;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pe.utils.RegistrationDAO;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userID = request.getParameter("txtUsername");
        String password = request.getParameter("txtPassword");

        RegistrationDAO registrationDAO = new RegistrationDAO();
        boolean isAuthenticated = registrationDAO.authenticateUser(userID, password);

        if (isAuthenticated) {
            // User credentials are correct
            request.getSession().setAttribute("userID", userID);

            // Lấy fullName từ cơ sở dữ liệu bằng RegistrationDAO
            String fullName = registrationDAO.getFullName(userID);

            // Đặt fullName làm thuộc tính phiên (session attribute)
            request.getSession().setAttribute("fullName", fullName);

            response.sendRedirect("admin.jsp");
        } else {
            // User credentials are incorrect
            request.setAttribute("error", "Incorrect UserID or Password");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }
}
