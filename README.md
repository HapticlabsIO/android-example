# Hapticlabs Android Package Example

This sample application demonstrates the features and usage of the `hapticlabsplayer` library, including various haptic and audio effects.

## Prerequisites

- [Git](https://git-scm.com/)
- [Android Studio](https://developer.android.com/studio)

## Setup

1. Clone this repository:
   ```sh
   git clone https://github.com/HapticlabsIO/HapticlabsAndroidPackage.git
   ```
2. Initialize submodules:
   ```sh
   git submodule update --init --recursive
   ```
3. Open the project in Android Studio.
4. The library in `hapticlabsplayer` is an included Gradle build that locates the Android SDK on its own. Either set `ANDROID_HOME`, or copy `local.properties` into `hapticlabsplayer/`.
5. Build and run the app on your device.

For more information, see the [`hapticlabsplayer` documentation](https://github.com/HapticlabsIO/androidplayer).
