package edu.neu.boweiwang.Controller;

import org.springframework.social.facebook.api.Facebook;
import org.springframework.social.facebook.api.User;
import org.springframework.social.facebook.api.impl.FacebookTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by kym-1992 on 4/24/16.
 */
@Controller
@RequestMapping("/facebook.do")
public class FacebookController {

    @RequestMapping(method= RequestMethod.GET)
    protected ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception{
        String accessToken =
                "CAAYMTvYiJtIBAOYHl92qlwhXbuObHJRYvOm6zk3U2Vx9PxEtXXwOhLTfK6ZBFjOOFGZBmjhVZA4JwflDOruyh7nwSLb1ZBW7iuuA6ANYUoGCIXKCEG6moOemqeYh3eqavB5XeK4E2WcctwbIR94XspFEzH8y1BYCU6WfvZBBRki6g8btDbyZA8sFKFwZAAW7TdCTKQ6LUw40AZDZD";
        Facebook facebook = new FacebookTemplate(accessToken);

        User profile = facebook.userOperations().getUserProfile();

        System.out.println(profile.getEmail());

        return null;
    }
}
