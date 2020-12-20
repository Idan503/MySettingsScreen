package com.idankorenisraeli.mysettingsscreen.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import com.idankorenisraeli.mysettingsscreen.R;
import com.idankorenisraeli.mysettingsscreen.tile.SettingsTileData;
import com.idankorenisraeli.mysettingsscreen.tile_holder.ClickableTileHolder;

import java.util.List;

public class SettingsRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<SettingsTileData> tilesData;
    private LayoutInflater mInflater;

    // data is passed into the constructor
    public SettingsRecyclerAdapter(Context context, List<SettingsTileData> data) {
        this.mInflater = LayoutInflater.from(context);
        this.tilesData = data;
    }

    // inflates the row layout from xml when needed
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.clickable_tile_layout, parent, false);
        return new ClickableTileHolder(view);
    }

    // binds the data to the TextView in each row
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder mHolder, int position) {


        //switch case...
        ClickableTileHolder holder = (ClickableTileHolder) mHolder;
        //...

        holder.setData(getItem(position));
    }

    // total number of rows
    @Override
    public int getItemCount() {
        return tilesData.size();
    }

    // convenience method for getting data at click position
    SettingsTileData getItem(int id) {
        return tilesData.get(id);
    }


}