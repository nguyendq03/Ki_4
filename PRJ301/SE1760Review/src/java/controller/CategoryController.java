/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import entity.Category;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.ResultSet;
import java.util.Vector;
import model.DAOCategory;

/**
 *
 * @author admin
 */
@WebServlet(name = "CategoryController", urlPatterns = {"/CategoryURL"})
public class CategoryController extends HttpServlet {

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
        DAOCategory dao = new DAOCategory();
        String service = request.getParameter("service");
        if (service == null) {
            service = "listAllCategory";
        }
        if (service.equals("listAllCategory")) {
            //get message
            String message = request.getParameter("message");
            if (message == null) {
                message = "";
            }
            //get data
            Vector<Category> vector = dao.getCategory("select * from Categories");
            //set data for JSP
            request.setAttribute("data", vector);
            request.setAttribute("message", message);
            // dispath
            request.getRequestDispatcher("/view/category/listAllCategory.jsp").forward(request, response);
        }
        if (service.equals("insertCategory")) {
            String submit = request.getParameter("submit");
            if (submit == null) {
                request.setAttribute("notification", "");
                request.getRequestDispatcher("/view/category/insertCategory.jsp").forward(request, response);
            } else {
                String CategoryName = request.getParameter("CategoryName");
                String description = request.getParameter("Description");
                String picture = request.getParameter("Picture");
                if (CategoryName == null) {
                }
                Category cate = new Category(CategoryName, description, picture);
                int n = dao.insertCategory(cate);
                String noti = (n > 0) ? "Insert successfully" : "Error occurs, cannot insert";
                request.setAttribute("notification", noti);
                request.getRequestDispatcher("/view/category/insertCategory.jsp").forward(request, response);
            }
        }
        if (service.equals("deleteCategory")) {
            int cateID = Integer.parseInt(request.getParameter("cid"));
            int n = dao.deleteCategory(cateID);
            String noti = (n > 0) ? "Delete successfully" : "Error occurs, cannot delete";
            response.sendRedirect("CategoryURL?message=" + noti);
        }
        if (service.equals("updateCategory")) {
            String submit = request.getParameter("submit");
            if (submit == null) {
                String cid = request.getParameter("cid");
                ResultSet rs = dao.getData("select * from Categories where CategoryID = " + cid);
                request.setAttribute("data", rs);
                request.getRequestDispatcher("/view/category/updateCategory.jsp").forward(request, response);
            } else {
                int CategoryID = 0;
                try{
                    CategoryID = Integer.parseInt(request.getParameter("CategoryID"));
                } catch(NumberFormatException e){}
                String categoryName = request.getParameter("CategoryName");
                String description = request.getParameter("Description");
                String picture = request.getParameter("Picture");
                int n = dao.updateCategory(new Category(CategoryID, categoryName, description, picture));
                String noti = (n > 0) ? "Update successfully" : "Error occurs, cannot update";
                response.sendRedirect("CategoryURL?message=" + noti);
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
