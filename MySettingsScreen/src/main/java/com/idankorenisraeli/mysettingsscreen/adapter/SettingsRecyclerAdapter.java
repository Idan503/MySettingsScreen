package com.idankorenisraeli.mysettingsscreen.adapter;

import android.content.Context;
import android.os.Debug;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.idankorenisraeli.mysettingsscreen.R;
import com.idankorenisraeli.mysettingsscreen.tile.SettingsTileData;
import com.idankorenisraeli.mysettingsscreen.tile.SwitchTileData;
import com.idankorenisraeli.mysettingsscreen.tile_holder.ClickableTileHolder;
import com.idankorenisraeli.mysettingsscreen.tile_holder.SeekbarTileHolder;
import com.idankorenisraeli.mysettingsscreen.tile_holder.SettingsTileHolder;
import com.idankorenisraeli.mysettingsscreen.tile_holder.SwitchTileHolder;
import com.idankorenisraeli.mysettingsscreen.tile_holder.TitleTileHolder;

import java.util.List;

public class SettingsRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    public static final int TITLE =0;
    public static final int CLICKABLE =1;
    public static final int SWITCH=2;
    public static final int SEEKBAR=3;
    public static final int DROPDOWN=4;
    public static final int RADIO_CHOICE=5;
    public static final int MULTI_CHOICE=6;
    public static final int GROUP=7;

    private List<SettingsTileData<?>> tilesData;
    private LayoutInflater mInflater;

    // data is passed into the constructor
    public SettingsRecyclerAdapter(Context context, List<SettingsTileData<?>> data) {
        this.mInflater = LayoutInflater.from(context);
        this.tilesData = data;
    }

    // inflates the row layout from xml when needed
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;

        switch (viewType){
            case TITLE:
                view = mInflater.inflate(R.layout.title_tile_layout, parent, false);
                return new TitleTileHolder(view);
            case CLICKABLE:
                view = mInflater.inflate(R.layout.clickable_tile_layout, parent, false);
                return new ClickableTileHolder(view);
            case SWITCH:
                view = mInflater.inflate(R.layout.switch_tile_layout, parent, false);
                return new SwitchTileHolder(view);
            case SEEKBAR:
                view = mInflater.inflate(R.layout.seekbar_tile_layout, parent, false);
                return new SeekbarTileHolder(view);
            default:
                view = mInflater.inflate(R.layout.title_tile_layout, parent, false);
                return new TitleTileHolder(view);
        }
    }

    // binds the data to the TextView in each row
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        SettingsTileData item = getItem(position);

        switch (getItemViewType(position)){
            case TITLE:
                ((TitleTileHolder) holder).setData(item);
                break;
            case CLICKABLE:
                ((ClickableTileHolder) holder).setData(item);
                break;
            case SWITCH:
                ((SwitchTileHolder) holder).setData(item);
                break;
            case SEEKBAR:
                ((SeekbarTileHolder)holder).setData(item);
        }



    }

    // total number of rows
    @Override
    public int getItemCount() {
        return tilesData.size();
    }

    @Override
    public int getItemViewType(int position) {
        switch (getItem(position).getClass().getSimpleName()){
            case "ClickableTileData":
                return CLICKABLE;
            case "TitleTileData":
                return TITLE;
            case "SwitchTileData":
                return SWITCH;
            case "SeekbarTileData":
                return SEEKBAR;

            default:
                throw new IllegalStateException("Unexpected value: " + getItem(position).getClass());
        }

    }

    // convenience method for getting data at click position
    SettingsTileData getItem(int id) {
        return tilesData.get(id);
    }


}