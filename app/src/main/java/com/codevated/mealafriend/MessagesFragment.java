package com.codevated.mealafriend;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import Views.MessagesFragmentView;


/**
 * A simple {@link Fragment} subclass.
 */
public class MessagesFragment extends Fragment implements MessagesFragmentView {
    SearchActivity searchActivity;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_messages, container, false);
        searchActivity = (SearchActivity) getActivity();
        //searchActivity.titleTv.setText("Messages");
        return view;
    }

    @Override
    public void displayMessages() {

    }

    @Override
    public void displayNoMessages() {

    }
}
