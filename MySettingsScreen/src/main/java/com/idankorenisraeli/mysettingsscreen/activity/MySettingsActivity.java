package com.idankorenisraeli.mysettingsscreen.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.idankorenisraeli.mysettingsscreen.R;
import com.idankorenisraeli.mysettingsscreen.recycler.SettingsRecyclerAdapter;
import com.idankorenisraeli.mysettingsscreen.tile_data.essential.SettingsTileData;

import java.util.ArrayList;

@SuppressWarnings("unchecked")
public class MySettingsActivity extends AppCompatActivity {
    android.widget.Toolbar actionBar;
    RecyclerView settingsRecycler;

    public static final String APPBAR_TITLE = "APPBAR_TITLE";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_settings);
        findViews();


        Bundle extras = getIntent().getExtras();
        if(extras!=null) {
            String title = extras.getString(APPBAR_TITLE);
            if (title != null)
                initActionBar(title);
            else
                hideActionBar();
        }
        else
            hideActionBar();


        ArrayList<SettingsTileData> tilesData = MySettingsScreen.getInstance().getTilesData();



        settingsRecycler.setLayoutManager(new LinearLayoutManager(this));
        settingsRecycler.setAdapter(new SettingsRecyclerAdapter(this, tilesData));

    }

    private void initActionBar(String title){
        setActionBar(actionBar);
        actionBar.setTitle(title);
    }

    private void hideActionBar(){
        actionBar.setVisibility(View.GONE);
    }


    private void findViews() {
        actionBar = findViewById(R.id.settings_TB_toolbar);
        settingsRecycler = findViewById(R.id.settings_RV_recycler);
    }
}