/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import entity.Order;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Vector;
import model.DAOOrder;

/**
 *
 * @author admin
 */
@WebServlet(name = "ControllerOrder", urlPatterns = {"/OrderURL"})
public class ControllerOrder extends HttpServlet {

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
            DAOOrder dao = new DAOOrder();
            String service = request.getParameter("service");
            if (service == null) {
                service = "viewOrder";
            }
            //list        
            if (service.equals("viewOrder")) {
                String customerID = request.getParameter("customerID");
                Vector<ArrayList<String>> vector = dao.viewOrderOfCustomerById(customerID);
                out.print("<b>OrderID: </b>" + vector.get(0).get(0) + "<br/>");
                out.print("<b>Date: </b>" + vector.get(0).get(1) + "<br/>");
                out.print("<b>Customer: </b>" + vector.get(0).get(2) + "<br/>");
                out.print("<b>Employee: </b>" + vector.get(0).get(3) + "<br/>");
                out.print("----------------Bill------------------");
                out.print("<br/><hr/><br/>");
                out.print(" <table border=" + "1px" + " width=" + "80%" + ">\n"
                        + "    <tr>\n"
                        + "        <th>No</th>\n"
                        + "        <th>ProductName</th>\n"
                        + "        <th>Quantity</th>\n"
                        + "        <th>UnitPrice</th>\n"
                        + "        <th>Discount</th>\n"
                        + "        <th>SubTotal</th>\n"
                        + "    </tr>");
                double grandTotal = 0;
                for (int i = 0; i < vector.size(); i++) {
                    grandTotal += Double.parseDouble(vector.get(i).get(8));
                    out.print("<tr>");
                    out.print("<td>" + (i + 1) + "</td>");
                    for (int j = 4; j < vector.get(i).size(); j++) {
                        out.print("<td>" + vector.get(i).get(j) + "</td>");
                    }
                    out.print("</tr>");
                }
                out.print("<tr>"
                        + "<td colspan=\"5\"><b>Grand Total</b><td>"
                        + grandTotal
                        + "<tr>");
                out.print("</table>");
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
