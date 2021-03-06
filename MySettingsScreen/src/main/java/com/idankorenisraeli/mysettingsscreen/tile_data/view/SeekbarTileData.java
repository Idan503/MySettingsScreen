package com.idankorenisraeli.mysettingsscreen.tile_data.view;

import android.widget.SeekBar;

import com.idankorenisraeli.mysettingsscreen.tile_data.essential.SavableTileData;


/**
 * Data of a seekbar tile, that provides with the user a selection of an integer
 * value between a certain minimum and maximum values
 */
public class SeekbarTileData extends SavableTileData<Integer,SeekbarTileData> {


    private SeekBar.OnSeekBarChangeListener onChangeListener;
    //Outer layout click functionality implemented inside holder object

    private Integer minValue;
    private Integer maxValue;

    @Override
    protected SeekbarTileData build() {
        return this;
    }

    public SeekbarTileData(String title, String description) {
        super(title, description);
    }


    public SeekBar.OnSeekBarChangeListener getOnChangeListener() {
        return onChangeListener;
    }

    public SeekbarTileData withOnChangeListener(SeekBar.OnSeekBarChangeListener onChangeListener) {
        this.onChangeListener = onChangeListener;
        return this;
    }

    public Integer getMinValue() {
        return minValue;
    }

    public SeekbarTileData withMinValue(Integer minValue) {
        this.minValue = minValue;
        return build();
    }

    public Integer getMaxValue() {
        return maxValue;
    }

    public SeekbarTileData withMaxValue(Integer maxValue) {
        this.maxValue = maxValue;
        return build();
    }


    protected void setOnChangeListener(SeekBar.OnSeekBarChangeListener onChangeListener) {
        this.onChangeListener = onChangeListener;
    }

    protected void setMinValue(Integer minValue) {
        this.minValue = minValue;
    }

    protected void setMaxValue(Integer maxValue) {
        this.maxValue = maxValue;
    }

}
