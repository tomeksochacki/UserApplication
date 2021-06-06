package pl.ts.validators;

import pl.ts.model.User;

public class UserValidator {

    public static boolean validateFull(User user){
        if (user.getName().equals("") || user.getSurname().equals("") || user.getAge().equals("") || user.getPhoneNumber().equals("") || user.getRole().equals("")) {
            return false;
        }
        return true;
    }
}
