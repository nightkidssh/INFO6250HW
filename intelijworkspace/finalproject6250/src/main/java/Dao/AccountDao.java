package Dao;

import org.hibernate.HibernateException;
import proj.AccountPkg.Account;
import proj.AccountPkg.AccountType;
import proj.PersonPkg.Person;

import java.util.Date;

/**
 * Created by kym-1992 on 3/28/16.
 */
public class AccountDao extends DAO{

    public AccountDao() {
    }

    public Account get(String username){
        return null;
    }

    public Account create(String userName, String password, AccountType accountType,
                          String firstName, String lastName, String sex, String phoneNumber, String emailAddress, String mailingAddress, String zipCode){
        try {
            begin();
            Person person = new Person(firstName, lastName, sex, phoneNumber, emailAddress, mailingAddress, zipCode);
            Account account = new Account(userName, password, new Date(), accountType);

            person.setAccount(account);
            account.setPerson(person);

            getSession().save(person);
            getSession().save(account);

            commit();
            return account;
        }catch (HibernateException e){
            rollback();
        }
        return null;
    }
}
