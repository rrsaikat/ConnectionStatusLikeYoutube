# ConnectionStatusLikeYoutube
![https://github.com/rrsaikat/ConnectionStatusLikeYoutube](https://img.shields.io/badge/platform-Android-green.svg?style=flat-square)
![https://jitpack.io](https://jitpack.io/v/rrsaikat/ConnectionStatusLikeYoutube.svg)
![https://github.com/rrsaikat/ConnectionStatusLikeYoutube](https://img.shields.io/badge/API-16+-orange.svg?style=flat-square)
![https://www.apache.org/licenses/LICENSE-2.0](https://img.shields.io/badge/licence-Apache%20v2.0-blue.svg?style=flat-square)

A simple library to check internet  every time using Broadcast Receiver like same as Youtube (online,offline)

## TODO

### Step 1
First we need following permission in order to access network state. Add following permission to your AndroidManifest.xml file.
Permissions required to access network state:

    <uses-permission android:name="android.permission.INTERNET" />
    <uses-permission android:name="android.permission.ACCESS_NETWORK_STATE" />
    <uses-permission android:name="android.permission.ACCESS_WIFI_STATE" />
    

### Step 2
we need to define the BroadcastReceiver in AndroidMenifest.xml file.
Add following to your menifest file.

    <application  ...>
         ...
            <receiver
                android:name=".recievers.NetworkChangeReceiver"
                android:label="NetworkChangeReceiver" >
                <intent-filter>
                    <action android:name="android.net.conn.CONNECTIVITY_CHANGE" />
                    <action android:name="android.net.wifi.WIFI_STATE_CHANGED" />
                </intent-filter>
            </receiver>
          ...
    </application>

### Step 3
Add it in your root build.gradle at the end of repositories:

    allprojects {
      repositories {
        ...
        maven { url 'https://jitpack.io' }
      }
    }

### Step 4
Add the dependency

	dependencies {
	        implementation 'com.github.rrsaikat:ConnectionStatusLikeYoutube:v1.0.0'
	}
