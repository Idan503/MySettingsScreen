package com.idankorenisraeli.mysettingsscreen.tile_holder;

import android.content.DialogInterface;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.appcompat.widget.AppCompatSpinner;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.idankorenisraeli.mysettingsscreen.R;
import com.idankorenisraeli.mysettingsscreen.tile.RadioTileData;
import com.idankorenisraeli.mysettingsscreen.tile.SettingsTileData;

import java.util.ArrayList;
import java.util.List;

public class RadioDropdownTileHolder extends SettingsTileHolder {

    private AppCompatSpinner spinner;

    public RadioDropdownTileHolder(View itemView) {
        super(itemView);
    }


    @Override
    protected void findViews() {
        super.findViews();

        spinner = itemView.findViewById(R.id.tile_SPN_spinner);

    }

    @Override
    public boolean setData(SettingsTileData<?> tileObject) {
        if (!super.setData(tileObject)) return false;
        RadioTileData mData = (RadioTileData) tileObject;

        buildDropdown(mData);
        spinner.setSelection(mData.getOptions().lastIndexOf(mData.getDefaultOption()));
        //Setting default value by position in list provided

        if (mData.getOnSelected() != null)
            spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    mData.getOnSelected().onOptionSelected(mData.getOptions().get(position));
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });


        return true;
    }

    private void buildDropdown(RadioTileData mData) {

        ArrayAdapter<CharSequence> adapter =
                new ArrayAdapter<>(itemView.getContext(), android.R.layout.simple_spinner_dropdown_item,
                        new ArrayList<>(mData.getOptions()));
        spinner.setAdapter(adapter);

    }


    @Override
    protected boolean validateData(SettingsTileData<?> mData) {
        RadioTileData tileData = (RadioTileData) mData;
        if (tileData.getOptions().size() == 0) {
            Log.w(TAG, "Radio Group Settings is missing \"Options\" list attribute.");
            return false;
        }
        if (tileData.getDefaultOption() == null) {
            tileData.setDefaultOption(tileData.getOptions().get(0));
            Log.w(TAG, "Radio Group Settings is missing \"Default Option\" attribute.");
        }

        return true;
    }

}
