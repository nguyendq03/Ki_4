/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.time.LocalDate;
import java.time.Period;


public class RegisterServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet RegisterServlet</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet RegisterServlet at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    } 


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    } 

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String stCode = request.getParameter("code");
        String stName = request.getParameter("name");
        String stDob = request.getParameter("dob");
        boolean vlCode = false;
        boolean vlName = false;
        boolean vlDob = false;
        
        if(stCode.startsWith("FPT")&&stCode.length()<=9){
            vlCode = true;
        }
        if(stName.length()>=6&&stName.length()<=32){
            vlName = true;
        }
        
        LocalDate dob = LocalDate.parse(stDob);
        Period p = Period.between(dob, LocalDate.now());
        if(p.getYears()>=18){
            vlDob = true;
        }
        if(vlCode&&vlName&&vlDob){
            out.println("<p>Student registered successful</p>");
        }else{
            if(vlCode==false){
                out.println("<p>Student Code must begin with \"FPT\" and contains maximum 9 characters</P>");
            }
            if(vlName==false){
                out.println("<p>Student Name must contain 6 to 32 character.</p>");
            }
            if(vlDob==false){
                out.println("<p>Student must be 18-year-old or older</p>");
            }
        }
        
    }


}
