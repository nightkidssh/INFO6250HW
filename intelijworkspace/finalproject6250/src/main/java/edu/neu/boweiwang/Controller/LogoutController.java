package edu.neu.boweiwang.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by kym-1992 on 4/5/16.
 */
@Controller
@RequestMapping("/logout.do")
public class LogoutController {
    @RequestMapping(method= RequestMethod.POST)
    protected ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception{
        request.getSession().invalidate();
        response.sendRedirect("realIndex.do");
        return null;
    }
}
