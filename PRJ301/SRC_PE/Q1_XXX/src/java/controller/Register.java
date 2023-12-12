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
import java.time.format.DateTimeParseException;

/**
 *
 * @author ASUS PC
 */
public class Register extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request  servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Register</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Register at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the
    // + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request  servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request  servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        String code = request.getParameter("code");
        String name = request.getParameter("name");
        String date = request.getParameter("date");
        boolean flag = true;

        if (code == null || code.isEmpty() || !(code.startsWith("FPT") && code.length() <= 9)) {
            out.println("Student Code must be begin with 'FPT' and no longer than 9 characters.");
            flag = false;
        }

        if (name == null || name.isEmpty() || !(name.length() >= 6 && name.length() <= 32)) {
            out.println("Student name must contain 6 and 32 characters long.");
            flag = false;
        }

        if (date == null || date.isEmpty()) {
            out.println("Date of birth must be provided.");
            flag = false;
        } else {
            try {
                LocalDate dob = LocalDate.parse(date);
                Period age = Period.between(dob, LocalDate.now());
                if (age.getYears() < 18) {
                    out.println("Student must be 18-years old.");
                    flag = false;
                }
            } catch (DateTimeParseException e) {
//                out.println("Invalid date format. Please provide a date in the format 'yyyy-MM-dd'.");
                flag = false;
            }
        }

        if (flag) {
            out.println("Student registration successful.");
        }
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
