package edu.neu.boweiwang.Dao;

import edu.neu.boweiwang.proj.AccountPkg.AccountType;
import edu.neu.boweiwang.proj.AccountPkg.CombinedAccount;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;


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
            q.setCacheable(true);
            combinedAccount = (CombinedAccount) q.uniqueResult();
            commit();
//            getSession().flush();
            close();
            return combinedAccount;
        } catch (HibernateException e) {
            rollback();
        } finally {
            close();
        }
        return combinedAccount;
    }

    public CombinedAccount findUniqueEmail(String emailAddress){
        CombinedAccount combinedAccount = null;
        try {
            begin();
            Query q = getSession().createQuery("from CombinedAccount where emailAddress = :emailAddress");
            q.setString("emailAddress", emailAddress);
            q.setCacheable(true);
            combinedAccount = (CombinedAccount) q.uniqueResult();
            commit();
//            getSession().flush();
            close();
            return combinedAccount;
        } catch (HibernateException e) {
            rollback();
        }finally {
            close();
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
//            getSession().flush();
            close();
            return combinedAccount;
        }catch (HibernateException e){
            rollback();
        } finally {
            close();
        }
        return null;
    }

    public List<CombinedAccount> getAllUser(){
        List<CombinedAccount> accountList;
        try {
            begin();
            Query q = getSession().createQuery("from CombinedAccount");
            q.setCacheable(true);
            accountList = q.list();
            commit();
//            getSession().flush();
            close();
            return accountList;
        } catch (HibernateException e) {
            rollback();
        } finally {
            close();
        }
        return null;
    }

    public List<CombinedAccount> getAllUserWithoutAdmin(){
        List<CombinedAccount> accountList;
        try {
            begin();
            Query q = getSession().createQuery("from CombinedAccount where accountType != :type");
            q.setParameter("type", AccountType.SystemAdmin);
            q.setCacheable(true);
            accountList = q.list();
            commit();
//            getSession().flush();
            close();
            return accountList;
        } catch (HibernateException e) {
            rollback();
        } finally {
            close();
        }
        return null;
    }

    public int deleteUser(int userID){
        int rowaffacted = 0;
        try{
            begin();
            Query q1 = getSession().createQuery("delete from Listing where combinedAccount.accountID = :accID");
            q1.setInteger("accID", userID);
            q1.executeUpdate();
            commit();
            close();

            begin();
            Query q = getSession().createQuery("delete from CombinedAccount where accountID = :accID");
            q.setInteger("accID", userID);
            rowaffacted = q.executeUpdate();
            commit();
//            getSession().flush();
            close();
        }catch (HibernateException e) {
            rollback();
        } finally {
            close();
        }
        return rowaffacted;
    }

    public int changePassoword(int userID, String newPassword){
        int rowaffacted = 0;
        try{
            begin();
            Query q1 = getSession().createQuery("update CombinedAccount set password = :newPassword where accountID= :userID");
            q1.setInteger("userID", userID);
            q1.setString("newPassword", newPassword);
            rowaffacted = q1.executeUpdate();
            commit();
            close();
        }catch (HibernateException e) {
            rollback();
        } finally {
            close();
        }
        return rowaffacted;
    }
}
