package com.drunkpiano.simplebottomnavigationbar;

import android.graphics.drawable.Drawable;

/**
 * @author DrunkPiano.
 *         Created on 16/9/30.
 */

public class BottomNavItem {
	int mDrawableSelected;
	int mDrawableUnselected;
	String mText;
	//    String mTabTag;
	int mTabIndex;

//    public BottomNavItem(Drawable drawable, String s) {
//        mIcon = drawable;
//        mText = s;
//    }
//
//    public BottomNavItem(int drawable, String s) {
//        mIconResource = drawable;
//        mText = s;
//    }

	/**
	 *
	 * @param drawableSelected selected icon of a tab
	 * @param drawableUnselected unselected icon of a tab
	 * @param title tab's title string
	 * @param tabIndex tab's index
	 */
	public BottomNavItem(int drawableSelected, int drawableUnselected, String title, int tabIndex) {
		mDrawableSelected = drawableSelected;
		mDrawableUnselected = drawableUnselected;
		mText = title;
		mTabIndex = tabIndex;
//        mTabTag = tabTag;
	}
}