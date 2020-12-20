package com.idankorenisraeli.mysettingsscreen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.idankorenisraeli.mysettingsscreen.adapter.SettingsRecyclerAdapter;
import com.idankorenisraeli.mysettingsscreen.tile.SettingsTile;

import java.util.ArrayList;

public class MySettingsActivity extends AppCompatActivity {
    android.widget.Toolbar actionBar;
    RecyclerView settingsRecycler;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_settings);

        findViews();

        setActionBar(actionBar);


        ArrayList<SettingsTile> tiles = new ArrayList<>();
        tiles.add(new SettingsTile("Hey123", "This is a description"));

        settingsRecycler.setLayoutManager(new LinearLayoutManager(this));
        settingsRecycler.setAdapter(new SettingsRecyclerAdapter(this, tiles));

    }


    private void findViews(){
        actionBar = findViewById(R.id.settings_TB_toolbar);
        settingsRecycler = findViewById(R.id.settings_RV_recycler);
    }
}