package com.idankorenisraeli.mysettingsscreen.tile_holder;

import android.util.Log;
import android.view.View;
import android.widget.SeekBar;

import com.idankorenisraeli.mysettingsscreen.R;
import com.idankorenisraeli.mysettingsscreen.tile_data.SeekbarTileData;
import com.idankorenisraeli.mysettingsscreen.tile_data.SettingsTileData;

public class SeekbarTileHolder extends TitleTileHolder{

    SeekBar tileSeekBar;

    // TODO - MIN VALUE, MAX VALUE, SP LINK

    public SeekbarTileHolder(View itemView) {
        super(itemView);
        findViews();


    }


    @Override
    protected void findViews() {
        super.findViews();
        tileSeekBar = itemView.findViewById(R.id.tile_SB_seekbar);
    }

    @Override
    public void setData(SettingsTileData tileObject) {
        super.setData(tileObject);
        SeekbarTileData mData = (SeekbarTileData) tileObject;
        tileSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if(mData.getOnChange()!=null)
                    mData.getOnChange().onProgressChanged(seekBar, progress,fromUser);

                //TODO - SP Management should be implemented here
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                if(mData.getOnChange()!=null)
                    mData.getOnChange().onStartTrackingTouch(seekBar);
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                if(mData.getOnChange()!=null)
                    mData.getOnChange().onStopTrackingTouch(seekBar);
            }

        });


        tileSeekBar.setMin(mData.getMinValue());
        tileSeekBar.setMax(mData.getMaxValue());
        tileSeekBar.setProgress(mData.getDefaultValue());


    }

    @Override
    protected void validateData(SettingsTileData mData) {
        super.validateData(mData);

        SeekbarTileData data = (SeekbarTileData) mData;
        if(data.getMinValue() == null){
            Log.w(TAG, "Seekbar Settings Tile is missing \"MinValue\" attribute.");
            data.setMinValue(0);
        }
        if(data.getMaxValue() == null){
            Log.w(TAG, "Seekbar Settings Tile is missing \"MaxValue\" attribute.");
            data.setMaxValue(100);
        }
        if(data.getDefaultValue() == null){
            Log.w(TAG, "Seekbar Settings Tile is missing \"DefaultValue\" attribute.");
            data.setDefaultValue(50);
        }

    }

}
