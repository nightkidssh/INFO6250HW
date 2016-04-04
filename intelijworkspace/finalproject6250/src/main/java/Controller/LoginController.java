package Controller;

import Dao.CombinedAccountDao;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import proj.AccountPkg.AccountType;
import proj.AccountPkg.CombinedAccount;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;

/**
 * Created by kym-1992 on 3/27/16.
 */
@Controller
@RequestMapping("/login.do")
public class LoginController {

    @RequestMapping(method= RequestMethod.POST)
    protected ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception{
        CombinedAccountDao combinedAccountDao = new CombinedAccountDao();

        combinedAccountDao.create("a", "aa", new Date(), AccountType.SystemAdmin, "Bowei", "Wang", "M", "1111111", "qqq@qq.com", "ccc", "111");

        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");

        CombinedAccount account = combinedAccountDao.get(userName);
//        System.out.println(account.getPassword());

        if(account!=null){
            if(passwordEncoder.matches(password, account.getPassword()) == true){
                HttpSession session = request.getSession();
                session.setAttribute("loggedInAccount", account);
            }
            else{
                request.setAttribute("Error", "Login Failed! Please check your input!");
            }
//            System.out.println("Success");
        }
        else{
            request.setAttribute("Error", "Login Failed! No such user!");
        }

        ModelAndView model = new ModelAndView("realIndex");
        return model;
    }

//    @RequestMapping(value = "/login", method = RequestMethod.GET)
//    public ModelAndView login(@RequestParam(value = "error", required = false) String error,
//                              @RequestParam(value = "logout", required = false) String logout) {
//
//        ModelAndView model = new ModelAndView();
//        if (error != null) {
//            model.addObject("error", "Invalid username and password!");
//        }
//
//        if (logout != null) {
//            model.addObject("msg", "You've been logged out successfully.");
//        }
//        model.setViewName("login");
//
//        return model;
//
//    }
}
