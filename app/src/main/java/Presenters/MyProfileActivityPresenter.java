package Presenters;

import Common.User;
import Repositories.UserRepository;
import Views.MyProfileActivityView;

public class MyProfileActivityPresenter {
    MyProfileActivityView view;
    UserRepository repository;

    public MyProfileActivityPresenter(MyProfileActivityView view, UserRepository repository) {
        this.view = view;
        this.repository = repository;
    }

    public void showUserInfo() {
        User user = repository.getUser();
        if(user == null){
            //logout
        }else {
            view.displayUserInfo(user);
        }
    }
}
