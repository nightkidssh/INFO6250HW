package edu.neu.boweiwang.Controller;

import edu.neu.boweiwang.proj.AccountPkg.CombinedAccount;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by kym-1992 on 4/23/16.
 */
@Controller
@RequestMapping("/changePassword.do")
public class passwordChangerController {

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView doChangePassoword(HttpServletRequest request, HttpServletResponse response) throws IOException {
        CombinedAccount combinedAccount = (CombinedAccount) request.getSession().getAttribute("loggedInAccount");
        if(combinedAccount == null){
            response.sendRedirect("realIndex.do");
        }
        else{

        }
        return null;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView populateForm(HttpServletRequest request, HttpServletResponse response) throws IOException {
        CombinedAccount combinedAccount = (CombinedAccount) request.getSession().getAttribute("loggedInAccount");
        if(combinedAccount == null){
            response.sendRedirect("realIndex.do");
        }
        return new ModelAndView("passwordChanger");
    }
}
