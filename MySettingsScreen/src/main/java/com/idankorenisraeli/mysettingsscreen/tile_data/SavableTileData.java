package com.idankorenisraeli.mysettingsscreen.tile_data;

import android.util.Log;

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
        Log.i("pttt", "This class is " + getClass().getSimpleName());
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
                String optionsArrayData =  SharedPrefsManager.getInstance().getString(key, "-1");
                if(optionsArrayData.equals("-1"))
                    result = defaultValue; // List was never saved
                else
                    result = (T) stringToCheckedList(optionsArrayData);
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
                SharedPrefsManager.getInstance().putString(key, checkedListToString((ArrayList<Boolean>) value));
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


    /**
     * Used for saving multi choice tiles
     * @param checkedList ArrayList of the choices if checked by order
     * @return String that represent check with 1 and uncheck with 0
     */
    private String checkedListToString(ArrayList<Boolean> checkedList){
        StringBuilder stringBuilder = new StringBuilder(checkedList.size());

        for (boolean b : checkedList) {
            char toAppend = b ? '1' : '0';
            stringBuilder.append(toAppend);
        }
        return stringBuilder.toString();
    }

    /**
     * Used for saving multi choice tiles
     * @param str String that represents multi choice check by 0s and 1s in order
     * @return Array that contains true and false for check and uncheck options
     */

    private ArrayList<Boolean> stringToCheckedList(String str){
        ArrayList<Boolean> arr = new ArrayList<>(str.length());

        for (int i = 0; i < str.length(); i++) {
            arr.add(str.charAt(i) == '1');
            // false for 0, true for 1
        }

        return arr;
    }

}
