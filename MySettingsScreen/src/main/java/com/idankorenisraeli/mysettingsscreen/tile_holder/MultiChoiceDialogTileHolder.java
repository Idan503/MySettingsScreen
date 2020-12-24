package com.idankorenisraeli.mysettingsscreen.tile_holder;

import android.content.DialogInterface;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.idankorenisraeli.mysettingsscreen.tile_data.MultiChoiceTileData;
import com.idankorenisraeli.mysettingsscreen.tile_data.SettingsTileData;

import java.util.ArrayList;
import java.util.List;

public class MultiChoiceDialogTileHolder extends TitleTileHolder {

    public MultiChoiceDialogTileHolder(View itemView) {
        super(itemView);
    }


    @Override
    public void setData(SettingsTileData tileObject) {
        super.setData(tileObject);
        MultiChoiceTileData mData = (MultiChoiceTileData) tileObject;

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    buildRadioAlertDialog(mData);

                }
            });

    }

    private void buildRadioAlertDialog(MultiChoiceTileData mData){

        CharSequence[] options = (CharSequence[]) mData.getOptions().toArray();

        boolean[] checked = new boolean[mData.getDefaultChecked().size()];

        for(int n = 0; n < checked.length; n++)
        {
            checked[n] = mData.getDefaultChecked().get(n);
        }

        MaterialAlertDialogBuilder builder = new MaterialAlertDialogBuilder(itemView.getContext())
                .setTitle(mData.getTitle())
                .setMultiChoiceItems(options, checked,null)
                .setNeutralButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
        builder.show();

    }


    @Override
    protected void validateData(SettingsTileData tileData){
        MultiChoiceTileData mData = (MultiChoiceTileData) tileData;
        if(mData.getOptions() == null){
            Log.w(TAG, "Radio Group Settings is missing \"Options\" list attribute.");
            mData.setOptions(new ArrayList<>());
        }
        if(mData.getDefaultChecked() == null) {
            Log.w(TAG, "Radio Group Settings is missing \"Default Checked\" attribute.");
            mData.setDefaultChecked(new ArrayList<>());
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
