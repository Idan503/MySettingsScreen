package com.idankorenisraeli.mysettingsscreen.holder.dialog;

import android.view.View;
import android.widget.TextView;

import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;

import com.google.android.material.timepicker.MaterialTimePicker;
import com.google.android.material.timepicker.TimeFormat;
import com.idankorenisraeli.mysettingsscreen.R;
import com.idankorenisraeli.mysettingsscreen.holder.essential.TitleTileHolder;
import com.idankorenisraeli.mysettingsscreen.tile_data.essential.SettingsTileData;
import com.idankorenisraeli.mysettingsscreen.tile_data.dialog.TimePickerTileData;

import java.util.ArrayList;
import java.util.Arrays;


public class TimePickerTileHolder extends TitleTileHolder {

    TextView timeSelectedLabel;

    public TimePickerTileHolder(View itemView) {
        super(itemView);
        findViews();
    }

    @Override
    public void findViews(){
        super.findViews();
        timeSelectedLabel = itemView.findViewById(R.id.tile_radio_LBL_selected);

    }

    @Override
    public void setData(SettingsTileData tileObject) {
        super.setData(tileObject);
        TimePickerTileData mData = (TimePickerTileData) tileObject;
        ArrayList<Integer> savedTime = mData.getSavedValue();
        String str = generateTimeString(savedTime.get(0),savedTime.get(1));
        timeSelectedLabel.setText(str);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buildTimePickerDialog(mData);
            }
        });

    }

    private void buildTimePickerDialog(TimePickerTileData mData){
        MaterialTimePicker materialTimePicker = new MaterialTimePicker.Builder()
                .setTimeFormat(TimeFormat.CLOCK_24H)
                .setHour(mData.getSavedValue().get(0))
                .setMinute(mData.getSavedValue().get(1))
                .setTitleText(mData.getTitle())
                .build();

        materialTimePicker.addOnPositiveButtonClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int newHour = materialTimePicker.getHour();
                int newMinute = materialTimePicker.getMinute();
                ArrayList<Integer> result = new ArrayList<>();
                result.add(newHour);
                result.add(newMinute);
                mData.saveValue(result);

                if(mData.getOnSelectedListener()!=null)
                    mData.getOnSelectedListener().onTimeSelected(newHour, newMinute);

                timeSelectedLabel.setText(generateTimeString(newHour, newMinute));
            }
        });

        FragmentManager fragmentManager = ((FragmentActivity) itemView.getContext()).getSupportFragmentManager();

        materialTimePicker.show(fragmentManager, "TAG");


    }

    @Override
    protected void validateData(SettingsTileData data){
        TimePickerTileData mData = (TimePickerTileData) data;
        if(mData.getDefaultValue()==null){
            logMissedAttribute(getClass().getSimpleName(),"Default Time");
            mData.setDefaultValue(new ArrayList<>(Arrays.asList(8,30)));
        }

    }



    private String generateTimeString(int hours, int minutes){
        return hours + ":" + minutes;
    }

}