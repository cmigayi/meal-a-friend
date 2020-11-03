package Presenters;

import java.util.ArrayList;

import Common.BookingsPassed;
import Repositories.BookingsPassedRepository;
import Views.BookingsPassedFragmentView;

public class BookingsPassedFragmentPresenter {
    BookingsPassedFragmentView view;
    BookingsPassedRepository repository;

    public BookingsPassedFragmentPresenter(BookingsPassedFragmentView view, BookingsPassedRepository repository) {
        this.view = view;
        this.repository = repository;
    }

    public void loadBookingsPassed() {
        ArrayList<BookingsPassed> passedList = repository.getBookingsPassed();

        if(passedList == null){
            view.displayNoBookingsPassed();
        }else{
            if(passedList.size() > 0){
                view.displayBookingsPassed();
            }else{
                view.displayNoBookingsPassed();
            }
        }
    }
}
