package Controller;

import Dao.CombinedAccountDao;
import org.json.JSONObject;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import proj.AccountPkg.CombinedAccount;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by kym-1992 on 3/27/16.
 */
@Controller
@RequestMapping("/login.do")
public class LoginController {

    private static final String googleURL = "https://www.google.com/recaptcha/api/siteverify";
    private static final String secret = "6LeqjBwTAAAAAPxaF5k_ozGsutOxl0PvZ4YDv0tA";

    @RequestMapping(method= RequestMethod.POST)
    protected ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception{
        CombinedAccountDao combinedAccountDao = new CombinedAccountDao();

//        combinedAccountDao.create("a", "aa", new Date(), AccountType.SystemAdmin, "Bowei", "Wang", "M", "1111111", "qqq@qq.com", "ccc", "111");

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");

        String grecaptcharesponse = request.getParameter("g-recaptcha-response");
        String ipAddress = request.getHeader("X-FORWARDED-FOR");
        if (ipAddress == null) {
            ipAddress = request.getRemoteAddr();
        }

        try {
            URL urlObj = new URL(googleURL);

            HttpURLConnection connection =
                    (HttpURLConnection) urlObj.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("User-Agent", "Mozilla/5.0");
            connection.setRequestProperty("Accept-Language", "en-US,en;q=0.5");

            String postParams = "secret=" + secret + "&response="
                    + grecaptcharesponse;

            // Send post request
            connection.setDoOutput(true);
            DataOutputStream wr = new DataOutputStream(connection.getOutputStream());
            wr.writeBytes(postParams);
            wr.flush();
            wr.close();

            InputStream json = connection.getInputStream();

            BufferedReader streamReader = new BufferedReader(new InputStreamReader(json));
            StringBuilder responseStrBuilder = new StringBuilder();

            String inputStr;
            while ((inputStr = streamReader.readLine()) != null) {
                responseStrBuilder.append(inputStr);
            }
            JSONObject jsonObject = new JSONObject(responseStrBuilder.toString());
            Boolean success = (Boolean) jsonObject.get("success");

            if(success == false){
                request.setAttribute("Error", "Please finish the CAPTCHA!");
                ModelAndView model = new ModelAndView("realIndex");
                return model;
            }

        }catch (Exception e){
            e.printStackTrace();
        }


        CombinedAccount account = combinedAccountDao.get(userName);

        if(account!=null){
            if(passwordEncoder.matches(password, account.getPassword()) == true){
                HttpSession session = request.getSession();
                session.setAttribute("loggedInAccount", account);
                response.sendRedirect("showmylisting.do");
            }
            else{
                request.setAttribute("Error", "Login Failed! Please check your input!");
            }

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
