/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Part7;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.eclipse.jdt.internal.compiler.ast.ThisReference;

/**
 *
 * @author kym-1992
 */
public class Books extends HttpServlet {
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
//            out.println("<title>Servlet Books</title>");            
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet Books at " + request.getContextPath() + "</h1>");
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
        ArrayList<StoreItem> itemList = populateItem();
        ArrayList<StoreItem> shoppingCart = new ArrayList<>();
        
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
            out.println("<form method='post' action='addItem.htm'>");
            for(StoreItem storeItem: itemList){
                if(storeItem.getCatalog()!=null && storeItem.getCatalog().equalsIgnoreCase("Books")){
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

    
    public static ArrayList<StoreItem> populateItem(){
        ArrayList<StoreItem> itemList = new ArrayList<>();
        
        StoreItem item = new StoreItem();
        item.setName("Java Servlet Programming");
        item.setCatalog("Books");
        item.setPrice(29.95);
        item.setId(0);
        itemList.add(item);
        
        StoreItem item1 = new StoreItem();
        item1.setName("Oracle Database Programming");
        item1.setCatalog("Books");
        item1.setPrice(48.95);
        item1.setId(1);
        itemList.add(item1);
        
        StoreItem item2 = new StoreItem();
        item2.setName("System Analysis and Design With UML");
        item2.setCatalog("Books");
        item2.setPrice(14.95);      
        item2.setId(2);
        itemList.add(item2);
        
        StoreItem item3 = new StoreItem();
        item3.setName("Object Oriented Software Engineering");
        item3.setCatalog("Books");
        item3.setPrice(35.99);    
        item3.setId(3);
        itemList.add(item3);
        
        StoreItem item4 = new StoreItem();
        item4.setName("Java Web Services");
        item4.setCatalog("Books");
        item4.setPrice(27.99);
        item4.setId(4);
        itemList.add(item4);
        
        StoreItem item5 = new StoreItem();
        item5.setName("I'm Going to Tell You a Secret by Madonna");
        item5.setCatalog("Music");
        item5.setPrice(26.99);
        item5.setId(5);
        itemList.add(item5);
        
        StoreItem item6 = new StoreItem();
        item6.setId(6);
        itemList.add(item6);
        
        StoreItem item7 = new StoreItem();
        item7.setId(7);
        itemList.add(item7);
        
        StoreItem item8 = new StoreItem();
        item8.setId(8);
        itemList.add(item8);
        
        StoreItem item9 = new StoreItem();
        item9.setId(9);
        itemList.add(item9);
        
        StoreItem item10 = new StoreItem();
        item10.setId(10);
        itemList.add(item10);
        
        StoreItem item11 = new StoreItem();
        item11.setId(11);
        itemList.add(item11);
        
        StoreItem item12 = new StoreItem();
        item12.setId(12);
        itemList.add(item12);
        
        StoreItem item13 = new StoreItem();
        item13.setId(13);
        itemList.add(item13);
        
        StoreItem item14 = new StoreItem();
        item14.setId(14);
        itemList.add(item14);
        
        return itemList;
    }
}
