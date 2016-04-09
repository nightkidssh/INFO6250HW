package Controller;

import Dao.CombinedAccountDao;
import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import proj.AccountPkg.AccountType;
import proj.AccountPkg.CombinedAccount;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;

/**
 * Created by kym-1992 on 4/1/16.
 */
@Controller
@RequestMapping("/registerAPI.do")
public class RegisterControllerWithAPI {
    @Autowired
    RegisterValidator validator;

    @InitBinder
    private void initBinder(WebDataBinder binder){
        binder.setValidator(validator);
    }

    public RegisterControllerWithAPI() {
    }

    @RequestMapping(method = RequestMethod.POST)
    public String doSubmitAction(@ModelAttribute("user") CombinedAccount account, BindingResult result, HttpServletRequest request) throws Exception {
        validator.validate(account, result);
        if (result.hasErrors()) {
            return "registerWithAPI";
        }

        try {
            System.out.print("test");
            CombinedAccountDao combinedAccountDao = new CombinedAccountDao();
            System.out.print("test1");

            combinedAccountDao.create(account.getUserName(), account.getPassword(), new Date(), account.getAccountType(), account.getFirstName(), account.getLastName()
                    , account.getSex(), account.getPhoneNumber(), account.getEmailAddress(), account.getMailingAddress(), account.getZipCode());

            if(request.isRequestedSessionIdValid() == false) {
                HttpSession session = request.getSession();
                session.invalidate();
                session.setAttribute("loggedInAccount", account);
            }
            else{
                HttpSession session = request.getSession();
                session.setAttribute("loggedInAccount", account);
            }
            // DAO.close();
        } catch (HibernateException e) {
            System.out.println("Exception: " + e.getMessage());
        }

        return "realIndex";
    }


    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView initializeForm(@ModelAttribute("user")CombinedAccount account, BindingResult result) {
        ModelAndView mv = new ModelAndView("registerWithAPI");
        mv.addObject("accountEnum", AccountType.values());
        return mv;
    }
}
