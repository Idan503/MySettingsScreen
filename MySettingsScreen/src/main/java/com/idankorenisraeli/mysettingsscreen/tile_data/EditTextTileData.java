package com.idankorenisraeli.mysettingsscreen.tile_data;

import com.idankorenisraeli.mysettingsscreen.callback.OnOptionSelectListener;

import java.util.InputMismatchException;
import java.util.List;

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
