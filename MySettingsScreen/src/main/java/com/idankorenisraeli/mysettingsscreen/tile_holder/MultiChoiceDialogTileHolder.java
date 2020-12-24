package com.idankorenisraeli.mysettingsscreen.tile_holder;

import android.content.DialogInterface;
import android.util.Log;
import android.view.View;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.idankorenisraeli.mysettingsscreen.tile_data.MultiChoiceTileData;
import com.idankorenisraeli.mysettingsscreen.tile_data.SettingsTileData;

import java.util.ArrayList;

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
                    buildMultiChoiceAlertDialog(mData);

                }
            });

    }

    private void buildMultiChoiceAlertDialog(MultiChoiceTileData mData){
        CharSequence[] options = mData.getOptionsList().toArray(new CharSequence[mData.getOptionsList().size()]);

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
        if(mData.getOptionsList() == null){
            Log.w(TAG, "Radio Group Settings is missing \"Options\" list attribute.");
            ArrayList<String> demoList =  new ArrayList<>();
            demoList.add("");
            mData.setOptions(demoList);
        }
        if(mData.getDefaultChecked() == null) {
            Log.w(TAG, "Radio Group Settings is missing \"Default Checked\" attribute.");
            ArrayList<Boolean> demoList =  new ArrayList<>();
            for (int i = 0; i < mData.getOptionsList().size(); i++) {
                demoList.add(false);
            }
            mData.setDefaultChecked(demoList);
        }
    }

}
