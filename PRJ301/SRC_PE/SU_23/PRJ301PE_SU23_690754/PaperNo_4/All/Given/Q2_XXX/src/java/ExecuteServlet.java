/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ExecuteServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String number = request.getParameter("number");
        if (number == null) {
            request.getRequestDispatcher("MyExam.jsp").forward(request, response);
        } else {
            int n = Integer.parseInt(number);
            if (n < 0 || n > 10) {
                request.setAttribute("number", n);
                request.setAttribute("error", "You must input an integer 0 < n < 10");
                request.getRequestDispatcher("MyExam.jsp").forward(request, response);
            } else {
                request.setAttribute("number", n);
                request.setAttribute("result", tinhGiaiThua(n));
                request.getRequestDispatcher("MyExam.jsp").forward(request, response);
            }
        }
    }

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

    public static int tinhGiaiThua(int n) {
        if (n == 0 || n == 1) {
            return 1;
        } else {
            int giaiThua = 1;

            for (int i = 2; i <= n; i++) {
                giaiThua *= i;
            }

            return giaiThua;
        }
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
