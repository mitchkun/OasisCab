package com.example.oasiscab;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import com.google.firebase.auth.FirebaseAuth;
import android.widget.Button;
import android.content.Intent;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

//    local variable declaration
    Button btnLogOut;
    TextView Name;
    FirebaseAuth firebaseAuth;
    private FirebaseAuth.AuthStateListener authStateListener;
    private static final String TAG_HOME = "home";
    private static final String TAG_PROFILE = "profile";
    private static final String TAG_FAVOURITE_LOCATION = "favouriteLocation";
    private static final String TAG_PAST_TRIP = "pastTrip";
    private static final String TAG_REPORT_ISSUE = "reportIssue";
    private static final String TAG_SETTINGS = "settings";
    private static final String TAG_HELP_AND_SUPPORT = "helpAndSupport";
    public static String CURRENT_TAG = TAG_HOME;

    // index to identify current nav menu item
    public static int navItemIndex = 0;
    private DrawerLayout drawer;
    private NavigationView navigationView;
    private Toolbar toolbar;
    private Handler mHandler;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nav_header_main);
        Name = findViewById(R.id.profile_name);
        Name.setText("Text Changed");
        setContentView(R.layout.activity_main);
        btnLogOut = (Button) findViewById(R.id.btnLogOut);
//        btnLogOut.setOnClickListener(new View.OnClickListener() {
//          @Override
 //           public void onClick(View view) {
//
 //               FirebaseAuth.getInstance().signOut();
 //               Intent I = new Intent(MainActivity.this, Login.class);
 //               startActivity(I);
//
 //           }
 //      });

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mHandler = new Handler();

        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        // initializing navigation menu
        setUpNavigationView();

        if (savedInstanceState == null) {
            navItemIndex = 0;

            CURRENT_TAG = TAG_HOME;
            loadHomeFragment();
        }
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }



    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            // Handle the camera action
        } else if (id == R.id.nav_profile) {

        } else if (id == R.id.nav_favourite_location) {

        } else if (id == R.id.nav_past_trips) {

        } else if (id == R.id.nav_settings) {

        } else if (id == R.id.nav_help_and_support) {

        } else if (id == R.id.nav_report_issue) {

        }else if(id == R.id.btnLogOut){

            FirebaseAuth.getInstance().signOut();
            Intent I = new Intent(MainActivity.this, Login.class);
            startActivity(I);


        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    private void loadHomeFragment() {
        // if user select the current navigation menu again, don't do anything
        // just close the navigation drawer
        if (getSupportFragmentManager().findFragmentByTag(CURRENT_TAG) != null) {
            drawer.closeDrawers();

            return;
        }
        Runnable mPendingRunnable = new Runnable() {
            @Override
            public void run() {
                // update the main content by replacing fragments
                Fragment fragment = getHomeFragment();
                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.setCustomAnimations(android.R.anim.fade_in,
                        android.R.anim.fade_out);
                fragmentTransaction.replace(R.id.frame, fragment, CURRENT_TAG);
                fragmentTransaction.commitAllowingStateLoss();
            }
        };

        // If mPendingRunnable is not null, then add to the message queue
        if (mPendingRunnable != null) {
            mHandler.post(mPendingRunnable);
        }

        //Closing drawer on item click
        drawer.closeDrawers();

        // refresh toolbar menu
        invalidateOptionsMenu();
    }

    private Fragment getHomeFragment() {
        switch (navItemIndex) {
            case 0:
                // home
               Home homeFragment = new Home();

                return homeFragment;
            case 1:
                // Profile
                MyProfileFragment myProfileFragment = new MyProfileFragment();

                return myProfileFragment;

            case 2:
                // Favourite Location fragment
                FavouriteLocation favouriteLocation = new FavouriteLocation();

                return favouriteLocation;

            case 3:
                // past trips fragment
                PastTrips pastTrips = new PastTrips();

                return pastTrips;

            case 4:
                // Report issue fragment
                ReportIssue reportIssue = new ReportIssue();

                return reportIssue;


            case 5:
                // Settings fragment
                Settings settings = new Settings();

                return settings;

            case 6:
                // Help and Support fragment
                HelpAndSupport helpAndSupport = new HelpAndSupport();

                return helpAndSupport;

            default:
                return new Home();
        }
    }

    private void setUpNavigationView() {
        //Setting Navigation View Item Selected Listener to handle the item click of the navigation menu
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {

            // This method will trigger on item Click of navigation menu
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {

                //Check to see which item was being clicked and perform appropriate action
                switch (menuItem.getItemId()) {
                    //Replacing the main content with ContentFragment Which is our Inbox View;
                    case R.id.nav_home:
                        navItemIndex = 0;
                        CURRENT_TAG = TAG_HOME;
                        break;
                    case R.id.nav_profile:
                        navItemIndex = 1;
                        CURRENT_TAG = TAG_PROFILE;
                        break;
                    case R.id.nav_favourite_location:
                        navItemIndex = 2;
                        CURRENT_TAG = TAG_FAVOURITE_LOCATION;
                        break;
                    case R.id.nav_past_trips:
                        navItemIndex = 3;
                        CURRENT_TAG = TAG_PAST_TRIP;
                        break;
                    case R.id.nav_settings:
                        navItemIndex = 5;
                        CURRENT_TAG = TAG_SETTINGS;
                        break;
                    case R.id.nav_help_and_support:
                        navItemIndex = 6;
                        CURRENT_TAG = TAG_HELP_AND_SUPPORT;
                        break;
                    case R.id.nav_report_issue:
                        navItemIndex = 4;
                        CURRENT_TAG = TAG_REPORT_ISSUE;
                        break;

                    default:
                        navItemIndex = 0;
                }

                //Checking if the item is in checked state or not, if not make it in checked state
                if (menuItem.isChecked()) {
                    menuItem.setChecked(false);
                } else {
                    menuItem.setChecked(true);
                }
                menuItem.setChecked(true);

                loadHomeFragment();

                return true;
            }
        });


        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.openDrawer, R.string.closeDrawer) {

            @Override
            public void onDrawerClosed(View drawerView) {
                // Code here will be triggered once the drawer closes as we dont want anything to happen so we leave this blank
                super.onDrawerClosed(drawerView);
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                // Code here will be triggered once the drawer open as we dont want anything to happen so we leave this blank
                super.onDrawerOpened(drawerView);
            }
        };

        //Setting the actionbarToggle to drawer layout
        drawer.setDrawerListener(actionBarDrawerToggle);

        //calling sync state is necessary or else your hamburger icon wont show up
        actionBarDrawerToggle.syncState();
    }
}
