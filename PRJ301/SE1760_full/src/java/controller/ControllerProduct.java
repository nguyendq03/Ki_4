/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import entity.Product;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Vector;
import model.DAOProduct;

/**
 *
 * @author DELL
 */
@WebServlet(name = "ControllerProduct", urlPatterns = {"/ProductURL"})
public class ControllerProduct extends HttpServlet {

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
            /* TODO output your page here. You may use following sample code. */
            DAOProduct dao = new DAOProduct();
            String service = request.getParameter("service");
            if (service == null) {
                service = "listAllProduct";
            }
            //list
            if (service.equals("listAllProduct")) {
                Vector<Product> vector = dao.getProduct("select * from Products");
                //File HTML
                out.print(" <table border=" + "1px" + ">\n"
                        + "    <tr>\n"
                        + "        <th>ProductID</th>\n"
                        + "        <th>ProductName</th>\n"
                        + "        <th>SupplierID</th>\n"
                        + "        <th>CategoryID</th>\n"
                        + "        <th>QuantityPerUnit</th>\n"
                        + "        <th>UnitPrice</th>\n"
                        + "        <th>UnitsInStock</th>\n"
                        + "        <th>UnitsOnOrder</th>\n"
                        + "        <th>ReorderLevel</th>\n"
                        + "        <th>Discontinued</th>\n"
                        + "        <th>update</th>\n"
                        + "        <th>delete</th>\n"
                        + "    </tr>");
                for (Product product : vector) {
                    out.print(" <tr>\n"
                            + "        <td>" + product.getProductID() + "</td>\n"
                            + "        <td>" + product.getProductName() + "</td>\n"
                            + "        <td>" + product.getSupplierID() + "</td>\n"
                            + "        <td>" + product.getCategoryID() + "</td>\n"
                            + "        <td>" + product.getQuantityPerUnit() + "</td>\n"
                            + "        <td>" + product.getUnitPrice() + "</td>\n"
                            + "        <td>" + product.getUnitsInStock() + "</td>\n"
                            + "        <td>" + product.getUnitsOnOrder() + "</td>\n"
                            + "        <td>" + product.getReorderLevel() + "</td>\n"
                            + "        <td>" + (product.getDiscontinued() == 1 ? "Continued" : "Discontinued") + "</td>\n"
                            + "        <td>update</td>\n"
                            + "        <td><a href=\"ProductURL?service=deleteProduct&id=" + product.getProductID() + ">delete</a></td>\n"
                            + "    </tr>");
                }

                out.print(" </table>");
            }
            //insertProduct
            if (service.equals("insertProduct")) {
                //Insert Product
                //get data
                String pname = request.getParameter("name");
                String Supplied = request.getParameter("supID");
                String cate = request.getParameter("cateID");
                String QuantityPerUnit = request.getParameter("QuantityPerUnit");
                String UnitePrice = request.getParameter("UnitePrice");
                String UnitsInStock = request.getParameter("UnitsInStock");
                String UnitsOnOrder = request.getParameter("UnitsOnOrder");
                String ReorderLevel = request.getParameter("ReorderLevel");
                String Discontinued = request.getParameter("Discontinued");
                // check data
                if (pname == null) {

                }
                // convert
                int supid = Integer.parseInt(Supplied);
                int cateid = Integer.parseInt(cate);
                double price = Double.parseDouble(UnitePrice);
                int instock = Integer.parseInt(UnitsInStock);
                int onOrder = Integer.parseInt(UnitsOnOrder);
                int reOder = Integer.parseInt(ReorderLevel);
                int dis = Integer.parseInt(Discontinued);
                Product pro = new Product(pname, supid, cateid, QuantityPerUnit,
                        price, instock, onOrder, reOder, dis);
                int n = dao.insertProductByPrepared(pro);
                response.sendRedirect("ProductURL");
            }
            //delete
            if (service.equals("deleteProduct")) {
                int id = Integer.parseInt(request.getParameter("id"));
                dao.deleteProduct(id);
                response.sendRedirect("ProductURL");
            }
            //search
            if (service.equals("searchProduct")) {
                String pname = request.getParameter("name");
                ArrayList<String> list = dao.searchProduct(pname);
                out.print(" <table border=" + "1px" + ">\n"
                        + "    <tr>\n"
                        + "        <th>ProductName</th>\n"
                        + "        <th>Supplier</th>\n"
                        + "        <th>Category</th>\n"
                        + "    </tr>");
                out.print(" <tr>\n"
                        + "        <td>" + list.get(0) + "</td>\n"
                        + "        <td>" + list.get(1) + "</td>\n"
                        + "        <td>" + list.get(2) + "</td>\n"
                        + "    </tr>");
            }
            out.print(" </table>");
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
