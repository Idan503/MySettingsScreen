package com.idankorenisraeli.mysettingsscreen.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.SeekBar;
import android.widget.Toast;

import com.idankorenisraeli.mysettingsscreen.R;
import com.idankorenisraeli.mysettingsscreen.callback.OnTimeSelectedListener;
import com.idankorenisraeli.mysettingsscreen.enums.ToggleType;
import com.idankorenisraeli.mysettingsscreen.recycler.SettingsRecyclerAdapter;
import com.idankorenisraeli.mysettingsscreen.tile_data.essential.ButtonTileData;
import com.idankorenisraeli.mysettingsscreen.tile_data.essential.DividerTileData;
import com.idankorenisraeli.mysettingsscreen.tile_data.dialog.EditTextTileData;
import com.idankorenisraeli.mysettingsscreen.tile_data.dialog.MultiChoiceTileData;
import com.idankorenisraeli.mysettingsscreen.tile_data.view.RadioTileData;
import com.idankorenisraeli.mysettingsscreen.enums.RadioType;
import com.idankorenisraeli.mysettingsscreen.tile_data.view.SeekbarTileData;
import com.idankorenisraeli.mysettingsscreen.tile_data.essential.SettingsTileData;
import com.idankorenisraeli.mysettingsscreen.tile_data.dialog.TimePickerTileData;
import com.idankorenisraeli.mysettingsscreen.tile_data.view.ToggleTileData;
import com.idankorenisraeli.mysettingsscreen.tile_data.essential.TitleTileData;

import java.util.ArrayList;

@SuppressWarnings("unchecked")
public class MySettingsActivity extends AppCompatActivity {
    android.widget.Toolbar actionBar;
    RecyclerView settingsRecycler;

    public static final String TILE_LIST_KEY = "TILE_DATA_LIST";

    private static boolean finishedLoading = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_settings);
        findViews();
        setActionBar(actionBar);

        ArrayList<SettingsTileData> tilesData = MySettingsScreen.getInstance().getTilesData();


        actionBar.setTitle("My Settings");


        settingsRecycler.setLayoutManager(new LinearLayoutManager(this));
        settingsRecycler.setAdapter(new SettingsRecyclerAdapter(this, tilesData));
        finishedLoading = true;

    }


    private void findViews() {
        actionBar = findViewById(R.id.settings_TB_toolbar);
        settingsRecycler = findViewById(R.id.settings_RV_recycler);
    }
}