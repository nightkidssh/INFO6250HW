/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServletFiles;

import Bean.SalesOrderBean;
import DAO.InsertCSVDAO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

/**
 *
 * @author kym-1992
 */
public class Part5Controller implements Controller{
    InsertCSVDAO insertCSVDAO;
    
    public Part5Controller(InsertCSVDAO insertCSVDAO) {
        this.insertCSVDAO = insertCSVDAO;
    }
    
    @Override
    public ModelAndView handleRequest(HttpServletRequest hsr, HttpServletResponse hsr1) throws Exception {
        ModelAndView mv = new ModelAndView();
                    
        
        String action = hsr.getParameter("part5action");
        
        if(action == null){
            mv.addObject("flag", "init");
            mv.setViewName("part5");
        }
        
        else if(action.equals("enterName")){
            String filename = hsr.getParameter("filename");       
                mv.addObject("filename", filename);
                mv.addObject("flag", "enterName");
                mv.setViewName("part5");           
        }
        
        else if(action.equals("doInsert")){
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
                mv.setViewName("part5");            
        }
        
        return mv;
    }
    
}
