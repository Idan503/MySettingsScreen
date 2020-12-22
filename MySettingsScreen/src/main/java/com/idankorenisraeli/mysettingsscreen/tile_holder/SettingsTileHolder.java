package com.idankorenisraeli.mysettingsscreen.tile_holder;

import android.graphics.drawable.Drawable;
import android.service.autofill.VisibilitySetterAction;
import android.util.Log;
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

    protected static final String TAG = "SettingsTileHolder";



    public SettingsTileHolder(View itemView) {
        super(itemView);
        findViews();
    }

    /**
     * Checks the data of the holder, shows warnings/errors in needed
     * @param mData the data that is set to the holder
     * @return False if there was an error
     */
    protected boolean validateData(SettingsTileData<?> mData){
        return mData!=null;
    }

    protected void findViews(){
        LinearLayout innerTextLayout = itemView.findViewById(R.id.tile_INC_text);
        titleText = innerTextLayout.findViewById(R.id.tile_LBL_title);
        descriptionText = innerTextLayout.findViewById(R.id.tile_LBL_description);
        iconImage = itemView.findViewById(R.id.tile_IMG_icon);
    }


    /**
     *
     * @param tileObject data of this tile holder
     * @return True when data was set successfully
     */
    public boolean setData(SettingsTileData<?> tileObject){
        if(!validateData(tileObject)) {
            return false; // cannot perform data set
        }

        this.setTitleText(tileObject.getTitle());
        this.setDescriptionText(tileObject.getDescription());
        this.setIconDrawable(tileObject.getIconId());

        return true;
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
