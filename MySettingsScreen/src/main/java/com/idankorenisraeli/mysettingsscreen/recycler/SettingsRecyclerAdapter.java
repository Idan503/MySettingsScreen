package com.idankorenisraeli.mysettingsscreen.recycler;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.idankorenisraeli.mysettingsscreen.R;
import com.idankorenisraeli.mysettingsscreen.enums.ToggleType;
import com.idankorenisraeli.mysettingsscreen.holder.dialog.DatePickerTileHolder;
import com.idankorenisraeli.mysettingsscreen.holder.essential.ButtonTileHolder;
import com.idankorenisraeli.mysettingsscreen.holder.view.CheckboxTileHolder;
import com.idankorenisraeli.mysettingsscreen.holder.essential.DividerTileHolder;
import com.idankorenisraeli.mysettingsscreen.holder.dialog.EditTextTileHolder;
import com.idankorenisraeli.mysettingsscreen.holder.dialog.MultiChoiceDialogTileHolder;
import com.idankorenisraeli.mysettingsscreen.holder.dialog.RadioDialogTileHolder;
import com.idankorenisraeli.mysettingsscreen.holder.view.RadioDropdownTileHolder;
import com.idankorenisraeli.mysettingsscreen.holder.view.SeekbarTileHolder;
import com.idankorenisraeli.mysettingsscreen.holder.essential.SettingsTileHolder;
import com.idankorenisraeli.mysettingsscreen.holder.view.SwitchTileHolder;
import com.idankorenisraeli.mysettingsscreen.holder.dialog.TimePickerTileHolder;
import com.idankorenisraeli.mysettingsscreen.holder.essential.TitleTileHolder;
import com.idankorenisraeli.mysettingsscreen.tile_data.view.RadioTileData;
import com.idankorenisraeli.mysettingsscreen.tile_data.essential.SettingsTileData;
import com.idankorenisraeli.mysettingsscreen.tile_data.view.ToggleTileData;

import java.util.List;

/**
 * This is the adapter that will manager the recyclerview
 * which will represent the settings screen itself.
 *
 * Each type of settings tile data gets its layout inflated here.
 */
public class SettingsRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    public static final int DIVIDER=0;
    public static final int TITLE = 1;
    public static final int CLICKABLE =2;
    public static final int TOGGLE_SWITCH=3;
    public static final int TOGGLE_CHECKBOX=4;
    public static final int SEEK_BAR = 5;
    public static final int RADIO_DROPDOWN =6;
    public static final int RADIO_DIALOG =7;
    public static final int TIME_PICKER = 8;
    public static final int MULTI_CHOICE=9;
    public static final int EDIT_TEXT=10;
    public static final int DATE_PICKER=11;


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
            case TOGGLE_SWITCH:
                view = mInflater.inflate(R.layout.switch_tile_layout, parent, false);
                return new SwitchTileHolder(view);
            case TOGGLE_CHECKBOX:
                view = mInflater.inflate(R.layout.checkbox_tile_layout, parent, false);
                return new CheckboxTileHolder(view);
            case SEEK_BAR:
                view = mInflater.inflate(R.layout.seekbar_tile_layout, parent, false);
                return new SeekbarTileHolder(view);
            case RADIO_DIALOG:
                view = mInflater.inflate(R.layout.option_selected_tile_layout, parent, false);
                return new RadioDialogTileHolder(view);
            case RADIO_DROPDOWN:
                view = mInflater.inflate(R.layout.dropdown_tile_layout, parent, false);
                return new RadioDropdownTileHolder(view);
            case TIME_PICKER:
                view = mInflater.inflate(R.layout.option_selected_tile_layout, parent, false);
                return new TimePickerTileHolder(view);
            case MULTI_CHOICE:
                view = mInflater.inflate(R.layout.clickable_tile_layout, parent, false);
                return new MultiChoiceDialogTileHolder(view);
            case EDIT_TEXT:
                view = mInflater.inflate(R.layout.option_selected_tile_layout, parent, false);
                return new EditTextTileHolder(view);
            case DIVIDER:
                view = mInflater.inflate(R.layout.divider_tile_layout, parent, false);
                return new DividerTileHolder(view);
            case DATE_PICKER:
                view = mInflater.inflate(R.layout.option_selected_tile_layout, parent, false);
                return new DatePickerTileHolder(view);
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
            case "ToggleTileData":
                ToggleTileData toggleData = (ToggleTileData) data;
                return toggleData.getToggleType() == ToggleType.CHECK_BOX ? TOGGLE_CHECKBOX : TOGGLE_SWITCH;
            case "SeekbarTileData":
                return SEEK_BAR;
            case "RadioTileData":
                //Checking weather the radio tile data is dropdown type or dialog type
                RadioTileData radioData = (RadioTileData) data;
                switch (radioData.getRadioType()){
                    case DROP_DOWN:
                        return RADIO_DROPDOWN;
                    case DIALOG:
                    case DIALOG_LABELED:
                        return RADIO_DIALOG;
                }
            case "TimePickerTileData":
                return TIME_PICKER;
            case "MultiChoiceTileData":
                return MULTI_CHOICE;
            case "EditTextTileData":
                return EDIT_TEXT;
            case "DividerTileData":
                return DIVIDER;
            case "DatePickerTileData":
                return DATE_PICKER;

            default:
                throw new IllegalStateException("Unexpected value: " + getItem(position).getClass());
        }

    }

    // convenience method for getting data at click position
    SettingsTileData getItem(int id) {
        return tilesData.get(id);
    }


}