package com.idankorenisraeli.mysettingsscreen.holder.essential;

import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.idankorenisraeli.mysettingsscreen.R;
import com.idankorenisraeli.mysettingsscreen.tile_data.essential.SettingsTileData;
import com.idankorenisraeli.mysettingsscreen.tile_data.essential.BasicTileData;

public class TitleTileHolder extends RecyclerView.ViewHolder implements SettingsTileHolder {

    private TextView titleText;
    private TextView descriptionText;
    private ImageView iconImage;

    protected static final String TAG = "SettingsTileHolder";

    private static final int NO_ICON_PADDING = 32;


    public TitleTileHolder(View itemView) {
        super(itemView);
        findViews();
    }



    protected void findViews(){
        LinearLayout innerTextLayout = itemView.findViewById(R.id.tile_INC_text);
        titleText = innerTextLayout.findViewById(R.id.tile_LBL_title);
        descriptionText = innerTextLayout.findViewById(R.id.tile_LBL_description);
        iconImage = itemView.findViewById(R.id.tile_IMG_icon);
    }

    /**
     * Checks the data of the holder, shows warnings/errors if needed
     * validate data will also set default values that will be shown on tiles, by its concrete object
     * @param tileObject the data that is set to the holder
     */
    protected void validateData(SettingsTileData tileObject){
        BasicTileData<?> mData = (BasicTileData<?>) tileObject;

        if(mData.getTitle()==null) {
            logMissedAttribute(getClass().getSimpleName(),"Title");
            mData.setTitle("");
        }
    }

    /**
     * This function applies a certain data to the tile that should hold it
     * If there is a major issue with the TileData object, it will do nothing.
     * @param tileObject data of this tile holder
     */
    public void setData(SettingsTileData tileObject){
        validateData(tileObject);
        BasicTileData<?> mData = (BasicTileData<?>) tileObject;

        this.setTitleText(mData.getTitle());
        this.setDescriptionText(mData.getDescription());
        this.setIconDrawable(mData.getIconId());

        if(mData.isSourceColorIcon()) {
            iconImage.getDrawable().setTintList(null);
        }

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
            if(id== BasicTileData.IC_INVISIBLE){
                icon = ContextCompat.getDrawable(itemView.getContext(), android.R.color.transparent);
            } else
                icon = ContextCompat.getDrawable(itemView.getContext(), id);
            iconImage.setImageDrawable(icon);
            iconImage.setVisibility(View.VISIBLE);
        }else{
            //No icon is set, adding padding to text's parent layout
            LinearLayout textParentLayout = (LinearLayout) titleText.getParent();
            overrideStartPadding(textParentLayout);
        }

    }

    private void overrideStartPadding(View view){
        int top = view.getPaddingTop();
        int end = view.getPaddingEnd();
        int bottom = view.getPaddingBottom();
        view.setPadding(NO_ICON_PADDING, top, end, bottom);
    }

    /**
     * This method will print a missing attribute warning to the console
     * @param className The type that is missing an attribute
     * @param attrName The name of the attribute that is missing
     */
    protected void logMissedAttribute(String className, String attrName){
        Log.w(TAG, className + " is missing \"" + attrName +"\" list attribute.");
    }

}
