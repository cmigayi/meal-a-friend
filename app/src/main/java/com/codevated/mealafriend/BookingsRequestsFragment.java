package com.codevated.mealafriend;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import Views.BookingsRequestsFragmentView;

public class BookingsRequestsFragment extends Fragment implements BookingsRequestsFragmentView{

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_bookings_requests, container, false);
        return view;
    }

    @Override
    public void displayBookingsRequests() {

    }

    @Override
    public void displayNoBookingsRequests() {

    }
}
