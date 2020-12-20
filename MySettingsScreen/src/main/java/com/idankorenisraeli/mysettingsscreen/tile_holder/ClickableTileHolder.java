package com.idankorenisraeli.mysettingsscreen.tile_holder;

import android.view.View;

import com.idankorenisraeli.mysettingsscreen.tile.ClickableTileData;

public class ClickableTileHolder extends SettingsTileHolder{

    public ClickableTileHolder(View itemView) {
        super(itemView);
    }

    public void setData(ClickableTileData tileObject) {
        super.setData(tileObject);
        this.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tileObject.getClickListener().onItemClick(itemView, getAdapterPosition());
            }
        });
    }
}
