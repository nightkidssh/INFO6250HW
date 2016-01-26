import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author kym-1992
 */


public class HW1part2 extends HttpServlet{
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException{
        
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        
        out.println("<!doctype html><HTML>");
        out.println("<head>");
        out.println("<title>Request Parameters</title>");
        out.println("</head>");
        out.println("<body bgcolor='pink'>");
        
        out.println("<UL>");
        Enumeration<String> headerNames = request.getHeaderNames();
        while(headerNames.hasMoreElements()){
            String header = headerNames.nextElement();
            out.println("<LI>" + header + " : " +request.getHeader(header) + "</LI>");
        }
        
        out.println("</UL>");
        
        
        out.println("Welcome User");
        
        out.println("</body><html>");
        out.close();        
    }
    
}
