package com.idankorenisraeli.mysettingsscreen.exception;

import android.util.Log;

public class NonSavableTileOperationException extends Exception {

    public NonSavableTileOperationException() {
        super();
        Log.e("MySettingsScreen", "Invalid Operation on non savable tile");
    }



}
