package proj.ListingPkg;

/**
 * Created by kym-1992 on 3/27/16.
 */
public enum ListingType {
    forSales("Sales Listing"), forLease("Lease Listing");

    private String value;
    private ListingType(String value){
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value;
    }
}
