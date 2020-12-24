package com.idankorenisraeli.mysettingsscreen.tile_data;

import com.idankorenisraeli.mysettingsscreen.callback.OnRadioSelectListener;

import java.util.InputMismatchException;
import java.util.List;


public class RadioTileData extends BasicTileData<RadioTileData> {

    private String defaultOption;
    private boolean dropDown = false;
    private OnRadioSelectListener onSelectedListener;
    private List<String> optionsList;
    //Outer layout click functionality implemented inside holder object

    // TODO - SP LINK

    @Override
    public RadioTileData build() {
        return this;
    }

    public RadioTileData(String title, String description) {
        super(title, description);
    }

    public OnRadioSelectListener getOnSelectedListener() {
        return onSelectedListener;
    }

    public RadioTileData withOnSelectedListener(OnRadioSelectListener onSelectedListener) {
        this.onSelectedListener = onSelectedListener;
        return build();
    }

    public List<String> getOptionsList() {
        return optionsList;
    }

    public RadioTileData withOptionsList(List<String> optionsList) {
        this.optionsList = optionsList;
        return build();
    }

    public boolean isDropDown() {
        return dropDown;
    }

    public RadioTileData withDropDown(boolean dropDown) {
        this.dropDown = dropDown;
        return build();
    }

    public String getDefaultOption() {
        return defaultOption;
    }

    public RadioTileData withDefaultOption(String defaultOption) {
        if(!optionsList.contains(defaultOption))
            throw new InputMismatchException("Options list must contain the Default Option");
        this.defaultOption = defaultOption;
        return build();
    }

    public void setDefaultOption(String defaultOption) {
        this.defaultOption = defaultOption;
    }

    public void setDropDown(boolean dropDown) {
        this.dropDown = dropDown;
    }

    public void setOnSelectedListener(OnRadioSelectListener onSelectedListener) {
        this.onSelectedListener = onSelectedListener;
    }

    public void setOptionsList(List<String> optionsList) {
        this.optionsList = optionsList;
    }
}
