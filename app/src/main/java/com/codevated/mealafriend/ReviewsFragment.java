package com.codevated.mealafriend;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;


public class ReviewsFragment extends Fragment {
    RecyclerView recyclerView;
    String[] items = {"Joe","Jack","Amos"};
    CustomReviewsHorizontalRecyclerViewAdapter customReviewsHorizontalRecyclerViewAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_reviews, container, false);
        recyclerView = view.findViewById(R.id.recyclerViewHorizontal);

        recyclerView.addItemDecoration(new DividerItemDecoration(getActivity(), LinearLayoutManager.HORIZONTAL));
        customReviewsHorizontalRecyclerViewAdapter =
                new CustomReviewsHorizontalRecyclerViewAdapter(items, getActivity());
        LinearLayoutManager horizontalLayout =
                new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(horizontalLayout);
        recyclerView.setAdapter(customReviewsHorizontalRecyclerViewAdapter);
        return view;
    }
}
