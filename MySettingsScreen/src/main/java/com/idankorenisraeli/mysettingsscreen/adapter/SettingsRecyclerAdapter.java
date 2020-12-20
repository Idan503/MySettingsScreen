package com.idankorenisraeli.mysettingsscreen.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import com.idankorenisraeli.mysettingsscreen.R;
import com.idankorenisraeli.mysettingsscreen.tile.ClickableTile;
import com.idankorenisraeli.mysettingsscreen.tile.SettingsTile;
import com.idankorenisraeli.mysettingsscreen.tile_holder.ClickableTileHolder;
import com.idankorenisraeli.mysettingsscreen.tile_holder.SettingsTileHolder;

import java.util.List;

public class SettingsRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<SettingsTile> tilesData;
    private LayoutInflater mInflater;

    // data is passed into the constructor
    public SettingsRecyclerAdapter(Context context, List<SettingsTile> data) {
        this.mInflater = LayoutInflater.from(context);
        this.tilesData = data;
    }

    // inflates the row layout from xml when needed
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.settings_tile_layout, parent, false);
        return new ClickableTileHolder(view);
    }

    // binds the data to the TextView in each row
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder mHolder, int position) {
        SettingsTileHolder holder = (SettingsTileHolder) mHolder;
        ((SettingsTileHolder) holder).setTitleText(getItem(position).getTitle());
        ((SettingsTileHolder) holder).setDescriptionText(getItem(position).getDescription());
    }

    // total number of rows
    @Override
    public int getItemCount() {
        return tilesData.size();
    }

    // convenience method for getting data at click position
    SettingsTile getItem(int id) {
        return tilesData.get(id);
    }


    // parent activity will implement this method to respond to click events
    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }
}