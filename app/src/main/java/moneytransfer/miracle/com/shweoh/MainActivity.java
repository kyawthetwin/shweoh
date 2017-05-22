package moneytransfer.miracle.com.shweoh;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import moneytransfer.miracle.com.shweoh.Adapter.MainPagerAdapter;
import moneytransfer.miracle.com.shweoh.Fragment.FragmentDrawer;
import moneytransfer.miracle.com.shweoh.Fragment.FriendsFragment;
import moneytransfer.miracle.com.shweoh.Fragment.HomeFragment;
import moneytransfer.miracle.com.shweoh.Fragment.MessagesFragment;
import moneytransfer.miracle.com.shweoh.Adapter.MainPagerAdapter;
import moneytransfer.miracle.com.shweoh.Adapter.PagerAdapter;

public class MainActivity extends AppCompatActivity implements FragmentDrawer.FragmentDrawerListener  {





    private Toolbar mToolbar;
    private FragmentDrawer drawerFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout_main);
        tabLayout.addTab(tabLayout.newTab().setText("Tutorials"));
        tabLayout.addTab(tabLayout.newTab().setText("Courses"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        final ViewPager viewPager = (ViewPager) findViewById(R.id.mainPager);
        final MainPagerAdapter mainPagerAdapter = new MainPagerAdapter(getSupportFragmentManager(), tabLayout.getTabCount());
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

            }
        });


        mToolbar = (Toolbar) findViewById(R.id.toolbar);

        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        drawerFragment = (FragmentDrawer)
                getSupportFragmentManager().findFragmentById(R.id.fragment_navigation_drawer);
        drawerFragment.setUp(R.id.fragment_navigation_drawer, (DrawerLayout) findViewById(R.id.drawer_layout), mToolbar);
        drawerFragment.setDrawerListener(this);

    }

    @Override
    public void onDrawerItemSelected(View view, int position) {
        displayView(position);
    }

    private void displayView(int position) {
        Fragment fragment = null;
        String title = getString(R.string.app_name);
        switch (position) {
            case 0:
                fragment = new HomeFragment();
                title = getString(R.string.nav_item_home);
                break;
            case 1:
                fragment = new FriendsFragment();
                title = getString(R.string.nav_item_friends);
                break;
            case 2:
                fragment = new MessagesFragment();
                title = getString(R.string.nav_item_notifications);
                break;
            default:
                break;
        }

        if (fragment != null) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.container_body, fragment);
            fragmentTransaction.commit();

            // set the toolbar title
            getSupportActionBar().setTitle(title);
        }

    }
}
