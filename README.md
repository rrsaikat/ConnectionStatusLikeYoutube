# ConnectionStatusLikeYoutube
![https://github.com/rrsaikat/ConnectionStatusLikeYoutube](https://img.shields.io/badge/platform-Android-green.svg?style=flat-square)
![https://jitpack.io](https://jitpack.io/v/rrsaikat/ConnectionStatusLikeYoutube.svg)
![https://github.com/rrsaikat/ConnectionStatusLikeYoutube](https://img.shields.io/badge/API-16+-orange.svg?style=flat-square)
![https://www.apache.org/licenses/LICENSE-2.0](https://img.shields.io/badge/licence-Apache%20v2.0-blue.svg?style=flat-square)

A simple library to check internet  every time using Broadcast Receiver like same as Youtube (online,offline)

<p align="start">
  <img src="https://github.com/rrsaikat/ConnectionStatusLikeYoutube/blob/master/app/src/main/res/drawable/onlineStatus.gif" height="420" width="240"/>
</p>


## TODO

### Step 1
Just declare this two lines into your onCreate() or onStart() method:

	NetworkChangeReceiver changeReceiver = new NetworkChangeReceiver(this);
	changeReceiver.build();


### Step 2
Add it in your root build.gradle at the end of repositories:

    allprojects {
      repositories {
        ...
        maven { url 'https://jitpack.io' }
      }
    }

### Step 3
Add the dependency

	dependencies {
	        implementation 'com.github.rrsaikat:ConnectionStatusLikeYoutube:v1.0.1'
	}

## NOTE
To handle errors or use this library you have to migrate your android.support into androidx . See the full project migration process at here: [Click Me](https://developer.android.com/jetpack/androidx/migrate)

## LICENSE
 Copyright 2018 Md. rezwan rabbi

	   Licensed under the Apache License, Version 2.0 (the "License");
	   you may not use this file except in compliance with the License.
	   You may obtain a copy of the License at

	       http://www.apache.org/licenses/LICENSE-2.0

	   Unless required by applicable law or agreed to in writing, software
	   distributed under the License is distributed on an "AS IS" BASIS,
	   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
	   See the License for the specific language governing permissions and
	   limitations under the License.
