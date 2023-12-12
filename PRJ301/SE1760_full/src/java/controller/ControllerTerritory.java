/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller;

import entity.Territory;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.Vector;
import model.DAOTerritory;

/**
 *
 * @author admin
 */
@WebServlet(name="ControllerTerritory", urlPatterns={"/TerritoryURL"})
public class ControllerTerritory extends HttpServlet {
   
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
            DAOTerritory dao = new DAOTerritory();
            String service = request.getParameter("service");
            if (service == null) {
                service = "listAllTerritory";
            }
            if (service.equals("listAllTerritory")) {
                Vector<Territory> vector = dao.getTerritory("select * from Territories");
                out.print(" <table border=" + "1px" + ">\n"
                        + "    <tr>\n"
                        + "        <th>TerritoryID</th>\n"
                        + "        <th>TerritoryDescription</th>\n"
                        + "        <th>RegionID</th>\n"
                        + "    </tr>");
                for (Territory territory : vector) { 
                    out.print(" <tr>\n"
                            + "        <td>" + territory.getTerritoryID() + "</td>\n"
                            + "        <td>" + territory.getTerritoryDescription() + "</td>\n"
                                    + "        <td>" + territory.getRegionID() + "</td>\n"
                            + "        <td>update</td>\n"
                            + "        <td>delete</td>\n"
                            + "    </tr>");
                }
                out.print(" </table>");
            }
            if (service.equals("insertTerritory")) {
                String territoryID = request.getParameter("territoryID");
                String territoryDescription = request.getParameter("territoryDescription");
                int regionID = Integer.parseInt(request.getParameter("regionID"));
                Territory territory = new Territory(territoryID, territoryDescription, regionID);
                int n = dao.insertTerritory(territory);
                response.sendRedirect("TerritoryURL");
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
