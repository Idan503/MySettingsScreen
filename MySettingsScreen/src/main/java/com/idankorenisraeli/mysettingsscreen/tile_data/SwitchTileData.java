package com.idankorenisraeli.mysettingsscreen.tile_data;

import android.widget.CompoundButton;

import androidx.annotation.Nullable;

/**
 * Settings tile that contains a single switch
 */
public class SwitchTileData extends SavableTileData<Boolean,SwitchTileData> {

    @Override
    public SwitchTileData build() {
        return this;
    }

    private @Nullable CompoundButton.OnCheckedChangeListener onChangeListener;
    //Outer layout click functionality implemented inside holder object


    public SwitchTileData(String title, String description) {
        super(title, description);
    }

    @Nullable
    public CompoundButton.OnCheckedChangeListener getOnChangeListener() {
        return onChangeListener;
    }

    public SwitchTileData withOnChangeListener(@Nullable CompoundButton.OnCheckedChangeListener onChangeListener) {
        this.onChangeListener = onChangeListener;
        return build();
    }

    public void setOnChangeListener(@Nullable CompoundButton.OnCheckedChangeListener onChangeListener) {
        this.onChangeListener = onChangeListener;
    }
}
