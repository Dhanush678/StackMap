package com.example.stackmap;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.example.array.arrayfragment;
import com.example.linkedlist.DoublyLinked;
import com.example.linkedlist.Linkedlist;
import com.example.linkedlist.circular_linked;
import com.google.android.material.tabs.TabLayout;

public class linkedlist extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linkedlist);
        ViewPagerAdapter viewPagerAdapter;
        ViewPager viewPager;
        TabLayout tabLayout;
        viewPager = findViewById(R.id.viewpager);

        // setting up the adapter
        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());

        // add the fragments

        viewPagerAdapter.add(new Linkedlist(), "Linear");
        viewPagerAdapter.add(new circular_linked(), "Circular");
        viewPagerAdapter.add(new DoublyLinked(), "Doubly");


        viewPager.setAdapter(viewPagerAdapter);
        tabLayout = findViewById(R.id.tab_layout);
        tabLayout.setupWithViewPager(viewPager);
    }
}