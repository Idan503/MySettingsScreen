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

    private Boolean defaultValue = false;
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

    public Boolean getDefaultValue() {
        return defaultValue;
    }

    public SwitchTileData withDefaultValue(boolean defaultValue) {
        this.defaultValue = defaultValue;
        return build();
    }

    public void setDefaultValue(Boolean defaultValue) {
        this.defaultValue = defaultValue;
    }

    public void setOnChangeListener(@Nullable CompoundButton.OnCheckedChangeListener onChangeListener) {
        this.onChangeListener = onChangeListener;
    }
}
