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

/**
 *
 * @author kym-1992
 */
public class Store extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */

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
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet Store</title>");            
//            out.println("</head>");
//            out.println("<body>");
//            
//            out.println("</body>");
            StringBuffer buffer = new StringBuffer();
            buffer.append("<frameset cols='10%,*' frameborder='1'>");
            buffer.append("<frame src='Menu.html'>");
            buffer.append("<frame src='' name='frame2'>");
            buffer.append("</frameset>");
            out.println(buffer);
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
        item6.setName("Baby One More Tile by Britney Spears");
        item6.setCatalog("Music");
        item6.setPrice(10.95);
        item6.setId(6);
        itemList.add(item6);
        
        StoreItem item7 = new StoreItem();
        item7.setName("Justified by Justin Timberlake");
        item7.setCatalog("Music");
        item7.setPrice(9.97);
        item7.setId(7);
        itemList.add(item7);
        
        StoreItem item8 = new StoreItem();
        item8.setName("Loose by Nelly Fustado");
        item8.setCatalog("Music");
        item8.setPrice(13.98);
        item8.setId(8);
        itemList.add(item8);
        
        StoreItem item9 = new StoreItem();
        item9.setName("Gold Digger by Kanye West");
        item9.setCatalog("Music");
        item9.setPrice(27.99);
        item9.setId(9);
        itemList.add(item9);
        
        StoreItem item10 = new StoreItem();
        item10.setName("Apple MacBook Pro with 13.3 Display");
        item10.setCatalog("Computers");
        item10.setPrice(1299.99);
        item10.setId(10);
        itemList.add(item10);
        
        StoreItem item11 = new StoreItem();
        item11.setName("Asus Laptop with Centrino 2 Black");
        item11.setCatalog("Computers");
        item11.setPrice(949.95);
        item11.setId(11);
        itemList.add(item11);
        
        StoreItem item12 = new StoreItem();
        item12.setName("HP Pavilion Laptop with Centrino 2 DV7");
        item12.setCatalog("Computers");
        item12.setPrice(1199.95);
        item12.setId(12);
        itemList.add(item12);
        
        StoreItem item13 = new StoreItem();
        item13.setName("Toshiba Satellite Laptop with Centrino 2 - Copper");
        item13.setCatalog("Computers");
        item13.setPrice(899.99);
        item13.setId(13);
        itemList.add(item13);
        
        StoreItem item14 = new StoreItem();
        item14.setName("Sony VAIO Laptop with Core 2 Duo Comopolitan Pink");
        item14.setCatalog("Computers");
        item14.setPrice(779.99);
        item14.setId(14);
        itemList.add(item14);
        
        return itemList;
    }    
}
