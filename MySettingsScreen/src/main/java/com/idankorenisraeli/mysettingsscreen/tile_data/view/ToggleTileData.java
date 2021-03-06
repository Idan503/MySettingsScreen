package com.idankorenisraeli.mysettingsscreen.tile_data.view;

import android.widget.CompoundButton;

import androidx.annotation.Nullable;

import com.idankorenisraeli.mysettingsscreen.enums.ToggleType;
import com.idankorenisraeli.mysettingsscreen.tile_data.essential.SavableTileData;

/**
 * Settings tile that let user choose a certain option of on/off
 * can be either by a switch (default) or by a checkbox
 */
public class ToggleTileData extends SavableTileData<Boolean, ToggleTileData> {

    private ToggleType toggleType = ToggleType.SWITCH;
    private @Nullable CompoundButton.OnCheckedChangeListener onChangeListener;
    //Outer layout click functionality implemented inside holder object
    @Override
    protected ToggleTileData build() {
        return this;
    }



    public ToggleTileData(String title, String description) {
        super(title, description);
    }

    @Nullable
    public CompoundButton.OnCheckedChangeListener getOnChangeListener() {
        return onChangeListener;
    }

    public ToggleTileData withOnChangeListener(@Nullable CompoundButton.OnCheckedChangeListener onChangeListener) {
        this.onChangeListener = onChangeListener;
        return build();
    }

    protected void setOnChangeListener(@Nullable CompoundButton.OnCheckedChangeListener onChangeListener) {
        this.onChangeListener = onChangeListener;
    }

    public ToggleTileData withToggleType(ToggleType type){
        this.toggleType = type;
        return build();
    }

    public ToggleType getToggleType() {
        return toggleType;
    }

    public void setToggleType(ToggleType toggleType) {
        this.toggleType = toggleType;
    }
}
