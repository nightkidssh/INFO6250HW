/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Bean.BookBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author kym-1992
 */
public class BooksDAO extends DAO{
    Connection conn;
    PreparedStatement ps;

    public void addBooks(BookBean book, ModelAndView mv) throws SQLException{
        
        try{
            this.conn = getConnection();
            String sql = "INSERT INTO books (isbn, title, authors, price)"
                        + "VALUES"
                        + "(?, ?, ?, ?)";
            ps = conn.prepareStatement(sql);
            ps.setString(1, book.getIsbn());
            ps.setString(2, book.getTitle());
            ps.setString(3, book.getAuthors());
            ps.setFloat(4, book.getPrice());
            ps.executeUpdate();
            
        }catch (SQLException ex) {
            Logger.getLogger(BooksDAO.class.getName()).log(Level.SEVERE, null, ex);
            mv.setViewName("index");  
        } finally {
            close(conn);
            ps.close();
        }
    }
}
