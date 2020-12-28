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
        String str = generateTimeString(savedTime.get(0),savedTime.get(1), mData.getFormat());
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
                .setTimeFormat(mData.getFormat())
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

                timeSelectedLabel.setText(generateTimeString(newHour, newMinute, mData.getFormat()));
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



    private String generateTimeString(int hours, int minutes, @TimeFormat int format){
        String timeType = "";
        if(TimeFormat.CLOCK_12H == format) {
            if(hours <= 11) {
                if (hours == 0) {
                    hours = 12;
                }
                timeType = " AM";
            }
            else{ //hours >=12
                hours-=12;
                timeType = " PM";
            }
        }

        String minutesString = reformatTimeNumber(minutes);
        String hoursString = reformatTimeNumber(hours);
        return hoursString + ":" + minutesString + timeType;
    }

    /**
     * This will change the time integer to a time string
     * for example meaning that a number of minutes like 7, will be converted to 07
     * @param timeInt Numeric value of minutes or hours
     * @return String representation of this value
     */
    private String reformatTimeNumber(int timeInt){
        return (timeInt < 10)? "0"+timeInt : ""+timeInt;
    }

}
