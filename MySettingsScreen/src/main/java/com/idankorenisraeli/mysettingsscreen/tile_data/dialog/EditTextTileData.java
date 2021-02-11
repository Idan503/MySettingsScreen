package com.idankorenisraeli.mysettingsscreen.tile_data.dialog;

import com.idankorenisraeli.mysettingsscreen.callback.OnOptionSelectListener;
import com.idankorenisraeli.mysettingsscreen.tile_data.essential.SavableTileData;

/**
 * Tile data object that stores the string that the user selected on a tile in the settings activity
 */
public class EditTextTileData extends SavableTileData<String, EditTextTileData> {
    private OnOptionSelectListener onSelectedListener;
    //Outer layout click functionality implemented inside holder object


    @Override
    protected EditTextTileData build() {
        return this;
    }

    public EditTextTileData(String title, String description) {
        super(title, description);
    }

    public OnOptionSelectListener getOnSelectedListener() {
        return onSelectedListener;
    }

    public EditTextTileData withOnSelectedListener(OnOptionSelectListener onSelectedListener) {
        this.onSelectedListener = onSelectedListener;
        return build();
    }


    protected void setOnSelectedListener(OnOptionSelectListener onSelectedListener) {
        this.onSelectedListener = onSelectedListener;
    }

}
