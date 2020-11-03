package com.codevated.mealafriend;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
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
import Common.CustomPagerAdapter;

public class MealInfoActivity extends AppCompatActivity implements View.OnClickListener {
    TextView titleTv;
    ImageButton menuBtn, backBtn;
    Button requestBookingBtn;
    SearchView searchView;
    Toolbar topbar;
    TabLayout tabLayout;
    ViewPager viewPager;

    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meal_info);

        topbar = (Toolbar) findViewById(R.id.top_bar);

        menuBtn = (ImageButton) topbar.findViewById(R.id.menu_btn);
        backBtn = (ImageButton) topbar.findViewById(R.id.back_btn);
        titleTv = (TextView) topbar.findViewById(R.id.page_title);
        searchView = (SearchView) topbar.findViewById(R.id.searchView);

        titleTv.setText("Sukumawiki and ugali");
        searchView.setVisibility(View.GONE);
        backBtn.setVisibility(View.VISIBLE);
        menuBtn.setVisibility(View.GONE);

        tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        tabLayout.addTab(tabLayout.newTab().setText("About meal"));
        tabLayout.addTab(tabLayout.newTab().setText("Host"));
        tabLayout.addTab(tabLayout.newTab().setText("Reviews"));
        tabLayout.addTab(tabLayout.newTab().setText("Location"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        viewPager = (ViewPager) findViewById(R.id.pager);
        CustomPagerAdapter pagerAdapter = new CustomPagerAdapter(getSupportFragmentManager(),
                tabLayout.getTabCount(),"MealInfo");
        viewPager.setAdapter(pagerAdapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        requestBookingBtn = (Button)findViewById(R.id.request_booking_btn);

        backBtn.setOnClickListener(this);
        requestBookingBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();

        switch(id){
            case R.id.back_btn:
                this.finish();
                break;
            case R.id.request_booking_btn:
                intent = new Intent(MealInfoActivity.this, BookingRequestActivity.class);
                startActivity(intent);
                break;
        }
    }
}
