package com.idankorenisraeli.mysettingsscreen.tile_holder;

import android.view.View;
import android.widget.CompoundButton;

import androidx.appcompat.widget.SwitchCompat;

import com.google.android.material.switchmaterial.SwitchMaterial;
import com.idankorenisraeli.mysettingsscreen.R;
import com.idankorenisraeli.mysettingsscreen.tile.SettingsTileData;
import com.idankorenisraeli.mysettingsscreen.tile.SwitchTileData;

public class SwitchTileHolder extends SettingsTileHolder{


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
    public boolean setData(SettingsTileData<?> tileObject) {
        if(!super.setData(tileObject)) return false;
        SwitchTileData mData = (SwitchTileData) tileObject;

        if(mData.getOnChange()!=null) {
            switchMaterial.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    mData.getOnChange().onCheckedChanged(buttonView, isChecked);

                    //SP Management should be implemented here
                }
            });


        }

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switchMaterial.performClick();
            }
        });

        return true;
    }
}
