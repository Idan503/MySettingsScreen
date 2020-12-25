package com.idankorenisraeli.mysettingsscreen.recycler;

import android.content.DialogInterface;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.idankorenisraeli.mysettingsscreen.tile_data.RadioTileData;
import com.idankorenisraeli.mysettingsscreen.tile_data.SettingsTileData;

import java.util.ArrayList;
import java.util.List;

class RadioDialogTileHolder extends TitleTileHolder {

    public RadioDialogTileHolder(View itemView) {
        super(itemView);
    }


    @Override
    public void setData(SettingsTileData tileObject) {
        super.setData(tileObject);
        RadioTileData mData = (RadioTileData) tileObject;

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buildRadioAlertDialog(mData);
            }
        });

    }

    private void buildRadioAlertDialog(RadioTileData mData){
        RadioGroup radioGroup = createRadioGroup(mData.getOptionsList(), mData.getSavedValue());

        MaterialAlertDialogBuilder builder = new MaterialAlertDialogBuilder(itemView.getContext())
                .setTitle(mData.getTitle())
                .setView(radioGroup)
                .setNeutralButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        int selectedId = radioGroup.getCheckedRadioButtonId();
                        // find the radiobutton by returned id to get its string value
                        RadioButton radioButton = radioGroup.findViewById(selectedId);
                        mData.saveValue(radioButton.getText().toString());
                        if(mData.getOnSelectedListener()!=null) {
                            mData.getOnSelectedListener().onRadioSelect(radioButton.getText().toString());

                        }
                    }
                });
        builder.show();

    }


    @Override
    protected void validateData(SettingsTileData tileData){
        RadioTileData mData = (RadioTileData) tileData;
        if(mData.getOptionsList() == null){
            Log.w(TAG, "Radio Group Settings is missing \"Options\" list attribute.");
            ArrayList<String> demoList =  new ArrayList<>();
            demoList.add("");
            mData.withOptionsList(demoList);
        }
        if(mData.getDefaultValue() == null) {
            Log.w(TAG, "Radio Group Settings is missing \"Default Option\" attribute.");
            mData.setDefaultValue(mData.getOptionsList().get(0));
        }
    }

    private RadioGroup createRadioGroup(List<String> options, String selectedOption) {
        final RadioButton[] innerButtons = new RadioButton[options.size()];
        RadioGroup radioGroup = new RadioGroup(itemView.getContext()); //create the RadioGroup
        radioGroup.setOrientation(RadioGroup.VERTICAL);

        int defaultSelectedId = 0;
        // Iterating the list of options to find selected by its value, while creating the buttons
        for(int i=0; i<options.size(); i++){
            innerButtons[i]  = new RadioButton(itemView.getContext());
            radioGroup.addView(innerButtons[i]); //the RadioButtons are added to the radioGroup
            innerButtons[i].setText(options.get(i));
            innerButtons[i].setTextSize(18);
            if(options.get(i).equals(selectedOption))
                defaultSelectedId = innerButtons[i].getId();
            innerButtons[i].setPadding(25,15,10,15);
        }


        radioGroup.setPadding(30, 25 , 25, 40);
        radioGroup.check(defaultSelectedId);

        return radioGroup;
    }

}
