/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import dal.DBContext;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Thread;
import model.Comment;

/**
 *
 * @author admin
 */
@WebServlet(urlPatterns = {"/discuss"})
public class DiscussServlet extends HttpServlet {

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
        DBContext dao = new DBContext();
        HttpSession session = request.getSession();
        String noti = (String) session.getAttribute("noti");
        if (!"Login successful".equals(noti)) {
            request.setAttribute("mes", "access denied");
            request.getRequestDispatcher("/discuss.jsp").forward(request, response);
        } else {
            String submit = request.getParameter("submit");
            //no submission
            if (submit == null || submit.equals("")) {
                LinkedHashMap<Thread, Vector<Comment>> list = new LinkedHashMap<>();
                //get all threads
                ResultSet rsThread = dao.getData("select * from thread");
                Vector<Thread> listThread = new Vector<>();
                try {
                    while (rsThread.next()) {
                        listThread.add(new Thread(rsThread.getInt(1), rsThread.getString(2)));
                    }
                } catch (SQLException ex) {
                }
                //get comment
                for (Thread thread : listThread) {
                    ResultSet rsComment = dao.getData("select c.*, a.displayname\n"
                            + "from Comment c join Account a on a.userid = c.userid\n"
                            + "where tid = " + thread.getTid());
                    Vector<Comment> listComment = new Vector<>();
                    try {
                        while (rsComment.next()) {
                            listComment.add(new Comment(rsComment.getInt(1), rsComment.getString(2),
                                    rsComment.getString(3), rsComment.getInt(4), rsComment.getString(5)));
                        }
                    } catch (SQLException ex) {
                    }
                    list.put(thread, listComment);
                }
                //set request
                request.setAttribute("list", list);
                request.getRequestDispatcher("/discuss.jsp").forward(request, response);
            }
            //post comment
            else if(submit.equals("save")) {
                String ctitle = request.getParameter("ctitle");
                int tid = Integer.parseInt(request.getParameter("tid"));
                String userid = (String)session.getAttribute("user");
                dao.postComment(ctitle, userid, tid);
                response.sendRedirect("discuss");
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
