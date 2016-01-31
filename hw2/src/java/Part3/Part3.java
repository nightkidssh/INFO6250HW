/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Part3;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author kym-1992
 */
public class Part3 extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processDoGetRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<script type=\"text/javascript\">function submit(){" +
//"            var childrenQuantity = document.getElementById(\"childrenQuantity\").value;\n" +
//"            var newWindow = window.open('hw2part3.htm');            \n" +
//"            if(Number.isInteger(childrenQuantity) === true && Number !== \"\"){\n" +
//"                newWindow.document.write(\"<form action='hw2part3' method='post'\");\n" +
//"                for(i = 1; i<= childrenQuantity; i++){\n" +
//"                    newWindow.document.write(\"<h3>Please enter the name of child number \" + i + \"</h3>\");\n" +
//"                    newWindow.document.write(\"<input type='text' name='childName\" + i + \"'>\");\n" +
//"                }\n" +
//"                newWindow.document.write(\"</form>\");\n" +
//"            }\n" +
//"            \n" +
//"            else{\n" +
"               document.write(\"ERROR input!!!!!\");\n" +
//"            }\n" +
                     "}</script>");
            
            out.println("<title>HW2 Part3</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>HW2 Part3 at " + request.getContextPath() + "</h1>");
            out.println("<form action='hw2part3'>");
            out.println("<h3>How many children do you have?<input type='text' name='childrenQuantity' id='childrenQuantity'/></h3><br/>");
            out.println("<input type='submit' value='Submit Query' onclick='submit()'/>");
            out.println("</form>");
            out.println("</body>");
            out.println("</html>");
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
        processDoGetRequest(request, response);
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
