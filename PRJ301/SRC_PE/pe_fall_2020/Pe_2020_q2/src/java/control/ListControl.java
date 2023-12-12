/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import dao.Account;
import dao.DAO;
import dao.Employee;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author trinh
 */
@WebServlet(name = "ListControl", urlPatterns = {"/list"})
public class ListControl extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        Account a = (Account) session.getAttribute("acc");
        if (a == null) {
            try (PrintWriter out = response.getWriter()) {
                /* TODO output your page here. You may use following sample code. */
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Servlet ListControl</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("Access denied !");
                out.println("</body>");
                out.println("</html>");
            }
        } else {

            DAO dao = new DAO();
            List<Employee> list = dao.getEmployeeByAccount(a.getId());

            try (PrintWriter out = response.getWriter()) {
                /* TODO output your page here. You may use following sample code. */
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Servlet ListControl</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("<h1>Hello " + a.getId() + "</h1>");
                out.println("<table border=\"1px solid black\">\n"
                        + "            <tr>\n"
                        + "                <td>ID</td>\n"
                        + "                <td>Name</td>\n"
                        + "                <td>Gender</td>\n"
                        + "                <td>DOB</td>\n"
                        + "            </tr>");
                for (Employee o : list) {
                    out.println("<tr>\n"
                            + "                <td>" + o.getId() + "</td>\n"
                            + "                <td>" + o.getName() + "</td>\n"
                            + "                <td>" + o.getGender1() + "</td>\n"
                            + "                <td>" + o.getDob() + "</td>\n"
                            + "            </tr>");
                }
                out.println("</table>");
                out.println("</body>");
                out.println("</html>");
            }
        }

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
