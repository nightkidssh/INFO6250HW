/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Part6;

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
public class Part6 extends HttpServlet {
    String question1;
    String question2;
    String question3;
    String question4;
    String question5;
    String question6;
    String question7;
    String question8;
    String question9;
    String question10;
    
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
//            out.println("<title>Servlet Part6</title>");            
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet Part6 at " + request.getContextPath() + "</h1>");
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
        sendPage1(response);
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
        String page = request.getParameter("page");     
        question1 = request.getParameter("question1");
        question2 = request.getParameter("question2");
        question3 = request.getParameter("question3");
        question4 = request.getParameter("question4");
        question5 = request.getParameter("question5");
        question6 = request.getParameter("question6");
        question7 = request.getParameter("question7");
        question8 = request.getParameter("question8");
        question9 = request.getParameter("question9");
        question10 = request.getParameter("question10");
        
        if(page == null){
            sendPage1(response);
            return;            
        }
        
        if(page.equals("1")){
            sendPage2(response);
        }
        
        else if(page.equals("2")){
            sendPage3(response);
        }
        
        else if(page.equals("3")){
            sendPage4(response);
        }
        
        else if(page.equals("4")){
            sendPage5(response);
        }
        
        else if(page.equals("5")){
            sendPage6(response);
        }
        
        else if(page.equals("6")){
            sendPage7(response);
        }
        
        else if(page.equals("7")){
            sendPage8(response);
        }
        
        else if(page.equals("8")){
            sendPage9(response);
        }
        
        else if(page.equals("9")){
            sendPage10(response);
        }
        
