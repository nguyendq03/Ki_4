/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.DAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Student;
import model.Class;

/**
 *
 * @author admin
 */
public class Update extends HttpServlet {

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
        DAO dao = new DAO();
        String service = request.getParameter("service");
        if (service == null || service.equals("")) {
            Vector<Student> listStudent = dao.getAllStudent();
            Vector<Class> listClass = dao.getAllClass();
            request.setAttribute("listStudent", listStudent);
            request.setAttribute("listClass", listClass);
            request.getRequestDispatcher("Q3.jsp").forward(request, response);
        }
        if (service.equals("viewInfo")) {
            String studentID = request.getParameter("studentID");
            ResultSet rs = dao.getData("select * from Students where StudentID = '" + studentID + "'");
            Student stu = new Student();
            try {
                while (rs.next()) {
                    Student student = new Student(rs.getString(1), rs.getString(2), 
                            rs.getString(3).substring(0, Math.min(rs.getString(3).length(), 10)), rs.getInt(4), rs.getInt(5));
                    stu = student;
                }
            } catch (SQLException ex) {
                Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            request.setAttribute("stuInfo", stu);
            request.getRequestDispatcher("update?service=").forward(request, response);
        }
        if(service.equals("update")) {
            String code = request.getParameter("code");
            String name = request.getParameter("name");
            String dob = request.getParameter("dob");
            int gender = Integer.parseInt(request.getParameter("gender"));
            int classID = Integer.parseInt(request.getParameter("classID"));
            Student student = new Student(code, name, dob, gender, classID);
            dao.updateStudent(student);
            request.getRequestDispatcher("update?service=").forward(request, response);
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
