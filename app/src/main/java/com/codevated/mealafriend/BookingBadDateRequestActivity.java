package com.codevated.mealafriend;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.TextView;

public class BookingBadDateRequestActivity extends AppCompatActivity implements View.OnClickListener {
    Toolbar topbar;
    ImageView hostImg;
    TextView titleTv;
    ImageButton menuBtn, backBtn;
    Button proceedBtn;
    SearchView searchView;

    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking_bad_date_request);

        topbar = (Toolbar) findViewById(R.id.top_bar);

        menuBtn = (ImageButton) topbar.findViewById(R.id.menu_btn);
        backBtn = (ImageButton) topbar.findViewById(R.id.back_btn);
        titleTv = (TextView) topbar.findViewById(R.id.page_title);
        searchView = (SearchView) topbar.findViewById(R.id.searchView);

        hostImg = (ImageView) findViewById(R.id.host_img);
        proceedBtn = findViewById(R.id.proceed_btn);

        titleTv.setText("Booking request");
        searchView.setVisibility(View.GONE);
        backBtn.setVisibility(View.VISIBLE);
        menuBtn.setVisibility(View.GONE);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();

        switch (id){
            case R.id.back_btn:
                finish();
                break;

            case R.id.proceed_btn:
                break;
        }
    }
}
