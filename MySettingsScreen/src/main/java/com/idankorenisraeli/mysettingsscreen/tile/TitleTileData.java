package com.idankorenisraeli.mysettingsscreen.tile;

/**
 * TitleTile is used for showing information without any user-interaction
 */
public class TitleTileData extends SettingsTileData {
    private int height;

    public TitleTileData(String title, String description) {
        super(title, description);
        this.height = -1;
    }

    /**
     * Width of the tile will always match the screen width
     * @param title Main text
     * @param description Subtitle
     * @param height In dp
     */
    public TitleTileData(String title, String description, int height) {
        super(title, description);
        this.height = height;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
