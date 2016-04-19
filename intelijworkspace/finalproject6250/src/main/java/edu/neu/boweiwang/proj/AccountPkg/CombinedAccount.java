package edu.neu.boweiwang.proj.AccountPkg;

import edu.neu.boweiwang.proj.ListingPkg.Listing;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by kym-1992 on 3/30/16.
 */
//For Login

@Entity
@Table(name = "combinedAccounttable")
public class CombinedAccount {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="accountID", unique=true, nullable=false)
    private int accountID;

    @Column(name="userName")
    private String userName;

    @Column(name="password" )
    private String password;

    @Column(name="confirmPassword" )
    private String confirmPassword;

    @Column(name = "dateCreated")
    private Date dateCreated;

    @Column(name = "accountType")
    @Enumerated(EnumType.STRING)
    private AccountType accountType;

//    @GeneratedValue
//    @Column(name="personID", unique=true, nullable=false)
//    private int personID;

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "lastName")
    private String lastName;

    @Column(name = "sex")
    private String sex;

    @Column(name = "phoneNumber")
    private String phoneNumber;

    @Column(name = "emailAddress")
    private String emailAddress;

    @Column(name = "mailingAddress")
    private String mailingAddress;

    @Column(name = "zipCode")
    private String zipCode;

    @OneToMany(mappedBy = "combinedAccount", cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
    private Set<Listing> listings;

    public CombinedAccount(String userName, String password, Date dateCreated, AccountType accountType, String firstName, String lastName, String sex, String phoneNumber, String emailAddress, String mailingAddress, String zipCode) {
        this.userName = userName;
        this.password = password;
        this.dateCreated = dateCreated;
        this.accountType = accountType;
        this.firstName = firstName;
        this.lastName = lastName;
        this.sex = sex;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
        this.mailingAddress = mailingAddress;
        this.zipCode = zipCode;
        this.listings = new HashSet<Listing>();
    }

    public CombinedAccount() {
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public int getAccountID() {
        return accountID;
    }

    public void setAccountID(int accountID) {
        this.accountID = accountID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

//    public int getPersonID() {
//        return personID;
//    }
//
//    public void setPersonID(int personID) {
//        this.personID = personID;
//    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getMailingAddress() {
        return mailingAddress;
    }

    public void setMailingAddress(String mailingAddress) {
        this.mailingAddress = mailingAddress;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public Set<Listing> getListings() {
        return listings;
    }

    public void setListings(Set<Listing> listings) {
        this.listings = listings;
    }
}
