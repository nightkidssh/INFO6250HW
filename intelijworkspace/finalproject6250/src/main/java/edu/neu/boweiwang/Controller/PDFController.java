package edu.neu.boweiwang.Controller;

import edu.neu.boweiwang.Dao.ListingDao;
import edu.neu.boweiwang.proj.AccountPkg.CombinedAccount;
import edu.neu.boweiwang.proj.ListingPkg.SalesListing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by kym-1992 on 4/23/16.
 */
@Controller
@RequestMapping("/report.pdf")
public class PDFController {
    @Autowired
    ListingDao listingDao;

    @Autowired
    ServletContext servletContext;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView createPDF(HttpServletRequest request, HttpServletResponse response) throws IOException {
        CombinedAccount combinedAccount = (CombinedAccount) request.getSession().getAttribute("loggedInAccount");
        if(combinedAccount == null){
            response.sendRedirect("realIndex.do");
        }

        String listingID = request.getParameter("listingID");

        SalesListing listing = null;
        if(listingID != null) {
            listing = (SalesListing) listingDao.findRecordByID(Integer.parseInt(listingID));
        }
        else{
            response.sendRedirect("realIndex.do");
        }

        View view = new PDFView();

        Map<String,Object> mapData = new HashMap<String,Object>();
        mapData.put("listing", listing);
        String check = File.separator;
        String rootPath = servletContext.getRealPath("").replace("build\\","");
        String path2 = rootPath+ check + "uploadedphoto";

        mapData.put("path2", path2);

        return new ModelAndView(view, "mapData", mapData);
    }
}
