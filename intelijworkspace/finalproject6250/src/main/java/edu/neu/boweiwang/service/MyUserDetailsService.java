//package edu.neu.boweiwang.service;
//
//import edu.neu.boweiwang.Dao.CombinedAccountDao;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.transaction.annotation.Transactional;
//import edu.neu.boweiwang.proj.AccountPkg.CombinedAccount;
//
//import java.util.ArrayList;
//import java.util.HashSet;
//import java.util.List;
//import java.util.Set;
//
///**
// * Created by kym-1992 on 3/30/16.
// */
////@Service("userDetailsService")
//public class MyUserDetailsService implements UserDetailsService {
//
//    @Autowired
//    CombinedAccountDao combinedAccountDao;
//
//    @Transactional(readOnly = true)
//    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
//        CombinedAccount combinedAccount = combinedAccountDao.get(userName);
//        List<GrantedAuthority> authorities = buildUserAuthority(combinedAccount);
//
//        return buildUserForAuthentication(combinedAccount, authorities);
//    }
//
//    private User buildUserForAuthentication(CombinedAccount combinedAccount, List<GrantedAuthority> authorities) {
//        return new User(combinedAccount.getUserName(), combinedAccount.getPassword(), true, true, true, true, authorities);
//
//    }
//
//    private List<GrantedAuthority> buildUserAuthority(CombinedAccount combinedAccount) {
//
//        Set<GrantedAuthority> setAuths = new HashSet<GrantedAuthority>();
//
//        // Build user's authorities
//        setAuths.add(new SimpleGrantedAuthority(combinedAccount.getAccountType().getValue()));
//
//        List<GrantedAuthority> Result = new ArrayList<GrantedAuthority>(setAuths);
//
//        return Result;
//    }
//}
//
