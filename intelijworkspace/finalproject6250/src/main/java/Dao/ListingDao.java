package Dao;

import org.hibernate.HibernateException;
import proj.AccountPkg.CombinedAccount;
import proj.ListingPkg.Listing;
import proj.ListingPkg.ListingType;
import proj.ListingPkg.SalesListing;

/**
 * Created by kym-1992 on 4/4/16.
 */
public class ListingDao extends DAO{
    public Listing create(ListingType listingType, CombinedAccount combinedAccount, String address, String zipCode, String latitude, String longitude, String description, int numberOfBeds, int numberOfBaths, double sizeInSqft, double lotSize, String type, int yearOfBuilt, String heatingType, String propertyTax, String comments, String listPrice){
        try{
            begin();
            if(listingType == ListingType.forLease){

            }

            else if(listingType == ListingType.forSales){
                SalesListing salesListing = new SalesListing( listingType,  combinedAccount,  address, zipCode, latitude,  longitude,  description,  numberOfBeds,  numberOfBaths,  sizeInSqft,  lotSize,  type,  yearOfBuilt,  heatingType,  propertyTax,  comments,  listPrice);
                getSession().save(salesListing);

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
}
