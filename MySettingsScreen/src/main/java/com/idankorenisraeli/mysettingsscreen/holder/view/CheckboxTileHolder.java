package com.idankorenisraeli.mysettingsscreen.holder.view;

import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import com.idankorenisraeli.mysettingsscreen.R;
import com.idankorenisraeli.mysettingsscreen.holder.essential.TitleTileHolder;
import com.idankorenisraeli.mysettingsscreen.tile_data.essential.SettingsTileData;
import com.idankorenisraeli.mysettingsscreen.tile_data.view.ToggleTileData;

/**
 * Holds a Toggle Setting tile which is on type of Checkbox.
 * Provide the user with the checkbox component to toggle on/off
 */
public class CheckboxTileHolder extends TitleTileHolder {


    private CheckBox checkBox;

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
            logMissedAttribute(getClass().getSimpleName(),"Default Value");
            mData.setDefaultValue(false);
        }


    }

    public CheckBox getCheckBox() {
        return checkBox;
    }

    public void setCheckBox(CheckBox checkBox) {
        this.checkBox = checkBox;
    }
}
