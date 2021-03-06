package com.idankorenisraeli.mysettingsscreen.tile_data.essential;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.material.textfield.TextInputLayout;

import java.io.Serializable;

/**
 * This class provides a skeleton for attributes and methods of Settings Tile Data,
 * and therefore is abstract.
 * If you would like to use a concrete simple tile with only title, description and icon,
 * You can use TitleTileData.
 * @param <T> Concrete type of tile data (used for builder)
 */
public abstract class BasicTileData<T> implements SettingsTileData, Serializable {

    protected @NonNull String title = "Tile Title";
    protected @NonNull String description = "Tile Description";

    protected  @Nullable Integer iconId;

    protected boolean sourceColorIcon = false;
    // When set to False (by default) the color of the tile icon is being set by values/themes.xml
    // Which sets the icon to a bright color on night-theme and dark color on day-theme.

    public static final int IC_INVISIBLE = -1;
    // Showing no icon but its padding only, color is transparent.

    protected abstract T build();

    public BasicTileData(){
    }

    public BasicTileData(String title, String description) {
        this.title = title;
        this.description = description;
    }

    @NonNull
    public String getTitle() {
        return title;
    }

    public T withTitle(String title) {
        this.title = title;
        return build();
    }

    @NonNull
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
     * Icon Id of -1 (= IC_INVISIBLE) will show icon padding only
     * @param iconId Id of icon drawable, IC_INVISIBLE (-1) for invisible
     * @return Result tile (builder)
     */
    public T withIconId(@Nullable Integer iconId) {
        this.iconId = iconId;
        return build();
    }

    /**
     * Will the icon will be shown with its original source color or a filter will be applied based on values/themes.xml
     * Night theme will provide bright icon colors
     * and day theme will provide dark icon colors
     * @param sourceColorIcon true for source color, false for provided day/night color
     * @return Result tile (builder)
     */
    public T withSourceColorIcon(boolean sourceColorIcon){
        this.sourceColorIcon = sourceColorIcon;
        return build();
    }


    /**
     * @return true when the icon of this tile is its original (source) color that is set.
     */
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
