package com.idankorenisraeli.mysettingsscreen.tile;

import java.io.Serializable;

public abstract class SettingsTile implements Serializable {

    private String title;
    private String description;

    public SettingsTile(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
