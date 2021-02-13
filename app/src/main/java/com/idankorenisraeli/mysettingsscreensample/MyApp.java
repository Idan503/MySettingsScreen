package com.idankorenisraeli.mysettingsscreensample;

import android.app.Application;
import android.graphics.Color;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.SeekBar;
import android.widget.Toast;

import com.google.android.material.timepicker.TimeFormat;
import com.idankorenisraeli.mysettingsscreen.MySettingsScreen;
import com.idankorenisraeli.mysettingsscreen.callback.OnMultiSelectListener;
import com.idankorenisraeli.mysettingsscreen.callback.OnOptionSelectListener;
import com.idankorenisraeli.mysettingsscreen.callback.OnTimeSelectedListener;
import com.idankorenisraeli.mysettingsscreen.enums.RadioType;
import com.idankorenisraeli.mysettingsscreen.enums.ToggleType;
import com.idankorenisraeli.mysettingsscreen.tile_data.dialog.DatePickerTileData;
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

import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class MyApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();


        // Generic list for multi-options examples
        ArrayList<String> options = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            options.add("Option " + i);
        }

        // Default options of the list above
        ArrayList<Boolean> checkedOptions = new ArrayList<>();
        checkedOptions.add(false);
        checkedOptions.add(false);
        checkedOptions.add(false);
        checkedOptions.add(true);
        checkedOptions.add(false);

        // Default time
        ArrayList<Integer> defaultTime = new ArrayList<>();
        defaultTime.add(8);
        defaultTime.add(30);

        // This list will hold the tiles data which the activity will be built upon
        ArrayList<SettingsTileData> dataTiles = new ArrayList<>();


        //region Adding Tiles Data
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
                        String msg = "Switch is toggled " + state;
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
                        String msg = "Checkbox is now toggled " + state;
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
                .withIconId(com.idankorenisraeli.mysettingsscreen.R.drawable.ic_baseline_arrow_drop_down_circle_24)
                .withOnSelectedListener(new OnOptionSelectListener() {
                    @Override
                    public void onOptionSelected(String option) {
                        showToast("Radio dropdown selected " + option);
                    }
                });

        RadioTileData radioLabeledDialogTileData = new RadioTileData("Radio Labeled Dialog", "Select an option from a dialog")
                .withRadioType(RadioType.DIALOG_LABELED)
                .withOptionsList(options)
                .withDefaultValue(options.get(2))
                .withIconId(com.idankorenisraeli.mysettingsscreen.R.drawable.ic_baseline_label_24)
                .withOnSelectedListener(new OnOptionSelectListener() {
                    @Override
                    public void onOptionSelected(String option) {
                        showToast("Radio dialog selected " + option);
                    }
                });

        RadioTileData radioDialogTileData = new RadioTileData("Radio Dialog", "Select an option from a dialog")
                .withRadioType(RadioType.DIALOG)
                .withOptionsList(options)
                .withDefaultValue(options.get(3))
                .withIconId(com.idankorenisraeli.mysettingsscreen.R.drawable.ic_baseline_radio_button_checked_24)
                .withOnSelectedListener(new OnOptionSelectListener() {
                    @Override
                    public void onOptionSelected(String option) {
                        showToast("Radio dialog selected " + option);
                    }
                });


        EditTextTileData editTextTileData = new EditTextTileData("Edit Text", "Tap to edit this setting")
                .withDefaultValue("MyOption")
                .withIconId(com.idankorenisraeli.mysettingsscreen.R.drawable.ic_baseline_border_color_24)
                .withOnSelectedListener(new OnOptionSelectListener() {
                    @Override
                    public void onOptionSelected(String option) {
                        showToast("Text selected " + option);
                    }
                });


        MultiChoiceTileData multiTileData = new MultiChoiceTileData ("Multi Choice Tile", "Select multiple options from a dialog")
                .withOptionsList(options)
                .withDefaultValue(checkedOptions)
                .withIconId(com.idankorenisraeli.mysettingsscreen.R.drawable.ic_baseline_rule_24)
                .withOnChangedListener(new OnMultiSelectListener() {
                    @Override
                    public void onMultiSelect(ArrayList<String> options, ArrayList<Boolean> checked) {
                        StringBuilder optionsSelected = new StringBuilder();
                        boolean selectedSomething = false;
                        for (int i = 0; i < options.size(); i++) {
                            if(checked.get(i)) {
                                optionsSelected.append(options.get(i)).append(", ");
                                selectedSomething = true;
                            }
                        }
                        if(selectedSomething) {
                            String data = optionsSelected.substring(0, optionsSelected.length() - 2);
                            showToast("Multi-Choice selected: " + data);
                        }
                        else{
                            showToast("Multi-Choice selected: None");
                        }

                    }
                });

        TimePickerTileData timePickerData = new TimePickerTileData("Time Picker", "Tap to change selected time")
                .withOnSelectedListener(new OnTimeSelectedListener() {
                    @Override
                    public void onTimeSelected(int hours, int minutes) {
                        showToast("Time selected " + hours + ":" + minutes);
                    }
                })
                .withDefaultValue(defaultTime)
                .withTimeFormat(TimeFormat.CLOCK_12H)
                .withIconId(com.idankorenisraeli.mysettingsscreen.R.drawable.ic_baseline_access_time_24);

        DatePickerTileData datePickerData = new DatePickerTileData("Date Picker", "Tap to select a date")
                .withIconId(com.idankorenisraeli.mysettingsscreen.R.drawable.ic_baseline_calendar_today_24)
                .withDateFormat(DateTimeFormatter.ofPattern("dd/MM/yyyy"))
                .withZoneId(ZoneId.of("Israel"))
                ;



        //endregion


        // Adding each tile data to the list
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
        dataTiles.add(datePickerData);


        MySettingsScreen.getInstance().setTilesData(dataTiles);

    }

    private void showToast(String message){
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
