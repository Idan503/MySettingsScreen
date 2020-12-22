package com.idankorenisraeli.mysettingsscreen.tile;

import android.widget.CompoundButton;

import java.util.ArrayList;


public class RadioTileData extends SettingsTileData<RadioTileData> {

    private CompoundButton.OnCheckedChangeListener onChanged;
    private ArrayList<String> options;
    //Outer layout click functionality implemented inside holder object

    // TODO - MIN VALUE, MAX VALUE, SP LINK

    @Override
    protected RadioTileData build() {
        return this;
    }

    public RadioTileData(String title, String description) {
        super(title, description);
    }

    public CompoundButton.OnCheckedChangeListener getOnChanged() {
        return onChanged;
    }

    public RadioTileData setOnChanged(CompoundButton.OnCheckedChangeListener onChanged) {
        this.onChanged = onChanged;
        return build();
    }

    public ArrayList<String> getOptions() {
        return options;
    }

    public RadioTileData setOptions(ArrayList<String> options) {
        this.options = options;
        return build();
    }
}
