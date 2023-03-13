package com.example.stackmap;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.searching.search;
import com.example.sorting.sort;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.tabs.TabLayout;

public class algorithm extends AppCompatActivity    {
    int count=0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_algorithm);
        BottomNavigationView nav;


        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        ViewPagerAdapter viewPagerAdapter;
        ViewPager viewPager;
        TabLayout tabLayout;
        viewPager = findViewById(R.id.viewpagersec);
        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());

        // add the fragments
        viewPagerAdapter.add(new search(), "Searching");
        viewPagerAdapter.add(new sort(), "Sorting");

        // Set the adapter
        viewPager.setAdapter(viewPagerAdapter);

        // The Page (fragment) titles will be displayed in the
        // tabLayout hence we need to  set the page viewer
        // we use the setupWithViewPager().
        tabLayout = findViewById(R.id.tab_layoutsec);
        tabLayout.setupWithViewPager(viewPager);


        list[] myMovieData = new list[]{
                new list("searching","Structures,Pointers",R.drawable.dsa),
                new list("Arrays","Arrays in Data Structure,2D,3D Arrays",R.drawable.arraty),
                new list("Linked List","Definition,Types of Linked List,Singly and Doubly Linked list,Circular and Circular Doubly Linked,Skip List",R.drawable.linkedsec),
                new list("Stack","Implementation Using Array and linked List",R.drawable.linked),
                new list("Queues","Implementation Using Array and Linked List,Dequeue,Circular Linked,Priority Queues",R.drawable.queuedtr),
                new list("Trees","Types of Trees,Binary tree,Binary search tree,AVL Trees,B Tree,B+ Tree",R.drawable.treee),
                new list("Graphs","Implementation, BFS ,DFS,Spanning Trees",R.drawable.graph),
        };

        listadaptersec listadaptersec = new listadaptersec(myMovieData,algorithm.this);
        recyclerView.setAdapter(listadaptersec);
        nav=findViewById(R.id.bottomNavigationView);
        nav.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()){
                    case R.id.DataStructure:
                        startActivity(new Intent(getApplicationContext(),MainActivity.class));
                        finish();
                        break;
                    case R.id.Algorithms:
                        startActivity(new Intent(getApplicationContext(), algorithm.class));
                        finish();
                        break;


                }





                return true;
            }
        });

    }
    @Override
    public void onBackPressed() {

        count++;
        if (count <=1) {
        /* If count is greater than 1 ,you can either move to the next
        activity or just quit. */
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            finish();

            /* Quitting */
            finishAffinity();
        } else {
            Toast.makeText(this, "Press back again to Leave!", Toast.LENGTH_SHORT).show();

            // resetting the counter in 2s
            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    count = 0;
                }
            }, 1000);
        }
        super.onBackPressed();    }

}
