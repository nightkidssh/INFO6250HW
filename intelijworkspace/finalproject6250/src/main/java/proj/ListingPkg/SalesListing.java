package proj.ListingPkg;

import proj.AccountPkg.CombinedAccount;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by kym-1992 on 4/4/16.
 */
@Entity
@Table(name="listing")
@DiscriminatorValue("S")
public class SalesListing extends Listing{
    @Column(name = "listPrice")
    private String listPrice;

    public SalesListing() {
    }

    public SalesListing(ListingType listingType, CombinedAccount combinedAccount, String address, String zipCode, String latitude, String longitude, String description, int numberOfBeds, int numberOfBaths, double sizeInSqft, double lotSize, String type, int yearOfBuilt, String heatingType, String propertyTax, String comments, String listPrice) {
        super(listingType, combinedAccount, address, zipCode, latitude, longitude, description, numberOfBeds, numberOfBaths, sizeInSqft, lotSize, type, yearOfBuilt, heatingType, propertyTax, comments);
        this.listPrice = listPrice;
    }

    public String getListPrice() {
        return listPrice;
    }

    public void setListPrice(String listPrice) {
        this.listPrice = listPrice;
    }
}
