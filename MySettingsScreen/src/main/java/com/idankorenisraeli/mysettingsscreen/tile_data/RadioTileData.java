package com.idankorenisraeli.mysettingsscreen.tile_data;

import com.idankorenisraeli.mysettingsscreen.callback.OnOptionSelectedListener;

import java.util.InputMismatchException;
import java.util.List;


public class RadioTileData extends TitleTileData<RadioTileData> {

    private String defaultOption;
    private boolean dropDown;
    private OnOptionSelectedListener onSelected;
    private List<String> options;
    //Outer layout click functionality implemented inside holder object

    // TODO - MIN VALUE, MAX VALUE, SP LINK

    @Override
    public RadioTileData build() {
        return this;
    }

    public RadioTileData(String title, String description) {
        super(title, description);
    }

    public OnOptionSelectedListener getOnSelected() {
        return onSelected;
    }

    public RadioTileData setOnSelected(OnOptionSelectedListener onSelected) {
        this.onSelected = onSelected;
        return build();
    }

    public List<String> getOptions() {
        return options;
    }

    public RadioTileData setOptions(List<String> options) {
        this.options = options;
        return build();
    }

    public boolean isDropDown() {
        return dropDown;
    }

    public RadioTileData setDropDown(boolean dropDown) {
        this.dropDown = dropDown;
        return build();
    }

    public String getDefaultOption() {
        return defaultOption;
    }

    public RadioTileData setDefaultOption(String defaultOption) {
        if(!options.contains(defaultOption))
            throw new InputMismatchException("Options list must contain the Default Option");
        this.defaultOption = defaultOption;
        return build();
    }
}
