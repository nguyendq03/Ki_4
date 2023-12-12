package cotroller;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
import dal.DAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;
import model.CandidateTBL;
import model.GroupTBL;
import model.UserTBL;

/**
 *
 * @author LENOVO
 */
@WebServlet(urlPatterns = {"/insert"})
public class InsertServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet InsertServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet InsertServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        DAO d = new DAO();
        List<GroupTBL> listG = d.getAllGroup();
        request.setAttribute("listG", listG);
        request.getRequestDispatcher("insert.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        String name = request.getParameter("name");
        String gender_raw = request.getParameter("gender");
        String dob_raw = request.getParameter("dob");
        int gid = Integer.parseInt(request.getParameter("gid"));
        UserTBL u = (UserTBL) session.getAttribute("account");
        String created_by = u.getUsername();
        Date dob = java.sql.Date.valueOf(dob_raw);
        boolean gender = false;
        if (gender_raw.equals("1")) {
            gender = true;
        }
        CandidateTBL cd = new CandidateTBL(0, name, gender, dob, gid, created_by);
        DAO d = new DAO();
        d.insert(cd);
        response.getWriter().print("Insert successful");
    }

}
