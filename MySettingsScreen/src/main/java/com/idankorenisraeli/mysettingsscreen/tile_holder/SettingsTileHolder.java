package com.idankorenisraeli.mysettingsscreen.tile_holder;

import android.graphics.drawable.Drawable;
import android.service.autofill.VisibilitySetterAction;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.idankorenisraeli.mysettingsscreen.R;
import com.idankorenisraeli.mysettingsscreen.tile.SettingsTileData;

public abstract class SettingsTileHolder extends RecyclerView.ViewHolder {
    private TextView titleText;
    private TextView descriptionText;
    private ImageView iconImage;



    public SettingsTileHolder(View itemView) {
        super(itemView);
        findViews();
    }


    protected void findViews(){
        LinearLayout innerTextLayout = itemView.findViewById(R.id.tile_INC_text);
        titleText = innerTextLayout.findViewById(R.id.tile_LBL_title);
        descriptionText = innerTextLayout.findViewById(R.id.tile_LBL_description);
        iconImage = itemView.findViewById(R.id.tile_IMG_icon);
    }


    protected void setData(SettingsTileData<?> tileObject){
        this.setTitleText(tileObject.getTitle());
        this.setDescriptionText(tileObject.getDescription());
        this.setIconDrawable(tileObject.getIconId());

    }

    private void setTitleText(String title){
        this.titleText.setText(title);
    }
    private void setDescriptionText(String title){
        this.descriptionText.setText(title);
    }
    private void setIconDrawable(Integer id){
        if(id!=null) {
            Drawable icon;
            if(id==SettingsTileData.INVISIBLE_ICON_ID){
                icon = ContextCompat.getDrawable(itemView.getContext(), android.R.color.transparent);
            } else
                icon = ContextCompat.getDrawable(itemView.getContext(), id);
            iconImage.setImageDrawable(icon);
            iconImage.setVisibility(View.VISIBLE);
        }
    }

}
