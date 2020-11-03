package Presenters;

import java.util.ArrayList;

import Common.Meal;
import Repositories.MealRepository;
import Views.HomeFragmentView;

public class HomeFragmentPresenter {
    HomeFragmentView view;
    MealRepository repository;
    private ArrayList<Meal> mealList;

    public HomeFragmentPresenter(HomeFragmentView view, MealRepository repository) {
        this.view = view;
        this.repository = repository;
    }

    public void loadMeals() {
        mealList = repository.getMeals();

        if(mealList == null){
            view.displayNoMeals();
        }else {
            if (mealList.size() > 0) {
                view.displayMeals(mealList);
            } else {
                view.displayNoMeals();
            }
        }
    }
}
