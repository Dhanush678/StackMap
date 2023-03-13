package com.example.searching;

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
 * Use the {@link search#newInstance} factory method to
 * create an instance of this fragment.
 */
public class search extends Fragment  {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public search() {
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
    public static search newInstance(String param1, String param2) {
        search fragment = new search();
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
        View rootView = inflater.inflate(R.layout.fragment_search, container, false);

        RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        list[] myMovieData = new list[]{
                new list("Linear Search","",R.drawable.linearsec),
                new list("Sentinel Linear Search","",R.drawable.sential),
                new list("Binary Search","",R.drawable.binarysearch),
                new list("One-Sided Binary Search","",R.drawable.linked),

        };

        listadaptersec listadaptersec = new listadaptersec(myMovieData, (algorithm) getActivity());
        recyclerView.setAdapter(listadaptersec);

        // 5. set item animator to DefaultAnimator
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        return rootView;


        // Inflate the layout for this fragment
    }

}