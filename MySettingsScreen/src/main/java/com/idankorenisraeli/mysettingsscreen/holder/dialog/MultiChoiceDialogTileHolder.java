package com.idankorenisraeli.mysettingsscreen.holder.dialog;

import android.content.DialogInterface;
import android.util.Log;
import android.view.View;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.idankorenisraeli.mysettingsscreen.holder.essential.TitleTileHolder;
import com.idankorenisraeli.mysettingsscreen.tile_data.dialog.MultiChoiceTileData;
import com.idankorenisraeli.mysettingsscreen.tile_data.essential.SettingsTileData;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Holds a multi choice settings tiles
 * And shows a dialog when user presses on it.
 */
public class MultiChoiceDialogTileHolder extends TitleTileHolder {

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


    /**
     * Creating the multi choice dialog window based on the options from the tile data object given.
     * User will be able to pick 0 or more options from this list by this dialog.
     * @param mData Data of the settings tile, to provide list of options and current state.
     */
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

                        if(mData.getOnChangedListener()!=null){
                            mData.getOnChangedListener().onMultiSelect(mData.getOptionsList(), currentChecked);
                        }
                    }
                });
        builder.show();

    }


    @Override
    protected void validateData(SettingsTileData tileData){
        MultiChoiceTileData mData = (MultiChoiceTileData) tileData;
        if(mData.getOptionsList() == null){
            logMissedAttribute(getClass().getSimpleName(),"Options");
            mData.withOptionsList(new ArrayList<>(Arrays.asList("Option 1", "Option2")));
        }
        if(mData.getDefaultValue() == null) {
            logMissedAttribute(getClass().getSimpleName(),"Default Value");
            ArrayList<Boolean> demoList =  new ArrayList<>();
            for (int i = 0; i < mData.getOptionsList().size(); i++) {
                demoList.add(false);
            }
            mData.setDefaultValue(demoList);
        }
    }

}
