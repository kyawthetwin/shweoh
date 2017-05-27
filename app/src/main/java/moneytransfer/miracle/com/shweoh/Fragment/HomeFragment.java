package moneytransfer.miracle.com.shweoh.Fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import moneytransfer.miracle.com.shweoh.Adapter.MainPagerAdapter;
import moneytransfer.miracle.com.shweoh.R;

/**
 * Created by kyawthetwin on 5/22/17.
 */

public class HomeFragment extends android.support.v4.app.Fragment {

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);

        TabLayout tabLayout = (TabLayout) rootView.findViewById(R.id.tab_layout_main);
        tabLayout.addTab(tabLayout.newTab().setText("Tutorials"));
        tabLayout.addTab(tabLayout.newTab().setText("Courses"));
        tabLayout.setSelectedTabIndicatorColor(getResources().getColor(R.color.colorPrimaryDark));
        tabLayout.setDrawingCacheBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        final ViewPager viewPager = (ViewPager) rootView.findViewById(R.id.mainPager);
        final MainPagerAdapter mainPagerAdapter = new MainPagerAdapter(getFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(mainPagerAdapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }
        });

        // Inflate the layout for this fragment
        return rootView;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }
}
