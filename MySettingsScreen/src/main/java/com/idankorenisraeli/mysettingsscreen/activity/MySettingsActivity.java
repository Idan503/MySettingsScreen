package com.idankorenisraeli.mysettingsscreen.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.SeekBar;

import com.idankorenisraeli.mysettingsscreen.R;
import com.idankorenisraeli.mysettingsscreen.adapter.SettingsRecyclerAdapter;
import com.idankorenisraeli.mysettingsscreen.tile.ClickableTileData;
import com.idankorenisraeli.mysettingsscreen.tile.SeekbarTileData;
import com.idankorenisraeli.mysettingsscreen.tile.SettingsTileData;
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


        ArrayList<SettingsTileData<?>> dataTiles = new ArrayList<>();
        dataTiles.add(new ClickableTileData("Hey", "This is a simple tile")
                .setIconId(android.R.drawable.ic_menu_add));
        dataTiles.add(new ClickableTileData("This Title", "Description of a title no icon").setInvisibleIcon(true));
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
            .setIconId(android.R.drawable.ic_delete)
            );


        settingsRecycler.setLayoutManager(new LinearLayoutManager(this));
        settingsRecycler.setAdapter(new SettingsRecyclerAdapter(this, dataTiles));

    }


    private void findViews(){
        actionBar = findViewById(R.id.settings_TB_toolbar);
        settingsRecycler = findViewById(R.id.settings_RV_recycler);
    }
}