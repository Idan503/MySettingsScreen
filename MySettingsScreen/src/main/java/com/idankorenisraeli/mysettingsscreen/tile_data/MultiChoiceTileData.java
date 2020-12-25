package com.idankorenisraeli.mysettingsscreen.tile_data;

import com.idankorenisraeli.mysettingsscreen.callback.OnMultiSelectListener;

import java.util.ArrayList;
import java.util.List;


/**
 *
 *
 * String savable type will represent the checked values from options by
 * a single string which contains 1s and 0s in the same order of checked/unchecked in list
 *
 */
public class MultiChoiceTileData extends SavableTileData<ArrayList<Boolean>,MultiChoiceTileData> {

    private OnMultiSelectListener onChangedListener;
    private ArrayList<String> optionsList;
    //Outer layout click functionality implemented inside holder object

    // TODO - Change Default Checked to type that can be saved as sp

    @Override
    protected MultiChoiceTileData build() {
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

    public void setOnChangedListener(OnMultiSelectListener onChangedListener) {
        this.onChangedListener = onChangedListener;
    }

    public void setOptionsList(ArrayList<String> optionsList) {
        this.optionsList = optionsList;
    }

    /*
    public void saveValue(boolean[] checkedList) {
        super.saveValue(checkedListToStr(checkedList));
    }


    public boolean[] getSavedValue(){
        return strToCheckedList(super.getSavedValue());
    }

     */






}
