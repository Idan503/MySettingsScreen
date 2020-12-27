package com.idankorenisraeli.mysettingsscreen.tile_data.dialog;

import com.idankorenisraeli.mysettingsscreen.callback.OnTimeSelectedListener;
import com.idankorenisraeli.mysettingsscreen.tile_data.essential.SavableTileData;

import java.util.ArrayList;


/**
 * Value that is saved to represent time is an ArrayList<Integer> with 2 values.
 * First value is hoursOfDay
 * Second value is minutes
 */
public class TimePickerTileData extends SavableTileData<ArrayList<Integer>, TimePickerTileData> {
    private OnTimeSelectedListener onSelectedListener;

    //Outer layout click functionality implemented inside holder object
    @Override
    protected TimePickerTileData build() {
        return this;
    }

    public TimePickerTileData(String title, String description) {
        super(title, description);
    }

    public OnTimeSelectedListener getOnSelectedListener() {
        return onSelectedListener;
    }

    public TimePickerTileData withOnSelectedListener(OnTimeSelectedListener onSelectedListener) {
        this.onSelectedListener = onSelectedListener;
        return build();
    }

}
