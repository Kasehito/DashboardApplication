package com.example.dashboardapplication.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dashboardapplication.Items;
import com.example.dashboardapplication.MyAdapter;
import com.example.dashboardapplication.R;

import java.util.ArrayList;
import java.util.List;

public class Menu2dFragment extends Fragment {

    RecyclerView recyclerView;
    MyAdapter adapter;
    List<Items> items;

    @Override
    public View onCreateView(LayoutInflater layoutInflater,ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View view = layoutInflater.inflate(R.layout.fragment_menu2d, container);
        items = new ArrayList<>();
        items.add(new Items("dadw","https://img.freepik.com/premium-vector/school-background-with-doodles-vector-illustration-hand-drawn-style-rulers-triangles-school-supplies-vector-illustration_647193-3275.jpg"));
        recyclerView = view.findViewById(R.id.rv2dMenu);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));  // 2 untuk 2 kolom
        adapter = new MyAdapter(getActivity(), items);
        recyclerView.setAdapter(adapter);

        return view;
    }
}
