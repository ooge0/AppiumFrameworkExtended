# AppiumQA project


## How to run virtual device from command line on Windows machine 
```
cd %ANDROID_HOME%\emulator
emulator -avd <emulatorName>
```
e.g.
```
cd %ANDROID_HOME%\emulator
emulator -avd Pixel4a
```


## How to check list of connected devices
```emulator -list-avds```

# WIKI
## Appium
### appium tests, JAVA code examples
https://github.com/appium/java-client/tree/master/src/test/java/io/appium/java_client/android

### Appium JAVA client examples, Android test >> AndroidSearchingTest
https://github.com/appium/java-client/blob/master/src/test/java/io/appium/java_client/android/AndroidSearchingTest.java

## ADB
## Get th list of all installed packages names
``adb shell pm list packages``

## CMD
## Save output in the file
``adb shell pm list packages > C:\work\trash\OUTPUT.txt``

## How to check the app performance by ADB
Checking top 5 processes by ADB command
``ADB shell top -m 5 -d 1``

## Emulator/AVD
### Restarting hanged emulator
Solution for Windows OS
``
Kill the process qemu-system-x86_64.exe if emulator is not responding
Full path to the EE  file can be like this: C:\Users\User\AppData\Local\Android\Sdk\emulator\qemu\windows-x86_64\qemu-system-x86_64.exe
``
