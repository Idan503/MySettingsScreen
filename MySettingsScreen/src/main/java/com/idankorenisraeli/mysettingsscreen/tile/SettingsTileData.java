package com.idankorenisraeli.mysettingsscreen.tile;

import java.io.Serializable;

public abstract class SettingsTileData implements Serializable {

    private String title;
    private String description;

    public SettingsTileData(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    private void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    private void setDescription(String description) {
        this.description = description;
    }
}
