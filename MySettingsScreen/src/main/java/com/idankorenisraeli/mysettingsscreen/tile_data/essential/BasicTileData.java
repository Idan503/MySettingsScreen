package com.idankorenisraeli.mysettingsscreen.tile_data.essential;

import androidx.annotation.Nullable;

import java.io.Serializable;

/**
 * This class provides a skeleton for attributes and methods of Settings Tile Data,
 * and therefore is abstract.
 * If you would like to use a concrete simple tile with only title, description and icon,
 * You can use TitleTileData.
 * @param <T> Concrete type of tile data (used for builder)
 */
public abstract class BasicTileData<T> implements SettingsTileData, Serializable {


    protected String title;
    protected String description;

    protected  @Nullable Integer iconId;

    protected boolean sourceColorIcon = false;
    //By default, tint will be applied to the icon based on Day/Night theme

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

    public T withSourceColorIcon(boolean sourceColorIcon){
        this.sourceColorIcon = sourceColorIcon;
        return build();
    }

    public boolean isSourceColorIcon() {
        return sourceColorIcon;
    }

    public void setSourceColorIcon(boolean sourceColorIcon) {
        this.sourceColorIcon = sourceColorIcon;
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
