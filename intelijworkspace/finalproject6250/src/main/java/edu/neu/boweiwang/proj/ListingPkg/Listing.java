package edu.neu.boweiwang.proj.ListingPkg;

import edu.neu.boweiwang.proj.AccountPkg.CombinedAccount;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.io.Serializable;


/**
 * Created by kym-1992 on 3/27/16.
 */
@Entity
@Table(name = "listing")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(
        name="discriminator",
        discriminatorType=DiscriminatorType.STRING
)
@DiscriminatorValue(value="P")
public class Listing implements Serializable {
    @Id
    @GeneratedValue
    @Column(name = "listingID")
    private int listingID;

    @Column(name = "listingType")
    @Enumerated(EnumType.STRING)
    private ListingType listingType;

    @ManyToOne
    @JoinColumn(name = "accountID")
    private CombinedAccount combinedAccount;

    @Column(name = "address")
    private String address;

    @Column(name = "zipCode")
    private String zipCode;

    @Column(name = "latitude")
    private String latitude;

    @Column(name = "longitude")
    private String longitude;

    @Column(name = "description")
    private String description;

    @Column(name = "numberOfBeds")
    private int numberOfBeds;

    @Column(name = "numberOfBaths")
    private int numberOfBaths;

    @Column(name = "sizeInSqft")
    private double sizeInSqft;

    @Column(name = "lotSize")
    private double lotSize;

    @Column(name = "type")
    private String type;

    @Column(name = "yearOfBuilt")
    private int yearOfBuilt;

    @Column(name = "heatingType")
    private String heatingType;

    @Column(name = "propertyTax")
    private String propertyTax;

    @Column(name = "comments")
    private String comments;

    @Column(name = "filePath1")
    private String fileLocation1;

    @Column(name = "filePath2")
    private String fileLocation2;

    @Column(name = "filePath3")
    private String fileLocation3;

    @Column(name = "filePath4")
    private String fileLocation4;

    @Transient
    private MultipartFile file1;

    @Transient
    private MultipartFile file2;

    @Transient
    private MultipartFile file3;

    @Transient
    private MultipartFile file4;

    public Listing() {
    }

    public Listing(ListingType listingType, CombinedAccount combinedAccount, String address, String zipCode, String latitude, String longitude, String description, int numberOfBeds, int numberOfBaths, double sizeInSqft, double lotSize, String type, int yearOfBuilt, String heatingType, String propertyTax, String comments) {
        this.listingType = listingType;
        this.combinedAccount = combinedAccount;
        this.address = address;
        this.zipCode = zipCode;
        this.latitude = latitude;
        this.longitude = longitude;
        this.description = description;
        this.numberOfBeds = numberOfBeds;
        this.numberOfBaths = numberOfBaths;
        this.sizeInSqft = sizeInSqft;
        this.lotSize = lotSize;
        this.type = type;
        this.yearOfBuilt = yearOfBuilt;
        this.heatingType = heatingType;
        this.propertyTax = propertyTax;
        this.comments = comments;
    }

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

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
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

//    public String getSalesPrice() {
//        return salesPrice;
//    }
//
//    public void setSalesPrice(String salesPrice) {
//        this.salesPrice = salesPrice;
//    }
//
//    public String getLeasePrice() {
//        return leasePrice;
//    }
//
//    public void setLeasePrice(String leasePrice) {
//        this.leasePrice = leasePrice;
//    }

    public CombinedAccount getCombinedAccount() {
        return combinedAccount;
    }

    public void setCombinedAccount(CombinedAccount combinedAccount) {
        this.combinedAccount = combinedAccount;
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

    public String getFileLocation1() {
        return fileLocation1;
    }

    public void setFileLocation1(String fileLocation1) {
        this.fileLocation1 = fileLocation1;
    }

    public String getFileLocation2() {
        return fileLocation2;
    }

    public void setFileLocation2(String fileLocation2) {
        this.fileLocation2 = fileLocation2;
    }

    public String getFileLocation3() {
        return fileLocation3;
    }

    public void setFileLocation3(String fileLocation3) {
        this.fileLocation3 = fileLocation3;
    }

    public String getFileLocation4() {
        return fileLocation4;
    }

    public void setFileLocation4(String fileLocation4) {
        this.fileLocation4 = fileLocation4;
    }

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }
}
