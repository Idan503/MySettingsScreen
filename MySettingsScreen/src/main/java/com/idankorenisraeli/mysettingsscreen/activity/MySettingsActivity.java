package com.idankorenisraeli.mysettingsscreen.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.widget.CompoundButton;

import com.idankorenisraeli.mysettingsscreen.R;
import com.idankorenisraeli.mysettingsscreen.recycler.SettingsRecyclerAdapter;
import com.idankorenisraeli.mysettingsscreen.tile_data.DividerTileData;
import com.idankorenisraeli.mysettingsscreen.tile_data.RadioTileData;
import com.idankorenisraeli.mysettingsscreen.tile_data.SeekbarTileData;
import com.idankorenisraeli.mysettingsscreen.tile_data.SettingsTileData;
import com.idankorenisraeli.mysettingsscreen.tile_data.SwitchTileData;

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


        RadioTileData tileRadio = new RadioTileData("Radio", "Description of radio");
        tileRadio.withOptionsList(options)
                .withDropDown(true)
                .withDefaultValue("Option 3")
                .build();

        SeekbarTileData tileSeekbar = new SeekbarTileData("Seekbar", "Description of seekbar")
                .withMinValue(50)
                .withMaxValue(150)
                .withDefaultValue(25)
                .build();

        SwitchTileData switchTileData = new SwitchTileData("Switch", "Description of Switch")
                .withDefaultValue(true)
                .withIconId(android.R.drawable.btn_plus)
                .withOnChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        Log.i("pttt", "Switch is now " + isChecked);
                    }
                });


        dataTiles.add(tileRadio);
        dataTiles.add(new DividerTileData().withHeight(1));
        dataTiles.add(tileSeekbar);
        dataTiles.add(switchTileData);

        settingsRecycler.setLayoutManager(new LinearLayoutManager(this));
        settingsRecycler.setAdapter(new SettingsRecyclerAdapter(this, dataTiles));

    }


    private void findViews() {
        actionBar = findViewById(R.id.settings_TB_toolbar);
        settingsRecycler = findViewById(R.id.settings_RV_recycler);
    }
}