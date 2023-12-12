/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import entity.Employee;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.ResultSet;
import model.DAOEmployee;

/**
 *
 * @author admin
 */
@WebServlet(name = "EmployeeController", urlPatterns = {"/EmployeeURL"})
public class EmployeeController extends HttpServlet {

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
        DAOEmployee dao = new DAOEmployee();
        String service = request.getParameter("service");
        if (service == null) {
            service = "listAllEmployee";
        }
        if (service.equals("listAllEmployee")) {
            String message = request.getParameter("message");
            if (message == null) {
                message = "";
            }
            ResultSet rs = dao.getData("select * from Employees");
            request.setAttribute("data", rs);
            request.setAttribute("message", message);
            request.getRequestDispatcher("/view/employee/listAllEmployee.jsp").forward(request, response);
        }
        if (service.equals("insertEmployee")) {
            String submit = request.getParameter("submit");
            if (submit == null) {
                request.setAttribute("notification", "");
                request.getRequestDispatcher("/view/employee/insertEmployee.jsp").forward(request, response);
            } else {
                String LastName = request.getParameter("LastName");
                String FirstName = request.getParameter("FirstName");
                String Title = request.getParameter("Title");
                String TitleOfCourtesy = request.getParameter("TitleOfCourtesy");
                String BirthDate = (String) request.getParameter("BirthDate");
                String HireDate = (String) request.getParameter("HireDate");
                String Address = request.getParameter("Address");
                String City = request.getParameter("City");
                String Region = request.getParameter("Region");
                String PostalCode = request.getParameter("PostalCode");
                String Country = request.getParameter("Country");
                String HomePhone = request.getParameter("HomePhone");
                String Extension = request.getParameter("Extension");
                String Photo = request.getParameter("Photo");
                String Notes = request.getParameter("Notes");
                int ReportsTo = 0;
                try {
                    ReportsTo = Integer.parseInt(request.getParameter("ReportsTo"));
                } catch (NumberFormatException e) {
                };
                String PhotoPath = request.getParameter("PhotoPath");
                Employee employee = new Employee(LastName, FirstName, Title, TitleOfCourtesy, BirthDate,
                        HireDate, Address, City, Region, PostalCode, Country, HomePhone, Extension, Photo, Notes, ReportsTo, PhotoPath);
                int n = dao.insertEmployee(employee);
                String noti = (n > 0) ? "Insert successfully" : "Error occurs, cannot insert";
                request.setAttribute("notification", noti);
                request.getRequestDispatcher("/view/employee/insertEmployee.jsp").forward(request, response);
            }
        }
        if(service.equals("deleteEmployee")) {
            int eid = Integer.parseInt(request.getParameter("eid"));
            int n = dao.deleteEmployee(eid);
            String noti = (n > 0) ? "Delete successfully" : "Error occurs, cannot delete";
            response.sendRedirect("EmployeeURL?message=" + noti);
        }
        if(service.equals("updateEmployee")) {
            String submit = request.getParameter("submit");
            if(submit == null) {
                int eid = Integer.parseInt(request.getParameter("eid"));
                ResultSet rs = dao.getData("select * from Employees where EmployeeID = " + eid);
                request.setAttribute("data", rs);
                request.getRequestDispatcher("/view/employee/updateEmployee.jsp").forward(request, response);
            }else {
                int eid = 0;
                try{
                    eid = Integer.parseInt(request.getParameter("eid"));
                }catch(NumberFormatException e) {};
                String LastName = request.getParameter("LastName");
                String FirstName = request.getParameter("FirstName");
                String Title = request.getParameter("Title");
                String TitleOfCourtesy = request.getParameter("TitleOfCourtesy");
                String BirthDate = "";
                String HireDate = "";
                String Address = request.getParameter("Address");
                String City = request.getParameter("City");
                String Region = request.getParameter("Region");
                String PostalCode = request.getParameter("PostalCode");
                String Country = request.getParameter("Country");
                String HomePhone = request.getParameter("HomePhone");
                String Extension = request.getParameter("Extension");
                String Photo = request.getParameter("Photo");
                String Notes = request.getParameter("Notes");
                int ReportsTo = 0;
                try {
                    ReportsTo = Integer.parseInt(request.getParameter("ReportsTo"));
                } catch (NumberFormatException e) {
                };
                String PhotoPath = request.getParameter("PhotoPath");
                Employee employee = new Employee(eid,LastName, FirstName, Title, TitleOfCourtesy, BirthDate,
                        HireDate, Address, City, Region, PostalCode, Country, HomePhone, Extension, Photo, Notes, ReportsTo, PhotoPath);
                int n = dao.updateEmployee(employee);
                String noti = (n > 0) ? "Update successfully" : "Error occurs, cannot update";
                response.sendRedirect("EmployeeURL?message=" + noti);
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
