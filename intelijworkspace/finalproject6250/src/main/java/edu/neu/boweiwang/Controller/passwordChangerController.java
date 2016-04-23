package edu.neu.boweiwang.Controller;

import edu.neu.boweiwang.Dao.CombinedAccountDao;
import edu.neu.boweiwang.proj.AccountPkg.CombinedAccount;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by kym-1992 on 4/23/16.
 */
@Controller
@RequestMapping("/changePassword.do")
public class passwordChangerController {

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView doChangePassoword(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter out = response.getWriter();
        CombinedAccount combinedAccount = (CombinedAccount) request.getSession().getAttribute("loggedInAccount");
        if(combinedAccount == null){
            response.sendRedirect("realIndex.do");
        }
        else{
            String oldPassword = request.getParameter("oldPass");
            String newPassword = request.getParameter("newPass");
            String confirmPassword = request.getParameter("confirmPass");

            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            if(passwordEncoder.matches(oldPassword, combinedAccount.getPassword())){
                if(newPassword.matches("((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,20})")){
                    if(newPassword.equals(confirmPassword)){
                        CombinedAccountDao combinedAccountDao = new CombinedAccountDao();
                        combinedAccountDao.changePassoword(combinedAccount.getAccountID(), passwordEncoder.encode(newPassword));
                        request.getSession().invalidate();

                        out.println("<html>");
                        out.println("<body>");
                        out.println("<script>alert('Password changed successfully! Please login with your new password!')</script>");
                        out.println("<script>window.location = 'realIndex.do';</script>");
                        out.println("</body>");
                        out.println("</html>");
                    }
                    else{
                        return new ModelAndView("passwordChanger", "newPassError", "New Password does NOT match confirm password!");
                    }
                }
                else{
                    return new ModelAndView("passwordChanger", "newPassError", "New Password does NOT meet the requirement!");
                }
            }
            else{
                return new ModelAndView("passwordChanger", "oldPassError", "Wrong old password!");
            }
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
