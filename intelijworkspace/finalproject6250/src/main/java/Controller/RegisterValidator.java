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

    public boolean supports(Class aClass) {
        return aClass.equals(CombinedAccount.class);
    }

    public void validate(Object o, Errors errors) {
        CombinedAccount combinedAccount = (CombinedAccount) o;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "error.invalid.user", "User Name Required");


    }
}
