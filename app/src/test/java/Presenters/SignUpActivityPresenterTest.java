package Presenters;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import Common.User;
import Repositories.UserRepository;
import Views.SignUpActivityView;

import static org.junit.Assert.*;

public class SignUpActivityPresenterTest {
    SignUpActivityView view;
    SignUpActivityPresenter presenter;
    User user;

    @Before
    public void setUp() throws Exception{
        view = new MockView();
    }

    @After
    public void tearDown() throws Exception {
        view = null;
    }

    @Test
    public void shouldPassNoEmptyInputs(){
        presenter = new SignUpActivityPresenter(view,null);
        user = new User();
        user.setFname("");
        user.setLname("");
        user.setEmail("");
        user.setPhone("");
        user.setPwd("");
        presenter.checkIfInputsEmpty(user);
        Assert.assertEquals(true,((MockView)view).displayInputError);
    }

    @Test
    public void shouldPassNoInvalidEmail(){
        presenter = new SignUpActivityPresenter(view,null);
        user = new User();
        user.setEmail("");
        presenter.checkIfEmailIsValid(user);
        Assert.assertEquals(true,((MockView)view).displayInputError);
    }

    @Test
    public void shouldPassNoInvalidPhone(){
        presenter = new SignUpActivityPresenter(view,null);
        user = new User();
        user.setPhone("0718");
        presenter.checkIfPhoneIsValid(user);
        Assert.assertEquals(true,((MockView)view).displayInputError);
    }

    @Test
    public void shouldPassNoInvalidPassword(){
        presenter = new SignUpActivityPresenter(view,null);
        user = new User();
        user.setPwd("");
        user.setConfirmPwd("");
        presenter.checkIfPasswordIsValid(user);
        Assert.assertEquals(true,((MockView)view).displayInputError);
    }

    @Test
    public void shouldPassViewDataToRepository(){
        UserRepository repository = new MockRepository();
        presenter = new SignUpActivityPresenter(view, repository);
        user = new User();
        presenter.signUp(user);
        Assert.assertEquals(true,((MockRepository)repository).userCreated);
    }

    public class MockView implements SignUpActivityView{
        private Boolean displayInputError;

        @Override
        public void displayInputError(String errorMsg) {
            displayInputError=true;
        }
    }

    public class MockRepository implements UserRepository{
        Boolean userCreated;

        @Override
        public User getUser() {
            return null;
        }

        @Override
        public User createUser(User user) {
            userCreated = true;
            return new User();
        }
    }

}