package com.idankorenisraeli.mysettingsscreen.tile_data;

import androidx.annotation.Nullable;

import java.io.Serializable;

/**
 * This class provides a skeleton for attributes and methods of Settings Tile Data,
 * and therefore is abstract.
 * If you would like to use a concrete simple tile with only title, description and icon,
 * You can use TitleTileData.
 * @param <T> Concrete type of tile data (used for builder)
 */
public abstract class BasicTileData<T> implements SettingsTileData {


    protected String title;
    protected String description;
    protected  @Nullable Integer iconId;

    public static final int IC_INVISIBLE = -1;

    protected abstract T build();

    public BasicTileData(){
    }

    public BasicTileData(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public T withTitle(String title) {
        this.title = title;
        return build();
    }

    public String getDescription() {
        return description;
    }

    public T withDescription(String description) {
        this.description = description;
        return build();
    }

    @Nullable
    public Integer getIconId() {
        return iconId;
    }

    /**
     * Set a null iconId for no-icon-tile.
     * Icon Id of -1 will show padding only (No icon)
     * @param iconId Id of icon drawable, -1 for invisible
     * @return Result tile (builder)
     */
    public T withIconId(@Nullable Integer iconId) {
        this.iconId = iconId;
        return build();
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setIconId(@Nullable Integer iconId) {
        this.iconId = iconId;
    }
}
