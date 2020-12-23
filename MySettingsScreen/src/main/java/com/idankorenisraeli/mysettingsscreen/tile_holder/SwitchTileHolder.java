package com.idankorenisraeli.mysettingsscreen.tile_holder;

import android.view.View;
import android.widget.CompoundButton;

import com.google.android.material.switchmaterial.SwitchMaterial;
import com.idankorenisraeli.mysettingsscreen.R;
import com.idankorenisraeli.mysettingsscreen.tile_data.SettingsTileData;
import com.idankorenisraeli.mysettingsscreen.tile_data.SwitchTileData;

public class SwitchTileHolder extends TitleTileHolder{


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

    }

    protected void validateData(SettingsTileData mData) {
        super.validateData(mData);


    }

}
