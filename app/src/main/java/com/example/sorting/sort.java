package com.example.sorting;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.stackmap.R;
import com.example.stackmap.algorithm;
import com.example.stackmap.list;
import com.example.stackmap.listadaptersec;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link sort#newInstance} factory method to
 * create an instance of this fragment.
 */
public class sort extends Fragment  {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public sort() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment search.
     */
    // TODO: Rename and change types and number of parameters
    public static sort newInstance(String param1, String param2) {
        sort fragment = new sort();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);










        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_sort, container, false);

        RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        list[] myMovieData = new list[]{
                new list("sorting","Structures,Pointers",R.drawable.dsa),
                new list("worjing","Arrays in Data Structure,2D,3D Arrays",R.drawable.arraty),
                new list("Linked List","Definition,Types of Linked List,Singly and Doubly Linked list,Circular and Circular Doubly Linked,Skip List",R.drawable.linkedsec),
                new list("Stack","Implementation Using Array and linked List",R.drawable.linked),
                new list("Queues","Implementation Using Array and Linked List,Dequeue,Circular Linked,Priority Queues",R.drawable.queuedtr),
                new list("Trees","Types of Trees,Binary tree,Binary search tree,AVL Trees,B Tree,B+ Tree",R.drawable.treee),
                new list("Graphs","Implementation, BFS ,DFS,Spanning Trees",R.drawable.graph),
        };

        listadaptersec listadaptersec = new listadaptersec(myMovieData, (algorithm) getActivity());
        recyclerView.setAdapter(listadaptersec);

        // 5. set item animator to DefaultAnimator
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        return rootView;


        // Inflate the layout for this fragment
    }

}