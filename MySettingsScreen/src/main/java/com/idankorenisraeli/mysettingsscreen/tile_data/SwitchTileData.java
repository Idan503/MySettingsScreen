package com.idankorenisraeli.mysettingsscreen.tile_data;

import android.widget.CompoundButton;

import androidx.annotation.Nullable;


public class SwitchTileData extends TextIconTileData<SwitchTileData> {

    @Override
    public SwitchTileData build() {
        return this;
    }

    private boolean defaultValue = false;
    private @Nullable CompoundButton.OnCheckedChangeListener onChange;
    //Outer layout click functionality implemented inside holder object


    public SwitchTileData(String title, String description) {
        super(title, description);
    }

    @Nullable
    public CompoundButton.OnCheckedChangeListener getOnChange() {
        return onChange;
    }

    public SwitchTileData setOnChange(@Nullable CompoundButton.OnCheckedChangeListener onChange) {
        this.onChange = onChange;
        return build();
    }

    public boolean isDefaultValue() {
        return defaultValue;
    }

    public SwitchTileData setDefaultValue(boolean defaultValue) {
        this.defaultValue = defaultValue;
        return build();
    }
}
