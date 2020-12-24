package com.idankorenisraeli.mysettingsscreen.tile_holder;

import android.util.Log;
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

        if(mData.getOnClickListener()!=null) {
            View.OnClickListener tileClickListener = new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mData.getOnClickListener().onClick(itemView);
                }
            };

            this.itemView.setClickable(true);
            this.itemView.setOnClickListener(tileClickListener);
        }
    }

    @Override
    protected void validateData(SettingsTileData tileObject) {
        super.validateData(tileObject);

        ButtonTileData mData = (ButtonTileData) tileObject;

        if(mData.getOnClickListener() == null){
            Log.w(TAG, "Radio Group Settings is missing \"On Click\" attribute.");
        }
    }
}
