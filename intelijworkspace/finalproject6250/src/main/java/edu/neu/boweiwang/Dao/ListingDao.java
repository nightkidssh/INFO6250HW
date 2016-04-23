package edu.neu.boweiwang.Dao;

import edu.neu.boweiwang.proj.AccountPkg.CombinedAccount;
import edu.neu.boweiwang.proj.ListingPkg.Listing;
import edu.neu.boweiwang.proj.ListingPkg.ListingType;
import edu.neu.boweiwang.proj.ListingPkg.SalesListing;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by kym-1992 on 4/4/16.
 */
@Component
public class ListingDao extends DAO{
    public Listing createSales(ListingType listingType, CombinedAccount combinedAccount, String address, String zipCode, String latitude, String longitude, String description, int numberOfBeds, int numberOfBaths, double sizeInSqft, double lotSize, String type, int yearOfBuilt, String heatingType, String propertyTax, String comments, String listPrice,
                               String filelocation1, String filelocation2, String filelocation3, String filelocation4){
        try{
            if(listingType.equals(ListingType.forLease)){

            }

            else if(listingType.equals(ListingType.forSales)){
                begin();
                SalesListing salesListing = new SalesListing( listingType,  combinedAccount,  address, zipCode, latitude,  longitude,  description,  numberOfBeds,  numberOfBaths,  sizeInSqft,  lotSize,  type,  yearOfBuilt,  heatingType,  propertyTax,  comments,  listPrice, filelocation1, filelocation2, filelocation3, filelocation4);
                getSession().save(salesListing);
                commit();
//                getSession().flush();
                close();
                return salesListing;
            }

            else{
                return null;
            }
        }
        catch (HibernateException e){
            e.printStackTrace();
            rollback();
        } finally {
            close();
        }

        return null;
    }

    public int updateListing(SalesListing salesListing){
        int rowsAffacted = 0;
        try{
                begin();
//                Query q = getSession().createQuery("update SalesListing set description = :description, numberOfBeds = :numberOfBeds, numberOfBaths=:numberOfBaths," +
//                        "sizeInSqft = :sizeInSqft, lotSize = :lotSize, yearOfBuilt = :yearOfBuilt")
                getSession().update(salesListing);
                commit();
//                getSession().flush();
                close();
        }
        catch (HibernateException e){
            e.printStackTrace();
            rollback();
        } finally {
            close();
        }

        return rowsAffacted;
    }

    public List getData(CombinedAccount combinedAccount, int limit, int offset){
        List<SalesListing> result = null;
        try {
            begin();
            Query q = getSession().createQuery("from Listing where combinedAccount = :combinedAccount");
            q.setParameter("combinedAccount", combinedAccount);
            q.setFirstResult(offset);
            q.setMaxResults(limit);
            result = q.list();
            commit();
//            getSession().flush();
            close();
        } catch (HibernateException e) {
            rollback();
        } finally {
            close();
        }

        return result;
    }

    public Number getRowCount(CombinedAccount combinedAccount){
        Number rowCount = 0;
        try {
            begin();
            Query q = getSession().createQuery("select count(*) from Listing where combinedAccount = :combinedAccount");
            q.setParameter("combinedAccount", combinedAccount);
            rowCount = (Number) q.uniqueResult();
            commit();
//            getSession().flush();
            close();
            return rowCount;
        } catch (HibernateException e) {
            rollback();
        } finally {
            close();
        }
        return rowCount;
    }

    public List getAllData(){
        List<SalesListing> result = null;
        try {
            begin();
            Query q = getSession().createQuery("from Listing");
            result = q.list();
            commit();
//            getSession().flush();
            close();
//
//            System.out.println(result.get(0).getAddress());
        } catch (HibernateException e) {
            rollback();
        } finally {
            close();
        }

        return result;
    }

    public int deleteRecord(int rowNumber, CombinedAccount combinedAccount){
        int rowAffacted = 0;

        try{
            begin();
            Query q = getSession().createQuery("delete from Listing where combinedAccount= :account and listingID = :listingID");
            q.setParameter("account", combinedAccount);
            q.setInteger("listingID", rowNumber);
            rowAffacted = q.executeUpdate();
            commit();
//            getSession().flush();
            close();
        }
        catch (HibernateException e){
            e.printStackTrace();
            rollback();
        } finally {
            close();
        }

        return rowAffacted;
    }

    public Listing findRecordByID(int rowNumber){
        Listing listing = null;

        try{
            begin();
            Query q = getSession().createQuery("from Listing where listingID = :listingID");
            q.setInteger("listingID", rowNumber);
            listing = (Listing) q.uniqueResult();
            commit();
//            getSession().flush();
            close();
        }catch (HibernateException e){
            e.printStackTrace();
            rollback();
        } finally {
            close();
        }
        return listing;
    }
}
