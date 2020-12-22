package com.idankorenisraeli.mysettingsscreen.tile_holder;

import android.content.DialogInterface;
import android.util.Log;
import android.view.View;
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
    protected void findViews(){
        super.findViews();

        spinner = itemView.findViewById(R.id.tile_SPN_spinner);

    }

    @Override
    public boolean setData(SettingsTileData<?> tileObject) {
        if(!super.setData(tileObject)) return false;
        RadioTileData mData = (RadioTileData) tileObject;

        buildDropdown(mData);


        return true;
    }

    private void buildDropdown(RadioTileData mData){

        ArrayAdapter<CharSequence> adapter =
                new ArrayAdapter<>(itemView.getContext(), android.R.layout.simple_spinner_dropdown_item,
                new ArrayList<>(mData.getOptions()));
        spinner.setAdapter(adapter);

        Log.i("pttt", "Builded" + mData.getOptions().toString());


    }


    @Override
    protected boolean validateData(SettingsTileData<?>  mData) {
        RadioTileData tileData = (RadioTileData) mData;
        if(tileData.getOptions().size() == 0){
            Log.w(TAG, "Radio Group Settings is missing \"Options\" list attribute.");
            return false;
        }
        if(tileData.getDefaultOption() == null) {
            tileData.setDefaultOption(tileData.getOptions().get(0));
            Log.w(TAG, "Radio Group Settings is missing \"Default Option\" attribute.");
        }

        return true;
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
