package edu.neu.boweiwang.Controller;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import org.w3c.dom.Document;
import edu.neu.boweiwang.proj.ListingPkg.SalesListing;

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

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "listingType", "Invalid.listingType", "listingType Required!");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "address", "Invalid.address", "Address Required!");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "zipCode", "Invalid.zipCode", "zipCode Required!");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "description", "Invalid.description", "description Required!");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "numberOfBeds", "Invalid.numberOfBeds", "numberOfBeds Required!");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "numberOfBaths", "Invalid.numberOfBaths", "numberOfBaths Required!");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "sizeInSqft", "Invalid.sizeInSqft", "sizeInSqft Required!");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lotSize", "Invalid.lotSize", "lotSize Required!");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "type", "Invalid.type", "type Required!");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "yearOfBuilt", "Invalid.yearOfBuilt", "yearOfBuilt Required!");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "heatingType", "Invalid.heatingType", "heatingType Required!");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "propertyTax", "Invalid.propertyTax", "propertyTax Required!");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "comments", "Invalid.comments", "comments Required!");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "listPrice", "Invalid.listPrice", "listPrice Required!");

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
            if(doc.getElementsByTagName("type").item(0)== null){
                errors.rejectValue("address", "Invalid.address", "Invalid Address!");
            }
            else {
                String type = doc.getElementsByTagName("type").item(0).getTextContent();
                if (status.equalsIgnoreCase("OK") && type.equalsIgnoreCase("street_address")) {
                    salesListing.setAddress(doc.getElementsByTagName("formatted_address").item(0).getTextContent());
                    salesListing.setLatitude(doc.getElementsByTagName("lat").item(0).getTextContent());
                    salesListing.setLongitude(doc.getElementsByTagName("lng").item(0).getTextContent());
                } else {
                    errors.rejectValue("address", "Invalid.address", "Invalid Address or zip code!");
                }
            }

            String zipRegex = "^[0-9]{5}(?:-[0-9]{4})?$";
            if(!salesListing.getZipCode().matches(zipRegex)){
                errors.rejectValue("zipCode", "Invalid.zipCode", "Not valid zipCode");
            }



            String priceRegex = "^[+-]?[0-9]{1,3}(?:,?[0-9]{3})*(?:\\.[0-9]{2})?$";
            if(!salesListing.getPropertyTax().matches(priceRegex)){
                errors.rejectValue("propertyTax", "Invalid.propertyTax", "Not valid propertyTax");
            }

            if(!salesListing.getListPrice().matches(priceRegex)){
                errors.rejectValue("listPrice", "Invalid.listPrice", "Not valid listPrice");
            }

        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
