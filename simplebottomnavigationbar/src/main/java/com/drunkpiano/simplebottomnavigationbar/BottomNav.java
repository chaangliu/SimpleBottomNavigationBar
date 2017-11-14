package com.drunkpiano.simplebottomnavigationbar;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * BottomNavigation core implementations.
 * Created by DrunkPiano on 2016/12/27.
 */

public class BottomNav extends LinearLayout {
	/**
	 * A list of ViewHolders.
	 */
	private List<ViewHolder> mViewHolderList = new ArrayList<>();
	/**
	 * Default and Selected tab title's TextColor.
	 */
	private int mDefaultTabTextColor;
	private int mSelectedTabTextColor;

	public BottomNav(Context context) {
		super(context);
//        initView();
	}

	public BottomNav(Context context, AttributeSet attrs) {
		super(context, attrs);
//        initView();
	}

	public BottomNav(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
//        initView();
	}

	public static class ViewHolder {
		BottomNavItem bottomNavItem;
		ImageView tabIcon;
		TextView tabTitle;
	}

	public void setDefaultTabTextColor(int color) {
		mDefaultTabTextColor = color;
	}

	public void setSetSelectedTabTextColor(int color) {
		mSelectedTabTextColor = color;
	}

	public BottomNav addItem(BottomNavItem bottomNavItem) {
		View view = LayoutInflater.from(getContext()).inflate(R.layout.widget_single_tab, null);
		ViewHolder holder = new ViewHolder();
		holder.bottomNavItem = bottomNavItem;
		holder.tabIcon = (ImageView) view.findViewById(R.id.imageView);
		holder.tabTitle = (TextView) view.findViewById(R.id.textView);
		//setup tab title
		if (TextUtils.isEmpty(bottomNavItem.mText)) {
			holder.tabTitle.setVisibility(View.INVISIBLE);
		} else {
			holder.tabTitle.setText(bottomNavItem.mText);
		}
		//setup tab image
		if (bottomNavItem.mDrawableUnselected > 0) {
			holder.tabIcon.setImageResource(bottomNavItem.mDrawableUnselected);
		} else {
			holder.tabIcon.setVisibility(View.INVISIBLE);
		}
		//set holder object as tag, so we can get it via holder
		view.setTag(holder);
		view.setOnClickListener(mOnClickListener);
		mViewHolderList.add(holder);
		// Adds a child view with the specified layout parameters.
		addView(view, new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT, 1.0F));
		return this;
	}

	private OnClickListener mOnClickListener = new OnClickListener() {
		@Override
		public void onClick(View v) {
			Object object = v.getTag();
			if (object != null && object instanceof ViewHolder) {
				ViewHolder holder = (ViewHolder) v.getTag();
				setCurrentSelectedTabByIndex(holder.bottomNavItem.mTabIndex);
			}
		}
	};

	private void setCurrentSelectedTabByIndex(int index) {
		mOnTabSelectedListener.onTabSelected(index);
		updateViewByIndex(index);
	}

	public void updateViewByIndex(int index) {
		for (ViewHolder holder : mViewHolderList) {
			//traverse
			if (index == holder.bottomNavItem.mTabIndex) {
				holder.tabIcon.setImageResource(holder.bottomNavItem.mDrawableSelected);
				holder.tabTitle.setTextColor(mSelectedTabTextColor);
			} else {
				holder.tabIcon.setImageResource(holder.bottomNavItem.mDrawableUnselected);
				holder.tabTitle.setTextColor(mDefaultTabTextColor);
			}
		}
	}

	private OnTabSelectedListener mOnTabSelectedListener;

	public interface OnTabSelectedListener {
		void onTabSelected(int index);

	}

	public void setTabSelectedListener(OnTabSelectedListener onTabSelectedListener) {
		mOnTabSelectedListener = onTabSelectedListener;
	}

	private int dp2px(int padding_in_dp) {
		final float scale = getResources().getDisplayMetrics().density;
		return (int) (padding_in_dp * scale + 0.5f);
	}
}

