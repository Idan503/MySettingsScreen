package com.idankorenisraeli.mysettingsscreen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.idankorenisraeli.mysettingsscreen.adapter.SettingsRecyclerAdapter;
import com.idankorenisraeli.mysettingsscreen.callback.OnSettingsTileClicked;
import com.idankorenisraeli.mysettingsscreen.tile.ClickableTileData;
import com.idankorenisraeli.mysettingsscreen.tile.SettingsTileData;

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


        ArrayList<SettingsTileData> tiles = new ArrayList<>();
        tiles.add(new ClickableTileData("Hey123", "This is a description", new OnSettingsTileClicked() {
            @Override
            public void onItemClick(View view, int position) {
                Toast.makeText(MySettingsActivity.this, "View: " + position, Toast.LENGTH_LONG).show();
            }
        }));

        settingsRecycler.setLayoutManager(new LinearLayoutManager(this));
        settingsRecycler.setAdapter(new SettingsRecyclerAdapter(this, tiles));

    }


    private void findViews(){
        actionBar = findViewById(R.id.settings_TB_toolbar);
        settingsRecycler = findViewById(R.id.settings_RV_recycler);
    }
}