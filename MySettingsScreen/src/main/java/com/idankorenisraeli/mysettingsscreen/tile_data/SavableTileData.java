package com.idankorenisraeli.mysettingsscreen.tile_data;

import android.util.Log;

import com.google.gson.reflect.TypeToken;
import com.idankorenisraeli.mysettingsscreen.common.SharedPrefsManager;

import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;

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

    /**
     * Updating the default value of this tile.
     * @param defaultValue the new default value of this tile
     */
    public void setDefaultValue(T defaultValue){
        this.defaultValue = defaultValue;
    }

    /**
     * Setting a default value, that will be retrieved for the first time getting from sp
     * NOTE: This function does not save any value into the device's sharedprefs
     * @param defaultValue value for the first time
     * @return updated object with the new default value applied
     */
    public U withDefaultValue(T defaultValue){
        this.defaultValue = defaultValue;
        return build();
    }


    /**
     * Getting the data of this settings tile from shared prefs
     * @return Latest value that user assign to this tile
     */
    @SuppressWarnings("unchecked")
    public T getSavedValue(){
        T result = null;
        String key = getSharedPrefsKey();
        switch (getSaveTypeName()){
            case "String":
                result = (T) SharedPrefsManager.getInstance().getString(key, (String) defaultValue);
                break;
            case "Integer":
                result = (T) (Object) SharedPrefsManager.getInstance().getInt(key, (Integer) defaultValue);
                break;
            case "Boolean":
                result = (T) (Object) SharedPrefsManager.getInstance().getBoolean(key, (Boolean) defaultValue);
                break;
            case "Double":
                result = (T) (Object) SharedPrefsManager.getInstance().getDouble(key, (Double) defaultValue);
                break;
            case "Long":
                result = (T) (Object) SharedPrefsManager.getInstance().getLong(key, (Long) defaultValue);
                break;
            case "Float":
                result = (T) (Object) SharedPrefsManager.getInstance().getFloat(key, (Float) defaultValue);
                break;
            case "ArrayList<Boolean>":
                result = (T) SharedPrefsManager.getInstance().getArray(key,new TypeToken<ArrayList<Boolean>>(){},(ArrayList<Boolean>)defaultValue);
                break;
            case "ArrayList<Integer>":
                result = (T) SharedPrefsManager.getInstance().getArray(key,new TypeToken<ArrayList<Integer>>(){},(ArrayList<Integer>)defaultValue);
                break;
            default:
                Log.w("MySettingsScreen", "Could not save settings of type " + getSaveTypeName());
        }
        Log.i("pttt", "SavableTileData" + " Getting " + result);
        return result;
    }


    /**
     * Saving the data of the settings tile to shared prefs
     * @param value the value that will be saved
     */
    @SuppressWarnings("unchecked")
    public void saveValue(T value){
        Log.i("pttt", "SavableTileData" + " Saving " + value);
        String key = getSharedPrefsKey();
        switch (getSaveTypeName()){
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
            case "ArrayList<Boolean>":
            case "ArrayList<Integer>":
                SharedPrefsManager.getInstance().putArray(key,(ArrayList<?>) value);
                break;
            default:
                Log.w("MySettingsScreen", "Could not save a setting of type " + getSaveTypeName());
        }
    }

    /**
     * Parameter type T is generic
     * Therefore this function will detect the concrete type
     * This is used for sharedprefs saving purpose
     * @return name of the real type of genetic T
     */
    @SuppressWarnings("unchecked")
    private String getSaveTypeName(){
        String typeName;

        if(defaultValue instanceof List<?>){
            typeName = "ArrayList";
            if(defaultValue!=null) {
                Object item = ((List<?>) defaultValue).get(0);
                typeName += "<" + item.getClass().getSimpleName() + ">";
            }else
                Log.w(getClass().getSimpleName(), "Could not get value type for tile " + title + ". please provide a default value.");
        }
        else {
            Class<T> persistentClass = (Class<T>)
                    ((ParameterizedType) getClass().getGenericSuperclass())
                            .getActualTypeArguments()[0];

            typeName = persistentClass.getSimpleName();
        }

        return typeName;
    }


    /**
     * Generates a key for saving the data of the tile to shared preferences.
     * @return Key string that matches the title text of the tile
     */
    protected String getSharedPrefsKey(){
        return SharedPrefsManager.KEYS.SP_KEY_PREFIX + title
                .replace(' ', '_')
                .replace('-', '_')
                .toUpperCase();
    }

}
