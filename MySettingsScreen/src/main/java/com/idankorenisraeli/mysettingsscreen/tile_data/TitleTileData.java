package com.idankorenisraeli.mysettingsscreen.tile_data;

/**
 * Settings tile which only contains icon and text, not clickable.
 */
public class TitleTileData extends TextIconTileData<TitleTileData> {
    @Override
    public TitleTileData build() {
        return this;
    }
}
