package com.idankorenisraeli.mysettingsscreen.tile;
import android.view.View;


public class ButtonTileData extends SettingsTileData<ButtonTileData> {

    @Override
    protected ButtonTileData build() {
        return this;
    }

    protected View.OnClickListener onClick;

    public ButtonTileData(String title, String description) {
        super(title, description);
    }


    public View.OnClickListener getOnClick() {
        return onClick;
    }

    public ButtonTileData setOnClick(View.OnClickListener onClick) {
        this.onClick = onClick;
        return this;
    }
}
