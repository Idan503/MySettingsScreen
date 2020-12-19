package com.idankorenisraeli.mysettingsscreensample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.button.MaterialButton;
import com.idankorenisraeli.mysettingsscreen.MySettingsActivity;

public class MainActivity extends AppCompatActivity {

    MaterialButton main_BTN_settings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViews();

        main_BTN_settings.setOnClickListener( new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(MainActivity.this, MySettingsActivity.class);
                    }
                }
        );


    }

    private void findViews(){
        main_BTN_settings = findViewById(R.id.main_BTN_settings);
    }
}