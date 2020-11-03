package com.codevated.mealafriend;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import Common.CircleTransform;

public class CustomReviewsHorizontalRecyclerViewAdapter extends RecyclerView.Adapter
        <CustomReviewsHorizontalRecyclerViewAdapter.ReviewsHolder> {
    String[] items;
    Context context;
    LayoutInflater layoutInflater;


    public CustomReviewsHorizontalRecyclerViewAdapter(String[] items, Context context) {
        this.items = items;
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public ReviewsHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.custom_reviews_recyclerview_horizontal_item,
                parent, false);
        ReviewsHolder reviewsHolder = new ReviewsHolder(view);
        return reviewsHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ReviewsHolder holder, int position) {
        //holder.imageView.setImageResource(R.drawable.host1);
        Picasso.with(context).load(R.drawable.host1).transform(new CircleTransform()).into(holder.imageView);
        holder.textView.setText(items[position]);
    }

    @Override
    public int getItemCount() {
        return items.length;
    }

    public class ReviewsHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView textView;

        public ReviewsHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.reviewer_img);
            textView = itemView.findViewById(R.id.reviewer_name);
        }
    }
}
