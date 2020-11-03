package com.codevated.mealafriend;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import Common.CircleTransform;

/**
 * Created by root on 8/28/18.
 */

public class CustomMealsListview extends ArrayAdapter {
    String [] imgs;
    Context context;
    LayoutInflater layoutInflater;

    public CustomMealsListview(Context context, String[] imgs) {
        super(context, R.layout.custom_meals_listview_item, imgs);
        this.imgs = imgs;
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getPosition(Object item) {
        return super.getPosition(item);
    }

    @Nullable
    @Override
    public Object getItem(int position) {
        return super.getItem(position);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = layoutInflater.inflate(R.layout.custom_meals_listview_item, null);
        ImageView hostImg = (ImageView) convertView.findViewById(R.id.host_img);
        TextView placeTv = (TextView) convertView.findViewById(R.id.place_tv);

        Picasso.with(context).load(R.drawable.host1).transform(new CircleTransform()).into(hostImg);
        placeTv.setText("At "+ Html.fromHtml("<font color='#68d047'>Cecil's place</font>"));

        return convertView;
    }
}
