package com.idankorenisraeli.mysettingsscreen.tile_data;

import java.io.Serializable;

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

    public DividerTileData setHeight(int height) {
        this.height = height;
        return this;
    }

    public DividerTileData build() {
        return this;
    }
}
