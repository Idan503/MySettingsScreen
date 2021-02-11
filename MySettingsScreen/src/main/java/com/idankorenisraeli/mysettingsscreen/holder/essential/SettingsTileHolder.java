package com.idankorenisraeli.mysettingsscreen.holder.essential;

import com.idankorenisraeli.mysettingsscreen.tile_data.essential.SettingsTileData;

/**
 * All the settings tiles holders data will be set by
 * an object of a SettingsTileData (Using polymorphism)
 */
public interface SettingsTileHolder {
    void setData(SettingsTileData tileData);
}
