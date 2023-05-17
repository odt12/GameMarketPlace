package com.example.gamemarketplace;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LibraryActivity extends AppCompatActivity {
    private ExpandableListView expandableListView;
    private ExpandableListAdapter expandableListAdapter;
    private List<String> titleList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library);

        // Initialize views
        Toolbar toolbar = findViewById(R.id.toolbar);
        expandableListView = findViewById(R.id.expandableListView);

        // Set toolbar with back button
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // Prepare data for ExpandableListView
        Map<String, List<String>> listData = prepareListData();

        titleList = new ArrayList<>(listData.keySet());
        expandableListAdapter = new CustomExpandableListAdapter(this, titleList, listData);

        expandableListView.setAdapter(expandableListAdapter);
    }

    private Map<String, List<String>> prepareListData() {
        Map<String, List<String>> listData = new HashMap<>();

        // Adding child data
        List<String> top250 = new ArrayList<>();
        top250.add("The Shawshank Redemption");
        top250.add("The Godfather");
        top250.add("Pulp Fiction");

        List<String> nowShowing = new ArrayList<>();
        nowShowing.add("The Conjuring");
        nowShowing.add("Despicable Me 2");
        nowShowing.add("Turbo");

        List<String> comingSoon = new ArrayList<>();
        comingSoon.add("2 Guns");
        comingSoon.add("The Smurfs 2");
        comingSoon.add("The Wolverine");

        listData.put("Top 250", top250); // Header, Child data
        listData.put("Play Now", nowShowing);
        listData.put("Coming Soon", comingSoon);



        return listData;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here.
        int id = item.getItemId();

        if (id == android.R.id.home) {
            finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
