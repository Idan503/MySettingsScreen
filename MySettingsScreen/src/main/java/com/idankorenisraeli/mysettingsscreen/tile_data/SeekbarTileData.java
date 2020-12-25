package com.idankorenisraeli.mysettingsscreen.tile_data;

import android.widget.SeekBar;


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
