package com.idankorenisraeli.mysettingsscreen.tile_holder;

import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import androidx.appcompat.widget.AppCompatSpinner;

import com.idankorenisraeli.mysettingsscreen.R;
import com.idankorenisraeli.mysettingsscreen.tile_data.RadioTileData;
import com.idankorenisraeli.mysettingsscreen.tile_data.SettingsTileData;

import java.util.ArrayList;

public class RadioDropdownTileHolder extends TitleTileHolder {

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
    public void setData(SettingsTileData tileObject) {
        super.setData(tileObject);
        RadioTileData mData = (RadioTileData) tileObject;

        buildDropdown(mData);
        spinner.setSelection(mData.getOptions().lastIndexOf(mData.getDefaultOption()));
        //Setting default value by position in list provided

        if (mData.getOnSelected() != null)
            spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    mData.getOnSelected().onRadioSelect(mData.getOptions().get(position));
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                spinner.performClick();
            }
        });

    }

    private void buildDropdown(RadioTileData mData) {

        ArrayAdapter<CharSequence> adapter =
                new ArrayAdapter<>(itemView.getContext(), android.R.layout.simple_spinner_dropdown_item,
                        new ArrayList<>(mData.getOptions()));
        spinner.setAdapter(adapter);

    }


    @Override
    protected void validateData(SettingsTileData tileData) {
        super.validateData(tileData);
        RadioTileData mData = (RadioTileData) tileData;
        if (mData.getOptions() == null) {
            Log.w(TAG, "Radio Group Settings is missing \"Options\" list attribute.");
            mData.setOptions(new ArrayList<>());
        }
        if (mData.getDefaultOption() == null) {
            Log.w(TAG, "Radio Group Settings is missing \"Default Option\" attribute.");
        }

    }

}
