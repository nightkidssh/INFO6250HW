package Controller;

import Dao.AccountDao;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import proj.AccountPkg.AccountType;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by kym-1992 on 3/27/16.
 */
@Controller
@RequestMapping("/login.do")
public class LoginController {

    @RequestMapping(method= RequestMethod.POST)
    protected ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception{
        AccountDao accountDao = new AccountDao();
        accountDao.create("a", "aa", AccountType.SystemAdmin, "Bowei", "Wang", "M", "1111111", "qqq@qq.com", "ccc", "xxx");

        ModelAndView model = new ModelAndView("index");

        return model;
    }
}
