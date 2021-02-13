package com.idankorenisraeli.mysettingsscreen.tile_data.essential;
import android.os.Parcel;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.io.Serializable;
import java.util.ArrayList;


/**
 * Inner page tile provides a way to show more tiles in a different interface.
 * This tile will create a new Fragment with the innerTilesData inside as more settings page.
 */
public class InnerPageTileData extends BasicTileData<InnerPageTileData> implements Serializable {


    private @NonNull ArrayList<SettingsTileData> innerTilesData = new ArrayList<>();
    private @Nullable String actionBarTitle; // null for NoActionBar

    @Override
    protected InnerPageTileData build() {
        return this;
    }


    public InnerPageTileData(String title, String description) {
        super(title, description);
    }

    @NonNull
    public ArrayList<SettingsTileData> getInnerTilesData() {
        return innerTilesData;
    }

    public void setInnerTilesData(@NonNull ArrayList<SettingsTileData> innerTilesData) {
        this.innerTilesData = innerTilesData;
    }

    public InnerPageTileData withInnerTilesData(ArrayList<SettingsTileData> tiles){
        this.innerTilesData = tiles;
        return build();
    }

    public InnerPageTileData withActionBarTitle(String title){
        this.actionBarTitle = title;
        return build();
    }

    @Nullable
    public String getActionBarTitle() {
        return actionBarTitle;
    }

    public void setActionBarTitle(@Nullable String actionBarTitle) {
        this.actionBarTitle = actionBarTitle;
    }
}
