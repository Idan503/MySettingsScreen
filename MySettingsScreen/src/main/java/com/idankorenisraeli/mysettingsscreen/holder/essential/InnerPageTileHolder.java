package com.idankorenisraeli.mysettingsscreen.holder.essential;

import android.util.Log;
import android.view.View;

import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.idankorenisraeli.mysettingsscreen.R;
import com.idankorenisraeli.mysettingsscreen.fragment.InnerPageFragment;
import com.idankorenisraeli.mysettingsscreen.tile_data.essential.ButtonTileData;
import com.idankorenisraeli.mysettingsscreen.tile_data.essential.InnerPageTileData;
import com.idankorenisraeli.mysettingsscreen.tile_data.essential.SettingsTileData;

import java.util.ArrayList;
import java.util.Iterator;

public class InnerPageTileHolder extends TitleTileHolder{

    public InnerPageTileHolder(View itemView) {
        super(itemView);
    }


    @Override
    public void setData(SettingsTileData tileObject) {
        super.setData(tileObject);

        InnerPageTileData mData = (InnerPageTileData) tileObject;


        View.OnClickListener tileClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Open Fragment
                InnerPageFragment fragment = new InnerPageFragment(mData);


                FragmentManager manager = ((FragmentActivity) itemView.getContext()).getSupportFragmentManager();
                FragmentTransaction transaction = manager.beginTransaction();

                transaction.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_left, R.anim.enter_from_left, R.anim.exit_to_right);
                transaction.replace(R.id.settings_FRAG_inner_page, fragment);
                transaction.addToBackStack(null);
                transaction.commit();


            }
        };

            this.itemView.setClickable(true);
            this.itemView.setOnClickListener(tileClickListener);
        }

    @Override
    protected void validateData(SettingsTileData tileObject) {
        super.validateData(tileObject);

        InnerPageTileData mData = (InnerPageTileData) tileObject;

        if(mData.getInnerTilesData().size() == 0){
            logMissedAttribute(getClass().getSimpleName(),"Inner Tiles Data is Empty");
        }

        Iterator<SettingsTileData> itr = mData.getInnerTilesData().iterator();
        while(itr.hasNext()){
            SettingsTileData tileData = itr.next();

            if(tileData instanceof InnerPageTileData) {
                logNotAllowed(getClass().getSimpleName(), "Inner page inside inner page");
                itr.remove();
            }
        }
        for(SettingsTileData tile : mData.getInnerTilesData()){
            if(tile instanceof InnerPageTileData) {
                logNotAllowed(getClass().getSimpleName(), "Inner page data tile inside inner page");

            }
        }

    }
}
