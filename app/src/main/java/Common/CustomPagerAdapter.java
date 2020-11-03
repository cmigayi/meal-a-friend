package Common;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.Log;

import com.codevated.mealafriend.BookingsFragment;
import com.codevated.mealafriend.BookingsPassedFragment;
import com.codevated.mealafriend.BookingsRequestsFragment;
import com.codevated.mealafriend.HostFragment;
import com.codevated.mealafriend.LocationFragment;
import com.codevated.mealafriend.MessagesFragment;
import com.codevated.mealafriend.ReviewsFragment;
import com.codevated.mealafriend.AboutMealFragment;
import com.codevated.mealafriend.HomeFragment;

/**
 * Created by cilo on 5/28/18.
 */

public class CustomPagerAdapter extends FragmentStatePagerAdapter {
    int numOfTabs;
    String activityName;

    public CustomPagerAdapter(FragmentManager fm, int numOfTabs, String actitivityName)  {
        super(fm);
        this.numOfTabs = numOfTabs;
        this.activityName = actitivityName;
    }

    @Override
    public Fragment getItem(int position) {
        if(activityName == "Search"){
            switch(position) {
                case 0:
                    Log.d("tabpos", String.valueOf(position));
                    HomeFragment homeFragment = new HomeFragment();
                    //pageTitle.setText("Search");
                    return homeFragment;
                case 1:
                    Log.d("tabpos", String.valueOf(position));
                    MessagesFragment messagesFragment = new MessagesFragment();
                    // pageTitle.setText("Messages");
                    return messagesFragment;
                case 2:
                    Log.d("tabpos", String.valueOf(position));
                    BookingsFragment bookingsFragment = new BookingsFragment();
                    //pageTitle.setText("Bookings");
                    return bookingsFragment;
            }
        }

        if(activityName == "MealInfo") {
            switch (position) {
                case 0:
                     AboutMealFragment aboutMealFragment = new AboutMealFragment();
                     return aboutMealFragment;
                case 1:
                     HostFragment hostFragment = new HostFragment();
                     return hostFragment;
                case 2:
                    ReviewsFragment reviewsFragment = new ReviewsFragment();
                    return reviewsFragment;
                case 3:
                     LocationFragment locationFragment = new LocationFragment();
                     return locationFragment;
            }
        }

        if(activityName == "bookingsFragment") {
            switch (position) {
                case 0:
                    BookingsRequestsFragment bookingsRequestsFragment = new BookingsRequestsFragment();
                    return bookingsRequestsFragment;
                case 1:
                    BookingsPassedFragment bookingsPassedFragment = new BookingsPassedFragment();
                    return bookingsPassedFragment;
            }
        }

        return null;
    }

    @Override
    public int getCount() {
        return numOfTabs;
    }
}
