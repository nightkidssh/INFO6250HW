package edu.neu.boweiwang.Dao;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;
import edu.neu.boweiwang.proj.AccountPkg.AccountType;
import edu.neu.boweiwang.proj.AccountPkg.CombinedAccount;

import java.util.Date;


/**
 * Created by kym-1992 on 3/30/16.
 */
@Repository
public class CombinedAccountDao extends DAO{
    public CombinedAccountDao() {
    }

    public CombinedAccount get(String username){
        CombinedAccount combinedAccount = null;
        try {
            begin();
            Query q = getSession().createQuery("from CombinedAccount where userName = :username");
            q.setString("username", username);
            combinedAccount = (CombinedAccount) q.uniqueResult();
            commit();
            return combinedAccount;
        } catch (HibernateException e) {
            rollback();
        }
        return combinedAccount;
    }

    public CombinedAccount findUniqueEmail(String emailAddress){
        CombinedAccount combinedAccount = null;
        try {
            begin();
            Query q = getSession().createQuery("from CombinedAccount where emailAddress = :emailAddress");
            q.setString("emailAddress", emailAddress);
            combinedAccount = (CombinedAccount) q.uniqueResult();
            commit();
            return combinedAccount;
        } catch (HibernateException e) {
            rollback();
        }
        return combinedAccount;
    }

    public CombinedAccount create(String userName, String password, Date dateCreated, AccountType accountType, String firstName, String lastName, String sex, String phoneNumber, String emailAddress, String mailingAddress, String zipCode){
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        try {
            begin();

            CombinedAccount combinedAccount = new CombinedAccount(userName, passwordEncoder.encode(password), dateCreated, accountType, firstName, lastName, sex, phoneNumber, emailAddress, mailingAddress, zipCode);
            getSession().save(combinedAccount);

            commit();
            return combinedAccount;
        }catch (HibernateException e){
            rollback();
        }
        return null;
    }
}
