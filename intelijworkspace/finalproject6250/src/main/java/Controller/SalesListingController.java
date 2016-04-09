package Controller;

import Dao.ListingDao;
import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import proj.AccountPkg.CombinedAccount;
import proj.ListingPkg.SalesListing;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by kym-1992 on 4/5/16.
 */
@Controller
@RequestMapping("/salesListing.do")
public class SalesListingController {
    @Autowired
    SalesListingValidator salesListingValidator;

    @InitBinder
    private void initBinder(WebDataBinder binder){
        binder.setValidator(salesListingValidator);
    }

    @RequestMapping(method = RequestMethod.POST)
    public String doSubmitAction(@ModelAttribute("salesListing") SalesListing salesListing, BindingResult result, HttpServletRequest request) throws Exception {
        salesListingValidator.validate(salesListing, result);
        if (result.hasErrors()) {
            return "salesListingForm";
        }

        CombinedAccount combinedAccount = (CombinedAccount) request.getSession().getAttribute("loggedInAccount");
        if(combinedAccount == null){
            return "realIndex";
        }

        try {
            ListingDao listingDao = new ListingDao();
            listingDao.createSales(salesListing.getListingType(), combinedAccount, salesListing.getAddress(), salesListing.getZipCode(), salesListing.getLatitude(), salesListing.getLongitude(),
                    salesListing.getDescription(), salesListing.getNumberOfBeds(), salesListing.getNumberOfBaths(), salesListing.getSizeInSqft(), salesListing.getLotSize(), salesListing.getType(),
                    salesListing.getYearOfBuilt(), salesListing.getHeatingType(), salesListing.getPropertyTax(), salesListing.getComments(), salesListing.getListPrice());

        } catch (HibernateException e) {
            System.out.println("Exception: " + e.getMessage());
        }

        return "realIndex";
    }


    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView initializeForm(@ModelAttribute("salesListing")SalesListing salesListing, BindingResult result) {
        ModelAndView mv = new ModelAndView("salesListingForm");
        return mv;
    }
}
