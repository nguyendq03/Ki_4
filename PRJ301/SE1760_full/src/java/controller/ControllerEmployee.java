/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller;

import entity.Employee;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.Vector;
import model.DAOEmployee;

/**
 *
 * @author admin
 */
@WebServlet(name="ControllerEmployee", urlPatterns={"/EmployeeURL"})
public class ControllerEmployee extends HttpServlet {
   
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
            DAOEmployee dao = new DAOEmployee();
            String service = request.getParameter("service");
            if (service == null) {
                service = "listAllEmployee";
            }
            if (service.equals("listAllEmployee")) {
                Vector<Employee> vector = dao.getEmployee("select * from Employees");
                out.print(" <table border=" + "1px" + ">\n"
                        + "    <tr>\n"
                        + "        <th>EmployeeID</th>\n" 
                        + "        <th>LastName</th>\n"
                        + "        <th>FirstName</th>\n"
                        + "        <th>Title</th>\n"
                        + "        <th>TitleOfCourtesy</th>\n"
                        + "        <th>BirthDate</th>\n"
                        + "        <th>HireDate</th>\n"
                        + "        <th>Address</th>\n"
                        + "        <th>City</th>\n"
                        + "        <th>Region</th>\n"
                        + "        <th>PostalCode</th>\n"
                        + "        <th>Country</th>\n"
                        + "        <th>HomePhone</th>\n"
                        + "        <th>Extension</th>\n"
                        + "        <th>Photo</th>\n"
                        + "        <th>Notes</th>\n"
                        + "        <th>ReportsTo</th>\n"
                        + "        <th>PhotoPath</th>\n"
                        + "        <th>update</th>\n"
                        + "        <th>delete</th>\n"
                        + "    </tr>");
                for (Employee employee : vector) { 
                    out.print(" <tr>\n"
                            + "        <td>" + employee.getEmployeeID() + "</td>\n"
                            + "        <td>" + employee.getLastName() + "</td>\n"
                            + "        <td>" + employee.getFirstName() + "</td>\n"
                            + "        <td>" + employee.getTitle() + "</td>\n"
                            + "        <td>" + employee.getTitleOfCourtesy() + "</td>\n"
                            + "        <td>" + employee.getBirthDate() + "</td>\n"
                            + "        <td>" + employee.getHireDate() + "</td>\n"
                            + "        <td>" + employee.getAddress() + "</td>\n"
                            + "        <td>" + employee.getCity() + "</td>\n"
                            + "        <td>" + employee.getRegion() + "</td>\n"
                            + "        <td>" + employee.getPostalCode() + "</td>\n"
                            + "        <td>" + employee.getCountry() + "</td>\n"
                            + "        <td>" + employee.getHomePhone() + "</td>\n"
                            + "        <td>" + employee.getExtension() + "</td>\n"
                            + "        <td>" + employee.getPhoto() + "</td>\n"
                            + "        <td>" + employee.getNotes() + "</td>\n"
                            + "        <td>" + employee.getReportsTo() + "</td>\n"
                            + "        <td>" + employee.getPhotoPath() + "</td>\n"
                            + "        <td>update</td>\n"
                            + "        <td>delete</td>\n"
                            + "    </tr>");
                }
                out.print(" </table>");
            }
            if (service.equals("insertEmployee")) {
                String lastName = request.getParameter("lastName");
                String firstName = request.getParameter("firstName");
                String title = request.getParameter("title");
                String titleOfCourtesy = request.getParameter("titleOfCourtesy");
                String birthDate = request.getParameter("birthDate");
                String hireDate = request.getParameter("hireDate");
                String address = request.getParameter("address");
                String city = request.getParameter("city");
                String region = request.getParameter("region");
                String postalCode = request.getParameter("postalCode");
                String country = request.getParameter("country");
                String homePhone = request.getParameter("homePhone");
                String extension = request.getParameter("extension");
                String photo = request.getParameter("photo");
                String notes = request.getParameter("notes");
                int reportsTo = Integer.parseInt(request.getParameter("notes"));
                String photoPath = request.getParameter("photoPath");
                if (lastName == null) {

                }
                Employee employee = new Employee(lastName, firstName, title, titleOfCourtesy,birthDate, hireDate, 
                        address, city,region, postalCode, country, homePhone, extension, photo, notes,reportsTo , photoPath);
                int n = dao.insertEmployee(employee);
                response.sendRedirect("EmployeeURL");
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
