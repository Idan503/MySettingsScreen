





[![](https://jitpack.io/v/Idan503/MySettingsScreen.svg)](https://jitpack.io/#Idan503/MySettingsScreen) [![GitHub license](https://img.shields.io/github/license/Idan503/MySettingsScreen?style=flat-square)](https://github.com/Idan503/MySettingsScreen)
# MySettingsScreen
An easy to use android library for automatically creating a fully functional custom-made ***settings activity*** for your application, programmatically. 
### Why should I use this?  
Creating a *settings screen* for your app is a task that can be *tedious* and *time consuming*.    
<br>
*[MySettingsScreen](https://github.com/Idan503/MySettingsScreen/wiki)* library provides you with a simpler and a lot faster way of creating a suitable settings screen to your app.  
This activity will also take care of all save and load functionalities for the many possible preferences that can be set, by saving the selected options to device's ***SharedPreferences***.  
<br/>
Your new settings screen will feel and look like a *native android settings screen*, and supports *[Material Desgin](https://github.com/material-components/material-components-android)* principles and interfaces.  



## A Quick Look
  <p float="left" align="middle" padding="10">
  <img src="/screenshots/usage_full_example.gif?raw=true" width="305" />
</p>

> #### Full implementation of the example above can be found in the included example app.


## Types of Settings Tiles
As you can see in the example above, your MySettingsScreen activity will contains settings tiles of different types.
* Stateless Tiles  
  *  `TitleTile` 
  *  `ButtonTile` 
  *  `InnerPageTile` 

* Stateful Tiles (Saves user preferences to device)
  *  `ToggleTile` 
  *  `RadioTile` 
  *  `MultiChoiceTile` 
  *  `SeekbarTile` 
  *  `EditTextTile` 
  *  `TimePickerTile`
  *  `DatePickerTile`

* Divider Tiles  
  *  `DeviderTile` 
 
> #### More information about *settings tiles* and their types can be found in the [Wiki Page](https://github.com/Idan503/MySettingsScreen/wiki).

## How to use?
The following snippet will create a settings screen with 3 basic tiles 
(Switch, Checkbox and Seekbar options)



#### Step 1 - In Application `onCreate`
##### Step 1.1
To make the settings screen ready, we would need to set the `SettingsTileData` on the `Application` class `onCreate` method:
```
  public class MyApp extends Application {  
      
    @Override  
    public void onCreate() {  
      super.onCreate();
      // Steps 1.3 to 1.5 should be implemeted here

```
##### Step 1.2
While also setting this class as your application name on `AndroidManifest.xml`
```
  <application  
    
	android:name=".MyApp"
  </application>
```
##### Step 1.3
Here we will initialize all the tiles we would like to add to our settings screen,  
in this example we selected 3 tiles (Switch, Time Picker, Seekbar).  
Feel free to check the [sample project](https://github.com/Idan503/MySettingsScreen/blob/main/app/src/main/java/com/idankorenisraeli/mysettingsscreensample/MyApp.java) for implementation examples of all tiles types.  
* Initializing a Switch Tile:

        ToggleTileData switchTileData = new ToggleTileData("Switch Tile", "Can be toggled off/on")
                .withDefaultValue(true)
                .withToggleType(ToggleType.SWITCH)
                .withOnChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        String state = isChecked ? "on" : "off";
                        String msg = "Switch is toggled " + state;
                        Toast.makeText(MyApp.this, msg, Toast.LENGTH_SHORT).show();
                    }
                })
                .withIconId(com.idankorenisraeli.mysettingsscreen.R.drawable.ic_baseline_toggle_on_24);
<br/>

* Initializing a Time Picker Tile:

        TimePickerTileData timePickerTileData = new TimePickerTileData("TimePicker Tile",
		     "Pick a time in the day")
                .withTimeFormat(TimeFormat.CLOCK_12H)
                .withOnSelectedListener(new OnTimeSelectedListener() {
                    @Override
                    public void onTimeSelected(int hours, int minutes) {
                        String msg = "Hours: " + hours + ", Minutes: " + minutes;
                        Toast.makeText(MyApp.this, msg, Toast.LENGTH_SHORT).show();
                    }
                })
                .withIconId(com.idankorenisraeli.mysettingsscreen.R.drawable.ic_clock_black_24dp);

<br/>

* Initializing a Seekbar Tile:    

        SeekbarTileData seekbarTileData =
			new SeekbarTileData("Seekbar Tile", "Between min/max provided values")
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
						String msg = "Progress set to " + seekBar.getProgress();
						Toast.makeText(MyApp.this, msg, Toast.LENGTH_SHORT).show();
					}
				})
				.withIconId(com.idankorenisraeli.mysettingsscreen.R.drawable.ic_96_settings);

<br/>

##### Step 1.4
Adding initialized tiles to a single ArrayList:

	  ArrayList<SettingsTileData> dataTiles = new ArrayList<>();
	  
	  dataTiles.add(switchTileData);
	  dataTiles.add(checkboxTileData);
	  dataTiles.add(seekbarTileData);

<br/>

##### Step 1.5
 Setting the new tiles data to the future created Settings Activity:

```
  MySettingsScreen.getInstance().setTilesData(dataTiles);
```
<br/>

#### Step 2 - In App's Activities
Now we have in our app a ready settings screen with all the tiles that we have initialized in step 1.  
We can now call `initSettingsScreen` to launch the settings screen anytime we want.

	  main_BTN_settings.setOnClickListener( new View.OnClickListener() {
	            @Override
	            public void onClick(View v) {
					MySettingsScreen.getInstance()
					.initSettingsScreen(MainActivity.this, "My Settings Screen" );
	            }
	        }
	   );
	   
We can also retreving a value from the Data Tiles anywhere on the app:	
```
  SettingsTileData data = MySettingsScreen.getInstance().getTileByTitle("Switch Tile");  
  Boolean toggleSwitchValue = ((SavableTileData<Boolean, ?>) data).getSavedValue();
```   


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
	implementation 'com.github.Idan503:MySettingsScreen:v1.0.01'
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