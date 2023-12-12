/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller;

import dal.DAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.sql.Date;
import java.util.List;
import model.CandidateTBL;
import model.GroupTBL;
import model.UserTBL;

/**
 *
 * @author ASUS PC
 */
@WebServlet(name="Insert", urlPatterns={"/insert"})
public class Insert extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Insert</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Insert at Trang Insert nay moi nguoi " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        if(session.getAttribute("user") == null){
            out.println("access denied");
            return;
        } 
        DAO dao = new DAO();
        List<GroupTBL> listgroup = dao.getAllGroup();
        request.setAttribute("listgroup", listgroup);
        request.getRequestDispatcher("Insert.jsp").forward(request, response);
    } 

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
         HttpSession session = request.getSession();
         UserTBL user = (UserTBL)session.getAttribute("user");
        String created_by = user.getUsername();
        String name = request.getParameter("name");
        String gender = request.getParameter("gender");
        String date = request.getParameter("date");
        String group = request.getParameter("group");
        
        CandidateTBL candidate = new CandidateTBL();
        candidate.setCname(name);
        boolean bool = gender == "1" ? true : false;
        candidate.setGender(true);
        candidate.setDob(Date.valueOf(date));
        candidate.setGid(Integer.parseInt(group));
        candidate.setCreated_by(created_by);

        DAO dao = new DAO();
        dao.insertCandidate(candidate);
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
