package com.idankorenisraeli.mysettingsscreen.tile_data;

import com.idankorenisraeli.mysettingsscreen.callback.OnMultiSelectListener;

import java.util.ArrayList;


public class MultiChoiceTileData extends BasicTileData<MultiChoiceTileData> {

    private OnMultiSelectListener onChangedListener;
    private ArrayList<String> optionsList;
    //private ArrayList<Boolean> defaultChecked;
    //Outer layout click functionality implemented inside holder object

    // TODO - Change Default Checked to type that can be saved as sp

    @Override
    public MultiChoiceTileData build() {
        return this;
    }

    public MultiChoiceTileData(String title, String description) {
        super(title, description);
    }



    public ArrayList<String> getOptionsList() {
        return optionsList;
    }

    public MultiChoiceTileData withOptionsList(ArrayList<String> options) {
        this.optionsList = options;
        return build();
    }

    public OnMultiSelectListener getOnChangedListener() {
        return onChangedListener;
    }

    public MultiChoiceTileData withOnChangedListener(OnMultiSelectListener onChangedListener) {
        this.onChangedListener = onChangedListener;
        return build();
    }

    /*
    public ArrayList<Boolean> getDefaultChecked() {
        return defaultChecked;
    }

    public MultiChoiceTileData withDefaultChecked(ArrayList<Boolean> defaultChecked) {
        this.defaultChecked = defaultChecked;
        return build();
    }
        public void setDefaultChecked(ArrayList<Boolean> defaultChecked) {
        this.defaultChecked = defaultChecked;
    }
     */

    public void setOnChangedListener(OnMultiSelectListener onChangedListener) {
        this.onChangedListener = onChangedListener;
    }

    public void setOptionsList(ArrayList<String> optionsList) {
        this.optionsList = optionsList;
    }


}
