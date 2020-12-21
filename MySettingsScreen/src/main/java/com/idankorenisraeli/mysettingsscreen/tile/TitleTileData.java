package com.idankorenisraeli.mysettingsscreen.tile;

import androidx.annotation.Nullable;

/**
 * TitleTile is used for showing information without any user-interaction
 */
public class TitleTileData extends SettingsTileData<TitleTileData> {
    private @Nullable Integer height;

    @Override
    protected TitleTileData build() {
        return this;
    }

    public TitleTileData(String title, String description) {
        super(title, description);
        this.height = null;
    }


    @Nullable
    public Integer getHeight() {
        return height;
    }

    public TitleTileData setHeight(@Nullable Integer height) {
        this.height = height;
        return this;
    }
}
