package com.idankorenisraeli.mysettingsscreen.tile_data;

import android.widget.TimePicker;

import com.idankorenisraeli.mysettingsscreen.callback.OnOptionSelectListener;
import com.idankorenisraeli.mysettingsscreen.enums.RadioType;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

public class TimePickerTileData extends SavableTileData<ArrayList<Integer>, TimePickerTileData> {
    private TimePicker.OnTimeChangedListener onSelectedListener;

    //Outer layout click functionality implemented inside holder object
    @Override
    protected TimePickerTileData build() {
        return this;
    }

    public TimePickerTileData(String title, String description) {
        super(title, description);
    }

    public TimePicker.OnTimeChangedListener getOnSelectedListener() {
        return onSelectedListener;
    }

    public TimePickerTileData withOnSelectedListener(TimePicker.OnTimeChangedListener onSelectedListener) {
        this.onSelectedListener = onSelectedListener;
        return build();
    }

}
