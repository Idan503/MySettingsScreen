package com.idankorenisraeli.mysettingsscreen.tile_holder;

import android.view.View;

import com.idankorenisraeli.mysettingsscreen.tile_data.ButtonTileData;
import com.idankorenisraeli.mysettingsscreen.tile_data.SettingsTileData;

public class ButtonTileHolder extends TitleTileHolder{

    public ButtonTileHolder(View itemView) {
        super(itemView);
    }


    @Override
    public void setData(SettingsTileData tileObject) {
        super.setData(tileObject);

        ButtonTileData mData = (ButtonTileData) tileObject;

        if(mData.getOnClick()!=null) {
            View.OnClickListener tileClickListener = new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mData.getOnClick().onClick(itemView);
                }
            };

            this.itemView.setClickable(true);
            this.itemView.setOnClickListener(tileClickListener);
        }

    }
}
