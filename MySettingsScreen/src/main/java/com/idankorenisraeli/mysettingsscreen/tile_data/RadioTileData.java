package com.idankorenisraeli.mysettingsscreen.tile_data;

import com.idankorenisraeli.mysettingsscreen.callback.OnRadioSelectListener;

import java.util.InputMismatchException;
import java.util.List;

public class RadioTileData extends SavableTileData<String, RadioTileData> {
    private RadioType radioType = RadioType.DIALOG_LABELED;
    private OnRadioSelectListener onSelectedListener;
    private List<String> optionsList;

    //Outer layout click functionality implemented inside holder object

    // TODO - SP LINK


    @Override
    protected RadioTileData build() {
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



    public RadioTileData withRadioType(RadioType type) {
        this.radioType = type;
        return build();
    }


    @Override
    public RadioTileData withDefaultValue(String defaultOption) {
        if(!optionsList.contains(defaultOption))
            throw new InputMismatchException("Options list must contain the Default Option");
        this.defaultValue = defaultOption;
        return build();
    }

    public RadioType getRadioType() {
        return radioType;
    }

    public void setRadioType(RadioType radioType) {
        this.radioType = radioType;
    }

    protected void setOnSelectedListener(OnRadioSelectListener onSelectedListener) {
        this.onSelectedListener = onSelectedListener;
    }

    protected void setOptionsList(List<String> optionsList) {
        this.optionsList = optionsList;
    }
}
