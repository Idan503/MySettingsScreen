package com.idankorenisraeli.mysettingsscreen.tile;

import android.content.DialogInterface;
import android.widget.CompoundButton;

import java.util.ArrayList;


public class MultiChoiceTileData extends SettingsTileData<MultiChoiceTileData> {

    private DialogInterface.OnMultiChoiceClickListener onChanged;
    private ArrayList<String> options;
    //Outer layout click functionality implemented inside holder object

    // TODO - MIN VALUE, MAX VALUE, SP LINK

    @Override
    protected MultiChoiceTileData build() {
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

    public DialogInterface.OnMultiChoiceClickListener getOnChanged() {
        return onChanged;
    }

    public MultiChoiceTileData setOnChanged(DialogInterface.OnMultiChoiceClickListener onChanged) {
        this.onChanged = onChanged;
        return build();
    }
}
