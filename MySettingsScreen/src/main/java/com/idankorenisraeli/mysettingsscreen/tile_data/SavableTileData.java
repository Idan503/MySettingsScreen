package com.idankorenisraeli.mysettingsscreen.tile_data;

import com.idankorenisraeli.mysettingsscreen.common.SharedPrefsManager;

/**
 *
 * @param <T> Type of data that will be saved on device
 * @param <U> Concrete type of the tile (Used for builder)
 */
public abstract class SavableTileData<T, U> extends BasicTileData<U> {

    public T getSavedValue(){
        return null;
    }



    protected String generateSharedPrefsKey(){
        return SharedPrefsManager.KEYS.SP_KEY_PREFIX + title.replace(' ', '_').toUpperCase();
    }

}
