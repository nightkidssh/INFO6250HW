/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Part4;

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
public class Part4 extends HttpServlet {

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
//            out.println("<title>Servlet Part4</title>");            
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet Part4 at " + request.getContextPath() + "</h1>");
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
//        processRequest(request, response);
        
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
                            
        StringBuffer stringBuffer = new StringBuffer(
            "<!doctype html><html>\n" +
            "<head>\n" +
            "<link rel=\"stylesheet\" type=\"text/css\" href=\"index.css\">\n" +
            "<title>Pet insurance claim form</title>\n" +
            "</head>\n" +
            "<body>\n" +
            "<div>\n" +
            "  <form action=\"hw2part4\" method=\"post\">\n" +
            "  <div class=\"default\">\n" +
            "    <table style=\"float:center\" border=\"0\">\n" +
            "      <tr>\n" +
            "        <td><h1>ASPCA Pet Insurance</h1></td>\n" +
            "        <td><textarea style=\"overflow:auto;resize:none\" rows=\"5\" cols=\"20\" name=\"officeuse\">For office use only</textarea></td>\n" +
            "        <td><h1>HAVE A QUESTION? Call us at 1-866-204-6764</h1></td>\n" +
            "      </tr>\n" +
            "\n" +
            "    </table>\n" +
            "  </div>\n" +
            "  <div class=\"defaultGrey\">\n" +
            "    <h2>Claim Form <i>PLEASE INCLUDE YOUR PET'S MEDICAL RECORDS TO HELP EXPEDITE PROCESSING.</i></h2>\n" +
            "  </div>\n" +
            "\n" +
            "  <div class=\"noBorder\">\n" +
            "    <p class=\"regular\"><u>1. General Information <i>Please fill out this form completely. Incomplete forms will delay processing.</i></u></p>\n" +
            "  </div>\n" +
            "\n" +
            "  <div class=\"noBorder\">\n" +
            "    <div class=\"leftright\">\n" +
            "      <div class=\"leftBorder\" style=\"background-color: grey\">\n" +
            "        <h3>Your Information&nbsp&nbsp&nbsp<input type=\"checkbox\" name=\"addresschanged\" value=\"Yes\"><i>Check here if this is a new address</i></h3>\n" +
            "      </div>\n" +
            "      <div style=\"text-align: left\">\n" +
            "        <h3>Name:&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<input type=\"text\" name=\"name\" size=\"40\"></h3>\n" +
            "        <hr>\n" +
            "      </div>\n" +
            "      <div style=\"text-align: left\">\n" +
            "        <h3>Address:&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<input type=\"text\" name=\"address\" size=\"60\"></h3>\n" +
            "        <hr>\n" +
            "      </div>\n" +
            "      <div style=\"text-align: left\">\n" +
            "        <h3>City, State, Zip:&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<input type=\"text\" name=\"CityStateZip\" size=\"60\"></h3>\n" +
            "        <hr>\n" +
            "      </div>\n" +
            "      <div style=\"text-align: left\">\n" +
            "        <h3>Phone:&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<input type=\"text\" name=\"phone\">&nbsp&nbsp&nbsp&nbspEmail:&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<input type=\"text\" name=\"Email\"></h3>\n" +
            "        <hr>\n" +
            "      </div>\n" +
            "    </div>\n" +
            "\n" +
            "    <div class=\"floatcenter\">\n" +
            "    </div>\n" +
            "\n" +
            "    <div class=\"floatright\">\n" +
            "      <div class=\"leftBorder\" style=\"background-color: grey\">\n" +
            "        <h3>Pet Information</h3>\n" +
            "      </div>\n" +
            "      <div style=\"text-align: left\">\n" +
            "        <h3>Account Number:&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<input type=\"text\" name=\"AccountNumber\" size=\"40\"></h3>\n" +
            "        <hr>\n" +
            "      </div>\n" +
            "      <div style=\"text-align: left\">\n" +
            "        <h3>Name:&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<input type=\"text\" name=\"petName\" size=\"40\"></h3>\n" +
            "        <hr>\n" +
            "      </div>\n" +
            "      <div style=\"text-align: left\">\n" +
            "        <h3>Breed:&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<input type=\"text\" name=\"Breed\" size=\"40\"></h3>\n" +
            "        <hr>\n" +
            "      </div>\n" +
            "      <div style=\"text-align: left\">\n" +
            "        <h3>Age:&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<input type=\"text\" name=\"age\">&nbsp&nbsp&nbsp&nbspGender:&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<input type=\"text\" name=\"Gender\"></h3>\n" +
            "        <hr>\n" +
            "      </div>\n" +
            "    </div>\n" +
            "  </div>\n" +
            "\n" +
            "  <div class=\"noBorder\">\n" +
            "    <p class=\"regular\">&nbsp&nbsp&nbsp&nbsp&nbsp<u>2. Diagnosis/Symptom Information&nbsp&nbsp&nbsp&nbsp<i>HELP US! By providing the \"Story of Occurrence/Diagnosis,\" you will help us avoid delays in processing your claim.</i></u></p>\n" +
            "  </div>\n" +
            "\n" +
            "  <div class=\"leftBorder\">\n" +
            "    <h3><i>Story of Occurrence/Diagnosis&nbsp&nbsp&nbsp&nbsp&nbsp- Please describe this incident, including dates, details and symptoms leading up to it.</i></h3>\n" +
            "    <textarea class=\"default\" rows=\"5\" cols=\"204\" name=\"Occurrence/Diagnosis\"></textarea>\n" +
            "  </div>\n" +
            "\n" +
            "  <div class=\"noBorder\">\n" +
            "    <div class=\"leftright\">\n" +
            "      <div style=\"text-align: left\">\n" +
            "        <h3>This claim is related to:&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<input type=\"checkbox\" name=\"Related\" value=\"Accident\">Accident<input type=\"checkbox\" name=\"Related\" value=\"Illness\">Illness<input type=\"checkbox\" name=\"Related\" value=\"Wellness\">Wellness</h3>\n" +
            "        <hr>\n" +
            "      </div>\n" +
            "      <div style=\"text-align: left\">\n" +
            "        <h3>Is this claim an estimate for future treatment?&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<input type=\"checkbox\" name=\"future\" value=\"yes\">Yes<input type=\"checkbox\" name=\"future\" value=\"no\">No</h3>\n" +
            "        <hr>\n" +
            "      </div>\n" +
            "      <div style=\"text-align: left\">\n" +
            "        <h3>Total amount claimed:&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<input type=\"text\" name=\"totalAmount\" size=\"60\"></h3>\n" +
            "        <hr>\n" +
            "      </div>\n" +
            "      <div style=\"text-align: left\">\n" +
            "        <h3>Date illness/injury first occurred:&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<input type=\"date\" name=\"firstDate\"></h3>\n" +
            "        <hr>\n" +
            "      </div>\n" +
            "      <div style=\"text-align: left\">\n" +
            "        <h3>Send payment to:&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<input type=\"checkbox\" name=\"payment\" value=\"me\">me<input type=\"checkbox\" name=\"payment\" value=\"Veterinarian\">Veterinarian</h3>\n" +
            "        <hr>\n" +
            "      </div>\n" +
            "    </div>\n" +
            "\n" +
            "    <div class=\"floatcenter\">\n" +
            "    </div>\n" +
            "\n" +
            "    <div class=\"floatright\">\n" +
            "      <div style=\"text-align: left\">\n" +
            "        <h3>Veterinarian:&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<input type=\"text\" name=\"Veterinarian\" size=\"40\"></h3>\n" +
            "        <hr>\n" +
            "      </div>\n" +
            "      <div style=\"text-align: left\">\n" +
            "        <h3>Clinic Name:&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<input type=\"text\" name=\"ClinicName\" size=\"40\"></h3>\n" +
            "        <hr>\n" +
            "      </div>\n" +
            "      <div style=\"text-align: left\">\n" +
            "        <h3>Phone:&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<input type=\"text\" name=\"clinicPhone\">&nbsp&nbsp&nbsp&nbspFax:&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<input type=\"text\" name=\"ClinicFax\"></h3>\n" +
            "        <hr>\n" +
            "      </div>\n" +
            "      <div style=\"text-align: left\">\n" +
            "        <h3>Did any other veterinarian treat your pet?&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<input type=\"checkbox\" name=\"otherVeterinarian\" value=\"yes\">Yes<input type=\"checkbox\" name=\"otherVeterinarian\" value=\"no\">No</h3>\n" +
            "        <hr>\n" +
            "      </div>\n" +
            "      <div style=\"text-align: left\">\n" +
            "        <h3>Is this a new condition?:&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<input type=\"checkbox\" name=\"newCondition\" value=\"yes\">Yes<input type=\"checkbox\" name=\"newCondition\" value=\"no\">No</h3>\n" +
            "        <hr>\n" +
            "      </div>\n" +
            "      <div><p>   </p></div>\n" +
            "    </div>\n" +
            "  </div>\n" +
            "\n" +
            "  <div style=\"text-align:left\">\n" +
            "    <p class=\"regular\">&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<u>3. Pet Owner Declaration&nbsp&nbsp&nbsp&nbsp</u></p>\n" +
            "  </div>\n" +
            "\n" +
            "  <div style=\"text-align:left\">\n" +
            "    <h3>I confirm to the best of my knowledge the above statements are true in every respect. I understand that the fees listed may not be covered or may\n" +
            "exceed my plan benefit. I understand that I am financially responsible to my veterinarian for the entire treatment. I understand that this claim\n" +
            "cannot be adjusted without itemized receipts. I also understand that the deliberate misrepresentation of the animal's condition or the omission of\n" +
            "any material facts may result in the denial of the claim and/or the cancellation of coverage. I authorize United States Fire Insurance Company and\n" +
            "its business partners to review and obtain a copy of ALL RECORDS including the insurance claim records and medical records as to examination,\n" +
            "history, diagnosis, treatment and prognosis with respect to any condition. I further authorize these entities to disclose identifying information about\n" +
            "me and my pet, as well as information about my claim experience, to my veterinarian.</h3>\n" +
            "  </div>\n" +
            "\n" +
            "  <div style=\"text-align:left\">\n" +
            "    <h3>Signature of Pet Owner:&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<input type=\"text\" name=\"signature\" size=\"40\">&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp\n" +
            "      &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbspDate:<input type=\"date\" name=\"signatureDate\"></h3>\n" +
            "    <hr>\n" +
            "  </div>\n" +
            "\n" +
            "  <div class=\"noBorder\">\n" +
            "    <h2>Please read IMPORTANT NOTICE document that follows for additional information.</h2>\n" +
            "  </div>\n" +
            "\n" +
            "  <div style=\"text-align:left\">\n" +
            "    <p class=\"regular\">&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<u>4. 3 EasyWays to Submit a Claim Form&nbsp&nbsp&nbsp&nbsp<i>You must submit an itemized invoice with this claim form.</i></u></p>\n" +
            "  </div>\n" +
            "\n" +
            "  <div class=\"noBorder\">\n" +
            "    <div class=\"leftAuto\">\n" +
            "      <h3>E-Mail:<br>\n" +
            "        claims@aspcapetinsurance.com<br>\n" +
            "        <i>scan and attach your receipts</i></h3>\n" +
            "    </div>\n" +
            "\n" +
            "    <div class=\"centerAuto\">\n" +
            "      <h3>Fax:<br>\n" +
            "        1-866-888-2495<br>\n" +
            "        <i>no cover sheet necessary</i></h3>\n" +
            "    </div>\n" +
            "\n" +
            "    <div class=\"rightAuto\">\n" +
            "      <h3>Mail:<br>\n" +
            "        ASPCA Pet Health Insurance<br>\n" +
            "        3840 Greentree Ave SW<br>\n" +
            "        Canton, Ohio 44706</h3>\n" +
            "    </div>\n" +
            "  </div>\n" +
            "\n" +
            "  <div class=\"noBorder\">\n" +
            "    <h3>* Please choose only one method. Duplicate claim submissions may delay processing.</h3>\n" +
            "  </div>\n" +
            "\n" +
            "  <input type=\"submit\" value=\"submit\" style=\"height:400px; width:400px\">\n" +
            "  </form>\n" +
            "</div>\n" +
            "</body>\n" +
            "\n" +
            "</html>"
        );
        out.println(stringBuffer);        
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
        response.setContentType("text/html");
        
