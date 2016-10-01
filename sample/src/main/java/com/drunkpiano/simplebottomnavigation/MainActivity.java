package com.drunkpiano.simplebottomnavigation;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.drunkpiano.simplebottomnavigationbar.BottomNav;
import com.drunkpiano.simplebottomnavigationbar.BottomNavItem;

import static com.drunkpiano.simplebottomnavigationbar.BottomNav.dp10;
import static com.drunkpiano.simplebottomnavigationbar.BottomNav.dp12;
import static com.drunkpiano.simplebottomnavigationbar.BottomNav.dp6;

/**
 * @author drunkpiano
 *         date 2016/10/01
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initBottomNavigation();

    }

    private void initBottomNavigation() {
        BottomNav bottomNav = (BottomNav) findViewById(R.id.bottom_nav);

        //Add 2 ~ 5 tabs here.
        bottomNav
                .addItem(new BottomNavItem(R.drawable.ic_lightbulb_outline_black_24dp, "Bulb"))
                .addItem(new BottomNavItem(R.drawable.ic_tag_faces_black_24dp, "Smile"))
                .addItem(new BottomNavItem(R.drawable.ic_favorite_black_24dp, "Favorite"))
//                .addItem(new BottomNavItem(R.drawable.ic_notifications_black_24dp, "Notifications"))
//                .addItem(new BottomNavItem(R.drawable.ic_settings_black_24dp, "Settings"))
                .initialise();
        bottomNav.setTabSelectedListener(new BottomNav.OnTabSelectedListener() {
            @Override
            public void onTabSelected(int position) {
//                Toast.makeText(MainActivity.this, "position--->" + position, Toast.LENGTH_SHORT).show();
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

        //Here I set the first tab to be clicked on Activity started.
        bottomNav.mTab1.setPadding(dp12, dp6, dp12, dp10);
        bottomNav.mTextView1.setTextSize(14);
        getSupportFragmentManager().beginTransaction().replace(R.id.container, FirstFragment.newInstance()).commit();

    }
}
