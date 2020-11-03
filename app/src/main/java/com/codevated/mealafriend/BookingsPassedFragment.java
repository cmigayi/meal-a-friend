package com.codevated.mealafriend;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import Views.BookingsPassedFragmentView;

public class BookingsPassedFragment extends Fragment implements BookingsPassedFragmentView {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_bookings_passed, container, false);
        return view;
    }

    @Override
    public void displayBookingsPassed() {

    }

    @Override
    public void displayNoBookingsPassed() {

    }
}
