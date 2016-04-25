package edu.neu.boweiwang.Controller;

import edu.neu.boweiwang.Dao.CombinedAccountDao;
import edu.neu.boweiwang.proj.AccountPkg.AccountType;
import edu.neu.boweiwang.proj.AccountPkg.CombinedAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.InvalidAuthorizationException;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.social.facebook.api.User;
import org.springframework.social.facebook.api.impl.FacebookTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;

/**
 * Created by kym-1992 on 4/24/16.
 */
@Controller
@RequestMapping("/facebook.do")
public class FacebookController {

    @Autowired
    CombinedAccountDao combinedAccountDao;

    @RequestMapping(method= RequestMethod.POST)
    protected ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception{
        String accessToken = request.getParameter("token");

        if(accessToken!=null) {
            try {
                Facebook facebook = new FacebookTemplate(accessToken);

                User profile = facebook.userOperations().getUserProfile();
                String facebookID = profile.getId();

                CombinedAccount combinedAccount = combinedAccountDao.get(facebookID);

                if (combinedAccount == null) {
                    combinedAccount = combinedAccountDao.create(facebookID, accessToken, new Date(), AccountType.HomeBuyer, profile.getFirstName(), profile.getLastName(), profile.getGender(), null, profile.getEmail(), null, null);
                    HttpSession session = request.getSession();
                    session.setAttribute("loggedInAccount", combinedAccount);
                    response.sendRedirect("realIndex.do");
                } else {
                    HttpSession session = request.getSession();
                    session.setAttribute("loggedInAccount", combinedAccount);
                    response.sendRedirect("realIndex.do");
                }

                System.out.println(profile.getEmail());
            }
            catch (InvalidAuthorizationException e){
                request.setAttribute("Error", "Login Failed! Facebook Login Error!");
                ModelAndView model = new ModelAndView("realIndex");
                return model;
            }
        }

        else{
            request.setAttribute("Error", "Login Failed! Facebook Login Error: Invalid User!");
            ModelAndView model = new ModelAndView("realIndex");
            return model;
        }

        return null;
    }
}
