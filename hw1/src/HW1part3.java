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
public class HW1part3 extends HttpServlet{
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException{
        
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
                            
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException{
        response.setContentType("text/html");
        
        PrintWriter out = response.getWriter();
        out.println("<!doctype html><HTML>");
        out.println("<head>");
        out.println("<title>Part3 Report</title>");
        out.println("</head>");
        out.println("<body bgcolor='pink'>");
        
        out.println("<UL>");        
        
        out.println("<LI>Officeuse: " + request.getParameter("officeuse") + "</LI>");
        String [] addresschanged = request.getParameterValues("addresschanged");
        if(addresschanged!=null){
            out.println("<LI>Check here if this is a new address: " + addresschanged[0] + "</LI>");
        }
        out.println("<LI>Name: " + request.getParameter("name") + "</LI>");
        out.println("<LI>Address: " + request.getParameter("address") + "</LI>");
        out.println("<LI>City/State/Zip: " + request.getParameter("CityStateZip") + "</LI>");
        out.println("<LI>Phone: " + request.getParameter("phone") + "</LI>");
        out.println("<LI>Email: " + request.getParameter("Email") + "</LI>");
        out.println("<LI>Account Number: " + request.getParameter("AccountNumber") + "</LI>");
        out.println("<LI>Pet Name: " + request.getParameter("petName") + "</LI>");        
        out.println("<LI>Breed: " + request.getParameter("Breed") + "</LI>");
        out.println("<LI>Age: " + request.getParameter("age") + "</LI>"); 
        out.println("<LI>Gender: " + request.getParameter("Gender") + "</LI>");    
        out.println("<LI>Occurrence/Diagnosis: " + request.getParameter("Occurrence/Diagnosis") + "</LI>");
        String [] Related = request.getParameterValues("Related");
        if(Related!=null){
            for(String s: Related){
                out.println("<LI>This claim is related to: " + s + "</LI>");
            }
        }
        String [] future = request.getParameterValues("future");
        if(future!=null){    
            out.println("<LI>Is this claim an estimate for future treatment?" + future[0] + "</LI>"); 
        }
        out.println("<LI>TotalAmount: " + request.getParameter("totalAmount") + "</LI>");
        out.println("<LI>FirstDate: " + request.getParameter("firstDate") + "</LI>");
        String [] payment = request.getParameterValues("payment");
        if(payment!=null){
            out.println("<LI>Send payment to:" + payment[0] + "</LI>");  
        }
        out.println("<LI>Veterinarian: " + request.getParameter("Veterinarian") + "</LI>");
        out.println("<LI>Clinic Name: " + request.getParameter("ClinicName") + "</LI>");    
        out.println("<LI>Clinic Phone: " + request.getParameter("clinicPhone") + "</LI>");
        out.println("<LI>Clinic Fax: " + request.getParameter("ClinicFax") + "</LI>"); 
        String [] otherVeterinarian = request.getParameterValues("otherVeterinarian");
        if(otherVeterinarian!=null){
            out.println("<LI>Did any other veterinarian treat your pet?" + otherVeterinarian[0] + "</LI>");  
        }
        String [] newCondition = request.getParameterValues("newCondition");
        if(newCondition!=null){
            out.println("<LI>Is this a new condition?" + newCondition[0] + "</LI>");   
        }
        out.println("<LI>Signature of Pet Owner: " + request.getParameter("signature") + "</LI>");
        out.println("<LI>Signature Date: " + request.getParameter("signatureDate") + "</LI>");
        out.println("</UL>");
        out.println("</body><html>");
        out.close();  
    }
}
