package proj.PersonPkg;

import proj.AccountPkg.Account;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by kym-1992 on 3/27/16.
 */
@Entity
@Table(name = "persontable")
public class Person {
    @Id
    @GeneratedValue
    @Column(name="personID", unique=true, nullable=false)
    private int personID;

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

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "person")
    private Set<Account> accounts = new HashSet<Account>(0);

    public Person(String firstName, String lastName, String sex, String phoneNumber, String emailAddress, String mailingAddress, String zipCode) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.sex = sex;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
        this.mailingAddress = mailingAddress;
        this.zipCode = zipCode;
    }

    public Person() {
    }

    public int getPersonID() {
        return personID;
    }

    public void setPersonID(int personID) {
        this.personID = personID;
    }

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
}
