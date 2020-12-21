package com.idankorenisraeli.mysettingsscreen.tile_holder;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.idankorenisraeli.mysettingsscreen.R;
import com.idankorenisraeli.mysettingsscreen.tile.SettingsTileData;
import com.idankorenisraeli.mysettingsscreen.tile.TitleTileData;

public class TitleTileHolder extends SettingsTileHolder{

    public TitleTileHolder(View itemView) {
        super(itemView);
    }



    @Override
    public void setData(SettingsTileData tileObject) {
        super.setData(tileObject);
        TitleTileData mData = (TitleTileData) tileObject;

        if(mData.getHeight()!=-1)
            resizeHeight(mData.getHeight());


    }

    private void resizeHeight(int newHeight){
        // Gets the layout params that will allow you to resize the layout
        ViewGroup.LayoutParams params = itemView.getLayoutParams();
        // Changes the height and width to the specified *pixels*
        params.height = newHeight;
        itemView.setLayoutParams(params);
    }
}
