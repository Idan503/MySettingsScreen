package com.idankorenisraeli.mysettingsscreen.recycler;

import android.util.Log;
import android.view.View;
import android.widget.CompoundButton;

import com.google.android.material.switchmaterial.SwitchMaterial;
import com.idankorenisraeli.mysettingsscreen.R;
import com.idankorenisraeli.mysettingsscreen.tile_data.SettingsTileData;
import com.idankorenisraeli.mysettingsscreen.tile_data.SwitchTileData;

class SwitchTileHolder extends TitleTileHolder{


    SwitchMaterial switchMaterial;

    public SwitchTileHolder(View itemView) {
        super(itemView);
        findViews();


    }


    @Override
    protected void findViews() {
        super.findViews();
        switchMaterial = itemView.findViewById(R.id.tile_SW_switch);
    }

    @Override
    public void setData(SettingsTileData tileObject) {
        super.setData(tileObject);
        SwitchTileData mData = (SwitchTileData) tileObject;


        switchMaterial.setChecked(mData.getSavedValue());

        switchMaterial.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                    mData.saveValue(isChecked);

                    if(mData.getOnChangeListener()!=null)
                        mData.getOnChangeListener().onCheckedChanged(buttonView, isChecked);

                    //SP Management should be implemented here
                }
            });




        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switchMaterial.performClick();
            }
        });

    }

    @Override
    protected void validateData(SettingsTileData tileData) {
        super.validateData(tileData);
        
        SwitchTileData mData = (SwitchTileData) tileData;

        if(mData.getDefaultValue() == null){
            Log.w(TAG, "Switch Settings Tile is missing \"Default Value\" attribute.");
            mData.setDefaultValue(false);
        }


    }

}
