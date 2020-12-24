package com.idankorenisraeli.mysettingsscreen.tile_holder;

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

public class RadioDialogTileHolder extends TitleTileHolder {

    public RadioDialogTileHolder(View itemView) {
        super(itemView);
    }


    @Override
    public void setData(SettingsTileData tileObject) {
        super.setData(tileObject);
        RadioTileData mData = (RadioTileData) tileObject;

        if (mData.getOnSelected() != null)
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    buildRadioAlertDialog(mData);

                }
            });

    }

    private void buildRadioAlertDialog(RadioTileData mData){
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
                        if(mData.getOnSelected()!=null)
                            mData.getOnSelected().onRadioSelect(radioButton.getText().toString());
                    }
                });
        builder.show();

    }


    @Override
    protected void validateData(SettingsTileData tileData){
        RadioTileData mData = (RadioTileData) tileData;
        if(mData.getOptions() == null){
            Log.w(TAG, "Radio Group Settings is missing \"Options\" list attribute.");
            ArrayList<String> demoList =  new ArrayList<>();
            demoList.add("");
            mData.setOptions(demoList);
        }
        if(mData.getDefaultOption() == null) {
            Log.w(TAG, "Radio Group Settings is missing \"Default Option\" attribute.");
            mData.setDefaultOption(mData.getOptions().get(0));
        }
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
