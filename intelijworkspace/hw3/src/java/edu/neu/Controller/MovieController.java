/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.neu.Controller;

import edu.neu.Bean.MovieBean;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
public class MovieController extends HttpServlet {

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
            throws ServletException, IOException{
        response.setContentType("text/html;charset=UTF-8");
        String value = request.getParameter("action");
        System.out.println(value);
        
        Connection conn = null;
        PreparedStatement stmt = null;
        
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            
            if(value.equals("login")){
                String option = request.getParameter("loginOption");
                
                if(option.equalsIgnoreCase("browse")){
                    RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/searchMovie.jsp");
                    rd.forward(request, response);
                }
                else if(option.equalsIgnoreCase("add")){
                    RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/addMovie.jsp");
                    rd.forward(request, response);
                }
            }
            
            if(value.equals("doAddMovie")){
                conn = getConnectionJDBC();
                String title = request.getParameter("title");
                String actor = request.getParameter("actor");
                String actress = request.getParameter("actress");
                String genre = request.getParameter("genre");
                int year = Integer.parseInt(request.getParameter("year"));
                
                String sql = "INSERT INTO movies (title, actor, actress, genre, year)"
                        + "VALUES"
                        + "(?, ?, ?, ?, ?)";
                try {
                    stmt = conn.prepareStatement(sql);
                    stmt.setString(1, title);
                    stmt.setString(2, actor);
                    stmt.setString(3, actress);
                    stmt.setString(4, genre);
                    stmt.setInt(5, year);
                    
                    stmt.executeUpdate();
                    stmt.close();
                    RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/movieAdded.jsp");
                    rd.forward(request, response);
                    
                } catch (SQLException ex) {
                    Logger.getLogger(MovieController.class.getName()).log(Level.SEVERE, null, ex);
                    RequestDispatcher rd = request.getRequestDispatcher("movie.jsp");
                    rd.forward(request, response);
                }
                
            }
            
            
            if(value.equals("doSearch")){
                String searchMethod = request.getParameter("searchMethod");
                conn = getConnectionJDBC();
                
                if(searchMethod.equals("title")){
                    String sql = "SELECT * FROM movies WHERE title=?";
                    try {
                        stmt = conn.prepareStatement(sql);
                        String searchKeyword = request.getParameter("searchKeyword");
                        stmt.setString(1, searchKeyword);
                        ResultSet rs = stmt.executeQuery();
                        
                        ArrayList<MovieBean> movieList = new ArrayList<>();
                        while(rs.next()){
                            MovieBean movieBean = new MovieBean();
                            movieBean.setTitle(rs.getString(1));
                            movieBean.setActor(rs.getString(2));
                            movieBean.setActress(rs.getString(3));
                            movieBean.setGenre(rs.getString(4));
                            movieBean.setYear(rs.getInt(5));
                            movieList.add(movieBean);
                        }
                        request.setAttribute("resultArrayList", movieList);
                        request.setAttribute("searchedItem", searchKeyword);
                        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/showMovie.jsp");
                        rd.forward(request, response);                        
                        
                        rs.close();
                        stmt.close();
                    } catch (SQLException ex) {
                        Logger.getLogger(MovieController.class.getName()).log(Level.SEVERE, null, ex);
                        RequestDispatcher rd = request.getRequestDispatcher("movie.jsp");
                        rd.forward(request, response);
                    }
                    
                }
                
                if(searchMethod.equals("actor")){
                    String sql = "SELECT * FROM movies WHERE actor=?";            
                    try {
                        stmt = conn.prepareStatement(sql);
                        String searchKeyword = request.getParameter("searchKeyword");
                        stmt.setString(1, searchKeyword);
                        ResultSet rs = stmt.executeQuery();
                        ArrayList<MovieBean> movieList = new ArrayList<>();
                        while(rs.next()){
                            MovieBean movieBean = new MovieBean();
                            movieBean.setTitle(rs.getString(1));
                            movieBean.setActor(rs.getString(2));
                            movieBean.setActress(rs.getString(3));
                            movieBean.setGenre(rs.getString(4));
                            movieBean.setYear(rs.getInt(5));
                            movieList.add(movieBean);
                        }
                        request.setAttribute("resultArrayList", movieList);
                        request.setAttribute("searchedItem", searchKeyword);
                        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/showMovie.jsp");
                        rd.forward(request, response);                        
                        
                        rs.close();
                        stmt.close();                        
                        
                        rs.close();
                        stmt.close();
                    } catch (SQLException ex) {
                        Logger.getLogger(MovieController.class.getName()).log(Level.SEVERE, null, ex);
                        RequestDispatcher rd = request.getRequestDispatcher("movie.jsp");
                        rd.forward(request, response);
                    }
                }
                
                if(searchMethod.equals("actress")){
                    String sql = "SELECT * FROM movies WHERE actress=?";           
                    try {
                        stmt = conn.prepareStatement(sql);
                        String searchKeyword = request.getParameter("searchKeyword");
                        stmt.setString(1, searchKeyword);    
                        ResultSet rs = stmt.executeQuery();
                        ArrayList<MovieBean> movieList = new ArrayList<>();
                        while(rs.next()){
                            MovieBean movieBean = new MovieBean();
                            movieBean.setTitle(rs.getString(1));
                            movieBean.setActor(rs.getString(2));
                            movieBean.setActress(rs.getString(3));
                            movieBean.setGenre(rs.getString(4));
                            movieBean.setYear(rs.getInt(5));
                            movieList.add(movieBean);
                        }
                        request.setAttribute("resultArrayList", movieList);
                        request.setAttribute("searchedItem", searchKeyword);
                        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/showMovie.jsp");
                        rd.forward(request, response);                        
                        
                        rs.close();
                        stmt.close();                        
                        
                        rs.close();
                        stmt.close();
                    } catch (SQLException ex) {
                        Logger.getLogger(MovieController.class.getName()).log(Level.SEVERE, null, ex);
                        RequestDispatcher rd = request.getRequestDispatcher("movie.jsp");
                        rd.forward(request, response);
                    }
                }
            }
        }
        
        if(conn!=null){
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(MovieController.class.getName()).log(Level.SEVERE, null, ex);
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
