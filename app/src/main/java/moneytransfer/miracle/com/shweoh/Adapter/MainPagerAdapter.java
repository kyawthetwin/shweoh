package moneytransfer.miracle.com.shweoh.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import moneytransfer.miracle.com.shweoh.Fragment.CourseFragment;
import moneytransfer.miracle.com.shweoh.Fragment.TutorialFragment;

/**
 * Created by user on 5/22/17.
 */

public class MainPagerAdapter extends FragmentPagerAdapter {
    int mNumOfTabs;
    public MainPagerAdapter(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                TutorialFragment tab1 = new TutorialFragment();
                return tab1;
            case 1:
                CourseFragment tab2 = new CourseFragment();
                return tab2;

            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}