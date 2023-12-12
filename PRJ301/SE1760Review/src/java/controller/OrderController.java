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
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Vector;
import model.DAOOrder;

/**
 *
 * @author admin
 */
@WebServlet(name = "OrderController", urlPatterns = {"/OrderURL"})
public class OrderController extends HttpServlet {

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
        DAOOrder dao = new DAOOrder();
        String service = request.getParameter("service");
        if (service == null) {
            service = "listAllOrder";
        }
        if (service.equals("listAllOrder")) {
            String message = request.getParameter("message");
            if (message == null) {
                message = "";
            }
            //Return data using select in DB
            ResultSet rs = dao.getData("select o.OrderID, c.ContactName as Customer, e.FirstName + ' ' + e.LastName as Employee, \n"
                    + "	o.OrderDate, o.RequiredDate, o.ShippedDate, o.ShipVia, o.Freight, o.ShipName,\n"
                    + "	o.ShipAddress, o.ShipCity, o.ShipRegion, o.ShipPostalCode, o.ShipCountry\n"
                    + "from Orders o join Customers c on o.CustomerID = c.CustomerID\n"
                    + "	join Employees e on o.EmployeeID = e.EmployeeID");
            request.setAttribute("data", rs);
            request.setAttribute("message", message);
            request.getRequestDispatcher("/view/order/listAllOrder.jsp").forward(request, response);
        }
        /*
        if(service.equals("insertOrder")) {
            String submit = request.getParameter("submit");
            if (submit == null) {
                ResultSet rsEmp = dao.getData("select EmployeeID, FirstName + ' ' + LastName as EmployeeName from Employees");
                request.setAttribute("notification", "");
                request.setAttribute("rsEmp", rsEmp);
                request.getRequestDispatcher("/view/order/insertOrder.jsp").forward(request, response);
            }
        }
         */
        if (service.equals("searchOrder")) {
            String OrderID = request.getParameter("OrderID");
            String Customer = request.getParameter("Customer");
            String Employee = request.getParameter("Employee");
            String RequiredFrom = request.getParameter("RequiredFrom");
            String RequiredTo = request.getParameter("RequiredTo");
            String ShippedFrom = request.getParameter("ShippedFrom");
            String ShippedTo = request.getParameter("ShippedTo");
            String ShipVia = request.getParameter("ShipVia");
            String Freight = request.getParameter("Freight");
            String ShipName = request.getParameter("ShipName");
            String ShipAddress = request.getParameter("ShipAddress");
            String ShipCity = request.getParameter("ShipCity");
            String ShipRegion = request.getParameter("ShipRegion");
            String ShipPostalCode = request.getParameter("ShipPostalCode");
            String ShipCountry = request.getParameter("ShipCountry");
            String OrderFrom = request.getParameter("OrderFrom");
            String OrderTo = request.getParameter("OrderTo");
            String sql = "select o.OrderID, c.ContactName as Customer, e.FirstName + ' ' + e.LastName as Employee, \n"
                    + "	o.OrderDate, o.RequiredDate, o.ShippedDate, o.ShipVia, o.Freight, o.ShipName,\n"
                    + "	o.ShipAddress, o.ShipCity, o.ShipRegion, o.ShipPostalCode, o.ShipCountry\n"
                    + "from Orders o join Customers c on o.CustomerID = c.CustomerID\n"
                    + "	join Employees e on o.EmployeeID = e.EmployeeID"
                    + " where 1 = 1";
            if (OrderID != null && !OrderID.equals("")) {
                sql += " and o.OrderID like '%" + OrderID + "%'";
            }
            if (Customer != null && !Customer.equals("")) {
                sql += " and c.ContactName like '%" + Customer + "%'";
            }
            if (Employee != null && !Employee.equals("")) {
                sql += " and e.FirstName + ' ' + e.LastName like '%" + Employee + "%'";
            }
            if (RequiredFrom != null && !RequiredFrom.equals("")) {
                sql += " and o.RequiredDate >= '" + RequiredFrom + "'";
            }
            if (RequiredTo != null && !RequiredTo.equals("")) {
                sql += " and o.RequiredDate <= '" + RequiredTo + "'";
            }
            if (ShippedFrom != null && !ShippedFrom.equals("")) {
                sql += " and o.ShippedDate >= '" + ShippedFrom + "'";
            }
            if (ShippedTo != null && !ShippedTo.equals("")) {
                sql += " and o.ShippedDate <= '" + ShippedTo + "'";
            }
            if (ShipVia != null && !ShipVia.equals("")) {
                sql += " and o.ShipVia like '%" + ShipVia + "%'";
            }
            if (Freight != null && !Freight.equals("")) {
                sql += " and o.Freight like '%" + Freight + "%'";
            }
            if (ShipName != null && !ShipName.equals("")) {
                sql += " and o.ShipName like '%" + ShipName + "%'";
            }
            if (ShipAddress != null && !ShipAddress.equals("")) {
                sql += " and o.ShipAddress like '%" + ShipAddress + "%'";
            }
            if (ShipCity != null && !ShipCity.equals("")) {
                sql += " and o.ShipCity like '%" + ShipCity + "%'";
            }
            if (ShipRegion != null && !ShipRegion.equals("")) {
                sql += " and o.ShipRegion like '%" + ShipRegion + "%'";
            }
            if (ShipPostalCode != null && !ShipPostalCode.equals("")) {
                sql += " and o.ShipPostalCode like '%" + ShipPostalCode + "%'";
            }
            if (ShipCountry != null && !ShipCountry.equals("")) {
                sql += " and o.ShipCountry like '%" + ShipCountry + "%'";
            }
            if (OrderFrom != null && !OrderFrom.equals("")) {
                sql += " and o.OrderDate >= '" + OrderFrom + "'";
            }
            if (OrderTo != null && !OrderTo.equals("")) {
                sql += " and o.OrderDate <= '" + OrderTo + "'";
            }
            ResultSet rs = dao.getData(sql);
            request.setAttribute("data", rs);
            request.getRequestDispatcher("/view/order/viewSearchedOrder.jsp").forward(request, response);
        }
        if (service.equals("viewOrder")) {
            String customerID = request.getParameter("customerID");
            Vector<ArrayList<String>> vector = dao.viewOrderOfCustomerById(customerID);
            request.setAttribute("customerID", customerID);
            request.setAttribute("bill", vector);
            request.getRequestDispatcher("/view/order/viewBillOfCustomer.jsp").forward(request, response);
        }
        if (service.equals("viewOrderInDay")) {
            String customerID = request.getParameter("customerID");
            String date = request.getParameter("date");
            Vector<ArrayList<String>> vector = dao.viewOrderOfCustomerByIdInDay(customerID, date);
            request.setAttribute("bill", vector);
            request.getRequestDispatcher("/view/order/viewBillOfCustomerInDay.jsp").forward(request, response);
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
