package Presenters;

import java.util.ArrayList;

import Common.BookingsRequest;
import Repositories.BookingsRequestsRepository;
import Views.BookingsRequestsFragmentView;

public class BookingsRequestsFragmentPresenter {
    BookingsRequestsFragmentView view;
    BookingsRequestsRepository repository;

    public BookingsRequestsFragmentPresenter(BookingsRequestsFragmentView view,
                                             BookingsRequestsRepository repository) {
        this.view = view;
        this.repository = repository;
    }

    public void loadBookingsRequests() {
        ArrayList<BookingsRequest> requestsList = repository.getBookingsRequests();

        if(requestsList == null){
            view.displayNoBookingsRequests();
        }else{
            if(requestsList.size() > 0){
                view.displayBookingsRequests();
            }else{
                view.displayNoBookingsRequests();
            }
        }
    }
}
