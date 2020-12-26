package com.idankorenisraeli.mysettingsscreen.recycler;

import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import com.idankorenisraeli.mysettingsscreen.R;
import com.idankorenisraeli.mysettingsscreen.tile_data.SettingsTileData;
import com.idankorenisraeli.mysettingsscreen.tile_data.ToggleTileData;

class CheckboxTileHolder extends TitleTileHolder{


    CheckBox checkBox;

    public CheckboxTileHolder(View itemView) {
        super(itemView);
        findViews();


    }


    @Override
    protected void findViews() {
        super.findViews();
        checkBox = itemView.findViewById(R.id.tile_CB_checkbox);
    }

    @Override
    public void setData(SettingsTileData tileObject) {
        super.setData(tileObject);
        ToggleTileData mData = (ToggleTileData) tileObject;


        checkBox.setChecked(mData.getSavedValue());

        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
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
                checkBox.performClick();
            }
        });

    }

    @Override
    protected void validateData(SettingsTileData tileData) {
        super.validateData(tileData);
        
        ToggleTileData mData = (ToggleTileData) tileData;

        if(mData.getDefaultValue() == null){
            Log.w(TAG, "Switch Settings Tile is missing \"Default Value\" attribute.");
            mData.setDefaultValue(false);
        }


    }

}
