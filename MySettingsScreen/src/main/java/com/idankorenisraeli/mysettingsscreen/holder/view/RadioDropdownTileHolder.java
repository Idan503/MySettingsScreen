package com.idankorenisraeli.mysettingsscreen.holder.view;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import androidx.appcompat.widget.AppCompatSpinner;

import com.idankorenisraeli.mysettingsscreen.R;
import com.idankorenisraeli.mysettingsscreen.holder.essential.TitleTileHolder;
import com.idankorenisraeli.mysettingsscreen.tile_data.view.RadioTileData;
import com.idankorenisraeli.mysettingsscreen.tile_data.essential.SettingsTileData;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Holds radio settings tile that is dropdown type.
 * Providing the user with a dropdown menu that he can choose an options from
 * base on a radio data tile.
 */
public class RadioDropdownTileHolder extends TitleTileHolder {

    private AppCompatSpinner spinner;

    // This var is for preventing a callback call when screen is being initialized
    private boolean dataLoaded = false;
    private static final int DELAY_FINISH_LOAD_TIME = 100; //in ms
    //Time to enable callback calls to prevent unwanted calls when loading

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
                if (mData.getOnSelectedListener() != null && dataLoaded)
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
                //Making the dropdown menu pop when user clicking on tile itself
            }
        });

    }

    /**
     * Creating the dropdown menu component (spinner)
     * @param mData data of the tile which contains the options that will be set.
     */
    private void buildDropdown(RadioTileData mData) {

        ArrayAdapter<CharSequence> adapter =
                new ArrayAdapter<>(itemView.getContext(), R.layout.support_simple_spinner_dropdown_item,
                        new ArrayList<>(mData.getOptionsList()));

        spinner.setAdapter(adapter);

        spinner.setSelection(mData.getOptionsList().indexOf(mData.getSavedValue()));

        final Handler handler = new Handler(Looper.getMainLooper());
        handler.postDelayed(() -> dataLoaded = true, DELAY_FINISH_LOAD_TIME);

        // Setting value of the spinner to saved value

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
