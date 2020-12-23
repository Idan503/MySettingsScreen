package com.idankorenisraeli.mysettingsscreen.tile_data;

import android.widget.SeekBar;


public class SeekbarTileData extends TextIconTileData<SeekbarTileData> {


    private SeekBar.OnSeekBarChangeListener onChange;
    //Outer layout click functionality implemented inside holder object

    private Integer minValue;
    private Integer maxValue;

    private Integer defaultValue;

    // TODO - SP LINK

    @Override
    public SeekbarTileData build() {
        return this;
    }

    public SeekbarTileData(String title, String description) {
        super(title, description);
    }


    public SeekBar.OnSeekBarChangeListener getOnChange() {
        return onChange;
    }

    public SeekbarTileData setOnChange(SeekBar.OnSeekBarChangeListener onChange) {
        this.onChange = onChange;
        return this;
    }

    public Integer getMinValue() {
        return minValue;
    }

    public SeekbarTileData setMinValue(Integer minValue) {
        this.minValue = minValue;
        return build();
    }

    public Integer getMaxValue() {
        return maxValue;
    }

    public SeekbarTileData setMaxValue(Integer maxValue) {
        this.maxValue = maxValue;
        return build();
    }

    public Integer getDefaultValue() {
        return defaultValue;
    }

    public SeekbarTileData setDefaultValue(Integer defaultValue) {
        this.defaultValue = defaultValue;
        return build();
    }
}
