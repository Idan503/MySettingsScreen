package com.idankorenisraeli.mysettingsscreen.tile;

import android.view.View;
import android.widget.CompoundButton;



public class SwitchTileData extends ClickableTileData {


    private CompoundButton.OnCheckedChangeListener onChange;
    //Outer layout click functionality implemented inside holder object


    public SwitchTileData(String title, String description, CompoundButton.OnCheckedChangeListener onChange) {
        super(title, description);
        this.onChange = onChange;
        this.onClick = null;
    }

    public CompoundButton.OnCheckedChangeListener getOnChange() {
        return onChange;
    }

    public void setOnChange(CompoundButton.OnCheckedChangeListener onChange) {
        this.onChange = onChange;
    }
}
