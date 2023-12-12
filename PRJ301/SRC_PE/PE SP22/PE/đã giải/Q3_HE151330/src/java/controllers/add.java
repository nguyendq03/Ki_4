/*
 * Copyright(C) 2022, Nguyen The Minh.
 * Code: J1.S.P0071 (150 LOC)
 * Title: Task management program of CCRM project.
 */
package controllers;

import dal.DAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Account;
import model.Certificate;

/**
 *
 * @author vietd
 */
@WebServlet(name = "add", urlPatterns = {"/add"})
public class add extends HttpServlet {

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
        boolean isLogin = session != null && session.getAttribute("userLogged") != null;
        if (isLogin) {
            DAO dao = new DAO();
            ArrayList<Certificate> certificates = dao.findAllCertificate();
            request.setAttribute("cer", certificates);
        } else {
            request.setAttribute("message", "Access Denied");
        }
        request.getRequestDispatcher("add.jsp").forward(request, response);
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
        HttpSession session = request.getSession();
        boolean isLogin = session != null && session.getAttribute("userLogged") != null;
        if (isLogin) {
            Account account = (Account) session.getAttribute("userLogged");
            String id = request.getParameter("id");
            String name = request.getParameter("name");
            String dob = request.getParameter("dob");
            String gender = request.getParameter("gender");
            String[] cerId = request.getParameterValues("cerId");
            String[] cerDate = request.getParameterValues("cerDate");
            String createdBy = account.getUsername();
            if (id != null && name != null && dob != null && gender != null && createdBy != null) {
                DAO dao = new DAO();
                if (dao.insertEmployee(id, name, dob, gender, createdBy, cerId, cerDate)) {
                    request.setAttribute("message", "Insert Success");
                } else {
                    request.setAttribute("message", "Insert Failed");
                }
            }
        } else {
            request.setAttribute("message", "Access Denied");

        }
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
