package Controller;

import Dao.AccountDao;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import proj.AccountPkg.Account;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by kym-1992 on 3/27/16.
 */
@Controller
@RequestMapping("/login.do")
public class LoginController {

    private AccountDao accountDao;

    @RequestMapping(method= RequestMethod.POST)
    protected ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception{
        accountDao = new AccountDao();
//        AccountDao accountDao = new AccountDao();
//        accountDao.create("a", "aa", AccountType.SystemAdmin, "Bowei", "Wang", "M", "1111111", "qqq@qq.com", "ccc", "xxx");
//
//        AccountDao accountDao = new AccountDao();
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");

        Account account = accountDao.get(userName);
        System.out.println(account.getPassword());

        if(account.getPassword().equals(password)){
            System.out.println("Success");
            HttpSession session = request.getSession();
            session.setAttribute("loggedInAccount", account);
        }
        else{
            System.out.println("Failed");
        }
        ModelAndView model = new ModelAndView("index");
        return model;
    }
}
