/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller;

import entity.CustomerCustomerDemo;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.Vector;
import model.DAOCustomerCustomerDemo;

/**
 *
 * @author admin
 */
@WebServlet(name="ControllerCustomerCustomerDemo", urlPatterns={"/CustomerCustomerDemoURL"})
public class ControllerCustomerCustomerDemo extends HttpServlet {
   
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
            DAOCustomerCustomerDemo dao = new DAOCustomerCustomerDemo();
            String service = request.getParameter("service");
            if (service == null) {
                service = "listAllCustomerCustomerDemo";
            }
            if (service.equals("listAllCustomerCustomerDemo")) {
                Vector<CustomerCustomerDemo> vector = dao.getCustomerCustomerDemo("select * from CustomerCustomerDemo");
                out.print(" <table border=" + "1px" + ">\n"
                        + "    <tr>\n"
                        + "        <th>CustomerID</th>\n"
                        + "        <th>CustomerTypeID</th>\n"
                        + "        <th>update</th>\n"
                        + "        <th>delete</th>\n"
                        + "    </tr>");
                for (CustomerCustomerDemo cus : vector) { 
                    out.print(" <tr>\n"
                            + "        <td>" + cus.getCustomerID() + "</td>\n"
                            + "        <td>" + cus.getCustomerTypeID() + "</td>\n"
                            + "        <td>update</td>\n"
                            + "        <td>delete</td>\n"
                            + "    </tr>");
                }
                out.print(" </table>");
            }
            if (service.equals("insertCustomer")) {
                String customerID = request.getParameter("customerID");
                String customerTypeID = request.getParameter("customerTypeID");
                if (customerID == null) {
                }
                CustomerCustomerDemo customer = new CustomerCustomerDemo(customerID, customerTypeID);
                int n = dao.insertCustomerCustomerDemo(customer);
                response.sendRedirect("CustomerCustomerDemoURL");
            }
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
