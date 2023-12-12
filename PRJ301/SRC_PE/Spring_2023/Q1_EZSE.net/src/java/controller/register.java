/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.time.LocalDate;
import java.time.Period;

/**
 *
 * @author Hoang Hiep
 */
public class register extends HttpServlet {
   
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
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Servlet register</title>");  
        out.println("</head>");
        out.println("<body>");
        String code = request.getParameter("code");
        String name = request.getParameter("name");
        String dob = request.getParameter("dob");
        
        String msg = "";
        
        // Check code
        if (!code.startsWith("FPT") || code.length() > 9) {
            msg += "Student Code must begin with \"FPT\" and contains maximum 9 characters.<br>";
        }
        
        // Check name
        if (name.length() < 6 || name.length() > 32) {
            msg += "Student Name must contain 6 to 32 characters.<br>";
        }
        
        // Check age
        int age = 0;
        if (!dob.equals("")) {
            LocalDate birthday = LocalDate.parse(dob);
            LocalDate today = LocalDate.now();
            Period period = Period.between(birthday, today);
            age = period.getYears();
        }
        
        if (age < 18) {
            msg += "Student must be 18-year-old or older.<br>";
        }
        
        if(msg.equals("")) {
            msg = "Student registered successful.";
        }
        
        out.println(msg);

        out.println("</body>");
        out.println("</html>");
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
        processRequest(request, response);
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
        processRequest(request, response);
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
