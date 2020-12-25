package com.idankorenisraeli.mysettingsscreen.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.Toast;

import com.idankorenisraeli.mysettingsscreen.R;
import com.idankorenisraeli.mysettingsscreen.recycler.SettingsRecyclerAdapter;
import com.idankorenisraeli.mysettingsscreen.tile_data.BasicTileData;
import com.idankorenisraeli.mysettingsscreen.tile_data.ButtonTileData;
import com.idankorenisraeli.mysettingsscreen.tile_data.DividerTileData;
import com.idankorenisraeli.mysettingsscreen.tile_data.MultiChoiceTileData;
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

        actionBar.setTitle("My Settings");


        ArrayList<String> options = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            options.add("Option " + i);
        }

        ArrayList<Boolean> checkedOptions = new ArrayList<>();
        checkedOptions.add(false);
        checkedOptions.add(false);
        checkedOptions.add(false);
        checkedOptions.add(true);
        checkedOptions.add(false);

        ArrayList<SettingsTileData> dataTiles = new ArrayList<>();

        TitleTileData nonSavableTile = new TitleTileData("Stateless Tiles", "Data is not saved to device");

        TitleTileData titleTileData = new TitleTileData("Title Tile", "No functionality here, just a title")
                .withIconId(android.R.drawable.divider_horizontal_textfield);

        ButtonTileData buttonTileData = new ButtonTileData("Button Tile", "Click to do something")
                .withOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(MySettingsActivity.this,"Button tile clicked", Toast.LENGTH_SHORT).show();
                    }
                })
                .withIconId(android.R.drawable.ic_media_next);

        DividerTileData dividerTileData = new DividerTileData().withHeight(1);

        TitleTileData savableTile = new TitleTileData("Stateful Tiles", "Data is being auto-saved to SharedPrefs");

        SwitchTileData switchTileData = new SwitchTileData("Switch Tile", "Can be toggled off/on")
                .withDefaultValue(true)
                .withOnChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        String state = isChecked ? "on" : "off";
                        String msg = "Switch is now toggled " + state;
                        Toast.makeText(MySettingsActivity.this,msg, Toast.LENGTH_SHORT).show();
                    }
                })
                .withIconId(BasicTileData.INVISIBLE_ICON_ID);

        SeekbarTileData seekbarTileData = new SeekbarTileData("Seekbar Tile", "Between min/max provided values")
                .withDefaultValue(50)
                .withMaxValue(100)
                .withMinValue(0)
                .withOnChangeListener(new SeekBar.OnSeekBarChangeListener() {
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {

                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {
                        Toast.makeText(MySettingsActivity.this, "Progress set to " + seekBar.getProgress(), Toast.LENGTH_SHORT).show();
                    }
                })
                .withIconId(BasicTileData.INVISIBLE_ICON_ID);


        RadioTileData radioDropdownTileData = new RadioTileData("Radio Dropdown", "Select an option from a dropdown")
                .withDropDown(true)
                .withOptionsList(options)
                .withDefaultValue(options.get(2))
                .withIconId(BasicTileData.INVISIBLE_ICON_ID);

        RadioTileData radioDialogTileData = new RadioTileData("Radio Dialog Tile", "Select an option from a dialog")
                .withDropDown(false)
                .withOptionsList(options)
                .withDefaultValue(options.get(2))
                .withIconId(BasicTileData.INVISIBLE_ICON_ID);

        MultiChoiceTileData multiTileData = new MultiChoiceTileData("Multi-Choice Tile", "Select multiple options from a dialog")
                .withOptionsList(options)
                .withDefaultValue(checkedOptions)
                .withIconId(BasicTileData.INVISIBLE_ICON_ID);




        multiTileData.getSavedValue();

        dataTiles.add(nonSavableTile);
        dataTiles.add(titleTileData);
        dataTiles.add(buttonTileData);
        dataTiles.add(dividerTileData);
        dataTiles.add(savableTile);
        dataTiles.add(switchTileData);
        dataTiles.add(seekbarTileData);
        dataTiles.add(radioDropdownTileData);
        dataTiles.add(radioDialogTileData);
        dataTiles.add(multiTileData);


        settingsRecycler.setLayoutManager(new LinearLayoutManager(this));
        settingsRecycler.setAdapter(new SettingsRecyclerAdapter(this, dataTiles));

    }


    private void findViews() {
        actionBar = findViewById(R.id.settings_TB_toolbar);
        settingsRecycler = findViewById(R.id.settings_RV_recycler);
    }
}