package com.rossconnacher.whattoplay;

import android.app.Fragment;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, BottomNavigationView.OnNavigationItemSelectedListener,
                    HallOfFameFragment.OnFragmentInteractionListener,
                    ComingSoonFragment.OnFragmentInteractionListener,
                    DiscoverFragment.OnFragmentInteractionListener,
                    HotFragment.OnFragmentInteractionListener,
                    MyGamesFragment.OnFragmentInteractionListener,
                    NewFragment.OnFragmentInteractionListener,
                    WishlistFragment.OnFragmentInteractionListener,
                    GameInfoFragment.OnFragmentInteractionListener,
                    GameVideosFragment.OnFragmentInteractionListener,
                    GameStreamsFragment.OnFragmentInteractionListener,
                    GameFragment.OnFragmentInteractionListener
{

    private static final String TAG = "MainActivity";
    private DrawerLayout mDrawerLayout;
    private BottomNavigationView mBottomNav;
    private NavigationView mTopNav;
    private IGDBEngine mGameEngine;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, mDrawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        mDrawerLayout.setDrawerListener(toggle);
        toggle.syncState();

        mTopNav = (NavigationView) findViewById(R.id.nav_view);
        mTopNav.setNavigationItemSelectedListener(this);

        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);

        mGameEngine = new IGDBEngine();

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
        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        Fragment mFrag = new Fragment();
        //top nav
        if (id == R.id.nav_my_games) {
            bottomNavigationView.setVisibility(View.GONE);
            mFrag = new MyGamesFragment();
            mDrawerLayout.closeDrawer(GravityCompat.START);
        } else if (id == R.id.nav_discover_games) {
            bottomNavigationView.setVisibility(View.VISIBLE);
            bottomNavigationView.setSelectedItemId(R.id.navigation_discover);
            mFrag = new DiscoverFragment();
            mDrawerLayout.closeDrawer(GravityCompat.START);
        } else if (id == R.id.nav_wishlist){
            bottomNavigationView.setVisibility(View.GONE);
            mFrag = new WishlistFragment();
            mDrawerLayout.closeDrawer(GravityCompat.START);
        }

        //bottom nav
        else if(id == R.id.navigation_discover) {
            mFrag = new DiscoverFragment();
        } else if(id == R.id.navigation_hot) {
            mFrag = new HotFragment();
        } else if(id == R.id.navigation_hall_of_fame) {
            mFrag = new HallOfFameFragment();
        } else if(id == R.id.navigation_new) {
            mFrag = new NewFragment();
        } else if(id == R.id.navigation_coming_soon) {
            mFrag = new ComingSoonFragment();
        }

        android.app.FragmentManager fragmentManager = getFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.contentFrame, mFrag).commit();

        return true;
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
