package com.example.dashboardapplication;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.dashboardapplication.fragment.Menu2dFragment;
import com.example.dashboardapplication.fragment.Menu3dFragment;
import com.example.dashboardapplication.fragment.MenuProfileFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Dashboard extends AppCompatActivity {
    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        bottomNavigationView = findViewById(R.id.bottomNav);
        bottomNavigationView.setOnItemSelectedListener(navListener);

        // Load the default fragment
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.frameLayout, new Menu2dFragment())
                .commit();
    }

    private BottomNavigationView.OnItemSelectedListener navListener =
            new BottomNavigationView.OnItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selectedFragment = null;

                    if (item.getItemId() == R.id.list2d) {
                        selectedFragment = new Menu2dFragment();
                    } else if (item.getItemId() == R.id.list3d) {
                        selectedFragment = new Menu3dFragment();
                    } else if (item.getItemId() == R.id.listProfile) {
                        selectedFragment = new MenuProfileFragment();
                    }

                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.frameLayout, selectedFragment)
                            .commit();

                    return true;
                }
            };
}
