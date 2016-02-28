/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServletFiles;

import Bean.BookBean;
import Dao.BooksDao;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author kym-1992
 */
public class BooksController implements Controller{
    BooksDao booksDAO;

    public BooksController(BooksDao booksDAO) {
        this.booksDAO = booksDAO;
    }

    @Override
    public ModelAndView handleRequest(HttpServletRequest hsr, HttpServletResponse hsr1) throws Exception {
        hsr1.setContentType("text/html;charset=UTF-8");
        ModelAndView mv = new ModelAndView();
        String action = hsr.getParameter("action");
        Connection conn = null;
        PreparedStatement stmt = null;


        if(action.equals("add")){
            int bookQuantity = Integer.parseInt(hsr.getParameter("bookQuantity"));
            if(bookQuantity > 0){
                mv.addObject("bookQuantity", bookQuantity);
                mv.setViewName("addBooks");
            }
            else{
                mv.setViewName("index");
            }
        }

        if(action.equals("doAddBook")){
            String[] isbnList = hsr.getParameterValues("isbn");
            String[] titleList = hsr.getParameterValues("title");
            String[] authorsList = hsr.getParameterValues("authors");
            String[] priceList = hsr.getParameterValues("price");


            for(int i = 0; i < isbnList.length; i++){
                BookBean book = new BookBean();
                book.setIsbn(isbnList[i]);
                book.setTitle(titleList[i]);
                book.setAuthors(authorsList[i]);
                float price = Float.parseFloat(priceList[i]);
                book.setPrice(price);
                booksDAO.addBook(book, mv);
            }

            hsr.setAttribute("quantity", isbnList.length);
            mv.setViewName("booksAdded");
        }

        return mv;
    }

}
