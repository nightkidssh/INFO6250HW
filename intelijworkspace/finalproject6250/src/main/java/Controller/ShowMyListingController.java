package Controller;

import Dao.ListingDao;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import proj.AccountPkg.CombinedAccount;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by kym-1992 on 4/11/16.
 */
@Controller
@RequestMapping("/showmylisting.do")
public class ShowMyListingController {
    @RequestMapping(method = RequestMethod.GET)
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
//
        ListingDao listingDao = new ListingDao();
//        long count = listingDao.getRowCount(combinedAccount).longValue();
//
//        if(page > count/100+1){
//            page = (int)(count/100 +1);
//        }

        List resultSet = listingDao.getData(combinedAccount, 100, page * 100);

        ModelAndView mv = new ModelAndView("showMyListing");
        mv.addObject("resultSet", resultSet);
        mv.addObject("currentPage", page);
//        mv.addObject("maxPage", (int)(count/100 +1));
        return mv;
    }
}
