package proj.AccountPkg;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by kym-1992 on 3/30/16.
 */
//For Login

@Entity
@Table(name = "combinedAccounttable")
public class CombinedAccount {
    @Id
    @GeneratedValue
    @Column(name="accountID", unique=true, nullable=false)
    private int accountID;

    @Column(name="userName")
    private String userName;

    @Column(name="password" )
    private String password;

    @Column(name = "dateCreated")
    private Date dateCreated;

    @Column(name = "accountType")
    @Enumerated(EnumType.STRING)
    private AccountType accountType;

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
    }

    public CombinedAccount() {
    }

}
