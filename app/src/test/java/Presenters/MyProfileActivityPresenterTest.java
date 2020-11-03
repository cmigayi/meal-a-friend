package Presenters;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import Common.User;
import Repositories.UserRepository;
import Views.MyProfileActivityView;

import static org.junit.Assert.*;

public class MyProfileActivityPresenterTest {
    MyProfileActivityView view;

    @Before
    public void setUp() throws Exception{
        view = new MockView();
    }

    @After
    public void tearDown() throws Exception{
        view = null;
    }

    @Test
    public void shouldPassUserInfoToView(){
        //given
        MockRepository repository = new MockRepository();

        //when
        MyProfileActivityPresenter presenter = new MyProfileActivityPresenter(view,repository);
        presenter.showUserInfo();

        //then
        Assert.assertEquals(true,((MockView)view).displayUserInfo);
    }

    private class MockView implements MyProfileActivityView{
        Boolean displayUserInfo;

        @Override
        public void displayUserInfo(User user) {
            if(user != null){
                displayUserInfo=true;
            }
        }
    }

    private class MockRepository implements UserRepository{

        @Override
        public User getUser() {
            return new User();
        }

        @Override
        public void createUser() {

        }
    }

}