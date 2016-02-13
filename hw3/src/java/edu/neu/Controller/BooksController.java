/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.neu.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author kym-1992
 */
public class BooksController extends HttpServlet {

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
        String action = request.getParameter("action");
        Connection conn = null;
        PreparedStatement stmt = null;
        
//        try (PrintWriter out = response.getWriter()) {
//            /* TODO output your page here. You may use following sample code. */
//        }
        
        if(action.equals("add")){
            int bookQuantity = Integer.parseInt(request.getParameter("bookQuantity"));
            if(bookQuantity > 0){
                request.setAttribute("bookQuantity", bookQuantity);
                RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/addBooks.jsp");
                rd.forward(request, response);
            }
            else{
                RequestDispatcher rd = request.getRequestDispatcher("movie.jsp");             
                rd.forward(request, response);
            }
        }
        
        if(action.equals("doAddBook")){
            String[] isbnList = request.getParameterValues("isbn");
            String[] titleList = request.getParameterValues("title");
            String[] authorsList = request.getParameterValues("authors");
            String[] priceList = request.getParameterValues("price");
            
            conn = getConnectionJDBC();
            
            
                String sql = "INSERT INTO books (isbn, title, authors, price)"
                        + "VALUES"
                        + "(?, ?, ?, ?)";
                try {
                    stmt = conn.prepareStatement(sql);
                    
                    for(int i=0; i < isbnList.length; i++){
                        stmt.setString(1, isbnList[i]);
                        stmt.setString(2, titleList[i]);
                        stmt.setString(3, authorsList[i]);
                        
                        int price = Integer.parseInt(priceList[i]);
                        stmt.setInt(4, price);
                        stmt.executeUpdate();                        
                    }

                    stmt.close();
                    
                    request.setAttribute("quantity", isbnList.length);
                    RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/booksAdded.jsp");
                    rd.forward(request, response);                    
                    
                } catch (SQLException ex) {
                    Logger.getLogger(MovieController.class.getName()).log(Level.SEVERE, null, ex);
                    RequestDispatcher rd = request.getRequestDispatcher("books.jsp");
                    rd.forward(request, response);                     
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

    private Connection getConnectionJDBC() throws IOException {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Where is your MySQL JDBC Driver?");
            e.printStackTrace();
        }
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:"
                    + "3306/webtoolhw3_schema", "root", "j-epyppsC5Qg");
        } catch (SQLException e) {
            System.out.println("Connection Failed! Check output console");
            e.printStackTrace();
        }

        if (connection != null) {
            System.out.println("connection established");
        }
        return connection;
    }        
}
