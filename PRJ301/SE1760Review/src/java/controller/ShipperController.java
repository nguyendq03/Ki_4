/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller;

import entity.Shipper;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.ResultSet;
import model.DAOShipper;

/**
 *
 * @author admin
 */
@WebServlet(name="ShipperController", urlPatterns={"/ShipperURL"})
public class ShipperController extends HttpServlet {
   
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
        DAOShipper dao = new DAOShipper();
        String service = request.getParameter("service");
        if (service == null) {
            service = "listAllShipper";
        }
        if (service.equals("listAllShipper")) {
            //get message
            String message = request.getParameter("message");
            if (message == null) {
                message = "";
            }
            ResultSet rs = dao.getData("select * from Shippers");
            request.setAttribute("data", rs);
            request.setAttribute("message", message);
            request.getRequestDispatcher("/view/shipper/listAllShipper.jsp").forward(request, response);
        }
        if(service.equals("insertShipper")) {
            String submit = request.getParameter("submit");
            if (submit == null) {
                request.setAttribute("notification", "");
                request.getRequestDispatcher("/view/shipper/insertShipper.jsp").forward(request, response);
            } else {
                String companyName = request.getParameter("companyName");
                String phone = request.getParameter("phone");
                if (companyName == null) {
                }
                Shipper shipper = new Shipper(companyName, phone);
                int n = dao.insertShipper(shipper);
                String noti = (n > 0) ? "Insert successfully" : "Error occurs, cannot insert";
                request.setAttribute("notification", noti);
                request.getRequestDispatcher("/view/shipper/insertShipper.jsp").forward(request, response);
            }
        }
        if (service.equals("deleteShipper")) {
            int sid =  0;
            try {
                sid = Integer.parseInt(request.getParameter("sid"));
            } catch(NumberFormatException e) {}
            int n = dao.deleteShipper(sid);
            String noti = (n > 0) ? "Delete successfully" : "Error occurs, cannot delete";
            response.sendRedirect("ShipperURL?message=" + noti);
        }
        if (service.equals("updateShipper")) {
            String submit = request.getParameter("submit");
            if (submit == null) {
                String sid = request.getParameter("sid");
                ResultSet rs = dao.getData("select * from Shippers where ShipperID = " + sid);
                request.setAttribute("data", rs);
                request.getRequestDispatcher("/view/shipper/updateShipper.jsp").forward(request, response);
            } else {
                int ShipperID = 0;
                try{
                    ShipperID = Integer.parseInt(request.getParameter("ShipperID"));
                } catch(NumberFormatException e){}
                String companyName = request.getParameter("companyName");
                String phone = request.getParameter("phone");
                Shipper shipper = new Shipper(ShipperID, companyName, phone);
                int n = dao.updateShipper(shipper);
                String noti = (n > 0) ? "Update successfully" : "Error occurs, cannot update";
                response.sendRedirect("ShipperURL?message=" + noti);
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
