package edu.neu.boweiwang.Controller;

import edu.neu.boweiwang.Dao.ListingDao;
import edu.neu.boweiwang.proj.AccountPkg.CombinedAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by kym-1992 on 4/21/16.
 */
@Controller
@RequestMapping("/buyerlisting.do")
public class ShowListingForBuyerController {
    @Autowired
    ListingDao listingDao;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView fetchAndShowData(HttpServletRequest request, HttpServletResponse response) {
        CombinedAccount combinedAccount = (CombinedAccount) request.getSession().getAttribute("loggedInAccount");
        if(combinedAccount == null){
            ModelAndView mv = new ModelAndView("realIndex");
            return mv;
        }

        int page = 0;

        List resultSet = null;
        if(request.getParameter("beds") == null) {
            resultSet = listingDao.getAllData();
        }

        else{
            if(request.getParameter("beds").matches("[0-9]+")) {
                resultSet = listingDao.getDataWithRestriction(Integer.parseInt(request.getParameter("beds")));
            }
            else{
                resultSet = listingDao.getAllData();
            }
        }

        ModelAndView mv = new ModelAndView("showListingForBuyer");
        mv.addObject("resultSet", resultSet);
        mv.addObject("currentPage", page);
//        mv.addObject("maxPage", count/100 +1);
        return mv;
    }
}
