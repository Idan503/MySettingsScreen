package com.idankorenisraeli.mysettingsscreen.tile_holder;

import android.view.View;

import com.idankorenisraeli.mysettingsscreen.tile.RadioTileData;
import com.idankorenisraeli.mysettingsscreen.tile.SettingsTileData;

public class RadioTileHolder extends SettingsTileHolder {

    public RadioTileHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void setData(SettingsTileData<?> tileObject) {
        super.setData(tileObject);
        RadioTileData mData = (RadioTileData) tileObject;

        if (mData.getOnChanged() != null)
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //mData.getOnChanged().onCheckedChanged();
                    //Init dialog with the callback ^^
                }
            });
    }
}
