# SimpleBottomNavigationBar

A simple bottom navigation bar, wrote according to the material design rules.

[Material Design](https://material.google.com/components/bottom-navigation.html#bottom-navigation-specs)

It supports 2 ~ 5 tabs.

![banner](https://github.com/LarryLawrence/SimpleBottomNavigationBar/blob/master/screenshots/Screenshot_2016-10-01-18-46-24.png)

# How to use
Download the project and make the module simplebottomnavigationbar as dependency. Or just ues the .aar file.

```java
        BottomNav bottomNav = (BottomNav) findViewById(R.id.bottom_nav);

        //Add 2 ~ 5 tabs here.
        bottomNav
                .addItem(new BottomNavItem(R.drawable.ic_lightbulb_outline_black_24dp, "Bulb"))
                .addItem(new BottomNavItem(R.drawable.ic_tag_faces_black_24dp, "Smile"))
                .addItem(new BottomNavItem(R.drawable.ic_favorite_black_24dp, "Favorite"))
                .initialise();
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

You can also find the usages in the 'sample' module.

## License

```
SimpleBottomNavigationBar library for Android
Copyright (c) 2016 DrunkPiano.

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

http://www.apache.org/licenses/LICENSE-2.0