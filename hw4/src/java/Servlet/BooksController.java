/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import DAO.DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

/**
 *
 * @author kym-1992
 */
public class BooksController implements Controller{

    @Override
    public ModelAndView handleRequest(HttpServletRequest hsr, HttpServletResponse hsr1) throws Exception {
        hsr1.setContentType("text/html;charset=UTF-8");
        ModelAndView mv = new ModelAndView();
        String action = hsr.getParameter("action");
        Connection conn = null;
        PreparedStatement stmt = null;
        
//        try (PrintWriter out = hsr1.getWriter()) {
//            /* TODO output your page here. You may use following sample code. */
//        }
        
        if(action.equals("add")){
            int bookQuantity = Integer.parseInt(hsr.getParameter("bookQuantity"));
            if(bookQuantity > 0){
//                hsr.setAttribute("bookQuantity", bookQuantity);
//                RequestDispatcher rd = hsr.getRequestDispatcher("/WEB-INF/views/addBooks.jsp");
//                rd.forward(hsr, hsr1);    
                mv.addObject("bookQuantity", bookQuantity);
                mv.setViewName("addBooks");
            }
            else{
//                RequestDispatcher rd = hsr.getRequestDispatcher("movie.jsp");             
//                rd.forward(hsr, hsr1);
                mv.setViewName("movie");
            }
        }
        
        if(action.equals("doAddBook")){
            String[] isbnList = hsr.getParameterValues("isbn");
            String[] titleList = hsr.getParameterValues("title");
            String[] authorsList = hsr.getParameterValues("authors");
            String[] priceList = hsr.getParameterValues("price");
            
            DAO dao = new DAO();
            conn = dao.getConnection();
            
            
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
                    
                    hsr.setAttribute("quantity", isbnList.length);
//                    RequestDispatcher rd = hsr.getRequestDispatcher("/WEB-INF/views/booksAdded.jsp");
//                    rd.forward(hsr, hsr1);                    
                    mv.setViewName("booksAdded");
                    
                } catch (SQLException ex) {
                    Logger.getLogger(BooksController.class.getName()).log(Level.SEVERE, null, ex);
//                    RequestDispatcher rd = hsr.getRequestDispatcher("books.jsp");
//                    rd.forward(hsr, hsr1);          
                    mv.setViewName("books");
                }                    
        }
        
        return mv;
    }
    
}
