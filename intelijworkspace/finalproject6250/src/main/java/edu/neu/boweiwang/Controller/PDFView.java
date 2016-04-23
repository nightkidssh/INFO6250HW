package edu.neu.boweiwang.Controller;

import com.lowagie.text.Document;
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
        SalesListing salesListing = (SalesListing) map.get("listing");
        Table table = new Table(2);
        
    }
}
