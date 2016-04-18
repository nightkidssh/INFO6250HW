package edu.neu.boweiwang.Controller;

import edu.neu.boweiwang.Dao.ListingDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import edu.neu.boweiwang.proj.AccountPkg.CombinedAccount;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by kym-1992 on 4/11/16.
 */
@Controller
//@RequestMapping("/showmylisting.do")
public class ShowMyListingController {
    @Autowired
    ListingDao listingDao;

    @RequestMapping(value = "/showmylisting.do", method = RequestMethod.GET)
    public ModelAndView fetchAndShowData(HttpServletRequest request, HttpServletResponse response) {
        CombinedAccount combinedAccount = (CombinedAccount) request.getSession().getAttribute("loggedInAccount");
        if(combinedAccount == null){
            ModelAndView mv = new ModelAndView("realIndex");
            return mv;
        }

        int page = 0;

//        if(request.getParameter("page") !=null){
//            page = Integer.parseInt(request.getParameter("page")) - 1;
//        }

//        ListingDao listingDao = new ListingDao();

//        int count = listingDao.getRowCount(combinedAccount).intValue();

//        if(page > count/100+1){
//            page = count/100 +1;
//        }
//
//        System.out.println(page);
//        System.out.println(count);

        List resultSet = listingDao.getData(combinedAccount, 100, page * 100);

        ModelAndView mv = new ModelAndView("showMyListing");
        mv.addObject("resultSet", resultSet);
        mv.addObject("currentPage", page);
//        mv.addObject("maxPage", count/100 +1);
        return mv;
    }

    @RequestMapping(value = "/showmylisting.do", method = RequestMethod.POST)
    public ModelAndView deleteRecord(HttpServletRequest request, HttpServletResponse response) {
        CombinedAccount combinedAccount;
        if(request.getSession().getAttribute("loggedInAccount") != null) {
            combinedAccount = (CombinedAccount) request.getSession().getAttribute("loggedInAccount");
            int listingID = Integer.parseInt(request.getParameter("listingID"));
            listingDao.deleteRecord(listingID, combinedAccount);
        }
        else{
            return new ModelAndView("realIndex");
        }

        return null;
    }
}
