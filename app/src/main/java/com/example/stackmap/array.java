package com.example.stackmap;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.example.array.arrayfragment;
import com.example.basicfragment.c;
import com.google.android.material.tabs.TabLayout;

public class array extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_array);

        ViewPagerAdapter viewPagerAdapter;
        ViewPager viewPager;
        TabLayout tabLayout;
        viewPager = findViewById(R.id.viewpager);

        // setting up the adapter
        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());

        // add the fragments
        viewPagerAdapter.add(new arrayfragment(), "C Program");


        // Set the adapter
        viewPager.setAdapter(viewPagerAdapter);

        // The Page (fragment) titles will be displayed in the
        // tabLayout hence we need to  set the page viewer
        // we use the setupWithViewPager().
        tabLayout = findViewById(R.id.tab_layout);
        tabLayout.setupWithViewPager(viewPager);
    }
}