package com.idankorenisraeli.mysettingsscreen.tile;

import android.graphics.drawable.Drawable;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.io.Serializable;

public abstract class SettingsTileData implements Serializable {

    private String title;
    private String description;
    private @Nullable Integer iconId;

    // Empty Builder
    public SettingsTileData(){

    }

    public SettingsTileData(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public SettingsTileData setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public SettingsTileData setDescription(String description) {
        this.description = description;
        return this;
    }

    @Nullable
    public Integer getIconId() {
        return iconId;
    }

    /**
     * Set a null iconId for no-icon-tile
     * @param iconId Id of icon drawable
     * @return Result tile (builder)
     */
    public SettingsTileData setIconId(@Nullable Integer iconId) {
        this.iconId = iconId;
        return this;
    }
}
