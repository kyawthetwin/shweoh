package moneytransfer.miracle.com.shweoh.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import moneytransfer.miracle.com.shweoh.Fragment.LoginFragment;
import moneytransfer.miracle.com.shweoh.Fragment.RegisterFragment;

/**
 * Created by kyawthetwin on 5/22/17.
 */

public class PagerAdapter extends FragmentPagerAdapter {

    int mNumOfTabs;
    public PagerAdapter(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                RegisterFragment tab1 = new RegisterFragment();
                return tab1;
            case 1:
                LoginFragment tab2 = new LoginFragment();
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
