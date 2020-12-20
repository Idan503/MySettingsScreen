package com.idankorenisraeli.mysettingsscreen.tile_holder;

import android.util.Log;
import android.view.View;

import com.idankorenisraeli.mysettingsscreen.tile.ClickableTileData;
import com.idankorenisraeli.mysettingsscreen.tile.SettingsTileData;

public class ClickableTileHolder extends SettingsTileHolder{

    public ClickableTileHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void setData(SettingsTileData tileObject) {
        super.setData(tileObject);

        ClickableTileData mData = (ClickableTileData) tileObject;

        View.OnClickListener tileClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mData.getClickListener()!=null)
                    mData.getClickListener().onItemClick(itemView, getAdapterPosition());
            }
        };

        this.itemView.setClickable(true);
        this.itemView.setOnClickListener(tileClickListener);
    }
}
