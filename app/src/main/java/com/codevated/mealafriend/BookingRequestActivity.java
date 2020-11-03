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

import com.squareup.picasso.Picasso;

import Common.CircleTransform;
import Common.GeneralUtils;
import Common.Payment;

public class BookingRequestActivity extends AppCompatActivity implements View.OnClickListener{
    Toolbar topbar;
    ImageView hostImg;
    TextView titleTv,selectedDateTv,selectedGuestsTv,guestPerMealTv,mealCostTv,
            bookingFeeTv,totalCostTv;
    ImageButton menuBtn, backBtn, addGuestBtn, removeGuestBtn;
    Button proceedBtn, selectDateBtn;
    SearchView searchView;

    Intent intent;

    GeneralUtils generalUtils;
    Payment payment;

    int guests;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking_request);

        topbar = (Toolbar) findViewById(R.id.top_bar);

        menuBtn = (ImageButton) topbar.findViewById(R.id.menu_btn);
        backBtn = (ImageButton) topbar.findViewById(R.id.back_btn);
        titleTv = (TextView) topbar.findViewById(R.id.page_title);
        searchView = (SearchView) topbar.findViewById(R.id.searchView);

        selectedDateTv = findViewById(R.id.selected_date_tv);
        selectedGuestsTv = findViewById(R.id.selected_guests_tv);
        guestPerMealTv = findViewById(R.id.guest_per_meal_tv);
        mealCostTv = findViewById(R.id.meal_cost_tv);
        bookingFeeTv = findViewById(R.id.booking_fee_tv);
        totalCostTv = findViewById(R.id.total_cost_tv);

        hostImg = (ImageView) findViewById(R.id.host_img);
        proceedBtn = findViewById(R.id.proceed_btn);
        selectDateBtn = findViewById(R.id.select_date_btn);
        addGuestBtn = findViewById(R.id.add_guest_btn);
        removeGuestBtn = findViewById(R.id.remove_guest_btn);

        generalUtils = new GeneralUtils();

        titleTv.setText("Booking request");
        searchView.setVisibility(View.GONE);
        backBtn.setVisibility(View.VISIBLE);
        menuBtn.setVisibility(View.GONE);

        Picasso.with(this).load(R.drawable.host1).transform(new CircleTransform()).into(hostImg);

        payment = new Payment();
        payment.setBookingFee(50.00);
        //payment.setGuestNum(1);
        payment.setMealPerGuestCost(120.00);

        displayPaymentReceipt(1);

        backBtn.setOnClickListener(this);
        proceedBtn.setOnClickListener(this);
        selectDateBtn.setOnClickListener(this);
        addGuestBtn.setOnClickListener(this);
        removeGuestBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();

        switch (id){
            case R.id.back_btn:
                finish();
                break;

            case R.id.proceed_btn:
//                intent = new Intent(BookingRequestActivity.this,
//                        BookingBadDateRequestActivity.class);
                intent = new Intent(BookingRequestActivity.this,
                        PaymentActivity.class);
                startActivity(intent);
                break;

            case R.id.select_date_btn:
                generalUtils.selectDateFromCalender(this, selectedDateTv);
                break;

            case R.id.add_guest_btn:
                guests = generalUtils.addGuests();
                generalUtils.guest = guests;
                selectedGuestsTv.setText(guests+" guests");

                displayPaymentReceipt(guests);
                break;

            case R.id.remove_guest_btn:
                guests = generalUtils.removeGuests();
                generalUtils.guest = guests;
                selectedGuestsTv.setText(guests+" guests");

                displayPaymentReceipt(guests);
                break;

        }
    }

    public void displayPaymentReceipt(int guestNum){
        payment.setGuestNum(guestNum);
        guestPerMealTv.setText("Ksh "+payment.getMealPerGuestCost()+" x "+payment.getGuestNum());
        mealCostTv.setText("Ksh "+payment.getTotalMealCost());
        bookingFeeTv.setText("Ksh "+payment.getBookingFee());
        totalCostTv.setText("Ksh "+payment.getTotalCost());

    }
}
