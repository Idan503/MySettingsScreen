package com.idankorenisraeli.mysettingsscreen.tile;

import android.graphics.drawable.Drawable;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.io.Serializable;

public abstract class SettingsTileData<T> implements Serializable {

    protected abstract T build();

    private String title;
    private String description;
    private @Nullable Integer iconId;

    public static final int INVISIBLE_ICON_ID = -1;

    
    public SettingsTileData(){

    }

    public SettingsTileData(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public T setTitle(String title) {
        this.title = title;
        return build();
    }

    public String getDescription() {
        return description;
    }

    public T setDescription(String description) {
        this.description = description;
        return build();
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
    public T setIconId(@Nullable Integer iconId) {
        this.iconId = iconId;
        return build();
    }

    public T setInvisibleIcon(boolean iconPaddingOnly){
        this.iconId = (iconPaddingOnly) ? INVISIBLE_ICON_ID : iconId;
        return build();
    }
}
