package com.codevated.mealafriend;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import Common.CircleTransform;

public class AboutMealFragment extends Fragment {
    ImageView hostImg;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_about_meal, null);
        hostImg = (ImageView) view.findViewById(R.id.host_img);

        Picasso.with(getActivity()).load(R.drawable.host1).transform(new CircleTransform()).into(hostImg);

        return view;
    }
}
