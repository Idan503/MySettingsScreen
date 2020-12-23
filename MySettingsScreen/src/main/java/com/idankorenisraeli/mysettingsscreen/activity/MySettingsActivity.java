package com.idankorenisraeli.mysettingsscreen.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.CompoundButton;
import android.widget.SeekBar;

import com.idankorenisraeli.mysettingsscreen.R;
import com.idankorenisraeli.mysettingsscreen.adapter.SettingsRecyclerAdapter;
import com.idankorenisraeli.mysettingsscreen.callback.OnOptionSelectedListener;
import com.idankorenisraeli.mysettingsscreen.tile_data.ButtonTileData;
import com.idankorenisraeli.mysettingsscreen.tile_data.DividerTileData;
import com.idankorenisraeli.mysettingsscreen.tile_data.RadioTileData;
import com.idankorenisraeli.mysettingsscreen.tile_data.SeekbarTileData;
import com.idankorenisraeli.mysettingsscreen.tile_data.SettingsTileData;
import com.idankorenisraeli.mysettingsscreen.tile_data.SwitchTileData;
import com.idankorenisraeli.mysettingsscreen.tile_data.TitleTileData;

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


        ArrayList<String> options = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            options.add("Option " + i);
        }

        ArrayList<SettingsTileData> dataTiles = new ArrayList<>();
        dataTiles.add(new ButtonTileData("Hey", "This is a simple tile")
                .setIconId(android.R.drawable.ic_menu_add));
        dataTiles.add(new ButtonTileData("This Title", "Description of a title no icon")
                .setIconId(TitleTileData.INVISIBLE_ICON_ID));

        dataTiles.add(new RadioTileData("Radio", "This is a radio type")
                .setDropDown(false)
                .setOptions(options)
                .setIconId(TitleTileData.INVISIBLE_ICON_ID)
                .setOnSelected(new OnOptionSelectedListener() {
                    @Override
                    public void onOptionSelected(String option) {
                        Log.i("pttt", "OPTION SELECETD: " + option);
                    }
                }));
        dataTiles.add(new SwitchTileData("SwitchTile", "This is a switch tile data")
                .setIconId(TitleTileData.INVISIBLE_ICON_ID)
                .setOnChange(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        Log.i("pttt", "" + isChecked);

                    }
                }));

        dataTiles.add(new RadioTileData("Radio Dropdown", "This dropdown here right")
                .setDropDown(true)
                .setOptions(options)
                .setOnSelected(new OnOptionSelectedListener() {
                    @Override
                    public void onOptionSelected(String option) {
                        Log.i("pttt", "Selected new dropdown " + option);
                    }
                })
                .setDefaultOption(options.get(4)));

        dataTiles.add(new DividerTileData().setHeight(2));

        dataTiles.add(new SeekbarTileData("Seek Bar Title", "Seek Bar Very Long Description Description Description")
                .setIconId(android.R.drawable.ic_menu_add)
        .setMinValue(15)
        .setMaxValue(100)
        .setDefaultValue(25));

        dataTiles.add(new SwitchTileData("Switch Tile", "Switch tile data description test")
                .setIconId(android.R.drawable.ic_btn_speak_now));

        dataTiles.add(new RadioTileData("Radio Dropdown", "Description").setDropDown(true).setOptions(options));


        settingsRecycler.setLayoutManager(new LinearLayoutManager(this));
        settingsRecycler.setAdapter(new SettingsRecyclerAdapter(this, dataTiles));

    }


    private void findViews() {
        actionBar = findViewById(R.id.settings_TB_toolbar);
        settingsRecycler = findViewById(R.id.settings_RV_recycler);
    }
}