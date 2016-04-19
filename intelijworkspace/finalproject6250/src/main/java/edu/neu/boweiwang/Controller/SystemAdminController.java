package edu.neu.boweiwang.Controller;

import edu.neu.boweiwang.Dao.CombinedAccountDao;
import edu.neu.boweiwang.proj.AccountPkg.AccountType;
import edu.neu.boweiwang.proj.AccountPkg.CombinedAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by kym-1992 on 4/18/16.
 */
@Controller
@RequestMapping("/sysadminpanel.do")
public class SystemAdminController {

    @Autowired
    CombinedAccountDao combinedAccountDao;

    public SystemAdminController() {
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView handleGet(HttpServletRequest request){
        List resultList = combinedAccountDao.getAllUserWithoutAdmin();

        ModelAndView mv = new ModelAndView("systemAdminPanel");
        mv.addObject("resultSet", resultList);
        return mv;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView handlePost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        CombinedAccount combinedAccount;
        if(request.getSession().getAttribute("loggedInAccount") != null) {
            combinedAccount = (CombinedAccount) request.getSession().getAttribute("loggedInAccount");
            if(combinedAccount.getAccountType()== AccountType.SystemAdmin) {

                int accountID = Integer.parseInt(request.getParameter("accountID"));
                combinedAccountDao.deleteUser(accountID);
            }
            else{
                response.sendRedirect("realIndex.do");
            }
        }
        else{
            response.sendRedirect("realIndex.do");
        }

        return null;
    }
}
