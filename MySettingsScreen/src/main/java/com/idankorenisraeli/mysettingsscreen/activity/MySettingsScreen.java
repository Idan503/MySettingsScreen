package com.idankorenisraeli.mysettingsscreen.activity;

import android.content.Context;
import android.content.Intent;

import com.idankorenisraeli.mysettingsscreen.tile_data.essential.BasicTileData;
import com.idankorenisraeli.mysettingsscreen.tile_data.essential.SavableTileData;
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
 */
public class MySettingsScreen {

    //Singleton instance of this class.
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
     * that will include all the given tiles from application creation in the list.
     * That were set before using setTilesData method of this class.
     *
     *
     * NOTE: The initialized settings screen will not have an app bar.
     * For a settings screen that includes an app bar, please use:
     * initSettingsScreen(Context, ArrayList<SettingsTileData>, String)
     *
     *
     * @param context Current context of activity that calls to the settings
     */
    public void initSettingsScreen(Context context){
        Intent intent = new Intent(context, MySettingsActivity.class);
        context.startActivity(intent);
    }

    /**
     * This method will create the settings activity
     * based on the current data tiles that were given
     * on application creation. (via Application onCreate method)
     *
     * @param context Current context of activity that calls to settings
     * @param appBarTitle Title of the app bar
     */
    public void initSettingsScreen(Context context, String appBarTitle){
        Intent intent = new Intent(context, MySettingsActivity.class);
        intent.putExtra(MySettingsActivity.APPBAR_TITLE, appBarTitle);
        context.startActivity(intent);
    }

    /**
     * Getting all tiles data that were sent to the settings activity
     * @return Settings Tiles Data List
     */
    public ArrayList<SettingsTileData> getTilesData() {
        return tilesData;
    }


    /**
     * Setting the tiles of the settings screen of your applcation.
     *
     * This method should be called on Application onCreate method,
     * with all tiles that the settings screen of your app will include.
     *
     * @param tilesData Data of all tiles that will be shown in the settings screen
     */
    public void setTilesData(ArrayList<SettingsTileData> tilesData) {
        this.tilesData = tilesData;
    }


    /**
     * This method will provide you with a TileData based on a title name.
     * This way we can get the saved value of a stateful tile.
     * @param title Title of the tile data
     * @return The TileData of the tile with the provided title, null when not found
     */
    @SuppressWarnings("rawtypes")
    public SettingsTileData getTileByTitle(String title){
        for(SettingsTileData tileData : tilesData){
            if(tileData instanceof BasicTileData)
                if(((BasicTileData) tileData).getTitle().equals(title))
                    return tileData;
        }
        return null;
    }
}
