package Presenters;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import Common.Meal;
import Repositories.MealRepository;
import Repositories.MessageRepository;
import Views.HomeFragmentView;
import Views.MessagesFragmentView;

public class HomeFragmentPresenterTest {
    HomeFragmentView view;
    MessageRepository repository;

    @Before
    public void setUp() throws Exception {
        //given
        view = new MockView();
    }

    @After
    public void tearDown() throws Exception {
        view = null;
    }

    @Test
    public void shouldPassMealsToViews(){
        //given
        MealRepository repository = new MockMealRepository(true);

        //when
        HomeFragmentPresenter presenter = new HomeFragmentPresenter(view,repository);
        presenter.loadMeals();

        //then
        Assert.assertEquals(true,((MockView) view).displayMealsFound);
    }

    @Test
    public void shouldPassNoMealsFound(){
        //given
        MealRepository repository = new MockMealRepository(false);

        //when
        HomeFragmentPresenter presenter = new HomeFragmentPresenter(view,repository);
        presenter.loadMeals();

        //then
        Assert.assertEquals(true,((MockView)view).displayMealsNotFound);
    }

    private class MockView implements HomeFragmentView{
        Boolean displayMealsFound;
        Boolean displayMealsNotFound;

        @Override
        public void displayMeals(ArrayList<Meal> mealList) {
            displayMealsFound=true;
        }

        @Override
        public void displayNoMeals() {
            displayMealsNotFound=true;
        }
    }

    private class MockMealRepository implements MealRepository{
        private boolean returnSomething;

        public MockMealRepository(boolean returnSomething) {
            this.returnSomething = returnSomething;
        }

        @Override
        public ArrayList<Meal> getMeals() {
            ArrayList<Meal> mealList = new ArrayList<Meal>();

            if(returnSomething == true){
                mealList.add(new Meal());
                mealList.add(new Meal());
            }
            return mealList;
        }
    }

}