package Common;

import java.util.regex.Pattern;

public class Password {

    public boolean isPasswordValid(String password, String confirmPassword) {
        boolean isValid = false;
        final String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{4,}$";

        if(password.equals(confirmPassword)) {
            if (Pattern.matches(PASSWORD_PATTERN, password)) {
                if (password.length() >= 6) {
                    isValid = true;
                }
            }
        }
        return isValid;
    }
}
