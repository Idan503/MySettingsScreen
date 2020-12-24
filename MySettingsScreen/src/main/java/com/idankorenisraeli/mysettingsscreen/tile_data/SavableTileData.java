package com.idankorenisraeli.mysettingsscreen.tile_data;

import android.util.Log;

import com.idankorenisraeli.mysettingsscreen.common.SharedPrefsManager;

import java.lang.reflect.ParameterizedType;

/**
 * @param <T> Type of data that will be saved on device
 * @param <U> Concrete type of the tile (Used for builder)
 */
public abstract class SavableTileData<T, U> extends BasicTileData<U> {
    protected T defaultValue; // The value that will be get as default from sharedprefs save

    public SavableTileData(String title, String description) {
        super(title, description);
    }

    public T getDefaultValue(){
        return defaultValue;
    }

    public void setDefaultValue(T defaultValue){
        this.defaultValue = defaultValue;
    }

    public U withDefaultValue(T defaultValue){
        this.defaultValue = defaultValue;
        return build();
    }


    @SuppressWarnings("unchecked")
    public T getSavedValue(){
        T result = null;
        Class<T> persistentClass = (Class<T>)
                ((ParameterizedType)getClass().getGenericSuperclass())
                        .getActualTypeArguments()[0];
        String typeName =persistentClass.getSimpleName();
        String key = getSharedPrefsKey();
        switch (typeName){
            case "String":
                SharedPrefsManager.getInstance().getString(key, (String) defaultValue);
                break;
            case "Integer":
                SharedPrefsManager.getInstance().getInt(key, (Integer) defaultValue);
                break;
            case "Boolean":
                SharedPrefsManager.getInstance().getBoolean(key, (Boolean) defaultValue);
                break;
            case "Double":
                SharedPrefsManager.getInstance().getDouble(key, (Double) defaultValue);
                break;
            case "Long":
                SharedPrefsManager.getInstance().getLong(key, (Long) defaultValue);
                break;
            case "Float":
                SharedPrefsManager.getInstance().getFloat(key, (Float) defaultValue);
                break;
            default:
                Log.w("MySettingsScreen", "Could not save a setting of type " + typeName);
        }
        
        return result;
    }

    @SuppressWarnings("unchecked")
    protected void saveValue(T value){
        Class<T> persistentClass = (Class<T>)
                ((ParameterizedType)getClass().getGenericSuperclass())
                        .getActualTypeArguments()[0];
        String typeName =persistentClass.getSimpleName();
        String key = getSharedPrefsKey();
        switch (typeName){
            case "String":
                SharedPrefsManager.getInstance().putString(key, (String) value);
                break;
            case "Integer":
                SharedPrefsManager.getInstance().putInt(key, (Integer) value);
                break;
            case "Boolean":
                SharedPrefsManager.getInstance().putBoolean(key, (Boolean) value);
                break;
            case "Double":
                SharedPrefsManager.getInstance().putDouble(key, (Double) value);
                break;
            case "Long":
                SharedPrefsManager.getInstance().putLong(key, (Long) value);
                break;
            case "Float":
                SharedPrefsManager.getInstance().putFloat(key, (Float) value);
                break;
            default:
                Log.w("MySettingsScreen", "Could not save a setting of type " + typeName);
        }
    }


    /**
     * Generates a key for saving the data of the tile to shared preferences.
     * @return Key string that matches the title text of the tile
     */
    protected String getSharedPrefsKey(){
        return SharedPrefsManager.KEYS.SP_KEY_PREFIX + title.replace(' ', '_').toUpperCase();
    }

}
