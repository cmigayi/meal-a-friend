package Presenters;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import Common.Meal;
import Repositories.MessageRepository;
import Repositories.SearchMealRepository;
import Views.SearchActivityView;

public class SearchActivityPresenterTest {
    SearchActivityView view;
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
    public void shouldHaveNoSearchItem(){
        //given
        MockRepository repository = new MockRepository(false);

        //when
        SearchActivityPresenter presenter = new SearchActivityPresenter(view,repository);
        presenter.searchMeal("");

        //then
        Assert.assertEquals(true,((MockView)view).displaySearchItemNotFound);
    }

    @Test
    public void shouldHaveSearchItem(){
        //given
        MockRepository repository = new MockRepository(true);

        //when
        SearchActivityPresenter presenter = new SearchActivityPresenter(view,repository);
        presenter.searchMeal("Food");

        //then
        Assert.assertEquals(true,((MockView)view).displaySearchItemFound);
    }

    private class MockView implements SearchActivityView{
        Boolean displaySearchItemNotFound;
        Boolean displaySearchItemFound;
        Boolean displayUserInfo;

        @Override
        public void displayNoSearchItem() {
            displaySearchItemNotFound=true;
        }

        @Override
        public void displaySearchItem() {
            displaySearchItemFound=true;
        }

        @Override
        public void displayuserInfo() {
            displayUserInfo = true;
        }
    }

    private class MockRepository implements SearchMealRepository{
        private boolean returnSomething;

        public MockRepository(boolean returnSomething) {
            this.returnSomething = returnSomething;
        }

        @Override
        public ArrayList<Meal> getMealsBySearchItem(String item) {
            ArrayList<Meal> mealList = new ArrayList<Meal>();
            if(returnSomething == true){
                mealList.add(new Meal());
                mealList.add(new Meal());

                return mealList;
            }else{
                return mealList;
            }
        }
    }
}