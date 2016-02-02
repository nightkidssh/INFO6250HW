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
public class MultipleFormsServlet extends HttpServlet {
String firstName;
String lastName;
String userName;
String password;
public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
sendPage1(response);
}
public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
String page = request.getParameter("page");
firstName = request.getParameter("firstName");
lastName = request.getParameter("lastName");
userName = request.getParameter("userName");
password = request.getParameter("password");
if (page == null) {
sendPage1(response);
return;
}
if (page.equals("1")) {
sendPage2(response);
}
else if (page.equals("2")) {
displayValues(response);
}
}
void sendPage1(HttpServletResponse response) throws ServletException, IOException {
response.setContentType("text/html");
PrintWriter out = response.getWriter();
out.println("<HTML>");
out.println("<HEAD><TITLE>Page 1</TITLE></HEAD>");
out.println("<BODY>");
out.println("<CENTER>");
out.println("<H2>Page 1</H2>");
out.println("Please enter your first first name and last name.<BR><BR>");
out.println("<FORM METHOD=POST>");
out.println("<INPUT TYPE=HIDDEN NAME=page VALUE=1>");
out.println("<TABLE>");
out.println("<TR>");
out.println("<TD>First Name&nbsp;</TD>");
out.println("<TD><INPUT TYPE=TEXT NAME=firstName></TD>");
out.println("</TR>");
out.println("<TR>");
out.println("<TD>Last Name&nbsp;</TD>");
out.println("<TD><INPUT TYPE=TEXT NAME=lastName></TD>");
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
void sendPage2(HttpServletResponse response) throws ServletException, IOException
{
response.setContentType("text/html");
PrintWriter out = response.getWriter();
out.println("<HTML>");
out.println("<HEAD><TITLE>Page 2</TITLE></HEAD>");
out.println("<BODY>");
out.println("<CENTER><H2>Page 2</H2>");
out.println("Please enter your user name and password.<BR><BR>");
out.println("<FORM METHOD=POST>");
out.println("<INPUT TYPE=HIDDEN NAME=page VALUE=2>");
out.println("<INPUT TYPE=HIDDEN NAME=firstName VALUE=\"" + firstName + "\"></TD>");
out.println("<INPUT TYPE=HIDDEN NAME=lastName VALUE=\"" + lastName + "\"></TD>");
out.println("<TABLE>");
out.println("<TR>");
out.println("<TD>User Name&nbsp;</TD>");
out.println("<TD><INPUT TYPE=TEXT NAME=userName></TD>");
out.println("</TR>");
out.println("<TR>");
out.println("<TD>Password&nbsp;</TD>");
out.println("<TD><INPUT TYPE=PASSWORD NAME=password></TD>");
out.println("</TR>");
out.println("<TR>");
out.println("<TD><INPUT TYPE=RESET></TD>");
out.println("<TD><INPUT TYPE=SUBMIT VALUE=Submit></TD>");
out.println("</TR>");
out.println("</TABLE>");
out.println("</FORM></CENTER>");
out.println("</BODY></HTML>");
}
void displayValues(HttpServletResponse response) throws ServletException, IOException {
response.setContentType("text/html");
PrintWriter out = response.getWriter();
out.println("<HTML>");
out.println("<HEAD><TITLE>Page 3</TITLE></HEAD>");
out.println("<BODY>");
out.println("<CENTER>");
out.println("<H2>Page 3 (Finish)</H2>");
out.println("Here are the values you have entered.<BR><BR>");
out.println("<TABLE>");
out.println("<TR>");
out.println("<TD>First Name: &nbsp;</TD>");
out.println("<TD>" + firstName + "</TD>");
out.println("</TR>");
out.println("<TR><TD>Last Name: &nbsp;</TD>");
out.println("<TD>" + lastName + "</TD>");
out.println("</TR>");
out.println("<TR>");
out.println("<TD>User Name: &nbsp;</TD>");
out.println("<TD>" + userName + "</TD>");
out.println("</TR>");
out.println("<TR><TD>Password: &nbsp;</TD>");
out.println("<TD>" + password + "</TD>");
out.println("</TR></TABLE></CENTER>");
out.println("</BODY></HTML>");
}
}