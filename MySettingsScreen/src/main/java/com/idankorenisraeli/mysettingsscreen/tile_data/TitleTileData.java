package com.idankorenisraeli.mysettingsscreen.tile_data;

/**
 * Settings tile which only contains icon and text, not clickable.
 */
public class TitleTileData extends BasicTileData<TitleTileData> {
    @Override
    protected TitleTileData build() {
        return this;
    }

    public TitleTileData(String title, String description){
        super(title,description);
    }


}
