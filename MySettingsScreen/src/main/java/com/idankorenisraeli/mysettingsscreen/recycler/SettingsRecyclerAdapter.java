package com.idankorenisraeli.mysettingsscreen.recycler;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.idankorenisraeli.mysettingsscreen.R;
import com.idankorenisraeli.mysettingsscreen.tile_data.EditTextTileData;
import com.idankorenisraeli.mysettingsscreen.tile_data.RadioTileData;
import com.idankorenisraeli.mysettingsscreen.tile_data.RadioType;
import com.idankorenisraeli.mysettingsscreen.tile_data.SettingsTileData;

import java.util.List;

/**
 * This is the adapter that will manager the recyclerview
 * which will represent the settings screen itself.
 *
 * Each type of settings tile data gets its layout inflated here.
 */
public class SettingsRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    public static final int TITLE =0;
    public static final int CLICKABLE =1;
    public static final int SWITCH=2;
    public static final int SEEK_BAR =3;
    public static final int RADIO_DROPDOWN =4;
    public static final int RADIO_DIALOG =5;
    public static final int MULTI_CHOICE=6;
    public static final int EDIT_TEXT=7;
    public static final int DIVIDER=8;

    final private List<SettingsTileData> tilesData;
    final private LayoutInflater mInflater;

    // data is passed into the constructor
    public SettingsRecyclerAdapter(Context context, List<SettingsTileData> data) {
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
                return new ButtonTileHolder(view);
            case SWITCH:
                view = mInflater.inflate(R.layout.switch_tile_layout, parent, false);
                return new SwitchTileHolder(view);
            case SEEK_BAR:
                view = mInflater.inflate(R.layout.seekbar_tile_layout, parent, false);
                return new SeekbarTileHolder(view);
            case RADIO_DIALOG:
                view = mInflater.inflate(R.layout.option_selected_tile_layout, parent, false);
                return new RadioDialogTileHolder(view);
            case RADIO_DROPDOWN:
                view = mInflater.inflate(R.layout.dropdown_tile_layout, parent, false);
                return new RadioDropdownTileHolder(view);
            case MULTI_CHOICE:
                view = mInflater.inflate(R.layout.clickable_tile_layout, parent, false);
                return new MultiChoiceDialogTileHolder(view);
            case EDIT_TEXT:
                view = mInflater.inflate(R.layout.option_selected_tile_layout, parent, false);
                return new EditTextTileHolder(view);
            case DIVIDER:
                view = mInflater.inflate(R.layout.divider_tile_layout, parent, false);
                return new DividerTileHolder(view);
            default:
                view = mInflater.inflate(R.layout.title_tile_layout, parent, false);
                return new TitleTileHolder(view);
        }
    }

    // binds the data to the TextView in each row
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        SettingsTileData item = getItem(position);

        ((SettingsTileHolder)holder).setData(item);

    }

    // total number of rows
    @Override
    public int getItemCount() {
        return tilesData.size();
    }

    @Override
    public int getItemViewType(int position) {
        SettingsTileData data = getItem(position);
        switch (getItem(position).getClass().getSimpleName()){
            case "ButtonTileData":
                return CLICKABLE;
            case "TitleTileData":
                return TITLE;
            case "SwitchTileData":
                return SWITCH;
            case "SeekbarTileData":
                return SEEK_BAR;
            case "RadioTileData":
                //Checking weather the radio tile data is dropdown type or dialog type
                RadioTileData radioData = (RadioTileData) data;
                return radioData.getRadioType() == RadioType.DROP_DOWN ? RADIO_DROPDOWN : RADIO_DIALOG;
            case "MultiChoiceTileData":
                return MULTI_CHOICE;
            case "EditTextTileData":
                return EDIT_TEXT;
            case "DividerTileData":
                return DIVIDER;

            default:
                throw new IllegalStateException("Unexpected value: " + getItem(position).getClass());
        }

    }

    // convenience method for getting data at click position
    SettingsTileData getItem(int id) {
        return tilesData.get(id);
    }


}