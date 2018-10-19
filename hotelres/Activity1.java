package com.example.student.hotelres;

import android.net.Uri;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.widget.TextView;

//import android.R;

public class Activity1 extends AppCompatActivity implements fragment1.OnFragmentInteractionListener, fragment2.OnFragmentInteractionListener, fragment3.OnFragmentInteractionListener, fragment4.OnFragmentInteractionListener{

    private String shareInFragments = "";
    private String tag = "Tabs MainActivity";

    public HotelReservation reservation;

    public String getShareInFragments(){
        return shareInFragments;
    }

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        reservation = new HotelReservation();

        Log.i(tag,"onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_1);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(tag,"onStart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(tag,"onStop");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(tag,"onPause");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(tag,"onResume");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(tag,"onDestroy");
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_activity1, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onFragmentInteraction(String value) {
        shareInFragments = value;
        shareInFragments += reservation.toString();
    }

    public void addAdults(){
        int currentAdults = reservation.getAdults();
        currentAdults++;
        reservation.setAdults(currentAdults);
    }

    public void addChildren(){
        int currentChildren = reservation.getChildren();
        currentChildren++;
        reservation.setChildren(currentChildren);
    }

    public void addRoom(){
        int currentRooms = reservation.getRooms();
        currentRooms++;
        reservation.setRooms(currentRooms);
    }

    public void addCheckIn(String checkIn){
        reservation.setCheckIn(checkIn);
    }

    public void addCheckOut(String checkOut){
        reservation.setCheckOut(checkOut);
    }

    public void addRoomSelection(String room){
        reservation.setRoomType(room);
    }

    public void addName(String name){
        reservation.setName(name);
    }

    public void addStreet(String street){
        reservation.setStreet(street);
    }

    public void addCity(String city){
        reservation.setCity(city);
    }

    public void addState(String state){
        reservation.setState(state);
    }

    public void addPhone(String phone){
        reservation.setPhone(phone);
    }

    public void addeMail(String eMail){
        reservation.seteMail(eMail);
    }

    public void onFragmentInteraction(Uri uri) {

    }



    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        public PlaceholderFragment() {
        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_activity1, container, false);
            TextView textView = (TextView) rootView.findViewById(R.id.section_label);
            textView.setText(getString(R.string.section_format, getArguments().getInt(ARG_SECTION_NUMBER)));
            return rootView;
        }
    }

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            switch (position){
                case 0: return fragment1.newInstance();
                case 1: return fragment2.newInstance("hello", "world");
                case 2: return fragment3.newInstance("hello", "world");
                case 3: return fragment4.newInstance("hello", "world");
                default: return PlaceholderFragment.newInstance(position + 1);
            }
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 4;
        }
    }
}
