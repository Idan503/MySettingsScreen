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
import com.idankorenisraeli.mysettingsscreen.tile.ButtonTileData;
import com.idankorenisraeli.mysettingsscreen.tile.RadioTileData;
import com.idankorenisraeli.mysettingsscreen.tile.SeekbarTileData;
import com.idankorenisraeli.mysettingsscreen.tile.SettingsTileData;
import com.idankorenisraeli.mysettingsscreen.tile.SwitchTileData;

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

        ArrayList<SettingsTileData<?>> dataTiles = new ArrayList<>();
        dataTiles.add(new ButtonTileData("Hey", "This is a simple tile")
                .setIconId(android.R.drawable.ic_menu_add));
        dataTiles.add(new ButtonTileData("This Title", "Description of a title no icon")
                .setIconId(SettingsTileData.INVISIBLE_ICON_ID));
        dataTiles.add(new SeekbarTileData("This Title", "Description of a title no icon")
                .setOnChange(new SeekBar.OnSeekBarChangeListener() {
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                        Log.i("pttt", progress + "");
                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {
                        Log.i("pttt", "started");
                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {
                        Log.i("pttt", "finished");
                    }
                })
                .setIconId(android.R.drawable.ic_menu_call)
        );
        dataTiles.add(new RadioTileData("Radio", "This is a radio type")
                .setDropDown(false)
                .setOptions(options)
                .setIconId(SettingsTileData.INVISIBLE_ICON_ID)
                .setOnSelected(new OnOptionSelectedListener() {
                    @Override
                    public void onOptionSelected(String option) {
                        Log.i("pttt", "OPTION SELECETD: " + option);
                    }
                }));
        dataTiles.add(new SwitchTileData("SwitchTile", "This is a switch tile data")
                .setIconId(SettingsTileData.INVISIBLE_ICON_ID)
                .setOnChange(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        Log.i("pttt", "" + isChecked);

                    }
                }));

        dataTiles.add(new RadioTileData("Radio Dropdown", "This dropdown here right")
                .setDropDown(true)
                .setOptions(options)

                .setDefaultOption(options.get(0)));


        settingsRecycler.setLayoutManager(new LinearLayoutManager(this));
        settingsRecycler.setAdapter(new SettingsRecyclerAdapter(this, dataTiles));

    }


    private void findViews() {
        actionBar = findViewById(R.id.settings_TB_toolbar);
        settingsRecycler = findViewById(R.id.settings_RV_recycler);
    }
}