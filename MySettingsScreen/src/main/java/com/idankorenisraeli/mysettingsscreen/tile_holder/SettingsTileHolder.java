package com.idankorenisraeli.mysettingsscreen.tile_holder;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.idankorenisraeli.mysettingsscreen.R;
import com.idankorenisraeli.mysettingsscreen.tile.SettingsTileData;

public abstract class SettingsTileHolder extends RecyclerView.ViewHolder {
    private TextView titleText;
    private TextView descriptionText;


    public SettingsTileHolder(View itemView) {
        super(itemView);
        titleText = itemView.findViewById(R.id.tile_LBL_title);
        descriptionText = itemView.findViewById(R.id.tile_LBL_description);
    }


    public void setData(SettingsTileData tileObject){
        this.setTitleText(tileObject.getTitle());
        this.setDescriptionText(tileObject.getDescription());
    }

    private void setTitleText(String title){
        this.titleText.setText(title);
    }
    private void setDescriptionText(String title){
        this.descriptionText.setText(title);
    }


}