        PrintWriter out = response.getWriter();
        out.println("<!doctype html><HTML>");
        out.println("<head>");
        out.println("<title>Part6 Report</title>");
        out.println("</head>");
        out.println("<body bgcolor='pink'>");
        
        out.println("<UL>");        
        
        out.println("<LI>Officeuse: " + request.getParameter("officeuse").replaceAll("[^\\dA-Za-z ]", "").trim() + "</LI>");
        String [] addresschanged = request.getParameterValues("addresschanged");
        if(addresschanged!=null){
            out.println("<LI>Check here if this is a new address: " + addresschanged[0].replaceAll("[^\\dA-Za-z ]", "").trim() + "</LI>");
        }
        out.println("<LI>Name: " + request.getParameter("name").replaceAll("[^\\dA-Za-z ]", "").trim() + "</LI>");
        out.println("<LI>Address: " + request.getParameter("address").replaceAll("[^\\dA-Za-z ]", "").trim() + "</LI>");
        out.println("<LI>City/State/Zip: " + request.getParameter("CityStateZip").replaceAll("[^\\dA-Za-z ]", "").trim() + "</LI>");
        out.println("<LI>Phone: " + request.getParameter("phone").replaceAll("[^\\dA-Za-z ]", "").trim() + "</LI>");
        out.println("<LI>Email: " + request.getParameter("Email").replaceAll("[^\\dA-Za-z ]", "").trim() + "</LI>");
        out.println("<LI>Account Number: " + request.getParameter("AccountNumber").replaceAll("[^\\dA-Za-z ]", "").trim() + "</LI>");
        out.println("<LI>Pet Name: " + request.getParameter("petName").replaceAll("[^\\dA-Za-z ]", "").trim() + "</LI>");        
        out.println("<LI>Breed: " + request.getParameter("Breed").replaceAll("[^\\dA-Za-z ]", "").trim() + "</LI>");
        out.println("<LI>Age: " + request.getParameter("age").replaceAll("[^\\dA-Za-z ]", "").trim() + "</LI>"); 
        out.println("<LI>Gender: " + request.getParameter("Gender").replaceAll("[^\\dA-Za-z ]", "").trim() + "</LI>");    
        out.println("<LI>Occurrence/Diagnosis: " + request.getParameter("Occurrence/Diagnosis").replaceAll("[^\\dA-Za-z ]", "").trim() + "</LI>");
        String [] Related = request.getParameterValues("Related");
        if(Related!=null){
            for(String s: Related){
                out.println("<LI>This claim is related to: " + s.replaceAll("[^\\dA-Za-z ]", "").trim() + "</LI>");
            }
        }
        String [] future = request.getParameterValues("future");
        if(future!=null){    
            out.println("<LI>Is this claim an estimate for future treatment?" + future[0].replaceAll("[^\\dA-Za-z ]", "").trim() + "</LI>"); 
        }
        out.println("<LI>TotalAmount: " + request.getParameter("totalAmount").replaceAll("[^\\dA-Za-z ]", "").trim() + "</LI>");
        out.println("<LI>FirstDate: " + request.getParameter("firstDate").replaceAll("[^\\dA-Za-z ]", "").trim() + "</LI>");
        String [] payment = request.getParameterValues("payment");
        if(payment!=null){
            out.println("<LI>Send payment to:" + payment[0].replaceAll("[^\\dA-Za-z ]", "").trim() + "</LI>");  
        }
        out.println("<LI>Veterinarian: " + request.getParameter("Veterinarian").replaceAll("[^\\dA-Za-z ]", "").trim() + "</LI>");
        out.println("<LI>Clinic Name: " + request.getParameter("ClinicName").replaceAll("[^\\dA-Za-z ]", "").trim() + "</LI>");    
        out.println("<LI>Clinic Phone: " + request.getParameter("clinicPhone").replaceAll("[^\\dA-Za-z ]", "").trim() + "</LI>");
        out.println("<LI>Clinic Fax: " + request.getParameter("ClinicFax").replaceAll("[^\\dA-Za-z ]", "").trim() + "</LI>"); 
        String [] otherVeterinarian = request.getParameterValues("otherVeterinarian");
        if(otherVeterinarian!=null){
            out.println("<LI>Did any other veterinarian treat your pet?" + otherVeterinarian[0].replaceAll("[^\\dA-Za-z ]", "").trim() + "</LI>");  
        }
        String [] newCondition = request.getParameterValues("newCondition");
        if(newCondition!=null){
            out.println("<LI>Is this a new condition?" + newCondition[0].replaceAll("[^\\dA-Za-z ]", "").trim() + "</LI>");   
        }
        out.println("<LI>Signature of Pet Owner: " + request.getParameter("signature").replaceAll("[^\\dA-Za-z ]", "").trim() + "</LI>");
        out.println("<LI>Signature Date: " + request.getParameter("signatureDate").replaceAll("[^\\dA-Za-z ]", "").trim() + "</LI>");
        out.println("</UL>");
        out.println("</body><html>");
        out.close();           
        
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
