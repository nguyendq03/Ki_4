/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller;

import dal.PaperDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Paper;

/**
 *
 * @author ezse.net
 */
public class assign extends HttpServlet {
   
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
            out.println("<title>Servlet assign</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet assign at " + request.getContextPath () + "</h1>");
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
        HttpSession session = request.getSession();
        if(session.getAttribute("user") == null) {
            PrintWriter out = response.getWriter();
            out.println("Access denied!");
        } else {
            PaperDAO paperDAO = new PaperDAO();
            int id = Integer.parseInt(request.getParameter("id"));
            Paper paper = paperDAO.getPaperByID(id);
            
            request.setAttribute("paper", paper);
            
            request.setAttribute("authors", paperDAO.getAllAuthorByPaperID(id));
            
            request.setAttribute("notAssignAuthors", paperDAO.getNoAssignAuthorByPaperID(id));
            
            request.getRequestDispatcher("assign.jsp").forward(request, response);
        }
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
        PaperDAO paperDAO = new PaperDAO();
        int pid = Integer.parseInt(request.getParameter("pid"));
        int auid = Integer.parseInt(request.getParameter("auid"));
        int isCorresponding = 0;
        if(request.getParameter("isCorresponding") != null) isCorresponding = 1;
        paperDAO.assign(pid, auid, isCorresponding);
        
        response.sendRedirect("assign?id=" + pid);
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
