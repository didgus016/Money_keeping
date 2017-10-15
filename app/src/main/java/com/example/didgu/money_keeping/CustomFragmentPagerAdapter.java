package com.example.didgu.money_keeping;

import android.app.Fragment;
import android.content.Context;
import android.app.FragmentManager;
import android.support.v13.app.FragmentPagerAdapter;

/**
 * Created by didgu on 2017-06-30.
 */

public class CustomFragmentPagerAdapter extends FragmentPagerAdapter {

    // Context that the adapter is getting called from
    private Context mContext;

    // Constructor
    public CustomFragmentPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    /**
     * returns the number of fragments
     * @return numberOfPages
     */
    @Override
    public int getCount() {
        return 3;
    }

    /**
     * Returns the fragment at the current position
     * @param position Current position of the viewPager
     * @return Appropriate Fragment
     */
    @Override
    public Fragment getItem(int position) {
        if (position == 0)
            return new AddEntryFragment();
        else if (position == 1)
            return new ExpenditureListFragment();
        else if (position == 2)
            return new SettingFragment();
        else
            return null;
    }

    /**
     * Returns page title according to the position
     * @param position Current position of the viewPager
     * @return String of page title
     */
    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0)
            return "Add";
        else if (position == 1)
            return "Expenditure";
        else if (position == 2)
            return "Settings";
        else
            return null;
    }
}
