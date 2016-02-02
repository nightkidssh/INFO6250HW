/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Part7;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author kym-1992
 */
public class Music extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
//    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        response.setContentType("text/html;charset=UTF-8");
//        try (PrintWriter out = response.getWriter()) {
//            /* TODO output your page here. You may use following sample code. */
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet Music</title>");            
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet Music at " + request.getContextPath() + "</h1>");
//            out.println("</body>");
//            out.println("</html>");
//        }
//    }

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
        ArrayList<StoreItem> itemList = Store.populateItem();
        Set<StoreItem> myItem;           
        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Books</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h3>Shop for books</h3><hr><br>");
            out.println("<div style='float: right'>");            
            out.println("[<a href='ShoppingCart.jsp'>View Cart</a>]");
            out.println("</div>");            
            
            HttpSession session = request.getSession();
            if(null != session.getAttribute("myShoppingCart")){
                myItem = (Set<StoreItem>) session.getAttribute("myShoppingCart");
            }
            else{
                myItem = new HashSet<StoreItem>();
            }          
            session.setAttribute("myShoppingCart", myItem);            
            
            out.println("<form method='post' action='addItem.htm'>");
            for(StoreItem storeItem: itemList){
                if(storeItem.getCatalog()!=null && storeItem.getCatalog().equalsIgnoreCase("Music")){
                    out.println("<input type='checkbox' name='itemId' value='" + storeItem.getId() + "'>" + storeItem.getName()
                            + "[$" + storeItem.getPrice() +"]<br><br>");
                }
            }
            out.println("<input type='hidden' name='action' value='add'/>");
            out.println("<input type='submit' value='Add to Cart'/>");
            out.println("</form>");            
            out.println("</body>");
            out.println("</html>");
        }    
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
//        processRequest(request, response);
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
