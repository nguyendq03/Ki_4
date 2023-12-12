/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller;

import entity.Supplier;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.ResultSet;
import model.DAOSupplier;

/**
 *
 * @author admin
 */
@WebServlet(name="SupplierController", urlPatterns={"/SupplierURL"})
public class SupplierController extends HttpServlet {
   
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
        DAOSupplier dao = new DAOSupplier();
        String service = request.getParameter("service");
        if (service == null) {
            service = "listAllSupplier";
        }
        if (service.equals("listAllSupplier")) {
            //get message
            String message = request.getParameter("message");
            if (message == null) {
                message = "";
            }
            ResultSet rs = dao.getData("select * from Suppliers");
            request.setAttribute("data", rs);
            request.setAttribute("message", message);
            request.getRequestDispatcher("/view/supplier/listAllSupplier.jsp").forward(request, response);
        }
        if(service.equals("insertSupplier")) {
            String submit = request.getParameter("submit");
            if (submit == null) {
                request.setAttribute("notification", "");
                request.getRequestDispatcher("/view/supplier/insertSupplier.jsp").forward(request, response);
            } else {
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
                String homePage = request.getParameter("homePage");
                if (companyName == null) {
                }
                Supplier supplier = new Supplier(companyName, contactName, contactTitle,
                         address, city, region, postalCode, country, phone, fax, homePage);
                int n = dao.insertSupplier(supplier);
                String noti = (n > 0) ? "Insert successfully" : "Error occurs, cannot insert";
                request.setAttribute("notification", noti);
                request.getRequestDispatcher("/view/supplier/insertSupplier.jsp").forward(request, response);
            }
        }
        if(service.equals("deleteSupplier")) {
            int supID = Integer.parseInt(request.getParameter("sid"));
            int n = dao.deleteSupplier(supID);
            String noti = (n > 0) ? "Delete successfully" : "Error occurs, cannot delete";
            response.sendRedirect("SupplierURL?message=" + noti);
        }
        if (service.equals("updateSupplier")) {
            String submit = request.getParameter("submit");
            if (submit == null) {
                String sid = request.getParameter("sid");
                ResultSet rs = dao.getData("select * from Suppliers where SupplierID = " + sid);
                request.setAttribute("data", rs);
                request.getRequestDispatcher("/view/supplier/updateSupplier.jsp").forward(request, response);
            } else {
                int SupllierID = 0;
                try{
                    SupllierID = Integer.parseInt(request.getParameter("SupllierID"));
                } catch(NumberFormatException e){}
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
                String homePage = request.getParameter("homePage");
                Supplier supplier = new Supplier(SupllierID, companyName, contactName, contactTitle,
                         address, city, region, postalCode, country, phone, fax, homePage);
                int n = dao.updateSupplier(supplier);
                String noti = (n > 0) ? "Update successfully" : "Error occurs, cannot update";
                response.sendRedirect("SupplierURL?message=" + noti);
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
