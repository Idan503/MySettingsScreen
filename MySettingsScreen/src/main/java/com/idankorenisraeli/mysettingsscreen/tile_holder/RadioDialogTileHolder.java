package com.idankorenisraeli.mysettingsscreen.tile_holder;

import android.content.DialogInterface;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.appcompat.app.AlertDialog;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.idankorenisraeli.mysettingsscreen.tile.RadioTileData;
import com.idankorenisraeli.mysettingsscreen.tile.SettingsTileData;

import java.util.List;

public class RadioDialogTileHolder extends SettingsTileHolder {

    public RadioDialogTileHolder(View itemView) {
        super(itemView);
    }


    @Override
    public boolean setData(SettingsTileData<?> tileObject) {
        if(!super.setData(tileObject)) return false;
        RadioTileData mData = (RadioTileData) tileObject;

        if (mData.getOnSelected() != null)
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    buildRadioAlertDialog(mData);

                }
            });

        return true;
    }

    private void buildRadioAlertDialog(RadioTileData mData){
        if(!validateData(mData)) return;
        RadioGroup radioGroup = createRadioGroup(mData.getOptions(), mData.getDefaultOption());

        MaterialAlertDialogBuilder builder = new MaterialAlertDialogBuilder(itemView.getContext())
                .setTitle(mData.getTitle())
                .setView(radioGroup)
                .setNeutralButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        int selectedId = radioGroup.getCheckedRadioButtonId();
                        // find the radiobutton by returned id to get its string value
                        RadioButton radioButton = radioGroup.findViewById(selectedId);
                        mData.getOnSelected().onOptionSelected(radioButton.getText().toString());
                    }
                });
        builder.show();

    }


    private boolean validateData(RadioTileData mData) {
        if(mData.getOptions().size() == 0){
            Log.w(TAG, "Radio Group Settings is missing \"Options\" list attribute.");
            return false;
        }
        if(mData.getDefaultOption() == null) {
            mData.setDefaultOption(mData.getOptions().get(0));
            Log.w(TAG, "Radio Group Settings is missing \"Default Option\" attribute.");
        }

        return true;
    }

    private RadioGroup createRadioGroup(List<String> options, String defaultOption) {
        final RadioButton[] innerButtons = new RadioButton[options.size()];
        RadioGroup radioGroup = new RadioGroup(itemView.getContext()); //create the RadioGroup
        radioGroup.setOrientation(RadioGroup.VERTICAL);

        int defaultSelectedId = 0;
        for(int i=0; i<options.size(); i++){
            innerButtons[i]  = new RadioButton(itemView.getContext());
            radioGroup.addView(innerButtons[i]); //the RadioButtons are added to the radioGroup
            innerButtons[i].setText(options.get(i));
            innerButtons[i].setTextSize(18);
            if(options.get(i).equals(defaultOption))
                defaultSelectedId = innerButtons[i].getId();
            innerButtons[i].setPadding(25,15,10,15);
        }


        radioGroup.setPadding(30, 25 , 25, 40);
        radioGroup.check(defaultSelectedId);

        return radioGroup;
    }

}
