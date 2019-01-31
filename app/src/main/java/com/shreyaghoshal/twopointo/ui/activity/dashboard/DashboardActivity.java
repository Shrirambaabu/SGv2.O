package com.shreyaghoshal.twopointo.ui.activity.dashboard;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ListView;

import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;
import com.shreyaghoshal.twopointo.R;
import com.shreyaghoshal.twopointo.base.ActivityContext;
import com.shreyaghoshal.twopointo.ui.fragments.feeds.FeedsFragment;
import com.shreyaghoshal.twopointo.ui.fragments.profile.ProfileFragment;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DashboardActivity extends AppCompatActivity implements DashboardContract.View, BottomNavigationView.OnNavigationItemSelectedListener {


    private Context mContext = DashboardActivity.this;
    @Inject
    DashboardPresenter dashboardPresenter;
    private int backState = 1;
    Fragment fragment;
    @BindView(R.id.bottomNavigationView)
    BottomNavigationViewEx bottomNavigationViewEx;
    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.drawer_layout)
    DrawerLayout mDrawerLayout;
    @BindView(R.id.nav_view)
    NavigationView navigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        ButterKnife.bind(this);

        DaggerDashboardComponent.builder()
                .activityContext(new ActivityContext(mContext))
                .build()
                .inject(this);
        dashboardPresenter.attach(this);
        bottomNavigationViewEx.setOnNavigationItemSelectedListener(this);
        setupBottomViewer();
        setToolBar();
    }

    private void setToolBar() {
        toolbar.setTitle("Feeds");
        toolbar.setTitleTextColor(getResources().getColor(android.R.color.black));
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(R.drawable.ic_menu);
        }
        loadFragment(new FeedsFragment());
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {

            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void setupBottomViewer() {

        int[][] states = new int[][] {
                new int[] { android.R.attr.state_enabled}, // enabled
                new int[] {-android.R.attr.state_enabled}, // disabled
                new int[] {-android.R.attr.state_checked}, // unchecked
                new int[] { android.R.attr.state_checked}, // checked
        };

        int[] colors = new int[] {
                Color.RED,
                Color.GREEN,
                Color.GREEN,
                Color.BLUE
        };

        ColorStateList myList = new ColorStateList(states, colors);

        bottomNavigationViewEx.setTextVisibility(true);
        bottomNavigationViewEx.enableAnimation(true);
        bottomNavigationViewEx.enableShiftingMode(false);
        bottomNavigationViewEx.enableItemShiftingMode(false);
        bottomNavigationViewEx.setTextSize(10);
        bottomNavigationViewEx.setIconSize(24);
        /*bottomNavigationViewEx.setIconTintList(0,myList);
        bottomNavigationViewEx.setIconTintList(1,myList);*/

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        displaySelectedItem(menuItem.getItemId());
        return true;
    }


    private void displaySelectedItem(int itemId) {
        switch (itemId) {
            case R.id.ic_feed:
                if (backState != 1) {
                    bottomNavigationViewEx.getMenu().getItem(0).setChecked(true);
                    backState = 1;
                    fragment = new FeedsFragment();
                    toolbar.setTitle("Feeds");
                    loadFragment(fragment);
                }
                break;

            case R.id.ic_membership:
                if (backState != 2) {
                    backState = 2;
                    bottomNavigationViewEx.getMenu().getItem(1).setChecked(true);
                    fragment = new ProfileFragment();
                    toolbar.setTitle("Coaches");
                    loadFragment(fragment);
                }
                break;
            case R.id.ic_profile:
                if (backState != 3) {
                    bottomNavigationViewEx.getMenu().getItem(2).setChecked(true);
                    backState = 3;

                    fragment = new ProfileFragment();
                    toolbar.setTitle("Profile");

                    loadFragment(fragment);
                }
                break;
        }
    }



    private void loadFragment(Fragment fragment) {
        // load fragment
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}
