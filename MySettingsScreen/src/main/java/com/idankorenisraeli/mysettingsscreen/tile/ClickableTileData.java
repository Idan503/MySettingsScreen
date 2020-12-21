package com.idankorenisraeli.mysettingsscreen.tile;
import android.view.View;


public class ClickableTileData extends SettingsTileData {

    protected View.OnClickListener onClick;

    public ClickableTileData(String title, String description) {
        super(title, description);
    }


    public View.OnClickListener getOnClick() {
        return onClick;
    }

    public ClickableTileData setOnClick(View.OnClickListener onClick) {
        this.onClick = onClick;
        return this;
    }
}
