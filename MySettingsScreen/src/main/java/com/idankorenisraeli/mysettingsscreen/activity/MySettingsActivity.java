package com.idankorenisraeli.mysettingsscreen.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Toast;

import com.idankorenisraeli.mysettingsscreen.R;
import com.idankorenisraeli.mysettingsscreen.adapter.SettingsRecyclerAdapter;
import com.idankorenisraeli.mysettingsscreen.tile.ClickableTileData;
import com.idankorenisraeli.mysettingsscreen.tile.SeekbarTileData;
import com.idankorenisraeli.mysettingsscreen.tile.SettingsTileData;
import com.idankorenisraeli.mysettingsscreen.tile.SwitchTileData;
import com.idankorenisraeli.mysettingsscreen.tile.TitleTileData;

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
        tiles.add(new TitleTileData("Hey123", "This is a description",120));

        tiles.add(new SwitchTileData("SwitchTile", "There is a switch", new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Log.i("pttt", isChecked + "    ");
            }
        }));

        tiles.add(new SeekbarTileData("Seek Bar", "This is a simple seekbar", null));

        settingsRecycler.setLayoutManager(new LinearLayoutManager(this));
        settingsRecycler.setAdapter(new SettingsRecyclerAdapter(this, tiles));

    }


    private void findViews(){
        actionBar = findViewById(R.id.settings_TB_toolbar);
        settingsRecycler = findViewById(R.id.settings_RV_recycler);
    }
}