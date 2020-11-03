package Presenters;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

import Common.BookingsPassed;
import Repositories.BookingsPassedRepository;
import Views.BookingsPassedFragmentView;

public class BookingsPassedFragmentPresenterTest {

    @Test
    public void shouldPassBookingsPassedToView(){
        //given
        BookingsPassedFragmentView view = new MockView();
        BookingsPassedRepository repository = new MockBookingsPassedRepository(true);

        //when
        BookingsPassedFragmentPresenter presenter = new BookingsPassedFragmentPresenter(view,repository);
        presenter.loadBookingsPassed();

        //then
        Assert.assertEquals(true,((MockView)view).displayBookingsPassed);
    }

    @Test
    public void shouldPassNoBookingsPassed(){
        //given
        BookingsPassedFragmentView view = new MockView();
        BookingsPassedRepository repository = new MockBookingsPassedRepository(false);

        //when
        BookingsPassedFragmentPresenter presenter = new BookingsPassedFragmentPresenter(view,repository);
        presenter.loadBookingsPassed();

        //then
        Assert.assertEquals(true,((MockView)view).displayNoBookingsPassed);
    }

    public class MockView implements BookingsPassedFragmentView{
        Boolean displayBookingsPassed;
        Boolean displayNoBookingsPassed;

        @Override
        public void displayBookingsPassed() {
            displayBookingsPassed=true;
        }

        @Override
        public void displayNoBookingsPassed() {
            displayNoBookingsPassed=true;
        }
    }

    public class MockBookingsPassedRepository implements BookingsPassedRepository{
        Boolean returnSomething;

        public MockBookingsPassedRepository(Boolean returnSomething) {
            this.returnSomething = returnSomething;
        }

        @Override
        public ArrayList<BookingsPassed> getBookingsPassed() {
            ArrayList<BookingsPassed> passedList = new ArrayList<BookingsPassed>();

            if(returnSomething == true){
                passedList.add(new BookingsPassed());
                passedList.add(new BookingsPassed());
            }
            return passedList;
        }
    }

}