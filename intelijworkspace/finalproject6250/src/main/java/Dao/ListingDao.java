package Dao;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import proj.AccountPkg.CombinedAccount;
import proj.ListingPkg.Listing;
import proj.ListingPkg.ListingType;
import proj.ListingPkg.SalesListing;

import java.util.List;

/**
 * Created by kym-1992 on 4/4/16.
 */
public class ListingDao extends DAO{
    public Listing createSales(ListingType listingType, CombinedAccount combinedAccount, String address, String zipCode, String latitude, String longitude, String description, int numberOfBeds, int numberOfBaths, double sizeInSqft, double lotSize, String type, int yearOfBuilt, String heatingType, String propertyTax, String comments, String listPrice){
        try{
//            begin();
//            SalesListing salesListing = new SalesListing( listingType,  combinedAccount,  address, zipCode, latitude,  longitude,  description,  numberOfBeds,  numberOfBaths,  sizeInSqft,  lotSize,  type,  yearOfBuilt,  heatingType,  propertyTax,  comments,  listPrice);
//            getSession().save(salesListing);
//            commit();

            if(listingType.equals(ListingType.forLease)){

            }

            else if(listingType.equals(ListingType.forSales)){
                begin();
                SalesListing salesListing = new SalesListing( listingType,  combinedAccount,  address, zipCode, latitude,  longitude,  description,  numberOfBeds,  numberOfBaths,  sizeInSqft,  lotSize,  type,  yearOfBuilt,  heatingType,  propertyTax,  comments,  listPrice);
                getSession().save(salesListing);
                commit();
                return salesListing;
            }

            else{
                return null;
            }
        }
        catch (HibernateException e){
            e.printStackTrace();
            rollback();
        }

        return null;
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

            System.out.println(result.get(0).getAddress());
        } catch (HibernateException e) {
            rollback();
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
            return rowCount;
        } catch (HibernateException e) {
            rollback();
        }
        return rowCount;
    }

    public List getAllData(){
        List<SalesListing> result = null;
        try {
            begin();
            Query q = getSession().createQuery("from Listing");
            result = q.list();

            System.out.println(result.get(0).getAddress());
        } catch (HibernateException e) {
            rollback();
        }

        return result;
    }
}
