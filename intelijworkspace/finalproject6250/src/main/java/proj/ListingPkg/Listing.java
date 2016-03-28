package proj.ListingPkg;

/**
 * Created by kym-1992 on 3/27/16.
 */
public class Listing {
    private int listingID;
    private ListingType listingType;
    private String address;
    private String description;
    private int numberOfBeds;
    private int numberOfBaths;
    private double sizeInSqft;
    private String salesPrice;
    private String leasePrice;
    private double lotSize;
    private String type;
    private int yearOfBuilt;
    private String heatingType;
    private String propertyTax;

    public int getListingID() {
        return listingID;
    }

    public void setListingID(int listingID) {
        this.listingID = listingID;
    }

    public ListingType getListingType() {
        return listingType;
    }

    public void setListingType(ListingType listingType) {
        this.listingType = listingType;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getNumberOfBeds() {
        return numberOfBeds;
    }

    public void setNumberOfBeds(int numberOfBeds) {
        this.numberOfBeds = numberOfBeds;
    }

    public int getNumberOfBaths() {
        return numberOfBaths;
    }

    public void setNumberOfBaths(int numberOfBaths) {
        this.numberOfBaths = numberOfBaths;
    }

    public double getSizeInSqft() {
        return sizeInSqft;
    }

    public void setSizeInSqft(double sizeInSqft) {
        this.sizeInSqft = sizeInSqft;
    }

    public String getSalesPrice() {
        return salesPrice;
    }

    public void setSalesPrice(String salesPrice) {
        this.salesPrice = salesPrice;
    }

    public String getLeasePrice() {
        return leasePrice;
    }

    public void setLeasePrice(String leasePrice) {
        this.leasePrice = leasePrice;
    }

    public double getLotSize() {
        return lotSize;
    }

    public void setLotSize(double lotSize) {
        this.lotSize = lotSize;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getYearOfBuilt() {
        return yearOfBuilt;
    }

    public void setYearOfBuilt(int yearOfBuilt) {
        this.yearOfBuilt = yearOfBuilt;
    }

    public String getHeatingType() {
        return heatingType;
    }

    public void setHeatingType(String heatingType) {
        this.heatingType = heatingType;
    }

    public String getPropertyTax() {
        return propertyTax;
    }

    public void setPropertyTax(String propertyTax) {
        this.propertyTax = propertyTax;
    }
}
