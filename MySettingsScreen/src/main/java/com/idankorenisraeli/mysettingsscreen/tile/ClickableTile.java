package com.idankorenisraeli.mysettingsscreen.tile;

import com.idankorenisraeli.mysettingsscreen.callback.OnTileClicked;

public class ClickableTile extends SettingsTile{

    private OnTileClicked onClick;

    public ClickableTile(String title, String description, OnTileClicked onClick) {
        super(title, description);
        this.onClick = onClick;
    }
}
