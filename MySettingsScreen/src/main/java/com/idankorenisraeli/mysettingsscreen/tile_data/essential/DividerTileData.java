package com.idankorenisraeli.mysettingsscreen.tile_data.essential;

import android.graphics.Color;

import java.io.Serializable;


/**
 * A horizontal line that will divide the tile before and the tile after this one visually
 */
public class DividerTileData implements Serializable, SettingsTileData {

    private Integer height;
    private int color = Color.WHITE;

    public final static Integer DEFAULT_HEIGHT = 1;

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

    public DividerTileData withColor(int color) {
        this.color = color;
        return build();
    }

    protected DividerTileData build() {
        return this;
    }

    protected void setHeight(Integer height) {
        this.height = height;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }
}
