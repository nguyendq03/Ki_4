/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller;

import entity.Category;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.Vector;
import model.DAOCategory;

/**
 *
 * @author admin
 */
@WebServlet(name="ControllerCategory", urlPatterns={"/CategoryURL"})
public class ControllerCategory extends HttpServlet {
   
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
            DAOCategory dao = new DAOCategory();
            String service = request.getParameter("service");
            if(service == null) {
                service = "listAllCategory";
            }
            if(service.equals("listAllCategory")) {
                Vector<Category> vector = dao.getCategory("select * from Categories");
                out.print(" <table border=" + "1px"+">\n"
                        + "    <tr>\n"
                        + "        <th>CategoryID</th>\n"
                        + "        <th>CategoryName</th>\n"
                        + "        <th>Description</th>\n"
                        + "        <th>Picture</th>\n"
                        + "        <th>update</th>\n"
                        + "        <th>delete</th>\n"
                        + "    </tr>");
                for(Category category : vector) {
                    out.print(" <tr>\n"
                            + "        <td>" + category.getCategoryID() + "</td>\n"
                            + "        <td>" + category.getCategoryName() + "</td>\n"
                            + "        <td>" + category.getDescription() + "</td>\n"
                            + "        <td>" + category.getPicture() + "</td>\n"
                            + "        <td>update</td>\n"
                            + "        <td>delete</td>\n"
                            + "    </tr>");
                }
                out.print(" </table>");
            }
            if(service.equals("insertCatgegory")) {
                String cname = request.getParameter("categoryName");
                String desc = (String)request.getParameter("description");
                String pic = (String)request.getParameter("picture");
                if(cname == null) {
                }
                Category cate = new Category(cname, desc, pic);
                int n = dao.insertCategory(cate);
                response.sendRedirect("CategoryURL");
            }
            if(service.equals("searchCategory")) {
                String cname = request.getParameter("name");
                Vector<Category> vector = dao.getCategory("select * from Categories where CategoryName = '" + cname + "'");
                out.print(" <table border=" + "1px"+">\n"
                        + "    <tr>\n"
                        + "        <th>CategoryID</th>\n"
                        + "        <th>CategoryName</th>\n"
                        + "        <th>Description</th>\n"
                        + "        <th>Picture</th>\n"
                        + "        <th>update</th>\n"
                        + "        <th>delete</th>\n"
                        + "    </tr>");
                for(Category category : vector) {
                    out.print(" <tr>\n"
                            + "        <td>" + category.getCategoryID() + "</td>\n"
                            + "        <td>" + category.getCategoryName() + "</td>\n"
                            + "        <td>" + category.getDescription() + "</td>\n"
                            + "        <td>" + category.getPicture() + "</td>\n"
                            + "        <td>update</td>\n"
                            + "        <td>delete</td>\n"
                            + "    </tr>");
                }
                out.print(" </table>");
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
