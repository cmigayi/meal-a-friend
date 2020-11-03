package com.codevated.mealafriend;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import Common.CircleTransform;
import Common.CustomPagerAdapter;
import Presenters.SearchActivityPresenter;
import Views.SearchActivityView;

public class SearchActivity extends AppCompatActivity implements View.OnClickListener,
        NavigationView.OnNavigationItemSelectedListener, SearchActivityView{

    ImageButton menuBtn;
    ImageView hostImg;
    TextView titleTv;
    SearchView searchView;
    Toolbar topbar;
    DrawerLayout mDrawerLayout;
    NavigationView navigationView;

    TabLayout tabLayout;
    ViewPager viewPager;

    Intent intent;
    SearchActivityPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        overridePendingTransition(0,0);
        setContentView(R.layout.activity_search);

        topbar = (Toolbar) findViewById(R.id.top_bar);

        menuBtn = (ImageButton) topbar.findViewById(R.id.menu_btn);
        //titleTv = (TextView) topbar.findViewById(R.id.page_title);
        searchView = (SearchView) topbar.findViewById(R.id.searchView);

        mDrawerLayout = findViewById(R.id.drawer_layout);

        navigationView = findViewById(R.id.nav_view);
        View headerView = navigationView.getHeaderView(0);
        hostImg = headerView.findViewById(R.id.host_img);

        Picasso.with(this).load(R.drawable.host1).transform(new CircleTransform()).into(hostImg);

        navigationView.setItemIconTintList(null);
        navigationView.setNavigationItemSelectedListener(this);

        mDrawerLayout.addDrawerListener(
                new DrawerLayout.DrawerListener() {
                    @Override
                    public void onDrawerSlide(View drawerView, float slideOffset) {
                        // Respond when the drawer's position changes
                    }

                    @Override
                    public void onDrawerOpened(View drawerView) {
                        // Respond when the drawer is opened
                    }

                    @Override
                    public void onDrawerClosed(View drawerView) {
                        // Respond when the drawer is closed
                    }

                    @Override
                    public void onDrawerStateChanged(int newState) {
                        // Respond when the drawer motion state changes
                    }
                }
        );

        menuBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mDrawerLayout.openDrawer(GravityCompat.START);
            }
        });

        tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        tabLayout.addTab(tabLayout.newTab().setText("Home").setIcon(R.drawable.ic_home_black_24dp));
        tabLayout.addTab(tabLayout.newTab().setText("Messages").setIcon(R.drawable.message_icon));
        tabLayout.addTab(tabLayout.newTab().setText("Bookings").setIcon(R.drawable.booking_icon));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        viewPager = (ViewPager) findViewById(R.id.pager);
        CustomPagerAdapter pagerAdapter = new CustomPagerAdapter(getSupportFragmentManager(),
                tabLayout.getTabCount(),"Search");
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

        presenter = new SearchActivityPresenter(this, null);
    }

    @Override
    public void onClick(View view) {

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        switch(id){
            case R.id.nav_home:
                Toast.makeText(this,"Home",Toast.LENGTH_LONG).show();
                break;
            case R.id.nav_my_profile:
                intent = new Intent(SearchActivity.this, MyProfileActivity.class);
                startActivity(intent);
                break;
            case R.id.nav_host:
                break;
            case R.id.nav_help:
                break;
        }
        return false;
    }

    @Override
    public void displayNoSearchItem() {

    }

    @Override
    public void displaySearchItem() {

    }

    @Override
    public void displayuserInfo() {

    }
}
