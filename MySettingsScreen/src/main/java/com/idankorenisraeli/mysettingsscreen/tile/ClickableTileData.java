package com.idankorenisraeli.mysettingsscreen.tile;
import android.view.View;


public class ClickableTileData extends SettingsTileData {

    protected View.OnClickListener onClick;

    public ClickableTileData(String title, String description, View.OnClickListener onClick) {
        super(title, description);
        if(onClick!=null)
            this.onClick = onClick;
    }

    public ClickableTileData(String title, String description) {
        super(title, description);
    }


    public View.OnClickListener getClickListener() {
        return onClick;
    }
}
