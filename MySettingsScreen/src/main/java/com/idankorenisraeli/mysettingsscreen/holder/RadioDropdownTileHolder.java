package com.idankorenisraeli.mysettingsscreen.holder;

import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import androidx.appcompat.widget.AppCompatSpinner;

import com.idankorenisraeli.mysettingsscreen.R;
import com.idankorenisraeli.mysettingsscreen.tile_data.RadioTileData;
import com.idankorenisraeli.mysettingsscreen.tile_data.SettingsTileData;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

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


        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (mData.getOnSelectedListener() != null)
                    mData.getOnSelectedListener().onOptionSelected(mData.getOptionsList().get(position));

                mData.saveValue(mData.getOptionsList().get(position));
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
                new ArrayAdapter<>(itemView.getContext(), R.layout.support_simple_spinner_dropdown_item,
                        new ArrayList<>(mData.getOptionsList()));

        spinner.setAdapter(adapter);
        spinner.setSelection(mData.getOptionsList().indexOf(mData.getSavedValue()));
        // Setting value of the spinner

    }


    @Override
    protected void validateData(SettingsTileData tileData) {
        super.validateData(tileData);
        RadioTileData mData = (RadioTileData) tileData;
        if (mData.getOptionsList() == null) {
            logMissedAttribute(getClass().getSimpleName(),"Options");
            mData.withOptionsList(new ArrayList<>(Arrays.asList("Option 1", "Option 2")));
        }
        if (mData.getDefaultValue() == null) {
            logMissedAttribute(getClass().getSimpleName(),"Default Option");
            mData.setDefaultValue(mData.getOptionsList().get(0));
        }

    }

}
