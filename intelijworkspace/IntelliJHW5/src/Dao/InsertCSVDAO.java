/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Bean.SalesOrderBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kym-1992
 */
public class InsertCSVDAO extends DAO{
    Connection conn;
    PreparedStatement ps;

    public void addRecord(SalesOrderBean orderBean) throws SQLException{
        try{
            this.conn = getConnection();
            String sql = "INSERT INTO salesorder (SalesOrderID,RevisionNumber,OrderDate,DueDate,ShipDate,Status,OnlineOrderFlag,SalesOrderNumber,PurchaseOrderNumber,AccountNumber,CustomerID,SalesPersonID,TerritoryID,BillToAddressID,ShipToAddressID,ShipMethodID,CreditCardID,CreditCardApprovalCode,CurrencyRateID,SubTotal,TaxAmt,Freight,TotalDue,Comment,ModifiedDate)"
                    + "VALUES"
                    + "(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, orderBean.getSalesOrderID());
            ps.setInt(2, orderBean.getRevisionNumber());
            ps.setString(3, orderBean.getOrderDate());
            ps.setString(4, orderBean.getDueDate());
            ps.setString(5, orderBean.getShipDate());
            ps.setInt(6, orderBean.getStatus());
            ps.setInt(7, orderBean.getOnlineOrderFlag());
            ps.setString(8, orderBean.getSalesOrderNumber());
            ps.setString(9, orderBean.getPurchaseOrderNumber());
            ps.setString(10, orderBean.getAccountNumber());
            ps.setInt(11, orderBean.getCustomerID());
            ps.setInt(12, orderBean.getSalesPersonID());
            ps.setInt(13, orderBean.getTerritoryID());
            ps.setInt(14, orderBean.getBillToAddressID());
            ps.setInt(15, orderBean.getShipToAddressID());
            ps.setInt(16, orderBean.getShipMethodID());
            ps.setInt(17, orderBean.getCreditCardID());
            ps.setString(18, orderBean.getCreditCardApprovalCode());
            ps.setString(19, orderBean.getCurrencyRateID());
            ps.setDouble(20, orderBean.getSubTotal());
            ps.setDouble(21, orderBean.getTaxAmt());
            ps.setDouble(22, orderBean.getFreight());
            ps.setDouble(23, orderBean.getTotalDue());
            ps.setString(24, orderBean.getComment());
            ps.setString(25, orderBean.getModifiedDate());

            ps.executeUpdate();

        }catch (SQLException ex) {
            Logger.getLogger(InsertCSVDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close(conn);
            ps.close();
        }
    }
}
