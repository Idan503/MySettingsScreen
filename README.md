[![](https://jitpack.io/v/Idan503/MySettingsScreen.svg)](https://jitpack.io/#Idan503/MySettingsScreen) [![GitHub license](https://img.shields.io/github/license/Idan503/MySettingsScreen?style=flat-square)](https://github.com/Idan503/MySettingsScreen)
# MySettingsScreen
An easy to use library for automatically creating a fully functional custom-made settings activity for your application, programmatically. 
### Why should I use this?  
Creating a settings screen for your app is a task that can be tedious and time consuming.    

MySettingsSreen library provides you with a simpler and a lot faster way of create the settings screen that you which to add to your app.  
This activity will also take care of all save and load functionalities for the many possible preferences that can be set.  
MySettingsScreen feels and looks like a native android settings screen, and supports material desgin principles and interfaces.  



## A Quick Look

## Usage

## Setup
##### Step 1
Add this to build.gradle of your project
```
allprojects {
	repositories {
		...
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
Copyright 2020 Idan Koren-Israeli

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