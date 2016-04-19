package edu.neu.boweiwang.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by kym-1992 on 4/19/16.
 */
@Controller
@RequestMapping(value = "/uploadimages.do")
public class FileUploadController {

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView handlePost(){
        return null;
    }


    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView handleGet(HttpServletRequest request, HttpServletResponse response){
        return null;
    }
}
