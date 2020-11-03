package Presenters;

import android.util.Log;
import android.util.Patterns;

import Common.Email;
import Common.Password;
import Common.Phone;
import Common.User;
import Repositories.UserRepository;
import Views.SignUpActivityView;

public class SignUpActivityPresenter {
    SignUpActivityView view;
    UserRepository repository;

    public SignUpActivityPresenter(SignUpActivityView view, UserRepository repository) {
        this.view = view;
        this.repository = repository;
    }

    public void checkIfInputsEmpty(User user) {

        if(user == null){
            view.displayInputError("All inputs must be filled!");
        }

        if(user.getFname().isEmpty()){
            view.displayInputError("Firstname must be provided!");
        }

        if(user.getLname().isEmpty()){
            view.displayInputError("Lastname must be provided!");
        }

        if(user.getEmail().isEmpty()){
            view.displayInputError("Email must be provided!");
        }

        if(user.getPhone().isEmpty()){
            view.displayInputError("Phone number must be provided!");
        }

        if(user.getPwd().isEmpty()){
            view.displayInputError("Password must be provided!");
        }
    }

    public void checkIfEmailIsValid(User user){
        Email email = new Email();

        if(user == null){
            view.displayInputError("All inputs must be filled!");
        }

        if(!email.isEmailValid(user.getEmail())){
            view.displayInputError("Email is not valid!");
        }
    }

    public void checkIfPhoneIsValid(User user){
        Phone phone = new Phone();

        if(user == null){
            view.displayInputError("All inputs must be filled!");
        }

        if(!phone.isPhoneValid(user.getPhone())){
            view.displayInputError("Phone is not valid!");
        }
    }

    public void checkIfPasswordIsValid(User user){
        Password password = new Password();

        if(user == null){
            view.displayInputError("All inputs must be filled!");
        }

        if(!password.isPasswordValid(user.getPwd(),user.getConfirmPwd())){
            view.displayInputError("Password not valid or does not match!");
        }
    }

    public void signUp(User user) {
        if(user == null){
            view.displayInputError("All inputs must be filled!");
        }

        /*
        * Create new user
        *
        * @Return created user
        */
        user = repository.createUser(user);

        if(user == null){
            view.displayInputError("Signup failed!");
        }else{
            //login or store data locally
        }
    }
}
