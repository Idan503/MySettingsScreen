package com.idankorenisraeli.mysettingsscreen.holder.essential;

import android.view.View;

import com.idankorenisraeli.mysettingsscreen.tile_data.essential.ButtonTileData;
import com.idankorenisraeli.mysettingsscreen.tile_data.essential.SettingsTileData;

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
            logMissedAttribute(getClass().getSimpleName(),"On Click");
        }
    }
}
