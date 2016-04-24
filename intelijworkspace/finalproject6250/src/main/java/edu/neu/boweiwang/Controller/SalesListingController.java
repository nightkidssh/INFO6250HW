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
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.channels.FileChannel;

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
            response.sendRedirect("realIndex.do");
        }

        try {
            System.out.println(salesListing.getFile1().getOriginalFilename().toString());

            //For File Uploader:
            File file1;
            File file2;
            File file3;
            File file4;


            FileChannel inputChannel = null;
            FileChannel outputChannel = null;

            String check = File.separator; //Checking if system is linux based or windows based by checking seprator used.

            String rootPath = null;
            String path = null;
            String path2 = null;

            if(check.equalsIgnoreCase("\\")) {
                rootPath = servletContext.getRealPath("").replace("build\\",""); //Netbeans projects gives real path as Lab6/build/web/ so we need to replace build in the path.
//                path = FileSystemView.getFileSystemView().getHomeDirectory() + check + "uploadedphoto" + check;
                path = "/STUDY/NEU/INFO6250/INFO6250HW/intelijworkspace/finalproject6250/web/uploadedphoto/";
                path2 = rootPath+ check + "uploadedphoto" + check;
                System.out.println(path2);
          }

            if(check.equalsIgnoreCase("/")) {
                rootPath = servletContext.getRealPath("").replace("build/","");
                rootPath += "/"; //Adding trailing slash for Mac systems.
//                path = System.getProperty("user.home") + check + "uploadedphoto" + check;
                path = "/STUDY/NEU/INFO6250/INFO6250HW/intelijworkspace/finalproject6250/web/uploadedphoto/";
                path2 = rootPath+ check + "uploadedphoto" + check;
            }

            if(!salesListing.getFile1().isEmpty()){
                String fileNameWithExt = System.currentTimeMillis() + salesListing.getFile1().getOriginalFilename();
                file1 = new File(path + fileNameWithExt);
//                filee1 = new File(path2 + fileNameWithExt);
//                String context = servletContext.getContextPath();

                salesListing.getFile1().transferTo(file1);
                inputChannel = new FileInputStream(path + fileNameWithExt).getChannel();
                outputChannel = new FileOutputStream(path2 + fileNameWithExt).getChannel();
                outputChannel.transferFrom(inputChannel, 0, inputChannel.size());

//                salesListing.getFile1().transferTo(filee1);
//                salesListing.setFileLocation1(context + "/" + fileNameWithExt);
                salesListing.setFileLocation1(fileNameWithExt);
            }

            if(!salesListing.getFile2().isEmpty()){
                String fileNameWithExt = System.currentTimeMillis() + salesListing.getFile2().getOriginalFilename();
                file2 = new File(path + fileNameWithExt);
//                filee2 = new File(path2 + fileNameWithExt);
//                String context = servletContext.getContextPath();

                salesListing.getFile2().transferTo(file2);
                inputChannel = new FileInputStream(path + fileNameWithExt).getChannel();
                outputChannel = new FileOutputStream(path2 + fileNameWithExt).getChannel();
                outputChannel.transferFrom(inputChannel, 0, inputChannel.size());
//                salesListing.getFile2().transferTo(filee2);
//                salesListing.setFileLocation2(context + "/" + fileNameWithExt);
                salesListing.setFileLocation2(fileNameWithExt);
            }

            if(!salesListing.getFile3().isEmpty()){
                String fileNameWithExt = System.currentTimeMillis() + salesListing.getFile3().getOriginalFilename();
                file3 = new File(path + fileNameWithExt);
//                filee3 = new File(path2 + fileNameWithExt);
//                String context = servletContext.getContextPath();

                salesListing.getFile3().transferTo(file3);
                inputChannel = new FileInputStream(path + fileNameWithExt).getChannel();
                outputChannel = new FileOutputStream(path2 + fileNameWithExt).getChannel();
                outputChannel.transferFrom(inputChannel, 0, inputChannel.size());
//                salesListing.getFile3().transferTo(filee3);
//                salesListing.setFileLocation3(context + "/" + fileNameWithExt);
                salesListing.setFileLocation3(fileNameWithExt);
            }

            if(!salesListing.getFile4().isEmpty()){
                String fileNameWithExt = System.currentTimeMillis() + salesListing.getFile4().getOriginalFilename();
                file4 = new File(path + fileNameWithExt);
//                filee4 = new File(path2 + fileNameWithExt);
//                String context = servletContext.getContextPath();

                salesListing.getFile4().transferTo(file4);
                inputChannel = new FileInputStream(path + fileNameWithExt).getChannel();
                outputChannel = new FileOutputStream(path2 + fileNameWithExt).getChannel();
                outputChannel.transferFrom(inputChannel, 0, inputChannel.size());
//                salesListing.getFile4().transferTo(filee4);
//                salesListing.setFileLocation4(context + "/" + fileNameWithExt);
                salesListing.setFileLocation4(fileNameWithExt);
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
