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
            out.println("<script type=\"text/javascript\">function submitValidation(){\n" +
"                if(document.getElementById(\"childrenQuantity\").value){\n" +
"                    var childrenQuantity = document.getElementById(\"childrenQuantity\").value;\n" +
"                    if(isNaN(childrenQuantity)){\n" +
"                        document.getElementById(\"error\").innerHTML=\"<font color='red'>Illegal input!!!</font>\";\n" +
"                    }\n" +
"                    else{\n" +
"                        var opened = window.open(\"enterName\");\n" +
"                        opened.document.write(\"<html><head><title>Enter Name</title></head><body><form method='post' action='hw2part3'><div id = 'newForm'></div><input type='submit' value='Submit Query'/></form></body></html>\");\n" +
"                        var newForm = opened.document.getElementById(\"newForm\");\n" +
"                        for(var i = 0; i < childrenQuantity; i++){\n" +
"                            newForm.appendChild(document.createTextNode(\"Please enter the name of child number\" + (i+1)));\n" +
"                            var input = document.createElement(\"input\");\n" +
"                            input.required = true;\n" +
"                            input.type = \"text\";\n" +
"                            input.name = \"childrenName\";\n" +
"                            newForm.appendChild(input);\n" +
"                            newForm.appendChild(document.createElement(\"br\"));\n" +
"                        }\n" +
"                    }\n" +
"                }\n" +
"                else{\n" +
"                    document.getElementById(\"error\").innerHTML=\"<font color='red'>Illegal input!!!</font>\";\n" +
"                }\n" +
"            }"
                    + "</script>");
            
            out.println("<title>HW2 Part3</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<form>");
            out.println("<h3>How many children do you have?<input type='text' name='childrenQuantity' id='childrenQuantity'/></h3><br/>");
            out.println("<input type='button' value='Submit Query' onclick='submitValidation()'/>");
            out.println("</form>");
            out.println("<div id='error'></div>");
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
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("</head>");
            out.println("<body>"); 
            out.println("<h3>Your children's names are:</h3><br>");
            String[] data = request.getParameterValues("childrenName");
            for(String s: data){
                out.println("<a>" + s + "</a><br>");
            }
            out.println("</body>");
            out.println("</html>");            
        }
        
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
