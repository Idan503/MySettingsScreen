package com.idankorenisraeli.mysettingsscreen.tile;

import android.view.View;
import android.widget.CompoundButton;

import androidx.annotation.Nullable;


public class SwitchTileData extends ClickableTileData {


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
        return this;
    }
}
