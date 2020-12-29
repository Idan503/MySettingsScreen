package com.idankorenisraeli.mysettingsscreen.callback;

import java.util.ArrayList;

/**
 * This callback is used for multichoicetile,
 * to return the list of the options and if each one is checked or unchecked respectively
 */
public interface OnMultiSelectListener {
    void onMultiSelect(ArrayList<String> options, ArrayList<Boolean> checked);
}
