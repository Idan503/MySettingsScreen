package com.idankorenisraeli.mysettingsscreen.tile;

import android.widget.CompoundButton;
import android.widget.SeekBar;


public class SeekbarTileData extends SettingsTileData<SeekbarTileData> {


    private SeekBar.OnSeekBarChangeListener onChange;
    //Outer layout click functionality implemented inside holder object

    // TODO - MIN VALUE, MAX VALUE, SP LINK

    @Override
    protected SeekbarTileData build() {
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
}
