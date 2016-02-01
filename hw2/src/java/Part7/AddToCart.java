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
import java.util.Iterator;
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
public class AddToCart extends HttpServlet {
    private ArrayList<StoreItem> itemList;
    private Set<StoreItem> myItem;

    public AddToCart() {
        itemList = Store.populateItem();
    }
    
    
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
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Items Processed</title>");            
        out.println("</head>");
        out.println("<body>"); 
        
        HttpSession session = request.getSession();
        if(null != session.getAttribute("myShoppingCart")){
            myItem = (Set<StoreItem>) session.getAttribute("myShoppingCart");
        }
        else{
            myItem = new HashSet<StoreItem>();
        }
        try{
            String actionValue = request.getParameter("action");
            
            if(actionValue.equalsIgnoreCase("add")){                 
                String[] selectedItems = request.getParameterValues("itemId");
                
                if(selectedItems==null){
                    out.println("<h3>Please select at least one item!!!</h3>");
                }
                
                else{
                    out.println("<h3>The following item has been added to your shopping cart successfully</h3>");                  
                    for(int i =0; i<selectedItems.length; i++){
                        int id = Integer.parseInt(selectedItems[i]);
                        for(StoreItem item: itemList){
                            if(id == item.getId()){
                                myItem.add(item);
                                out.println("<h3>- " +item.getName() + "</h3>");
                            }
                        }
                    }
                }
            }
            
            else if(actionValue.equals("remove")){
                boolean check = false;
                String removeCourse = request.getParameter("id");
                int id = Integer.parseInt(removeCourse);
                Iterator iterator = myItem.iterator();
                
                while(iterator.hasNext()){
                    if(check) break;
                    StoreItem item = (StoreItem) iterator.next();
                    if(item.getId() == id){
                        myItem.remove(item);
                        check = true;
                        session.setAttribute("myShoppingCart", myItem);
                        response.sendRedirect("ShoppingCart.jsp");
                    }
                }
            }
            
            session.setAttribute("myShoppingCart", myItem);
            out.println("[<a href='ShoppingCart.jsp'>View Cart</a>][<a href='books'>Go to Books Page</a>][<a href='music'>Go to Music Page</a>][<a href='computers'>Go to Computers Page</a>]");
            out.println("</body>");
            out.println("</html>");            
            
            
        }catch(Exception e){
            System.out.println("Exception is " + e);
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

}
