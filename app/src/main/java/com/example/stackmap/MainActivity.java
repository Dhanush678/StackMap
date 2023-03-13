package com.example.stackmap;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity    {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView nav;


        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        list[] myMovieData = new list[]{
                new list("Basic Concepts","Structures,Pointers",R.drawable.dsa),
                new list("Arrays","Arrays in Data Structure,2D,3D Arrays",R.drawable.arraty),
                new list("Linked List","Definition,Types of Linked List,Singly and Doubly Linked list,Circular",R.drawable.linkedsec),
                new list("Stack","Implementation Using Array and linked List",R.drawable.linked),
                new list("Queues","Implementation Using Array and Linked List,Dequeue,Circular Linked,Priority Queues",R.drawable.queuedtr),
                new list("Trees","Types of Trees,Binary tree,Binary search tree,AVL Trees,B Tree,B+ Tree",R.drawable.treee),
                new list("Graphs","Implementation, BFS ,DFS,Spanning Trees",R.drawable.graph),
        };

        listadapter listadapter = new listadapter(myMovieData,MainActivity.this);
        recyclerView.setAdapter(listadapter);
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
    boolean doubleBackToExitPressedOnce = false;

    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed();
            return;
        }

        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, "Please click BACK again to exit", Toast.LENGTH_SHORT).show();

        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {

            @Override
            public void run() {
                doubleBackToExitPressedOnce=false;
            }
        }, 1000);
    }

}
