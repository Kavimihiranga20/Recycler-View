package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerAdapter recyclerAdapter;

    List<String> routeList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        routeList = new ArrayList<>();
        routeList.add("Galle - Colombo");
        routeList.add("Kandy - Nuwaraeliya ");
        routeList.add("Colombo - Badulla");
        routeList.add("Matara - Ratnapura");
        routeList.add("Aluthgama - Panadura");
        routeList.add("Galle - Ampara");
        routeList.add("Matara - Bandarawela");
        routeList.add("Maharagama - Kottawa");
        routeList.add("Piliyandala - Kesbewa");
        routeList.add("Homagama - Makumbura");
        routeList.add("Colombo - Kataragama");
        routeList.add("Kandy - Badulla ");
        routeList.add("Colombo - Hakmana");
        routeList.add("Borella - kottawa ");
        routeList.add("Homagama - Maharagama ");
        routeList.add("Borella - Nawrohala");


        recyclerView = findViewById(R.id.recyclerView);
        recyclerAdapter = new RecyclerAdapter(routeList);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(recyclerAdapter);

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(dividerItemDecoration);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.main_menu, menu);
        MenuItem menuItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) menuItem.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                recyclerAdapter.getFilter().filter(newText);
                return false;
            }
        });


        return super.onCreateOptionsMenu(menu);
    }
}














