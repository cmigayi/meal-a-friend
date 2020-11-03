package Presenters;

import android.content.Context;

import java.util.ArrayList;

import Common.Meal;
import Common.User;
import Repositories.MealRepository;
import Repositories.SearchMealRepository;
import Repositories.UserRepository;
import Views.SearchActivityView;

/**
 * Created by root on 8/27/18.
 */

public class SearchActivityPresenter{
    private SearchMealRepository repository;
    private SearchActivityView view;
    private ArrayList<Meal> mealList;

    public SearchActivityPresenter(SearchActivityView view, SearchMealRepository repository) {
        this.repository = repository;
        this.view = view;
    }

    public void searchMeal(String item){
        if(item.isEmpty()){
            view.displayNoSearchItem();
        }else{
            mealList = repository.getMealsBySearchItem(item);

            if(mealList == null){
                view.displayNoSearchItem();
            }else{
                if (mealList.size() > 0) {
                    view.displaySearchItem();
                }else{
                    view.displayNoSearchItem();
                }
            }
        }
    }
}
