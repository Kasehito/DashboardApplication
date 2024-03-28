package com.example.dashboardapplication.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dashboardapplication.CalculatorActivity;
import com.example.dashboardapplication.Items;
import com.example.dashboardapplication.MyAdapter;
import com.example.dashboardapplication.R;

import java.util.ArrayList;
import java.util.List;

public class Menu3dFragment extends Fragment implements MyAdapter.ItemClickListener {
    RecyclerView recyclerView;
    MyAdapter adapter;
    List<Items> items;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_menu3d, container, false);

        items = new ArrayList<>();
        items.add(new Items("cube", R.drawable.cube));
        items.add(new Items("pyramid", R.drawable.pyramid));
        items.add(new Items("sphere", R.drawable.ball));

        recyclerView = view.findViewById(R.id.rv3dMenu);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        adapter = new MyAdapter(getActivity(), items);
        recyclerView.setAdapter(adapter);
        adapter.setClickListener(this);


        return view;
    }

    public void gotoCalc(String type) {
        Intent intent = new Intent(getContext(), CalculatorActivity.class);
        intent.putExtra("type", type);
        startActivity(intent);
    }

    @Override
    public void onItemClick(View view, int position) {
        String nama = items.get(position).getName();
        gotoCalc(nama);
    }
}
