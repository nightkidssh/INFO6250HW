package Controller;

import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import proj.ListingPkg.SalesListing;

/**
 * Created by kym-1992 on 4/5/16.
 */
@Controller
@RequestMapping("/salesListing.do")
public class SalesListingController {
    @Autowired
    SalesListingValidator salesListingValidator;

    @RequestMapping(method = RequestMethod.POST)
    public String doSubmitAction(@ModelAttribute("salesListing") SalesListing salesListing, BindingResult result, HttpRequest httpRequest) throws Exception {
        salesListingValidator.validate(salesListing, result);
        if (result.hasErrors()) {
            return "salesListingForm";
        }

        try {

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
