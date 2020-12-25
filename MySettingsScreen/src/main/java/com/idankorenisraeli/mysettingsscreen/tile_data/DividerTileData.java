package com.idankorenisraeli.mysettingsscreen.tile_data;

import java.io.Serializable;


/**
 * A horizontal line that will divide the tile before and the tile after this one visually
 */
public class DividerTileData implements Serializable, SettingsTileData {

    private Integer height;

    public DividerTileData(){

    }

    public DividerTileData(int height){
        this.height = height;
    }

    public Integer getHeight() {
        return height;
    }

    public DividerTileData withHeight(int height) {
        this.height = height;
        return build();
    }

    protected DividerTileData build() {
        return this;
    }

    protected void setHeight(Integer height) {
        this.height = height;
    }
}
