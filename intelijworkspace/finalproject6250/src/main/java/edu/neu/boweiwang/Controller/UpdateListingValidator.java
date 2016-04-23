package edu.neu.boweiwang.Controller;

import edu.neu.boweiwang.proj.ListingPkg.SalesListing;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * Created by kym-1992 on 4/23/16.
 */
@Component
public class UpdateListingValidator implements Validator {
    public boolean supports(Class<?> aClass) {
        return aClass.equals(SalesListing.class);
    }

    public void validate(Object o, Errors errors) {
        SalesListing salesListing = (SalesListing) o;

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

        String priceRegex = "^[+-]?[0-9]{1,3}(?:,?[0-9]{3})*(?:\\.[0-9]{2})?$";
        if(!salesListing.getPropertyTax().matches(priceRegex)){
            errors.rejectValue("propertyTax", "Invalid.propertyTax", "Not valid propertyTax");
        }

        if(!salesListing.getListPrice().matches(priceRegex)){
            errors.rejectValue("listPrice", "Invalid.listPrice", "Not valid listPrice");
        }

    }
}
