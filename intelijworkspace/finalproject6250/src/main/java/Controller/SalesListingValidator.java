package Controller;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.w3c.dom.Document;
import proj.ListingPkg.SalesListing;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by kym-1992 on 4/5/16.
 */
@Component
public class SalesListingValidator implements Validator{
    public boolean supports(Class<?> aClass) {
        return aClass.equals(SalesListing.class);
    }

    public void validate(Object o, Errors errors) {
        SalesListing salesListing = (SalesListing) o;

        //Address with Google Map API
        String rawaddress = salesListing.getAddress();
        rawaddress = rawaddress.replaceAll("\\s+", "+");
        String googleURL = "https://maps.googleapis.com/maps/api/geocode/xml?address=" + rawaddress + "&components=country:US|postal_code:" + salesListing.getZipCode();
        try {
            URL urlObj = new URL(googleURL);

            HttpURLConnection connection =
                    (HttpURLConnection) urlObj.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Accept", "application/xml");

            InputStream xml = connection.getInputStream();

            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(xml);

            doc.getDocumentElement().normalize();
            String status = doc.getElementsByTagName("status").item(0).getTextContent();
            if(status.equalsIgnoreCase("OK")){
                salesListing.setAddress(doc.getElementsByTagName("formatted_address").item(0).getTextContent());
            }
            else{
                errors.rejectValue("address", "Invalid.address", doc.getElementsByTagName("error_message").item(0).getTextContent());
            }

        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
