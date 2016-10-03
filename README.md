# SimpleBottomNavigationBar

A simple bottom navigation bar, wrote exactly according to the [material design's description][materialDesignLink].

It supports 2 ~ 5 tabs.

![banner](https://github.com/LarryLawrence/SimpleBottomNavigationBar/blob/master/screenshots/navi.gif)

# Download
Based on your IDE you can import library in one of the following ways:

Download [the latest AAR][mavenAarDownload], or:

in your build.gradle:
```groovy
compile 'com.drunkpiano:simplebottomnavigationbar:1.0.0'
```
or, grab via Maven:
```xml
<dependency>
  <groupId>com.drunkpiano</groupId>
  <artifactId>simplebottomnavigationbar</artifactId>
  <version>1.0.0</version>
  <type>pom</type>
</dependency>
```
or Ivy:
```xml
<dependency org='com.drunkpiano' name='simplebottomnavigationbar' rev='1.0.0'>
  <artifact name='$AID' ext='pom'></artifact>
</dependency>
```

# How to use
## In your xml:
```xml
<com.drunkpiano.simplebottomnavigationbar.BottomNav
    android:id="@+id/bottom_nav"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:layout_alignParentBottom="true"
    android:background="@android:color/white"
    android:elevation="@dimen/abc_action_bar_elevation_material" />
```

## In your class:
```java
BottomNav bottomNav = (BottomNav) findViewById(R.id.bottom_nav);

//Add 2 ~ 5 tabs here.
bottomNav
        .addItem(new BottomNavItem(R.drawable.ic_lightbulb_outline_black_24dp, "Bulb"))
        .addItem(new BottomNavItem(R.drawable.ic_tag_faces_black_24dp, "Smile"))
        .addItem(new BottomNavItem(R.drawable.ic_favorite_black_24dp, "Favorite"))
        .initialise();
```

## Add TabSelectedListener:
```
bottomNav.setTabSelectedListener(new BottomNav.OnTabSelectedListener() {
    @Override
    public void onTabSelected(int position) {
        switch (position) {
            case 0:
                getSupportFragmentManager().beginTransaction().replace(R.id.container, FirstFragment.newInstance()).commit();
                break;
            case 1:
                getSupportFragmentManager().beginTransaction().replace(R.id.container, SecondFragment.newInstance()).commit();
                break;
            default:
                getSupportFragmentManager().beginTransaction().replace(R.id.container, ThirdFragment.newInstance()).commit();
                break;
        }
    }

});
```
**You can also find the usages in the 'sample' module.**

## License

```
SimpleBottomNavigationBar library for Android
Copyright (c) 2016 DrunkPiano.

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

http://www.apache.org/licenses/LICENSE-2.0

[materialDesignLink]: https://material.google.com/components/bottom-navigation.html#bottom-navigation-specs
[mavenAarDownload]: https://jcenter.bintray.com/com/drunkpiano/simplebottomnavigationbar/1.0.0/:simplebottomnavigationbar-1.0.0.aar