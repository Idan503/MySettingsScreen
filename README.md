


[![](https://jitpack.io/v/Idan503/MySettingsScreen.svg)](https://jitpack.io/#Idan503/MySettingsScreen) [![GitHub license](https://img.shields.io/github/license/Idan503/MySettingsScreen?style=flat-square)](https://github.com/Idan503/MySettingsScreen)
# MySettingsScreen
An easy to use android library for automatically creating a fully functional custom-made ***settings activity*** for your application, programmatically. 
## Why should I use this?  
Creating a *settings screen* for your app is a task that can be *tedious* and *time consuming*.    
<br>
*MySettingsScreen* library provides you with a simpler and a lot faster way of creating a suitable settings screen to your app.  
This activity will also take care of all save and load functionalities for the many possible preferences that can be set, by saving the selected options to device's ***SharedPreferences***.
<br/>
Your new settings screen will feel and look like a *native android settings screen*, and supports *[Material Desgin](https://github.com/material-components/material-components-android)* principles and interfaces.  



## A Quick Look
  <p float="left" align="middle" padding="10">
  <img src="/screenshots/usage_full_example.gif?raw=true" width="325" />
</p>

Full implementation snippet of this example can be found [here](https://github.com/Idan503/MySettingsScreen/wiki/All-Tiles-Usage-Example)

## Usage
The following snippet will create a settings screen with 3 basic tiles 
(Switch, Checkbox and Seekbar options)


<br/>
Initializing a Switch Tile:

	  ToggleTileData switchTileData = new ToggleTileData("Switch Tile", "Can be toggled off/on")
	        .withDefaultValue(true)
	        .withToggleType(ToggleType.SWITCH)
	        .withOnChangeListener(new CompoundButton.OnCheckedChangeListener() {
	            @Override
	            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
	                String state = isChecked ? "on" : "off";
	                String msg = "Switch is toggled " + state;
	                showToast(msg);
	            }
	        })
	        .withIconId(com.idankorenisraeli.mysettingsscreen.R.drawable.ic_baseline_toggle_on_24);

<br/>
Initializing a Checkbox Tile:

	  ToggleTileData checkboxTileData = new ToggleTileData("Checkbox Tile", "Can be toggled off/on")
	        .withDefaultValue(true)
	        .withToggleType(ToggleType.CHECK_BOX)
	        .withOnChangeListener(new CompoundButton.OnCheckedChangeListener() {
	            @Override
	            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
	                String state = isChecked ? "on" : "off";
	                String msg = "Checkbox is now toggled " + state;
	                showToast(msg);
	            }
	         })
	        .withIconId(com.idankorenisraeli.mysettingsscreen.R.drawable.ic_baseline_check_24);

<br/>
Initializing a Seekbar Tile:    

	  SeekbarTileData seekbarTileData = new SeekbarTileData("Seekbar Tile", "Between min/max provided values")
	        .withDefaultValue(50)
	        .withMaxValue(100)
	        .withMinValue(0)
	        .withOnChangeListener(new SeekBar.OnSeekBarChangeListener() {
	            @Override
	            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {}

	            @Override
	            public void onStartTrackingTouch(SeekBar seekBar) {}

	            @Override
	            public void onStopTrackingTouch(SeekBar seekBar) {
	                showToast("Progress set to " + seekBar.getProgress());
	            }
	         })
	        .withIconId(com.idankorenisraeli.mysettingsscreen.R.drawable.ic_96_settings);

<br/>
Adding initialized tiles to an ArrayList:

	  ArrayList<SettingsTileData> dataTiles = new ArrayList<>();
	  
	  dataTiles.add(switchTileData);
	  dataTiles.add(checkboxTileData);
	  dataTiles.add(seekbarTileData);



<br/>
Starting the Settings Activity with the tiles:

	  main_BTN_settings.setOnClickListener( new View.OnClickListener() {
	            @Override
	            public void onClick(View v) {
	                MySettingsScreen.getInstance()
					.initSettingsScreen(MainActivity.this, tiles, "My Settings Screen" );
	            }
	        }
	   );
	   

> More examples can be found in the [Wiki Pages](https://github.com/Idan503/MySettingsScreen/wiki) of the library

## Setup
##### Step 1
Add this to build.gradle of your project
```
allprojects {
	repositories {

		maven { url 'https://jitpack.io' }
	}
}
```

##### Step 2
Add this dependency to your build.gradle of your app
```
dependencies {
	implementation 'com.github.Idan503:MySettingsScreen:<version>'
}
```	

## License

```
Copyright 2021 Idan Koren-Israeli

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0
   
Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```