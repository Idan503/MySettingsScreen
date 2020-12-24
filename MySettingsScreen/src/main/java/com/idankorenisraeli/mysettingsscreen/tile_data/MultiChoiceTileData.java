package com.idankorenisraeli.mysettingsscreen.tile_data;

import com.idankorenisraeli.mysettingsscreen.callback.OnMultiSelectListener;

import java.util.ArrayList;


public class MultiChoiceTileData extends TextIconTileData<MultiChoiceTileData> {

    private OnMultiSelectListener onChanged;
    private ArrayList<String> options;
    private ArrayList<Boolean> defaultChecked;
    //Outer layout click functionality implemented inside holder object

    // TODO - SP LINK

    @Override
    public MultiChoiceTileData build() {
        return this;
    }

    public MultiChoiceTileData(String title, String description) {
        super(title, description);
    }



    public ArrayList<String> getOptions() {
        return options;
    }

    public MultiChoiceTileData setOptions(ArrayList<String> options) {
        this.options = options;
        return build();
    }

    public OnMultiSelectListener getOnChanged() {
        return onChanged;
    }

    public MultiChoiceTileData setOnChanged(OnMultiSelectListener onChanged) {
        this.onChanged = onChanged;
        return build();
    }

    public ArrayList<Boolean> getDefaultChecked() {
        return defaultChecked;
    }

    public MultiChoiceTileData setDefaultChecked(ArrayList<Boolean> defaultChecked) {
        this.defaultChecked = defaultChecked;
        return build();
    }
}
