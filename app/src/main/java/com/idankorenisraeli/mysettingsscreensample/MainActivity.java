package com.idankorenisraeli.mysettingsscreensample;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.SeekBar;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.timepicker.TimeFormat;
import com.idankorenisraeli.mysettingsscreen.activity.MySettingsScreen;
import com.idankorenisraeli.mysettingsscreen.callback.OnMultiSelectListener;
import com.idankorenisraeli.mysettingsscreen.callback.OnOptionSelectListener;
import com.idankorenisraeli.mysettingsscreen.callback.OnTimeSelectedListener;
import com.idankorenisraeli.mysettingsscreen.enums.RadioType;
import com.idankorenisraeli.mysettingsscreen.enums.ToggleType;
import com.idankorenisraeli.mysettingsscreen.holder.essential.SettingsTileHolder;
import com.idankorenisraeli.mysettingsscreen.tile_data.dialog.EditTextTileData;
import com.idankorenisraeli.mysettingsscreen.tile_data.dialog.MultiChoiceTileData;
import com.idankorenisraeli.mysettingsscreen.tile_data.dialog.TimePickerTileData;
import com.idankorenisraeli.mysettingsscreen.tile_data.essential.ButtonTileData;
import com.idankorenisraeli.mysettingsscreen.tile_data.essential.DividerTileData;
import com.idankorenisraeli.mysettingsscreen.tile_data.essential.SavableTileData;
import com.idankorenisraeli.mysettingsscreen.tile_data.essential.SettingsTileData;
import com.idankorenisraeli.mysettingsscreen.tile_data.essential.TitleTileData;
import com.idankorenisraeli.mysettingsscreen.tile_data.view.RadioTileData;
import com.idankorenisraeli.mysettingsscreen.tile_data.view.SeekbarTileData;
import com.idankorenisraeli.mysettingsscreen.tile_data.view.ToggleTileData;

import java.util.ArrayList;


/**
 * In this example we will create a settings screen
 * which will include all the possible tiles that can be implemented
 * using the library.
 */
public class MainActivity extends AppCompatActivity {

    MaterialButton main_BTN_settings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViews();
        hideActionBar();


        main_BTN_settings.setOnClickListener( new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        MySettingsScreen.getInstance().initSettingsScreen(MainActivity.this, "My Settings Screen" );
                    }
                }
        );


        // Getting a saved value from tiles anywhere else in your app
        SettingsTileData data = MySettingsScreen.getInstance().getTileByTitle("Switch Tile");
        Boolean toggleSwitchValue =  ((SavableTileData<Boolean, ?>) data).getSavedValue();
        //showToast("Toggle Value Retrieved: " + toggleSwitchValue.toString());


    }


    private void findViews(){
        main_BTN_settings = findViewById(R.id.main_BTN_settings);
    }

    private void hideActionBar(){
        ActionBar defaultActionBar = getSupportActionBar();
        if(defaultActionBar!=null)
            defaultActionBar.hide(); //hides default action bar (there is a toolbar instead in the layout)

    }

    private void showToast(String message){
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

}