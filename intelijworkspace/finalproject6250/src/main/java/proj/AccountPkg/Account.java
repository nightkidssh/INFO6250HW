package proj.AccountPkg;

import proj.PersonPkg.Person;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by kym-1992 on 3/27/16.
 */
@Entity
@Table(name = "accounttable")
public class Account {

    @Id
    @GeneratedValue
    @Column(name="accountID", unique=true, nullable=false)
    private int accountID;

    @Column(name="userName")
    private String userName;

    @Column(name="password" )
    private String password;

    @OneToOne(mappedBy = "account", cascade=CascadeType.ALL)
    private Person person;

    @Column(name = "dateCreated")
    private Date dateCreated;

    @Column(name = "accountType")
    @Enumerated(EnumType.STRING)
    private AccountType accountType;

    public Account(String userName, String password, Date dateCreated, AccountType accountType) {
        this.userName = userName;
        this.password = password;
        this.dateCreated = dateCreated;
        this.accountType = accountType;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    public int getAccountID() {
        return accountID;
    }

    public void setAccountID(int accountID) {
        this.accountID = accountID;
    }
    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
