# SlantedTextView
一个倾斜的TextView,适用于标签效果。

## 预览
[预览](https://github.com/HeZaiJin/SlantedTextView/blob/master/screen_shot/screenshot.png)

## Gradle
```java
compile 'com.haozhang.libary:android-slanted-textview:1.0'
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
```java
    SlantedTextView stv = (SlantedTextView) findViewById(R.id.test);

    stv.setText("PHP")
            .setTextColor(Color.WHITE)
            .setSlantedBackgroundColor(Color.BLACK)
            .setTextSize(18)
            .setSlantedLength(50)
            .setMode(SlantedTextView.MODE_LEFT);
```

