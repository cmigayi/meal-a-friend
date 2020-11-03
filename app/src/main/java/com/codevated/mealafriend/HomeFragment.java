package com.codevated.mealafriend;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

import Common.Meal;
import Views.HomeFragmentView;


public class HomeFragment extends Fragment implements HomeFragmentView{
    ListView mealList;
    String [] imgs = {"R.drawable.sukuma", "R.drawable.sukumaricebeans","R.drawable.sukuma", "R.drawable.sukumaricebeans"};
    Intent intent;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment__home, container, false);
        mealList = (ListView) view.findViewById(R.id.meals_list);
        CustomMealsListview customMealsListview = new CustomMealsListview(getActivity(), imgs);
        mealList.setAdapter(customMealsListview);
        mealList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                intent = new Intent(getActivity(), MealInfoActivity.class);
                startActivity(intent);
            }
        });
        return view;
    }

    @Override
    public void displayMeals(ArrayList<Meal> mealList) {

    }

    @Override
    public void displayNoMeals() {

    }
}
