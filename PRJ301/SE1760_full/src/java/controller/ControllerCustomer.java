/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import entity.Customer;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.Vector;
import model.DAOCustomer;

/**
 *
 * @author admin
 */
@WebServlet(name = "ControllerCustomer", urlPatterns = {"/CustomerURL"})
public class ControllerCustomer extends HttpServlet {

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
        try ( PrintWriter out = response.getWriter()) {
            out.print("<h1>Click on CustomerID to view Order Detail<h1>");
            DAOCustomer dao = new DAOCustomer();
            String service = request.getParameter("service");
            if (service == null) {
                service = "listAllCustomer";
            }
            if (service.equals("listAllCustomer")) {
                Vector<Customer> vector = dao.getCustomer("select * from Customers");
                out.print(" <table border=" + "1px" + ">\n"
                        + "    <tr>\n"
                        + "        <th>CustomerID</th>\n"
                        + "        <th>CompanyName</th>\n"
                        + "        <th>ContactName</th>\n"
                        + "        <th>ContactTitle</th>\n"
                        + "        <th>Address</th>\n"
                        + "        <th>City</th>\n"
                        + "        <th>Region</th>\n"
                        + "        <th>PostalCode</th>\n"
                        + "        <th>Country</th>\n"
                        + "        <th>Phone</th>\n"
                        + "        <th>Fax</th>\n"
                        + "    </tr>");
                for (Customer customer : vector) { 
                    out.print(" <tr>\n"
                            + "        <td><a href=OrderURL?service=viewOrder&customerID="+ customer.getCustomerID() +">" + customer.getCustomerID() + "</a></td>\n"
                            + "        <td>" + customer.getCompanyName() + "</td>\n"
                            + "        <td>" + customer.getContactName() + "</td>\n"
                            + "        <td>" + customer.getContactTitle() + "</td>\n"
                            + "        <td>" + customer.getAddress() + "</td>\n"
                            + "        <td>" + customer.getCity() + "</td>\n"
                            + "        <td>" + customer.getRegion() + "</td>\n"
                            + "        <td>" + customer.getPostalCode() + "</td>\n"
                            + "        <td>" + customer.getCountry() + "</td>\n"
                            + "        <td>" + customer.getPhone() + "</td>\n"
                            + "        <td>" + customer.getFax() + "</td>\n"
                            + "    </tr>");
                }
                out.print(" </table>");
            }
            if (service.equals("insertCustomer")) {
                String customerID = request.getParameter("customerID");
                String companyName = request.getParameter("companyName");
                String contactName = request.getParameter("contactName");
                String contactTitle = request.getParameter("contactTitle");
                String address = request.getParameter("address");
                String city = request.getParameter("city");
                String region = request.getParameter("region");
                String postalCode = request.getParameter("postalCode");
                String country = request.getParameter("country");
                String phone = request.getParameter("phone");
                String fax = request.getParameter("fax");
                if (customerID == null) {

                }
                Customer customer = new Customer(customerID, companyName, contactName, contactTitle, address, city, region, postalCode, country, phone, fax);
                int n = dao.insertCustomer(customer);
                response.sendRedirect("CustomerURL");
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
