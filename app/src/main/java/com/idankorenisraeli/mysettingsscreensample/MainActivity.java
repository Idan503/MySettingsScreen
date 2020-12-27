package com.idankorenisraeli.mysettingsscreensample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.SeekBar;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;
import com.idankorenisraeli.mysettingsscreen.activity.MySettingsScreen;
import com.idankorenisraeli.mysettingsscreen.callback.OnTimeSelectedListener;
import com.idankorenisraeli.mysettingsscreen.enums.RadioType;
import com.idankorenisraeli.mysettingsscreen.enums.ToggleType;
import com.idankorenisraeli.mysettingsscreen.tile_data.dialog.EditTextTileData;
import com.idankorenisraeli.mysettingsscreen.tile_data.dialog.MultiChoiceTileData;
import com.idankorenisraeli.mysettingsscreen.tile_data.dialog.TimePickerTileData;
import com.idankorenisraeli.mysettingsscreen.tile_data.essential.ButtonTileData;
import com.idankorenisraeli.mysettingsscreen.tile_data.essential.DividerTileData;
import com.idankorenisraeli.mysettingsscreen.tile_data.essential.SettingsTileData;
import com.idankorenisraeli.mysettingsscreen.tile_data.essential.TitleTileData;
import com.idankorenisraeli.mysettingsscreen.tile_data.view.RadioTileData;
import com.idankorenisraeli.mysettingsscreen.tile_data.view.SeekbarTileData;
import com.idankorenisraeli.mysettingsscreen.tile_data.view.ToggleTileData;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    MaterialButton main_BTN_settings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViews();


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
                .withIconId(com.idankorenisraeli.mysettingsscreen.R.drawable.ic_baseline_text_fields_24);

        ButtonTileData buttonTileData = new ButtonTileData("Button Tile", "Click to do something")
                .withOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        showToast("Button tile clicked");
                    }
                })
                .withIconId(com.idankorenisraeli.mysettingsscreen.R.drawable.ic_baseline_radio_button_unchecked_24);

        DividerTileData whiteDivider = new DividerTileData().withHeight(1)
                .withColor(Color.WHITE);

        DividerTileData grayDivider =  new DividerTileData().withHeight(1)
                .withColor(Color.parseColor("#FF666666"));

        TitleTileData savableTile = new TitleTileData("Stateful Tiles", "Data is being auto-saved to SharedPrefs");

        ToggleTileData switchTileData = new ToggleTileData("Switch Tile", "Can be toggled off/on")
                .withDefaultValue(true)
                .withToggleType(ToggleType.SWITCH)
                .withOnChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        String state = isChecked ? "on" : "off";
                        String msg = "Switch is now toggled " + state;
                        showToast(msg);
                    }
                })
                .withIconId(com.idankorenisraeli.mysettingsscreen.R.drawable.ic_baseline_toggle_on_24);

        ToggleTileData checkboxTileData = new ToggleTileData("Checkbox Tile", "Can be toggled off/on")
                .withDefaultValue(true)
                .withToggleType(ToggleType.CHECK_BOX)
                .withOnChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        String state = isChecked ? "on" : "off";
                        String msg = "Switch is now toggled " + state;
                        showToast(msg);
                    }
                })
                .withIconId(com.idankorenisraeli.mysettingsscreen.R.drawable.ic_baseline_check_24);

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
                        showToast("Progress set to " + seekBar.getProgress());
                    }
                })
                .withIconId(com.idankorenisraeli.mysettingsscreen.R.drawable.ic_96_settings);


        RadioTileData radioDropdownTileData = new RadioTileData("Radio Dropdown", "Select an option from a dropdown")
                .withRadioType(RadioType.DROP_DOWN)
                .withOptionsList(options)
                .withDefaultValue(options.get(1))
                .withIconId(com.idankorenisraeli.mysettingsscreen.R.drawable.ic_baseline_arrow_drop_down_circle_24);

        RadioTileData radioLabeledDialogTileData = new RadioTileData("Radio Labeled Dialog", "Select an option from a dialog")
                .withRadioType(RadioType.DIALOG_LABELED)
                .withOptionsList(options)
                .withDefaultValue(options.get(2))
                .withIconId(com.idankorenisraeli.mysettingsscreen.R.drawable.ic_baseline_label_24);

        RadioTileData radioDialogTileData = new RadioTileData("Radio Dialog", "Select an option from a dialog")
                .withRadioType(RadioType.DIALOG)
                .withOptionsList(options)
                .withDefaultValue(options.get(3))
                .withIconId(com.idankorenisraeli.mysettingsscreen.R.drawable.ic_baseline_radio_button_checked_24);


        EditTextTileData editTextTileData = new EditTextTileData("Edit Text", "Tap to edit this setting")
                .withDefaultValue("MyOption")
                .withIconId(com.idankorenisraeli.mysettingsscreen.R.drawable.ic_baseline_border_color_24);


        ArrayList<Integer> defaultTime = new ArrayList<>();
        defaultTime.add(8);
        defaultTime.add(30);

        TimePickerTileData timePickerData = new TimePickerTileData("Time Picker", "Tap to change selected time")
                .withOnSelectedListener(new OnTimeSelectedListener() {
                    @Override
                    public void onTimeSelected(int hours, int minutes) {
                        showToast("Time: " + hours + ":" + minutes);
                    }
                })
                .withDefaultValue(defaultTime)
                .withIconId(android.R.drawable.btn_plus);

        MultiChoiceTileData multiTileData = new MultiChoiceTileData("Multi Choice Tile", "Select multiple options from a dialog")
                .withOptionsList(options)
                .withDefaultValue(checkedOptions)
                .withIconId(com.idankorenisraeli.mysettingsscreen.R.drawable.ic_baseline_rule_24);


        dataTiles.add(nonSavableTile);
        dataTiles.add(titleTileData);
        dataTiles.add(buttonTileData);
        dataTiles.add(whiteDivider);
        dataTiles.add(savableTile);
        dataTiles.add(switchTileData);
        dataTiles.add(checkboxTileData);
        dataTiles.add(grayDivider);
        dataTiles.add(radioDialogTileData);
        dataTiles.add(radioLabeledDialogTileData);
        dataTiles.add(radioDropdownTileData);
        dataTiles.add(grayDivider);
        dataTiles.add(multiTileData);
        dataTiles.add(seekbarTileData);
        dataTiles.add(editTextTileData);
        dataTiles.add(timePickerData);




        main_BTN_settings.setOnClickListener( new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        MySettingsScreen.getInstance().initSettingsScreen(MainActivity.this, dataTiles);
                    }
                }
        );

        main_BTN_settings.performClick();


    }

    private void findViews(){
        main_BTN_settings = findViewById(R.id.main_BTN_settings);
    }

    private void showToast(String message){
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}