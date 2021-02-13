package com.idankorenisraeli.mysettingsscreensample;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;
import com.idankorenisraeli.mysettingsscreen.MySettingsScreen;
import com.idankorenisraeli.mysettingsscreen.tile_data.essential.SavableTileData;
import com.idankorenisraeli.mysettingsscreen.tile_data.essential.SettingsTileData;


/**
 * In this example we will create a settings screen
 * which will include all the possible tiles that can be implemented
 * using the library.
 */
public class MainActivity extends AppCompatActivity {

    MaterialButton main_BTN_settings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViews();
        hideActionBar();


        main_BTN_settings.setOnClickListener( new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        MySettingsScreen.getInstance().initSettingsScreen(MainActivity.this, "My Settings Screen" );
                    }
                }
        );


        // Getting a saved value from tiles anywhere else in your app
        SettingsTileData data = MySettingsScreen.getInstance().getTileByTitle("Switch Tile");
        Boolean toggleSwitchValue =  ((SavableTileData<Boolean, ?>) data).getSavedValue();
        //showToast("Toggle Value Retrieved: " + toggleSwitchValue.toString());


    }


    private void findViews(){
        main_BTN_settings = findViewById(R.id.main_BTN_settings);
    }

    private void hideActionBar(){
        ActionBar defaultActionBar = getSupportActionBar();
        if(defaultActionBar!=null)
            defaultActionBar.hide(); //hides default action bar (there is a toolbar instead in the layout)

    }

    private void showToast(String message){
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

}