        else if(page.equals("10")){
            displayValues(response);
        }        
    }

    void sendPage1(HttpServletResponse response) throws ServletException, IOException{
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<HTML>");
        out.println("<HEAD><TITLE>Page 1</TITLE></HEAD>");
        out.println("<BODY>");
        out.println("<CENTER>");
        out.println("<H2>Question 1</H2>");
        out.println("Which of these life-cycle method you can over-ride in your class?<BR><BR>");
        out.println("<FORM METHOD=POST>");
        out.println("<INPUT TYPE=HIDDEN NAME=page VALUE=1>");
        out.println("<TABLE>");
        out.println("<TR>");
        out.println("<TD>1.&nbsp;</TD>");
        out.println("<TD><INPUT TYPE='RADIO' NAME='question1' VALUE='init' checked>init()</TD>");
        out.println("</TR>");
        out.println("<TR>");
        out.println("<TD>2.&nbsp;</TD>");
        out.println("<TD><INPUT TYPE='RADIO' NAME='question1' VALUE='service'>service()</TD>");
        out.println("</TR>");
        out.println("<TR>");
        out.println("<TD>3.&nbsp;</TD>");
        out.println("<TD><INPUT TYPE='RADIO' NAME='question1' VALUE='doGet'>doGet()</TD>");
        out.println("</TR>");
        out.println("<TR>");
        out.println("<TD>4.&nbsp;</TD>");
        out.println("<TD><INPUT TYPE='RADIO' NAME='question1' VALUE='All of these'>All of these</TD>");
        out.println("</TR>");        
        
        out.println("<TR>");
        out.println("<TD><INPUT TYPE=RESET></TD>");
        out.println("<TD><INPUT TYPE=SUBMIT VALUE=Submit></TD>");
        out.println("</TR>");
        out.println("</TABLE>");
        out.println("</FORM>");
        out.println("</CENTER>");
        out.println("</BODY>");
        out.println("</HTML>");        
    }
    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    
    void sendPage2(HttpServletResponse response) throws ServletException, IOException
    {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<HTML>");
        out.println("<HEAD><TITLE>Page 2</TITLE></HEAD>");
        out.println("<BODY>");
        out.println("<CENTER><H2>Question 2</H2>");
        out.println("Which life-cycle method make ready the servlet for garbage collection?<BR><BR>");
        out.println("<FORM METHOD=POST>");
        out.println("<INPUT TYPE=HIDDEN NAME=page VALUE=2>");
        out.println("<INPUT TYPE=HIDDEN NAME=question1 VALUE=\"" + question1 + "\"></TD>");
        out.println("<TABLE>");
        out.println("<TR>");
        out.println("<TD>1.&nbsp;</TD>");
        out.println("<TD><INPUT TYPE='RADIO' NAME='question2' VALUE='init' checked>init()</TD>");
        out.println("</TR>");
        out.println("<TR>");
        out.println("<TD>2.&nbsp;</TD>");
        out.println("<TD><INPUT TYPE='RADIO' NAME='question2' VALUE='service'>service()</TD>");
        out.println("</TR>");
        out.println("<TR>");
        out.println("<TD>3.&nbsp;</TD>");
        out.println("<TD><INPUT TYPE='RADIO' NAME='question2' VALUE='system.gc'>system.gc</TD>");
        out.println("</TR>");
        out.println("<TR>");
        out.println("<TD>4.&nbsp;</TD>");
        out.println("<TD><INPUT TYPE='RADIO' NAME='question2' VALUE='destroy'>destroy</TD>");
        out.println("</TR>");     
        
        out.println("<TR>");
        out.println("<TD><INPUT TYPE=RESET></TD>");
        out.println("<TD><INPUT TYPE=SUBMIT VALUE=Submit></TD>");
        out.println("</TR>");
        out.println("</FORM></CENTER>");
        out.println("</BODY></HTML>");
    }        
    
    void sendPage3(HttpServletResponse response) throws ServletException, IOException
    {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<HTML>");
        out.println("<HEAD><TITLE>Page 3</TITLE></HEAD>");
        out.println("<BODY>");
        out.println("<CENTER><H2>Question 3</H2>");
        out.println("Which statement is not true about ServletContext?<BR><BR>");
        out.println("<FORM METHOD=POST>");
        out.println("<INPUT TYPE=HIDDEN NAME=page VALUE=3>");
        out.println("<INPUT TYPE=HIDDEN NAME=question1 VALUE=\"" + question1 + "\"></TD>");
        out.println("<INPUT TYPE=HIDDEN NAME=question2 VALUE=\"" + question2 + "\"></TD>");
        out.println("<TABLE>");
        out.println("<TR>");
        out.println("<TD>1.&nbsp;</TD>");
        out.println("<TD><INPUT TYPE='RADIO' NAME='question3' VALUE='There is one ServletContext per one application' checked>There is one ServletContext per one application</TD>");
        out.println("</TR>");
        out.println("<TR>");
        out.println("<TD>2.&nbsp;</TD>");
        out.println("<TD><INPUT TYPE='RADIO' NAME='question3' VALUE='Generally it is used to get web app parameters'>Generally it is used to get web app parameters</TD>");
        out.println("</TR>");
        out.println("<TR>");
        out.println("<TD>3.&nbsp;</TD>");
        out.println("<TD><INPUT TYPE='RADIO' NAME='question3' VALUE='We can get Server Information though it'>We can get Server Information though it</TD>");
        out.println("</TR>");
        out.println("<TR>");
        out.println("<TD>4.&nbsp;</TD>");
        out.println("<TD><INPUT TYPE='RADIO' NAME='question3' VALUE='There is one ServletContext per one servlet'>There is one ServletContext per one servlet</TD>");
        out.println("</TR>");     
        
        out.println("<TR>");
        out.println("<TD><INPUT TYPE=RESET></TD>");
        out.println("<TD><INPUT TYPE=SUBMIT VALUE=Submit></TD>");
        out.println("</TR>");
        out.println("</FORM></CENTER>");
        out.println("</BODY></HTML>");
    }    

    void sendPage4(HttpServletResponse response) throws ServletException, IOException
    {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<HTML>");
        out.println("<HEAD><TITLE>Page 4</TITLE></HEAD>");
        out.println("<BODY>");
        out.println("<CENTER><H2>Question 4</H2>");
        out.println("Which tag of DD maps internal name of servlet to public URL pattern?<BR><BR>");
        out.println("<FORM METHOD=POST>");
        out.println("<INPUT TYPE=HIDDEN NAME=page VALUE=4>");
        out.println("<INPUT TYPE=HIDDEN NAME=question1 VALUE=\"" + question1 + "\"></TD>");
        out.println("<INPUT TYPE=HIDDEN NAME=question2 VALUE=\"" + question2 + "\"></TD>");
        out.println("<INPUT TYPE=HIDDEN NAME=question3 VALUE=\"" + question3 + "\"></TD>");
        out.println("<TABLE>");
        out.println("<TR>");
        out.println("<TD>1.&nbsp;</TD>");
        out.println("<TD><INPUT TYPE='RADIO' NAME='question4' VALUE='servlet' checked>servlet</TD>");
        out.println("</TR>");
        out.println("<TR>");
        out.println("<TD>2.&nbsp;</TD>");
        out.println("<TD><INPUT TYPE='RADIO' NAME='question4' VALUE='servlet-mapping'>servlet-mapping</TD>");
        out.println("</TR>");
        out.println("<TR>");
        out.println("<TD>3.&nbsp;</TD>");
        out.println("<TD><INPUT TYPE='RADIO' NAME='question4' VALUE='web-app'>web-app</TD>");
        out.println("</TR>");
        out.println("<TR>");
        out.println("<TD>4.&nbsp;</TD>");
        out.println("<TD><INPUT TYPE='RADIO' NAME='question4' VALUE='servlet-mappings'>servlet-mappings</TD>");
        out.println("</TR>");     
        
        out.println("<TR>");
        out.println("<TD><INPUT TYPE=RESET></TD>");
        out.println("<TD><INPUT TYPE=SUBMIT VALUE=Submit></TD>");
        out.println("</TR>");
        out.println("</FORM></CENTER>");
        out.println("</BODY></HTML>");
    }    
    
    void sendPage5(HttpServletResponse response) throws ServletException, IOException
    {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<HTML>");
        out.println("<HEAD><TITLE>Page 5</TITLE></HEAD>");
        out.println("<BODY>");
        out.println("<CENTER><H2>Question 5</H2>");
        out.println("Which http method is idempotent?<BR><BR>");
        out.println("<FORM METHOD=POST>");
        out.println("<INPUT TYPE=HIDDEN NAME=page VALUE=5>");
        out.println("<INPUT TYPE=HIDDEN NAME=question1 VALUE=\"" + question1 + "\"></TD>");
        out.println("<INPUT TYPE=HIDDEN NAME=question2 VALUE=\"" + question2 + "\"></TD>");
        out.println("<INPUT TYPE=HIDDEN NAME=question3 VALUE=\"" + question3 + "\"></TD>");
        out.println("<INPUT TYPE=HIDDEN NAME=question4 VALUE=\"" + question4 + "\"></TD>");
        out.println("<TABLE>");
        out.println("<TR>");
        out.println("<TD>1.&nbsp;</TD>");
        out.println("<TD><INPUT TYPE='RADIO' NAME='question5' VALUE='get' checked>get</TD>");
        out.println("</TR>");
        out.println("<TR>");
        out.println("<TD>2.&nbsp;</TD>");
        out.println("<TD><INPUT TYPE='RADIO' NAME='question5' VALUE='post'>post</TD>");
        out.println("</TR>");
        out.println("<TR>");
        out.println("<TD>3.&nbsp;</TD>");
        out.println("<TD><INPUT TYPE='RADIO' NAME='question5' VALUE='trace'>trace</TD>");
        out.println("</TR>");
        out.println("<TR>");
        out.println("<TD>4.&nbsp;</TD>");
        out.println("<TD><INPUT TYPE='RADIO' NAME='question5' VALUE='option'>option</TD>");
        out.println("</TR>");     
        
        out.println("<TR>");
        out.println("<TD><INPUT TYPE=RESET></TD>");
        out.println("<TD><INPUT TYPE=SUBMIT VALUE=Submit></TD>");
        out.println("</TR>");
        out.println("</FORM></CENTER>");
        out.println("</BODY></HTML>");
    }    
    
    void sendPage6(HttpServletResponse response) throws ServletException, IOException
    {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<HTML>");
        out.println("<HEAD><TITLE>Page 2</TITLE></HEAD>");
        out.println("<BODY>");
        out.println("<CENTER><H2>Question 2</H2>");
        out.println("Which life-cycle method make ready the servlet for garbage collection?<BR><BR>");
        out.println("<FORM METHOD=POST>");
        out.println("<INPUT TYPE=HIDDEN NAME=page VALUE=2>");
        out.println("<INPUT TYPE=HIDDEN NAME=question1 VALUE=\"" + question1 + "\"></TD>");
        out.println("<TABLE>");
        out.println("<TR>");
        out.println("<TD>1.&nbsp;</TD>");
        out.println("<TD><INPUT TYPE='RADIO' NAME='question2' VALUE='init' checked>init()</TD>");
        out.println("</TR>");
        out.println("<TR>");
        out.println("<TD>2.&nbsp;</TD>");
        out.println("<TD><INPUT TYPE='RADIO' NAME='question2' VALUE='service'>service()</TD>");
        out.println("</TR>");
        out.println("<TR>");
        out.println("<TD>3.&nbsp;</TD>");
        out.println("<TD><INPUT TYPE='RADIO' NAME='question2' VALUE='system.gc'>system.gc</TD>");
        out.println("</TR>");
        out.println("<TR>");
        out.println("<TD>4.&nbsp;</TD>");
        out.println("<TD><INPUT TYPE='RADIO' NAME='question2' VALUE='destroy'>destroy</TD>");
        out.println("</TR>");     
        
        out.println("<TR>");
        out.println("<TD><INPUT TYPE=RESET></TD>");
        out.println("<TD><INPUT TYPE=SUBMIT VALUE=Submit></TD>");
        out.println("</TR>");
        out.println("</FORM></CENTER>");
        out.println("</BODY></HTML>");
    }    
    
    void sendPage7(HttpServletResponse response) throws ServletException, IOException
    {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<HTML>");
        out.println("<HEAD><TITLE>Page 2</TITLE></HEAD>");
        out.println("<BODY>");
        out.println("<CENTER><H2>Question 2</H2>");
        out.println("Which life-cycle method make ready the servlet for garbage collection?<BR><BR>");
        out.println("<FORM METHOD=POST>");
        out.println("<INPUT TYPE=HIDDEN NAME=page VALUE=2>");
        out.println("<INPUT TYPE=HIDDEN NAME=question1 VALUE=\"" + question1 + "\"></TD>");
        out.println("<TABLE>");
        out.println("<TR>");
        out.println("<TD>1.&nbsp;</TD>");
        out.println("<TD><INPUT TYPE='RADIO' NAME='question2' VALUE='init' checked>init()</TD>");
        out.println("</TR>");
        out.println("<TR>");
        out.println("<TD>2.&nbsp;</TD>");
        out.println("<TD><INPUT TYPE='RADIO' NAME='question2' VALUE='service'>service()</TD>");
        out.println("</TR>");
        out.println("<TR>");
        out.println("<TD>3.&nbsp;</TD>");
        out.println("<TD><INPUT TYPE='RADIO' NAME='question2' VALUE='system.gc'>system.gc</TD>");
        out.println("</TR>");
        out.println("<TR>");
        out.println("<TD>4.&nbsp;</TD>");
        out.println("<TD><INPUT TYPE='RADIO' NAME='question2' VALUE='destroy'>destroy</TD>");
        out.println("</TR>");     
        
        out.println("<TR>");
        out.println("<TD><INPUT TYPE=RESET></TD>");
        out.println("<TD><INPUT TYPE=SUBMIT VALUE=Submit></TD>");
        out.println("</TR>");
        out.println("</FORM></CENTER>");
        out.println("</BODY></HTML>");
    }    
    
    void sendPage8(HttpServletResponse response) throws ServletException, IOException
    {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<HTML>");
        out.println("<HEAD><TITLE>Page 2</TITLE></HEAD>");
        out.println("<BODY>");
        out.println("<CENTER><H2>Question 2</H2>");
        out.println("Which life-cycle method make ready the servlet for garbage collection?<BR><BR>");
        out.println("<FORM METHOD=POST>");
        out.println("<INPUT TYPE=HIDDEN NAME=page VALUE=2>");
        out.println("<INPUT TYPE=HIDDEN NAME=question1 VALUE=\"" + question1 + "\"></TD>");
        out.println("<TABLE>");
        out.println("<TR>");
        out.println("<TD>1.&nbsp;</TD>");
        out.println("<TD><INPUT TYPE='RADIO' NAME='question2' VALUE='init' checked>init()</TD>");
        out.println("</TR>");
        out.println("<TR>");
        out.println("<TD>2.&nbsp;</TD>");
        out.println("<TD><INPUT TYPE='RADIO' NAME='question2' VALUE='service'>service()</TD>");
        out.println("</TR>");
        out.println("<TR>");
        out.println("<TD>3.&nbsp;</TD>");
        out.println("<TD><INPUT TYPE='RADIO' NAME='question2' VALUE='system.gc'>system.gc</TD>");
        out.println("</TR>");
        out.println("<TR>");
        out.println("<TD>4.&nbsp;</TD>");
        out.println("<TD><INPUT TYPE='RADIO' NAME='question2' VALUE='destroy'>destroy</TD>");
        out.println("</TR>");     
        
        out.println("<TR>");
        out.println("<TD><INPUT TYPE=RESET></TD>");
        out.println("<TD><INPUT TYPE=SUBMIT VALUE=Submit></TD>");
        out.println("</TR>");
        out.println("</FORM></CENTER>");
        out.println("</BODY></HTML>");
    }    
    
    void sendPage9(HttpServletResponse response) throws ServletException, IOException
    {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<HTML>");
        out.println("<HEAD><TITLE>Page 2</TITLE></HEAD>");
        out.println("<BODY>");
        out.println("<CENTER><H2>Question 2</H2>");
        out.println("Which life-cycle method make ready the servlet for garbage collection?<BR><BR>");
        out.println("<FORM METHOD=POST>");
        out.println("<INPUT TYPE=HIDDEN NAME=page VALUE=2>");
        out.println("<INPUT TYPE=HIDDEN NAME=question1 VALUE=\"" + question1 + "\"></TD>");
        out.println("<TABLE>");
        out.println("<TR>");
        out.println("<TD>1.&nbsp;</TD>");
        out.println("<TD><INPUT TYPE='RADIO' NAME='question2' VALUE='init' checked>init()</TD>");
        out.println("</TR>");
        out.println("<TR>");
        out.println("<TD>2.&nbsp;</TD>");
        out.println("<TD><INPUT TYPE='RADIO' NAME='question2' VALUE='service'>service()</TD>");
        out.println("</TR>");
        out.println("<TR>");
        out.println("<TD>3.&nbsp;</TD>");
        out.println("<TD><INPUT TYPE='RADIO' NAME='question2' VALUE='system.gc'>system.gc</TD>");
        out.println("</TR>");
        out.println("<TR>");
        out.println("<TD>4.&nbsp;</TD>");
        out.println("<TD><INPUT TYPE='RADIO' NAME='question2' VALUE='destroy'>destroy</TD>");
        out.println("</TR>");     
        
        out.println("<TR>");
        out.println("<TD><INPUT TYPE=RESET></TD>");
        out.println("<TD><INPUT TYPE=SUBMIT VALUE=Submit></TD>");
        out.println("</TR>");
        out.println("</FORM></CENTER>");
        out.println("</BODY></HTML>");
    }    
    
    void sendPage10(HttpServletResponse response) throws ServletException, IOException
    {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<HTML>");
        out.println("<HEAD><TITLE>Page 2</TITLE></HEAD>");
        out.println("<BODY>");
        out.println("<CENTER><H2>Question 2</H2>");
        out.println("Which life-cycle method make ready the servlet for garbage collection?<BR><BR>");
        out.println("<FORM METHOD=POST>");
        out.println("<INPUT TYPE=HIDDEN NAME=page VALUE=2>");
        out.println("<INPUT TYPE=HIDDEN NAME=question1 VALUE=\"" + question1 + "\"></TD>");
        out.println("<TABLE>");
        out.println("<TR>");
        out.println("<TD>1.&nbsp;</TD>");
        out.println("<TD><INPUT TYPE='RADIO' NAME='question2' VALUE='init' checked>init()</TD>");
        out.println("</TR>");
        out.println("<TR>");
        out.println("<TD>2.&nbsp;</TD>");
        out.println("<TD><INPUT TYPE='RADIO' NAME='question2' VALUE='service'>service()</TD>");
        out.println("</TR>");
        out.println("<TR>");
        out.println("<TD>3.&nbsp;</TD>");
        out.println("<TD><INPUT TYPE='RADIO' NAME='question2' VALUE='system.gc'>system.gc</TD>");
        out.println("</TR>");
        out.println("<TR>");
        out.println("<TD>4.&nbsp;</TD>");
        out.println("<TD><INPUT TYPE='RADIO' NAME='question2' VALUE='destroy'>destroy</TD>");
        out.println("</TR>");     
        
        out.println("<TR>");
        out.println("<TD><INPUT TYPE=RESET></TD>");
        out.println("<TD><INPUT TYPE=SUBMIT VALUE=Submit></TD>");
        out.println("</TR>");
        out.println("</FORM></CENTER>");
        out.println("</BODY></HTML>");
    }        
    
    void displayValues(HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<HTML>");
        out.println("<HEAD><TITLE>Result</TITLE></HEAD>");
        out.println("<BODY>");
        out.println("<CENTER>");
        out.println("<H2>Result</H2>");
        out.println("Review your question input:<BR><BR>");
        out.println("<TABLE>");
        out.println("<TR>");
        out.println("<TD>1: &nbsp;</TD>");
        out.println("<TD>" + question1 + "</TD>");
        out.println("</TR>");
        out.println("<TR><TD>2: &nbsp;</TD>");
        out.println("<TD>" + question2 + "</TD>");
        out.println("</TR>");
        out.println("<TR>");
        out.println("<TD>3: &nbsp;</TD>");
        out.println("<TD>" + question3 +"</TD>");
        out.println("</TR>");
        out.println("<TR>");
        out.println("<TD>3: &nbsp;</TD>");
        out.println("<TD>" + question3 +"</TD>");
        out.println("</TR>");
        out.println("<TR>");
        out.println("<TD>4: &nbsp;</TD>");
        out.println("<TD>" + question4 +"</TD>");
        out.println("</TR>");
        out.println("<TR>");
        out.println("<TD>5: &nbsp;</TD>");
        out.println("<TD>" + question5 +"</TD>");
        out.println("</TR>");
        out.println("<TR>");
        out.println("<TD>6: &nbsp;</TD>");
        out.println("<TD>" + question6 +"</TD>");
        out.println("</TR>");
        out.println("<TR>");
        out.println("<TD>7: &nbsp;</TD>");
        out.println("<TD>" + question7 +"</TD>");
        out.println("</TR>");
        out.println("<TR>");
        out.println("<TD>8: &nbsp;</TD>");
        out.println("<TD>" + question8 +"</TD>");
        out.println("</TR>");
        out.println("<TR>");
        out.println("<TD>9: &nbsp;</TD>");
        out.println("<TD>" + question9 +"</TD>");
        out.println("</TR>");        
        out.println("<TR><TD>10: &nbsp;</TD>");
        out.println("<TD>" + question10 + "</TD>");
        out.println("</TR></TABLE></CENTER>");
        out.println("</BODY></HTML>");
    }    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
