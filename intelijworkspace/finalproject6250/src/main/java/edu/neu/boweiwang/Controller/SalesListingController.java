package edu.neu.boweiwang.Controller;

import edu.neu.boweiwang.Dao.ListingDao;
import edu.neu.boweiwang.proj.AccountPkg.CombinedAccount;
import edu.neu.boweiwang.proj.ListingPkg.Listing;
import edu.neu.boweiwang.proj.ListingPkg.SalesListing;
import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;

/**
 * Created by kym-1992 on 4/5/16.
 */
@Controller
@RequestMapping("/salesListing.do")
public class SalesListingController {
    @Autowired
    SalesListingValidator salesListingValidator;

    @Autowired
    ServletContext servletContext;

    @Autowired
    ListingDao listingDao;

    @InitBinder
    private void initBinder(WebDataBinder binder){
        binder.setValidator(salesListingValidator);
    }

    @RequestMapping(method = RequestMethod.POST)
    public String doSubmitAction(@ModelAttribute("salesListing") SalesListing salesListing, BindingResult result, HttpServletRequest request, HttpServletResponse response,
                                 @RequestParam("file1") MultipartFile ffile1, @RequestParam("file2") MultipartFile ffile2, @RequestParam("file3") MultipartFile ffile3, @RequestParam("file4") MultipartFile ffile4) throws Exception {
        salesListingValidator.validate(salesListing, result);
        if (result.hasErrors()) {
            return "salesListingForm";
        }

        CombinedAccount combinedAccount = (CombinedAccount) request.getSession().getAttribute("loggedInAccount");
        if(combinedAccount == null){
            return "realIndex";
        }

        try {
            //For File Uploader:
            File file1;
            File file2;
            File file3;
            File file4;
            String check = File.separator; //Checking if system is linux based or windows based by checking seprator used.

            String path = null;

            if(check.equalsIgnoreCase("\\")) {
                path = servletContext.getRealPath("").replace("build\\",""); //Netbeans projects gives real path as Lab6/build/web/ so we need to replace build in the path.
          }

            if(check.equalsIgnoreCase("/")) {
                path = servletContext.getRealPath("").replace("build/","");
                path += "/"; //Adding trailing slash for Mac systems.
            }

            if(salesListing.getFile1()!=null){
                String fileNameWithExt = System.currentTimeMillis() + salesListing.getFile1().getOriginalFilename();
                file1 = new File(path + fileNameWithExt);
                String context = servletContext.getContextPath();

                salesListing.getFile1().transferTo(file1);
                salesListing.setFileLocation1(context + "/" + fileNameWithExt);

            }

            if(salesListing.getFile2()!=null){
                String fileNameWithExt = System.currentTimeMillis() + salesListing.getFile1().getOriginalFilename();
                file2 = new File(path + fileNameWithExt);
                String context = servletContext.getContextPath();

                salesListing.getFile2().transferTo(file2);
                salesListing.setFileLocation2(context + "/" + fileNameWithExt);

            }

            if(salesListing.getFile3()!=null){
                String fileNameWithExt = System.currentTimeMillis() + salesListing.getFile1().getOriginalFilename();
                file3 = new File(path + fileNameWithExt);
                String context = servletContext.getContextPath();

                salesListing.getFile3().transferTo(file3);
                salesListing.setFileLocation3(context + "/" + fileNameWithExt);

            }

            if(salesListing.getFile4()!=null){
                String fileNameWithExt = System.currentTimeMillis() + salesListing.getFile1().getOriginalFilename();
                file4 = new File(path + fileNameWithExt);
                String context = servletContext.getContextPath();

                salesListing.getFile4().transferTo(file4);
                salesListing.setFileLocation4(context + "/" + fileNameWithExt);

            }

            Listing listing = listingDao.createSales(salesListing.getListingType(), combinedAccount, salesListing.getAddress(), salesListing.getZipCode(), salesListing.getLatitude(), salesListing.getLongitude(),
                    salesListing.getDescription(), salesListing.getNumberOfBeds(), salesListing.getNumberOfBaths(), salesListing.getSizeInSqft(), salesListing.getLotSize(), salesListing.getType(),
                    salesListing.getYearOfBuilt(), salesListing.getHeatingType(), salesListing.getPropertyTax(), salesListing.getComments(), salesListing.getListPrice(), salesListing.getFileLocation1(),
                    salesListing.getFileLocation2(), salesListing.getFileLocation3(), salesListing.getFileLocation4());

        } catch (HibernateException e) {
            System.out.println("Exception: " + e.getMessage());
        }

        response.sendRedirect("showmylisting.do");
        return null;
    }


    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView initializeForm(@ModelAttribute("salesListing")SalesListing salesListing, BindingResult result) {
        ModelAndView mv = new ModelAndView("salesListingForm");
        return mv;
    }
}
