package com.drunkpiano.simplebottomnavigationbar;

import android.graphics.drawable.Drawable;
import android.support.annotation.DrawableRes;

/**
 * @author DrunkPiano.
 *         Created on 16/9/30.
 */

public class BottomNavItem {
    protected Drawable mIcon;
    protected int mIconResource;
    protected String mText;

    public BottomNavItem(Drawable drawable, String s) {
        mIcon = drawable;
        mText = s;
    }

    public BottomNavItem(@DrawableRes int drawable, String s) {
        mIconResource = drawable;
        mText = s;
    }
}
