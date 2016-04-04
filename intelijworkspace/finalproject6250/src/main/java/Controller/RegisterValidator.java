package Controller;

import Dao.CombinedAccountDao;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import org.w3c.dom.Document;
import proj.AccountPkg.CombinedAccount;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by kym-1992 on 4/1/16.
 */
@Component
public class RegisterValidator implements Validator {

    public boolean supports(Class<?> aClass) {
        return aClass.equals(CombinedAccount.class);
    }

    public void validate(Object o, Errors errors){
        CombinedAccount combinedAccount = (CombinedAccount) o;
        CombinedAccountDao dao = new CombinedAccountDao();

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userName", "Invalid.userName", "userName Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "Invalid.password", "password Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "confirmPassword", "Invalid.confirmPassword", "confirmPassword Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "Invalid.firstName", "User Name Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName", "Invalid.lastName", "lastName Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "phoneNumber", "Invalid.phoneNumber", "phoneNumber Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "emailAddress", "Invalid.emailAddress", "emailAddress Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "mailingAddress", "Invalid.mailingAddress", "mailingAddress Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "zipCode", "Invalid.zipCode", "zipCode Required");

        String userNameRegex = "^[a-z0-9_-]{3,15}$";
        if(!combinedAccount.getUserName().matches(userNameRegex)){
            errors.rejectValue("userName", "Invalid.userName", "userName length from 3 - 15, no special character!");
        }
        if(dao.get(combinedAccount.getUserName()) != null){
            errors.rejectValue("userName", "Invalid.userName", "This userName is used!");
        }

        String passwordRegex =  "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,20})";
        if(!combinedAccount.getPassword().matches(passwordRegex)){
            errors.rejectValue("password", "Invalid.password", "Invalid password!");
        }

        if(!combinedAccount.getPassword().equals(combinedAccount.getConfirmPassword())){
            errors.rejectValue("confirmPassword", "Invalid.confirmPassword", "ConfirmPassword does NOT match password!");
        }

        String firstLastNameRegex = "[a-zA-Z]*";
        if(!combinedAccount.getFirstName().matches(firstLastNameRegex)){
            errors.rejectValue("firstName", "Invalid.firstName", "Not valid firstName");
        }

        if(!combinedAccount.getLastName().matches(firstLastNameRegex)){
            errors.rejectValue("lastName", "Invalid.lastName", "Not valid lastName");
        }

        String phoneRegex = "^\\(?([0-9]{3})\\)?[-.\\s]?([0-9]{3})[-.\\s]?([0-9]{4})$";
        if(!combinedAccount.getPhoneNumber().matches(phoneRegex)){
            errors.rejectValue("phoneNumber", "Invalid.phoneNumber", "Not valid phoneNumber");
        }

        String emailRegex = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        if(!combinedAccount.getEmailAddress().matches(emailRegex)){
            errors.rejectValue("emailAddress", "Invalid.emailAddress", "Not valid email");
        }
        if(dao.findUniqueEmail(combinedAccount.getEmailAddress()) != null){
            errors.rejectValue("emailAddress", "Invalid.emailAddress", "This Email is used!");
        }

        //Address with Google Map API
        String rawaddress = combinedAccount.getMailingAddress();
        rawaddress = rawaddress.replaceAll("\\s+", "+");
        String googleURL = "https://maps.googleapis.com/maps/api/geocode/xml?address=" + rawaddress + "&components=country:US|postal_code:" + combinedAccount.getZipCode();
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
                combinedAccount.setMailingAddress(doc.getElementsByTagName("formatted_address").item(0).getTextContent());
            }
            else{
                errors.rejectValue("mailingAddress", "Invalid.mailingAddress", doc.getElementsByTagName("error_message").item(0).getTextContent());
            }

        }catch (Exception e){
            e.printStackTrace();
        }

        String zipRegex = "^[0-9]{5}(?:-[0-9]{4})?$";
        if(!combinedAccount.getZipCode().matches(zipRegex)){
            errors.rejectValue("zipCode", "Invalid.zipCode", "Not valid zipCode");
        }
    }
}
