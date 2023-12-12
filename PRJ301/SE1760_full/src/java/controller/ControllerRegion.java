/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller;

import entity.Region;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.Vector;
import model.DAORegion;

/**
 *
 * @author admin
 */
@WebServlet(name="ControllerRegion", urlPatterns={"/RegionURL"})
public class ControllerRegion extends HttpServlet {
   
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
            DAORegion dao = new DAORegion();
            String service = request.getParameter("service");
            if (service == null) {
                service = "listAllRegion";
            }
            if (service.equals("listAllRegion")) {
                Vector<Region> vector = dao.getRegion("select * from Region");
                out.print(" <table border=" + "1px" + ">\n"
                        + "    <tr>\n"
                        + "        <th>RegionID</th>\n"
                        + "        <th>RegionDescription</th>\n"
                        + "    </tr>");
                for (Region region : vector) { 
                    out.print(" <tr>\n"
                            + "        <td>" + region.getRegionID() + "</td>\n"
                            + "        <td>" + region.getRegionDescription() + "</td>\n"
                            + "        <td>update</td>\n"
                            + "        <td>delete</td>\n"
                            + "    </tr>");
                }
                out.print(" </table>");
            }
            if (service.equals("insertRegion")) {
                int regionID = Integer.parseInt(request.getParameter("regionID"));
                String regionDescription = request.getParameter("regionDescription");
                
                Region region = new Region(regionID, regionDescription);
                int n = dao.insertRegion(region);
                response.sendRedirect("RegionURL");
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
