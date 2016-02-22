/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServletFiles;

import Bean.SalesOrderBean;
import DAO.InsertCSVDAO;
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
    InsertCSVDAO insertCSVDAO;
    
    public Part4Controller(InsertCSVDAO insertCSVDAO) {
        this.insertCSVDAO = insertCSVDAO;
    }
    
    @Override
    public ModelAndView handleRequest(HttpServletRequest hsr, HttpServletResponse hsr1) throws Exception {
        ModelAndView mv = new ModelAndView();
        orders = new ArrayList<>();
                    
        
        String action = hsr.getParameter("part4action");
        
        if(action == null){
            mv.addObject("flag", "init");
            mv.setViewName("part4");
        }
        
        else if(action.equals("enterName")){
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
                    salesOrderBean.setSubTotal(rs.getDouble(20));
                    salesOrderBean.setTaxAmt(rs.getDouble(21));
                    salesOrderBean.setFreight(rs.getDouble(22));
                    salesOrderBean.setTotalDue(rs.getDouble(23));
                    salesOrderBean.setComment(rs.getString(24));
                    salesOrderBean.setModifiedDate(rs.getString(25));
                        
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
        
        else if(action.equals("doInsert")){
//            orders = (ArrayList<SalesOrderBean>) hsr.getAttribute("recordList");
//            for(SalesOrderBean salesOrderBean: orders){
//                insertCSVDAO.addRecord(salesOrderBean);
//            }
            
            String[] SalesOrderID = hsr.getParameterValues("SalesOrderID");
            String[] RevisionNumber = hsr.getParameterValues("RevisionNumber");
            String[] OrderDate = hsr.getParameterValues("OrderDate");
            String[] DueDate = hsr.getParameterValues("DueDate");
            String[] ShipDate = hsr.getParameterValues("ShipDate");
            String[] Status = hsr.getParameterValues("Status");
            String[] OnlineOrderFlag = hsr.getParameterValues("OnlineOrderFlag");
            String[] SalesOrderNumber = hsr.getParameterValues("SalesOrderNumber");
            String[] PurchaseOrderNumber = hsr.getParameterValues("PurchaseOrderNumber");
            String[] AccountNumber = hsr.getParameterValues("AccountNumber");
            String[] CustomerID = hsr.getParameterValues("CustomerID");
            String[] SalesPersonID = hsr.getParameterValues("SalesPersonID");
            String[] TerritoryID = hsr.getParameterValues("TerritoryID");
            String[] BillToAddressID = hsr.getParameterValues("BillToAddressID");
            String[] ShipToAddressID = hsr.getParameterValues("ShipToAddressID");
            String[] ShipMethodID = hsr.getParameterValues("ShipMethodID");
            String[] CreditCardID = hsr.getParameterValues("CreditCardID");
            String[] CreditCardApprovalCode = hsr.getParameterValues("CreditCardApprovalCode");
            String[] CurrencyRateID = hsr.getParameterValues("CurrencyRateID");
            String[] SubTotal = hsr.getParameterValues("SubTotal");
            String[] TaxAmt = hsr.getParameterValues("TaxAmt");
            String[] Freight = hsr.getParameterValues("Freight");
            String[] TotalDue = hsr.getParameterValues("TotalDue");
            String[] Comment = hsr.getParameterValues("Comment");
            String[] ModifiedDate = hsr.getParameterValues("ModifiedDate");
            
            
            for(int i = 0; i < 100; i++){
                SalesOrderBean salesOrderBean = new SalesOrderBean();
                salesOrderBean.setSalesOrderID(Integer.parseInt(SalesOrderID[i]));
                salesOrderBean.setRevisionNumber(Integer.parseInt(RevisionNumber[i]));
                salesOrderBean.setOrderDate(OrderDate[i]);
                salesOrderBean.setDueDate(DueDate[i]);
                salesOrderBean.setShipDate(ShipDate[i]);
                salesOrderBean.setStatus(Integer.parseInt(Status[i]));
                salesOrderBean.setOnlineOrderFlag(Integer.parseInt(OnlineOrderFlag[i]));
                salesOrderBean.setSalesOrderNumber(SalesOrderNumber[i]);
                salesOrderBean.setPurchaseOrderNumber(PurchaseOrderNumber[i]);
                salesOrderBean.setAccountNumber(AccountNumber[i]);
                
                salesOrderBean.setCustomerID(Integer.parseInt(CustomerID[i]));
                salesOrderBean.setSalesPersonID(Integer.parseInt(SalesPersonID[i]));
                salesOrderBean.setTerritoryID(Integer.parseInt(TerritoryID[i]));
                salesOrderBean.setBillToAddressID(Integer.parseInt(BillToAddressID[i]));
                salesOrderBean.setShipToAddressID(Integer.parseInt(ShipToAddressID[i]));
                salesOrderBean.setShipMethodID(Integer.parseInt(ShipMethodID[i]));
                salesOrderBean.setCreditCardID(Integer.parseInt(CreditCardID[i]));
                
                salesOrderBean.setCreditCardApprovalCode(CreditCardApprovalCode[i]);
                salesOrderBean.setCurrencyRateID(CurrencyRateID[i]);
                salesOrderBean.setSubTotal(Double.parseDouble(SubTotal[i]));
                salesOrderBean.setTaxAmt(Double.parseDouble(TaxAmt[i]));
                salesOrderBean.setFreight(Double.parseDouble(Freight[i]));
                salesOrderBean.setTotalDue(Double.parseDouble(TotalDue[i]));
                salesOrderBean.setComment(Comment[i]);
                salesOrderBean.setModifiedDate(ModifiedDate[i]);           
                
                insertCSVDAO.addRecord(salesOrderBean);
            }
            
                mv.addObject("quantity", SalesOrderID.length);
                mv.addObject("flag", "added");
                mv.setViewName("part4");            
        }
        
        return mv;
    }
    
}
