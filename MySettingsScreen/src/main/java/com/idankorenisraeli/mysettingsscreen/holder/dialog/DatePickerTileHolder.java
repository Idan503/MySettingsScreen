package com.idankorenisraeli.mysettingsscreen.holder.dialog;

import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;

import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;

import com.google.android.material.datepicker.CalendarConstraints;
import com.google.android.material.datepicker.MaterialDatePicker;
import com.google.android.material.datepicker.MaterialPickerOnPositiveButtonClickListener;
import com.google.android.material.timepicker.TimeFormat;
import com.idankorenisraeli.mysettingsscreen.R;
import com.idankorenisraeli.mysettingsscreen.holder.essential.TitleTileHolder;
import com.idankorenisraeli.mysettingsscreen.tile_data.dialog.DatePickerTileData;
import com.idankorenisraeli.mysettingsscreen.tile_data.dialog.TimePickerTileData;
import com.idankorenisraeli.mysettingsscreen.tile_data.essential.SettingsTileData;

import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;


/**
 * Holds the data object of the Time Picker tile.
 * When the user clicks on this item,
 * A Time Picker dialog will pop up.
 */
public class DatePickerTileHolder extends TitleTileHolder {
    private TextView dateSelectedLabel;

    public DatePickerTileHolder(View itemView) {
        super(itemView);
        findViews();
    }

    @Override
    public void findViews(){
        super.findViews();
        dateSelectedLabel = itemView.findViewById(R.id.tile_radio_LBL_selected);
    }

    @Override
    public void setData(SettingsTileData tileObject) {
        super.setData(tileObject);
        DatePickerTileData mData = (DatePickerTileData) tileObject;
        String str = generateDateString(mData);
        dateSelectedLabel.setText(str);

        itemView.setOnClickListener(v -> buildDatePickerDialog(mData));

    }

    /**
     * Creates a date picker dialog that the user can select date from.
     * @param mData Data of the settings tile, that provides current selected time
     */
    private void buildDatePickerDialog(DatePickerTileData mData){
        MaterialDatePicker.Builder<Long> materialDateBuilder = MaterialDatePicker.Builder.datePicker();
        materialDateBuilder.setTitleText("Select a Date");
        CalendarConstraints.Builder constraints = new CalendarConstraints.Builder();
        constraints.setOpenAt(mData.getSavedValue()); // Opening the calendar on the saved date

        materialDateBuilder.setCalendarConstraints(constraints.build());
        materialDateBuilder.setSelection(mData.getSavedValue());


        final MaterialDatePicker<Long> materialDatePicker = materialDateBuilder.build();

        materialDatePicker.addOnPositiveButtonClickListener(new MaterialPickerOnPositiveButtonClickListener<Long>() {
                @Override
                public void onPositiveButtonClick(Long selection) {
                    mData.saveValue(selection);
                    dateSelectedLabel.setText(generateDateString(mData));
                }
            });

                materialDatePicker.show(((FragmentActivity) itemView.getContext()).getSupportFragmentManager(),
                        "MATERIAL_DATE_PICKER");
    }

    @Override
    protected void validateData(SettingsTileData data){
        DatePickerTileData mData = (DatePickerTileData) data;
        if(mData.getDefaultValue()==null){
            logMissedAttribute(getClass().getSimpleName(),"Default Date");
            mData.setDefaultValue(Calendar.getInstance().getTime().toInstant().toEpochMilli());
        }
        if(mData.getZoneId()==null){
            logMissedAttribute(getClass().getSimpleName(),"Default Date");
            mData.setZoneId(ZoneId.of("Israel"));
        }

        if(mData.getDateFormat()==null){
            logMissedAttribute(getClass().getSimpleName(),"Default Date");
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM dd, uuuu");

            mData.setDateFormat(formatter);
        }

    }

    protected String generateDateString(DatePickerTileData mData){
        return Instant.ofEpochMilli(mData.getSavedValue())
                .atZone(mData.getZoneId())
                .toLocalDate()
                .format(mData.getDateFormat());
    }


}
