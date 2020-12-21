package com.idankorenisraeli.mysettingsscreen.tile;

import android.widget.CompoundButton;
import android.widget.SeekBar;


public class SeekbarTileData extends SettingsTileData {


    private SeekBar.OnSeekBarChangeListener onChange;
    //Outer layout click functionality implemented inside holder object

    // TODO - MIN VALUE, MAX VALUE, SP LINK

    public SeekbarTileData(String title, String description, SeekBar.OnSeekBarChangeListener onChange) {
        super(title, description);
        this.onChange = onChange;
    }

    public SeekBar.OnSeekBarChangeListener getOnChange() {
        return onChange;
    }

    public void setOnChange(SeekBar.OnSeekBarChangeListener onChange) {
        this.onChange = onChange;
    }
}
