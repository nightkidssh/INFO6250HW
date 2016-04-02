package Controller;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import proj.AccountPkg.CombinedAccount;

/**
 * Created by kym-1992 on 4/1/16.
 */
@Component
public class RegisterValidator implements Validator {

    public boolean supports(Class<?> aClass) {
        return aClass.equals(CombinedAccount.class);
    }

    public void validate(Object o, Errors errors) {
        CombinedAccount combinedAccount = (CombinedAccount) o;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userName", "Invalid.userName", "userName Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "Invalid.password", "password Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "confirmPassword", "Invalid.confirmPassword", "confirmPassword Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "Invalid.firstName", "User Name Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName", "Invalid.lastName", "lastName Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "phoneNumber", "Invalid.phoneNumber", "phoneNumber Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "emailAddress", "Invalid.emailAddress", "emailAddress Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "mailingAddress", "Invalid.mailingAddress", "mailingAddress Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "zipCode", "Invalid.zipCode", "zipCode Required");
        
    }
}
