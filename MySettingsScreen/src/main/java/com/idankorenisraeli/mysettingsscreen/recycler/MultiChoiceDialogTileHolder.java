package com.idankorenisraeli.mysettingsscreen.recycler;

import android.content.DialogInterface;
import android.util.Log;
import android.view.View;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.idankorenisraeli.mysettingsscreen.tile_data.MultiChoiceTileData;
import com.idankorenisraeli.mysettingsscreen.tile_data.SettingsTileData;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

class MultiChoiceDialogTileHolder extends TitleTileHolder {

    public MultiChoiceDialogTileHolder(View itemView) {
        super(itemView);
    }


    @Override
    public void setData(SettingsTileData tileObject) {
        super.setData(tileObject);
        Log.i("pttt", " Setting Multi dialog data");
        MultiChoiceTileData mData = (MultiChoiceTileData) tileObject;

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.i("pttt", "Clicked ItemView Dialog should open");
                    buildMultiChoiceAlertDialog(mData);

                }
            });

    }



    private void buildMultiChoiceAlertDialog(MultiChoiceTileData mData){
        CharSequence[] options = mData.getOptionsList().toArray(new CharSequence[mData.getOptionsList().size()]);

        ArrayList<Boolean> savedValue = mData.getSavedValue();
        boolean[] checked = new boolean[savedValue.size()];

        for(int n = 0; n < checked.length; n++)
        {
            checked[n] = savedValue.get(n);
        }

        MaterialAlertDialogBuilder builder = new MaterialAlertDialogBuilder(itemView.getContext())
                .setTitle(mData.getTitle())
                .setMultiChoiceItems(options, checked, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                        checked[which] = isChecked;
                    }
                })
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        ArrayList<Boolean> currentChecked = new ArrayList<>();
                        for (boolean b : checked) {
                            currentChecked.add(b);
                        }
                        mData.saveValue(currentChecked);
                    }
                });
        builder.show();

    }


    @Override
    protected void validateData(SettingsTileData tileData){
        MultiChoiceTileData mData = (MultiChoiceTileData) tileData;
        if(mData.getOptionsList() == null){
            Log.w(TAG, "Radio Group Settings is missing \"Options\" list attribute.");
            ArrayList<String> demoList =  new ArrayList<>();
            demoList.add("");
            mData.setOptionsList(demoList);
        }
        if(mData.getDefaultValue() == null) {
            Log.w(TAG, "Radio Group Settings is missing \"Default Value\" attribute.");
            ArrayList<Boolean> demoList =  new ArrayList<>();
            for (int i = 0; i < mData.getOptionsList().size(); i++) {
                demoList.add(false);
            }
            mData.setDefaultValue(demoList);
        }
    }

}
