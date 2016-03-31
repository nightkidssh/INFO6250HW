package Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by kym-1992 on 3/27/16.
 */
@Controller
//@RequestMapping("/login.do")
public class LoginController {

//    private AccountDao accountDao;
//
//    @RequestMapping(method= RequestMethod.POST)
//    protected ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception{
////        accountDao = new AccountDao();
////        accountDao.create("a", "aa", AccountType.SystemAdmin, "Bowei", "Wang", "M", "1111111", "qqq@qq.com", "ccc", "xxx");
//        CombinedAccountDao combinedAccountDao = new CombinedAccountDao();
//
//        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//        String hashedPassword = passwordEncoder.encode("aa");
//        combinedAccountDao.create("a", hashedPassword, new Date(), AccountType.SystemAdmin, "Bowei", "Wang", "M", "1111111", "qqq@qq.com", "ccc", "111");
//
////        String userName = request.getParameter("userName");
////        String password = request.getParameter("password");
////
////        Account account = accountDao.get(userName);
////        System.out.println(account.getPassword());
////
////        if(account.getPassword().equals(password)){
////            System.out.println("Success");
////            HttpSession session = request.getSession();
////            session.setAttribute("loggedInAccount", account);
////        }
////        else{
////            System.out.println("Failed");
////        }
//
//        ModelAndView model = new ModelAndView("index");
//        return model;
//    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login(@RequestParam(value = "error", required = false) String error,
                              @RequestParam(value = "logout", required = false) String logout) {

        ModelAndView model = new ModelAndView();
        if (error != null) {
            model.addObject("error", "Invalid username and password!");
        }

        if (logout != null) {
            model.addObject("msg", "You've been logged out successfully.");
        }
        model.setViewName("login");

        return model;

    }
}
