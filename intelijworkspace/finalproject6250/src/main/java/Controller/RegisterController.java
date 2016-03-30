package Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import proj.AccountPkg.Account;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by kym-1992 on 3/28/16.
 */
@Controller
@RequestMapping("/register.do")
public class RegisterController{

    @RequestMapping(method= RequestMethod.POST)
    protected ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception{
        String status = request.getParameter("registerStatus");
        if(status.equals("init")){
            Account account = new Account();

            ModelAndView model = new ModelAndView();
            model.setViewName("register");
            return model;
        }

        else if(status.equals("doRegister")){
            boolean valid = false;

            ModelAndView mv;
            if(valid == true){
                mv = new ModelAndView("index");
            }
            else{
                mv = new ModelAndView("register");
            }
            return mv;
        }

//        else {
//            AccountDao accountDao = new AccountDao();
//            accountDao.create("a", "aa", AccountType.SystemAdmin, "Bowei", "Wang", "M", "1111111", "qqq@qq.com", "ccc", "xxx");
//
//            ModelAndView model = new ModelAndView("HelloWorldPage");
//            model.addObject("msg", "hello world");
//
//            return model;
//        }
        else{
            ModelAndView model = new ModelAndView();
            model.setViewName("register");
            return model;
        }
    }
//
//    @RequestMapping(value = "/register.do", method = RequestMethod.POST)
//    public String showRegisterForm(Model model){
//        Account account = new Account();
//        model.addAttribute("accountForm", account);
//
//        return "register";
//    }
//
//    @RequestMapping(value = "/register.do/doRegister", method = RequestMethod.POST)
//    public String createUser(@ModelAttribute("accountForm")Account account, BindingResult result, Model model){
//        return null;
//    }

}
