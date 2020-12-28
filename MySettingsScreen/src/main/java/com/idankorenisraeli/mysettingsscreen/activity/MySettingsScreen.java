package com.idankorenisraeli.mysettingsscreen.activity;

import android.content.Context;
import android.content.Intent;

import com.idankorenisraeli.mysettingsscreen.tile_data.essential.SettingsTileData;

import java.util.ArrayList;

/**
 * By using the single instance from this class
 * you will be able to instantiate your app's settings screen.
 *
 * Here is an example of a simple code that will provide you
 * with a settings screen which has a single title tile:
 *
 *
 * ArrayList<SettingsTileData> dataTiles = new ArrayList<>();
 * TitleTileData titleTile = new TitleTileData("Title Example", "This tile is a simple title");
 * dataTiles.add(titleTile);
 *
 * MySettingsScreen.getInstance().initSettingsScreen(MainActivity.this, dataTiles);
 *
 * //This will initiate your settings screen with the provided that tiles
 * //which in this case is a single title data tile.
 *
 *
 *
 */
public class MySettingsScreen {


    private static MySettingsScreen single_instance = null;
    private ArrayList<SettingsTileData> tilesData;

    private MySettingsScreen(ArrayList<SettingsTileData> tilesDataList) {
        tilesData = tilesDataList;
    }

    private MySettingsScreen() {
    }

    public static MySettingsScreen getInstance(){
        if(single_instance==null)
            single_instance = new MySettingsScreen();
        return single_instance;
    }

    /**
     * This method will initiate a new settings screen
     * that will include all the given tiles in the list.
     *
     * NOTE: The initialized settings screen will not have an app bar.
     * For a settings screen that includes an app bar, please use:
     * initSettingsScreen(Context, ArrayList<SettingsTileData>, String)
     *
     * @param context Current context of activity that calls to the settings
     * @param tilesList List of all the SettingsTileData that your screen will be built upon.
     *                  This includes any option you would like to see in your app's settings page.
     */
    public void initSettingsScreen(Context context, ArrayList<SettingsTileData> tilesList){
        Intent intent = new Intent(context, MySettingsActivity.class);
        tilesData = tilesList;
        context.startActivity(intent);
    }

    public void initSettingsScreen(Context context, ArrayList<SettingsTileData> tilesList, String appBarTitle){
        Intent intent = new Intent(context, MySettingsActivity.class);
        intent.putExtra(MySettingsActivity.APPBAR_TITLE, appBarTitle);
        tilesData = tilesList;
        context.startActivity(intent);
    }

    public ArrayList<SettingsTileData> getTilesData() {
        return tilesData;
    }

    public void setTilesData(ArrayList<SettingsTileData> tilesData) {
        this.tilesData = tilesData;
    }
}
