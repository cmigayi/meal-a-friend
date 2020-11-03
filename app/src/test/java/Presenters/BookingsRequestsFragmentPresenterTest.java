package Presenters;


import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import Common.BookingsRequest;
import Repositories.BookingsRequestsRepository;
import Views.BookingsRequestsFragmentView;

public class BookingsRequestsFragmentPresenterTest {
    BookingsRequestsFragmentView view;

    @Before
    public void setUp() throws Exception {
        view = new MockView();
    }

    @After
    public void tearDown() throws Exception {
        view = null;
    }

    @Test
    public void shouldPassBookingsRequestsToView(){
        //given
        BookingsRequestsRepository repository = new MockBookingsRequestsRepository(true);

        //when
        BookingsRequestsFragmentPresenter presenter =
                new BookingsRequestsFragmentPresenter(view,repository);
        presenter.loadBookingsRequests();

        //then
        Assert.assertEquals(true,((MockView)view).displayBookingsRequests);
    }

    @Test
    public void shouldPassNoBookingsRequests(){
        //given
        BookingsRequestsRepository repository = new MockBookingsRequestsRepository(false);

        //when
        BookingsRequestsFragmentPresenter presenter =
                new BookingsRequestsFragmentPresenter(view,repository);
        presenter.loadBookingsRequests();

        //then
        Assert.assertEquals(true,((MockView)view).displayNoBookingsRequests);
    }

    public class MockView implements BookingsRequestsFragmentView{
        Boolean displayBookingsRequests;
        Boolean displayNoBookingsRequests;

        @Override
        public void displayBookingsRequests() {
            displayBookingsRequests=true;
        }

        @Override
        public void displayNoBookingsRequests() {
            displayNoBookingsRequests=true;
        }
    }

    public class MockBookingsRequestsRepository implements BookingsRequestsRepository{
        Boolean returnSomething;

        public MockBookingsRequestsRepository(Boolean returnSomething) {
            this.returnSomething = returnSomething;
        }

        @Override
        public ArrayList<BookingsRequest> getBookingsRequests() {
            ArrayList<BookingsRequest> requestsList = new ArrayList<BookingsRequest>();

            if(returnSomething == true){
                requestsList.add(new BookingsRequest());
                requestsList.add(new BookingsRequest());
            }
            return requestsList;
        }
    }

}