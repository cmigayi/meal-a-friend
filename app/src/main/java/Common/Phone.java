package Common;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Phone {

    public boolean isPhoneValid(String phone) {

        boolean isValid = false;

        if(!Pattern.matches("[a-zA-Z]+", phone)) {
            if(phone.length() < 6 || phone.length() > 13) {
                // if(phone.length() != 10) {
                isValid = false;
            } else {
                isValid = true;
            }
        } else {
            isValid=false;
        }
        return isValid;
    }
}
