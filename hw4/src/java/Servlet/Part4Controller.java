/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Bean.SalesOrderBean;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

/**
 *
 * @author kym-1992
 */
public class Part4Controller implements Controller{
    private ArrayList<SalesOrderBean> orders;
    
    @Override
    public ModelAndView handleRequest(HttpServletRequest hsr, HttpServletResponse hsr1) throws Exception {
        ModelAndView mv = new ModelAndView();
        
        String action = hsr.getParameter("part4action");
        
        if(action == null){
            mv.addObject("flag", "init");
            mv.setViewName("part4");
        }
        
        else if(action.equals("enterName")){
            orders = new ArrayList<>();
            
            String filename = hsr.getParameter("filename");
            try {
                // Load the driver.
                Class.forName("org.relique.jdbc.csv.CsvDriver");

                // Create a connection. CSV file is in D:
                Connection conn = DriverManager.getConnection("jdbc:relique:csv:/STUDY/NEU/INFO6250/workspace/hw4");

                // Create a Statement object to execute the query with.
                Statement stmt = conn.createStatement();

                // Select columns from SalesOrder.csv
                ResultSet rs = stmt.executeQuery("SELECT * FROM "+ filename);

                //loop through rs
                while(rs.next()){
                    SalesOrderBean salesOrderBean = new SalesOrderBean();
                    salesOrderBean.setSalesOrderID(rs.getInt(1));
                    salesOrderBean.setRevisionNumber(rs.getInt(2));
                    salesOrderBean.setOrderDate(rs.getString(3));
                    salesOrderBean.setDueDate(rs.getString(4));
                    salesOrderBean.setShipDate(rs.getString(5));
                    salesOrderBean.setStatus(rs.getInt(6));
                    salesOrderBean.setOnlineOrderFlag(rs.getInt(7));
                    salesOrderBean.setSalesOrderNumber(rs.getString(8));
                    salesOrderBean.setPurchaseOrderNumber(rs.getString(9));
                    salesOrderBean.setAccountNumber(rs.getString(10));
                    salesOrderBean.setCustomerID(rs.getInt(11));
                    salesOrderBean.setSalesPersonID(rs.getInt(12));
                    salesOrderBean.setTerritoryID(rs.getInt(13));
                    salesOrderBean.setBillToAddressID(rs.getInt(14));
                    salesOrderBean.setShipToAddressID(rs.getInt(15));
                    salesOrderBean.setShipMethodID(rs.getInt(16));
                    salesOrderBean.setCreditCardID(rs.getInt(17));
                    salesOrderBean.setCreditCardApprovalCode(rs.getString(18));
                    salesOrderBean.setCurrencyRateID(rs.getString(19));
                    
                    
                            
                    orders.add(salesOrderBean);
                }

                mv.addObject("orderList", orders);
                mv.addObject("flag", "display");
                mv.setViewName("part4");
                // Clean up
                conn.close();
                stmt.close();
                rs.close();
            } catch (Exception e) {
                System.out.println("EXCEPTION: " + e.getMessage());
            }            
        }
        return mv;
    }
    
}
