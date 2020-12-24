package com.idankorenisraeli.mysettingsscreen.tile_data;
import android.view.View;

/**
 * The tile itself will look exactly like and regular title tile.
 * But it will a ripple effect when clicking on it
 * and a functionality when clicked can be implemented via @onClickListener
 */
public class ButtonTileData extends BasicTileData<ButtonTileData> {

    /**
     * Button doesn't have a state and therefore nothing is saved in SharedPreferences.
     * If you would like to save settings information you can use other type of settings tile,
     * or instead provide saving in a separated shared prefs repo using the @onClickListener
     */

    @Override
    public ButtonTileData build() {
        return this;
    }

    protected View.OnClickListener onClickListener;

    public ButtonTileData(String title, String description) {
        super(title, description);
    }


    public View.OnClickListener getOnClickListener() {
        return onClickListener;
    }

    public ButtonTileData withOnClickListener(View.OnClickListener onClick) {
        this.onClickListener = onClick;
        return build();
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }
}
