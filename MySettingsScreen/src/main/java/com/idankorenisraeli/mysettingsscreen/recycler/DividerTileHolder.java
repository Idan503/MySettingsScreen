package com.idankorenisraeli.mysettingsscreen.recycler;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.idankorenisraeli.mysettingsscreen.R;
import com.idankorenisraeli.mysettingsscreen.tile_data.DividerTileData;
import com.idankorenisraeli.mysettingsscreen.tile_data.SettingsTileData;

class DividerTileHolder extends RecyclerView.ViewHolder implements SettingsTileHolder {

    View divider;

    private final static String TAG = "DividerTileHolder";

    public DividerTileHolder(@NonNull View itemView) {
        super(itemView); findViews();
    }

    private void findViews(){
        divider = itemView.findViewById(R.id.tile_VIEW_divider);
    }


    @Override
    public void setData(SettingsTileData tileData) {

        DividerTileData mData = (DividerTileData) tileData;
        validateData(mData);

        ViewGroup.LayoutParams params = divider.getLayoutParams();
        params.height = mData.getHeight();

        divider.setLayoutParams(params);

    }

    private void validateData(DividerTileData data){
        if(data.getHeight()==null) {
            Log.w(TAG, "Seekbar Settings Tile is missing \"Height\" attribute.");
            data.withHeight(2);
        }
    }

}