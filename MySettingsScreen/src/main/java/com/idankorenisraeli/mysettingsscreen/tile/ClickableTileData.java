package com.idankorenisraeli.mysettingsscreen.tile;

import com.idankorenisraeli.mysettingsscreen.callback.OnSettingsTileClicked;

public class ClickableTileData extends SettingsTileData {

    private final OnSettingsTileClicked onClick;

    public ClickableTileData(String title, String description, OnSettingsTileClicked onClick) {
        super(title, description);
        this.onClick = onClick;
    }


    public OnSettingsTileClicked getClickListener() {
        return onClick;
    }
}
