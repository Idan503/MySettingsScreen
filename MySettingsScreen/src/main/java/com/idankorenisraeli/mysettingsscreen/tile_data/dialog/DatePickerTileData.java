package com.idankorenisraeli.mysettingsscreen.tile_data.dialog;

import com.google.android.material.timepicker.TimeFormat;
import com.idankorenisraeli.mysettingsscreen.callback.OnTimeSelectedListener;
import com.idankorenisraeli.mysettingsscreen.tile_data.essential.SavableTileData;

import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;


/**
 * Date picker dialog tile data
 *
 *
 */
public class DatePickerTileData extends SavableTileData<Long, DatePickerTileData> {
    private OnTimeSelectedListener onSelectedListener;
    private ZoneId zoneId;
    private DateTimeFormatter dateFormat;

    //Outer layout click functionality implemented inside holder object
    @Override
    protected DatePickerTileData build() {
        return this;
    }

    public DatePickerTileData(String title, String description) {
        super(title, description);
    }

    public OnTimeSelectedListener getOnSelectedListener() {
        return onSelectedListener;
    }

    public DatePickerTileData withOnSelectedListener(OnTimeSelectedListener onSelectedListener) {
        this.onSelectedListener = onSelectedListener;
        return build();
    }

    public DatePickerTileData withZoneId(ZoneId zone){
        this.zoneId = zone;
        return build();
    }

    public void setOnSelectedListener(OnTimeSelectedListener onSelectedListener) {
        this.onSelectedListener = onSelectedListener;
    }

    public DatePickerTileData withDateFormat(DateTimeFormatter format){
        this.dateFormat = format;
        return build();
    }

    public ZoneId getZoneId() {
        return zoneId;
    }

    public void setZoneId(ZoneId zoneId) {
        this.zoneId = zoneId;
    }

    public DateTimeFormatter getDateFormat() {
        return dateFormat;
    }

    public void setDateFormat(DateTimeFormatter dateFormat) {
        this.dateFormat = dateFormat;
    }
}
