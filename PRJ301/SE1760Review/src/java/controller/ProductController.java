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
import java.sql.ResultSet;
import java.util.Vector;
import model.DAOProduct;

/**
 *
 * @author admin
 */
@WebServlet(name = "ProductController", urlPatterns = {"/ProductURL"})
public class ProductController extends HttpServlet {

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
        DAOProduct dao = new DAOProduct();
        String service = request.getParameter("service");
        if (service == null) {
            service = "listAllProduct";
        }
        if (service.equals("listAllProduct")) {
            String message = request.getParameter("message");
            if (message == null) {
                message = "";
            }
            ResultSet rs = dao.getData(
                    "select p.ProductID, p.ProductName, s.CompanyName, \n"
                    + "	c.CategoryName, p.QuantityPerUnit, p.UnitPrice,\n"
                    + "	p.UnitsInStock, p.UnitsOnOrder, p.ReorderLevel, p.Discontinued\n"
                    + "from Products p join Suppliers s on p.SupplierID = s.SupplierID\n"
                    + "	join Categories c on p.CategoryID = c.CategoryID");
            request.setAttribute("data", rs);
            request.setAttribute("message", message);
            request.getRequestDispatcher("/view/product/listAllProduct.jsp").forward(request, response);
        }
        if (service.equals("insertProduct")) {
            String submit = request.getParameter("submit");
            if (submit == null) {
                ResultSet rsCate
                        = dao.getData("select CategoryID,CategoryName from Categories");
                ResultSet rsSup
                        = dao.getData("select SupplierID,CompanyName from Suppliers");
                request.setAttribute("rsCate", rsCate);
                request.setAttribute("rsSup", rsSup);
                request.setAttribute("notification", "");
                request.getRequestDispatcher("/view/product/insertProduct.jsp").forward(request, response);
            } else {
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
                int dis = 0;
                try {
                    dis = Integer.parseInt(Discontinued);
                } catch (NumberFormatException ex) {
                };
                Product pro = new Product(pname, supid, cateid, QuantityPerUnit,
                        price, instock, onOrder, reOder, dis);
                int n = dao.insertProductByPrepared(pro);
                String noti = (n > 0) ? "Insert successfully" : "Error occurs, cannot insert";
                request.setAttribute("notification", noti);
                ResultSet rsCate
                        = dao.getData("select CategoryID,CategoryName from Categories");
                ResultSet rsSup
                        = dao.getData("select SupplierID,CompanyName from Suppliers");
                request.setAttribute("rsCate", rsCate);
                request.setAttribute("rsSup", rsSup);
                request.getRequestDispatcher("/view/product/insertProduct.jsp").forward(request, response);
            }
        }
        if (service.equals("deleteProduct")) {
            int pid = Integer.parseInt(request.getParameter("pid"));
            int n = dao.deleteProduct(pid);
            String noti = (n > 0) ? "Delete successfully" : "Error occurs, cannot delete";
            response.sendRedirect("ProductURL?message=" + noti);
        }
        if (service.equals("updateProduct")) {
            String submit = request.getParameter("submit");
            if (submit == null) {
                int pid = Integer.parseInt(request.getParameter("pid"));
                Vector<Product> vector
                        = dao.getProduct("select * from Products where ProductID=" + pid);
                ResultSet rsCate
                        = dao.getData("select CategoryID,CategoryName from Categories");
                ResultSet rsSup
                        = dao.getData("select SupplierID,CompanyName from Suppliers");
                request.setAttribute("rsCate", rsCate);
                request.setAttribute("rsSup", rsSup);
                request.setAttribute("data", vector);
                request.setAttribute("notification", "");
                request.getRequestDispatcher("/view/product/updateProduct.jsp").forward(request, response);
            } else {
                int pid = Integer.parseInt(request.getParameter("pid"));
                String pname = request.getParameter("name");
                String Supplied = request.getParameter("supID");
                String cate = request.getParameter("cateID");
                String QuantityPerUnit = request.getParameter("QuantityPerUnit");
                String UnitePrice = request.getParameter("UnitePrice");
                String UnitsInStock = request.getParameter("UnitsInStock");
                String UnitsOnOrder = request.getParameter("UnitsOnOrder");
                String ReorderLevel = request.getParameter("ReorderLevel");
                String Discontinued = request.getParameter("Discontinued");

                // convert
                int supid = Integer.parseInt(Supplied);
                int cateid = Integer.parseInt(cate);
                double price = Double.parseDouble(UnitePrice);
                int instock = Integer.parseInt(UnitsInStock);
                int onOrder = Integer.parseInt(UnitsOnOrder);
                int reOder = Integer.parseInt(ReorderLevel);
                int dis = Integer.parseInt(Discontinued);
                Product pro = new Product(pid, pname, supid, cateid, QuantityPerUnit,
                        price, instock, onOrder, reOder, dis);
                int n = dao.updateProduct(pro);
                String noti = (n > 0) ? "Update successfully" : "Error occurs, cannot update";
                response.sendRedirect("ProductURL?message=" + noti);
            }
        }
        
        if (service.equals("searchProduct")) {
    String searchKeyword = request.getParameter("searchKeyword");
    ResultSet searchResults = (ResultSet) dao.searchProduct(searchKeyword);
    request.setAttribute("searchResults", searchResults);
    request.getRequestDispatcher("/view/product/searchProduct.jsp").forward(request, response);
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
