package Views;

import java.util.ArrayList;

import Common.Meal;

public interface HomeFragmentView {
    public void displayMeals(ArrayList<Meal> mealList);
    public void displayNoMeals();
}
