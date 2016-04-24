package edu.neu.boweiwang.Controller;

import com.lowagie.text.Document;
import com.lowagie.text.Image;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.PdfWriter;
import edu.neu.boweiwang.proj.ListingPkg.SalesListing;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;


/**
 * Created by kym-1992 on 4/23/16.
 */
public class PDFView extends AbstractPdfView {

    protected void buildPdfDocument(Map<String, Object> map, Document document, PdfWriter pdfWriter, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {

        Map<String, Object> mapData = (Map<String, Object>) map.get("mapData");
        SalesListing salesListing = (SalesListing) mapData.get("listing");
        String path2 = (String) mapData.get("path2");

        Table table = new Table(2);
        table.addCell("listingID");
        table.addCell(String.valueOf(salesListing.getListingID()));
        table.addCell("listingType");
        table.addCell(salesListing.getListingType().getValue());
        table.addCell("address");
        table.addCell(salesListing.getAddress());
        table.addCell("zipCode");
        table.addCell(salesListing.getZipCode());
        table.addCell("description");
        table.addCell(salesListing.getDescription());
        table.addCell("Number Of Beds");
        table.addCell(String.valueOf(salesListing.getNumberOfBeds()));
        table.addCell("number Of Baths");
        table.addCell(String.valueOf(salesListing.getNumberOfBaths()));
        table.addCell("sizeInSqft");
        table.addCell(String.valueOf(salesListing.getSizeInSqft()));
        table.addCell("lotSize");
        table.addCell(String.valueOf(salesListing.getLotSize()));
        table.addCell("type");
        table.addCell(salesListing.getType());
        table.addCell("yearOfBuilt");
        table.addCell(String.valueOf(salesListing.getYearOfBuilt()));
        table.addCell("heatingType");
        table.addCell(salesListing.getHeatingType());
        table.addCell("propertyTax");
        table.addCell(salesListing.getPropertyTax());
        table.addCell("comments");
        table.addCell(salesListing.getComments());
        document.add(table);

        System.out.println(path2 + salesListing.getFileLocation1());

        if (salesListing.getFileLocation1() != null) {
            Image image = Image.getInstance(path2 + salesListing.getFileLocation1());
//            Image image = Image.getInstance("uploadedphoto/" + salesListing.getFileLocation1());
            float scaler = ((document.getPageSize().getWidth() - document.leftMargin()
                    - document.rightMargin() - 0) / image.getWidth()) * 100;

            image.scalePercent(scaler);
            if (image != null) {
                document.add(image);
            }
        }

        if (salesListing.getFileLocation2() != null) {
            Image image2 = Image.getInstance(path2 + salesListing.getFileLocation2());
            float scaler2 = ((document.getPageSize().getWidth() - document.leftMargin()
                    - document.rightMargin() - 0) / image2.getWidth()) * 100;
            image2.scalePercent(scaler2);
            if (image2 != null) {
                document.add(image2);
            }
        }

        if (salesListing.getFileLocation3() != null) {
            Image image3 = Image.getInstance(path2 + salesListing.getFileLocation3());
            float scaler3 = ((document.getPageSize().getWidth() - document.leftMargin()
                    - document.rightMargin() - 0) / image3.getWidth()) * 100;
            image3.scalePercent(scaler3);
            if (image3 != null) {
                document.add(image3);
            }
        }

        if (salesListing.getFileLocation4() != null) {
            Image image4 = Image.getInstance(path2 + salesListing.getFileLocation4());
            float scaler4 = ((document.getPageSize().getWidth() - document.leftMargin()
                    - document.rightMargin() - 0) / image4.getWidth()) * 100;
            image4.scalePercent(scaler4);
            if (image4 != null) {
                document.add(image4);
            }
        }
    }

}
