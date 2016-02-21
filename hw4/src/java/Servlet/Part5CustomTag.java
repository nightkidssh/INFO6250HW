/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import javax.servlet.jsp.tagext.TagSupport;

/**
 *
 * @author kym-1992
 */
public class Part5CustomTag extends TagSupport{
    
    @Override
    public int doStartTag() throws JspException{
        
        System.out.println(6666666);
//        String filename = (String) getJspContext().getAttribute("filename", PageContext.REQUEST_SCOPE);
//        try {
//            // Load the driver.
//            Class.forName("org.relique.jdbc.csv.CsvDriver");
//
//            // Create a connection. CSV file is in D:
//            Connection conn = DriverManager.getConnection("jdbc:relique:csv:/STUDY/NEU/INFO6250/workspace/hw4");
//
//            // Create a Statement object to execute the query with.
//            Statement stmt = conn.createStatement();
//
//            // Select columns from SalesOrder.csv
//            ResultSet rs = stmt.executeQuery("SELECT * FROM "+ filename);
//
//            JspWriter out = getJspContext().getOut();
//            
//            out.println("                    <h1>Please confirm the input:</h1>\n" +
//"                    <form action=\"part4.htm\" method=\"post\">\n" +
//"                        <input type=\"submit\" value=\"Submit\" name=\"Submit\"/>\n" +
//"                        <input type=\"hidden\" name=\"part4action\" value=\"doInsert\" />\n" +
//"                    <table border=\"1\">\n" +
//"                    <tr>\n" +
//"                        <td>SalesOrderID</td>\n" +
//"                        <td>RevisionNumber</td>\n" +
//"                        <td>OrderDate</td>\n" +
//"                        <td>DueDate</td>\n" +
//"                        <td>ShipDate</td>\n" +
//"                        <td>Status</td>\n" +
//"                        <td>OnlineOrderFlag</td>\n" +
//"                        <td>SalesOrderNumber</td>\n" +
//"                        <td>PurchaseOrderNumber</td>\n" +
//"                        <td>AccountNumber</td>\n" +
//"                        <td>CustomerID</td>\n" +
//"                        <td>SalesPersonID</td>\n" +
//"                        <td>TerritoryID</td>\n" +
//"                        <td>BillToAddressID</td>\n" +
//"                        <td>ShipToAddressID</td>\n" +
//"                        <td>ShipMethodID</td>\n" +
//"                        <td>CreditCardID</td>\n" +
//"                        <td>CreditCardApprovalCode</td>\n" +
//"                        <td>CurrencyRateID</td>\n" +
//"                        <td>SubTotal</td>\n" +
//"                        <td>TaxAmt</td>\n" +
//"                        <td>Freight</td>\n" +
//"                        <td>TotalDue</td>\n" +
//"                        <td>Comment</td>\n" +
//"                        <td>ModifiedDate</td>\n" +
//"                    </tr>    ");
//            //loop through rs
//            while(rs.next()){    
//                
//            }   
//            
//                out.println("</table>\n" +
//"                    </form>");
//                conn.close();
//                stmt.close();
//                rs.close();
//            } catch (Exception e) {
//                System.out.println("EXCEPTION: " + e.getMessage());
//            }    
        return EVAL_PAGE;
    }
}
