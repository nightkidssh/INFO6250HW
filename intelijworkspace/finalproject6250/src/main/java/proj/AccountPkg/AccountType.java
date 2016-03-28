package proj.AccountPkg;

/**
 * Created by kym-1992 on 3/27/16.
 */
public enum AccountType {
    SystemAdmin("System Admin Account"), Landlord("Landlord Account"), HomeBuyer("Home Buyer Account");


    private String value;
    private AccountType(String value){
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value;
    }
}
