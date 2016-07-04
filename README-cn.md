[![Android Arsenal](https://img.shields.io/badge/Android%20Arsenal-SlantedTextView-green.svg?style=true)](https://android-arsenal.com/details/1/3816)
# SlantedTextView
一个倾斜的TextView,适用于标签效果。

## 预览
![预览](https://github.com/HeZaiJin/SlantedTextView/blob/master/screen_shot/screenshot.png)

## Gradle
```java
compile 'com.haozhang.libary:android-slanted-textview:1.1'
```

## Layout文件
```java
<com.haozhang.lib.SlantedTextView
    android:layout_width="80dp"
    android:layout_height="80dp"
    android:gravity="center"
    app:slantedBackgroundColor="@color/secondary_text"
    app:slantedLength="40dp"
    app:slantedMode="left"
    app:slantedText="IOS"
    app:slantedTextColor="@color/primary"
    app:slantedTextSize="16sp"
    />
```
## Java
代码中可以动态设置属性
```java
    SlantedTextView stv = (SlantedTextView) findViewById(R.id.test);

    stv.setText("PHP")
            .setTextColor(Color.WHITE)
            .setSlantedBackgroundColor(Color.BLACK)
            .setTextSize(18)
            .setSlantedLength(50)
            .setMode(SlantedTextView.MODE_LEFT);
```
## 属性
![注意](https://github.com/HeZaiJin/SlantedTextView/blob/master/screen_shot/note.png)
## SlantedMode
![SlantedMode](https://github.com/HeZaiJin/SlantedTextView/blob/master/screen_shot/slanted_mode.png)
#License
```
Copyright 2016 Hand HaoZhang

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
