package Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by kym-1992 on 4/1/16.
 */
@Controller
@RequestMapping("/realIndex.do")
public class RealIndexController {
    @RequestMapping(method = RequestMethod.GET)
    protected ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception{
        ModelAndView mv = new ModelAndView("realIndex");
        return  mv;
    }
}
