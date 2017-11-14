package com.drunkpiano.simplebottomnavigation;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.drunkpiano.simplebottomnavigationbar.BottomNav;
import com.drunkpiano.simplebottomnavigationbar.BottomNavItem;

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

		//Add tabs here.
		bottomNav
				.addItem(new BottomNavItem(R.drawable.ic_lightbulb_outline_black_24dp, R.drawable.ic_lightbulb_outline_black_24dp, "Bulb", 0))
				.addItem(new BottomNavItem(R.drawable.ic_tag_faces_black_24dp, R.drawable.ic_tag_faces_black_24dp, "Smile", 1))
				.addItem(new BottomNavItem(R.drawable.ic_favorite_black_24dp, R.drawable.ic_favorite_black_24dp, "Favorite", 2));
		//text color settings
		bottomNav.setDefaultTabTextColor(Color.GRAY);
		bottomNav.setSetSelectedTabTextColor(Color.BLACK);
		bottomNav.setTabSelectedListener(new BottomNav.OnTabSelectedListener() {
			@Override
			public void onTabSelected(int index) {
				switch (index) {
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
		bottomNav.updateViewByIndex(0);
	}
}
