package Repositories;

import java.util.ArrayList;

import Common.Meal;

public interface SearchMealRepository {

    public ArrayList<Meal> getMealsBySearchItem(String item);
}
