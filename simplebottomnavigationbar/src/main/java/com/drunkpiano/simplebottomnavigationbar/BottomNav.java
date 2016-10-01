package com.drunkpiano.simplebottomnavigationbar;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import static com.drunkpiano.simplebottomnavigationbar.R.id.imageView1;
import static com.drunkpiano.simplebottomnavigationbar.R.id.imageView2;
import static com.drunkpiano.simplebottomnavigationbar.R.id.imageView3;
import static com.drunkpiano.simplebottomnavigationbar.R.id.imageView4;
import static com.drunkpiano.simplebottomnavigationbar.R.id.imageView5;

/**
 * A simple Bottom Navigation Bar.
 * Created by DrunkPiano on 16/9/30.
 * Any Issues please Mail Me/ 发邮件给我: lcconan@gmail.com
 */

public class BottomNav extends FrameLayout {
    /**
     * Tabs
     */
    public LinearLayout mTab1;
    public LinearLayout mTab2;
    public LinearLayout mTab3;
    public LinearLayout mTab4;
    public LinearLayout mTab5;
    /**
     * TextViews in the tabs
     */
    public TextView mTextView1;
    public TextView mTextView2;
    public TextView mTextView3;
    public TextView mTextView4;
    public TextView mTextView5;
    /**
     * ImageViews in the tabs
     */
    private ImageView mImageView1;
    private ImageView mImageView2;
    private ImageView mImageView3;
    private ImageView mImageView4;
    private ImageView mImageView5;
    /**
     * Dps converted from pixels
     */
    public static int dp12;
    public static int dp10;
    public static int dp8;
    public static int dp6;

    private ArrayList<BottomNavItem> mBottomNavItems = new ArrayList<>();

    public BottomNav(Context context) {
        super(context);
        initView();
    }

    public BottomNav(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    public BottomNav(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    private void initView() {
        LayoutInflater.from(getContext()).inflate(R.layout.widget_bottom_navi, this, true);
        mTextView1 = (TextView) findViewById(R.id.textView1);
        mTextView2 = (TextView) findViewById(R.id.textView2);
        mTextView3 = (TextView) findViewById(R.id.textView3);
        mTextView4 = (TextView) findViewById(R.id.textView4);
        mTextView5 = (TextView) findViewById(R.id.textView5);
        mImageView1 = (ImageView) findViewById(imageView1);
        mImageView2 = (ImageView) findViewById(imageView2);
        mImageView3 = (ImageView) findViewById(imageView3);
        mImageView4 = (ImageView) findViewById(imageView4);
        mImageView5 = (ImageView) findViewById(imageView5);
        mTab1 = (LinearLayout) findViewById(R.id.tab1);
        mTab2 = (LinearLayout) findViewById(R.id.tab2);
        mTab3 = (LinearLayout) findViewById(R.id.tab3);
        mTab4 = (LinearLayout) findViewById(R.id.tab4);
        mTab5 = (LinearLayout) findViewById(R.id.tab5);
        dp12 = dp2px(12);
        dp10 = dp2px(10);
        dp8 = dp2px(8);
        dp6 = dp2px(6);
    }

    public BottomNav addItem(BottomNavItem bn) {
        mBottomNavItems.add(bn);
        return this;
    }

    public void initialise() {
        int size = mBottomNavItems.size();
        if (size < 2) {
            Toast.makeText(getContext(), "At least 2 tabs should be deployed here.", Toast.LENGTH_LONG).show();
            Log.d("Notification", "Hey, this bottom navigation bar only support 2 ~ 5 tabs.");
            return;
        }
        if (size > 5) {
            Toast.makeText(getContext(), "At Most 5 tabs could be deployed here.", Toast.LENGTH_LONG).show();
            Log.d("Notification", "Hey, this bottom navigation bar only support 2 ~ 5 tabs.");
            return;
        }
        ArrayList<String> tabTxtArray = new ArrayList<>();
        ArrayList<Integer> tabDrawableArray = new ArrayList<>();

        for (BottomNavItem bni : mBottomNavItems) {
            tabTxtArray.add(bni.mText);
            tabDrawableArray.add(bni.mIconResource);
        }
        switch (size) {
            case 2:
                mTextView1.setText(tabTxtArray.get(0));
                mTextView2.setText(tabTxtArray.get(1));
                mImageView1.setImageResource(tabDrawableArray.get(0));
                mImageView2.setImageResource(tabDrawableArray.get(1));
                mTab1.setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        mOnTabSelectedListener.onTabSelected(0);
//                    public void setPadding(int left, int top, int right, int bottom) {
                        mTab1.setPadding(dp12, dp6, dp12, dp10);
                        mTextView1.setTextSize(14);

                        mTab2.setPadding(dp12, dp8, dp12, dp10);
                        mTextView2.setTextSize(12);
                    }
                });
                mTab2.setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        mOnTabSelectedListener.onTabSelected(1);
                        mTab2.setPadding(dp12, dp6, dp12, dp10);
                        mTextView2.setTextSize(14);

                        mTab1.setPadding(dp12, dp8, dp12, dp10);
                        mTextView1.setTextSize(12);
                    }
                });
                break;
            case 3:
                mTextView1.setText(tabTxtArray.get(0));
                mTextView2.setText(tabTxtArray.get(1));
                mTextView3.setText(tabTxtArray.get(2));
                mImageView1.setImageResource(tabDrawableArray.get(0));
                mImageView2.setImageResource(tabDrawableArray.get(1));
                mImageView3.setImageResource(tabDrawableArray.get(2));
                mTab3.setVisibility(View.VISIBLE);
                mTab1.setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        mOnTabSelectedListener.onTabSelected(0);
                        mTab1.setPadding(dp12, dp6, dp12, dp10);
                        mTextView1.setTextSize(14);

                        mTab2.setPadding(dp12, dp8, dp12, dp10);
                        mTextView2.setTextSize(12);

                        mTab3.setPadding(dp12, dp8, dp12, dp10);
                        mTextView3.setTextSize(12);
                    }
                });
                mTab2.setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        mOnTabSelectedListener.onTabSelected(1);
                        mTab2.setPadding(dp12, dp6, dp12, dp10);
                        mTextView2.setTextSize(14);

                        mTab1.setPadding(dp12, dp8, dp12, dp10);
                        mTextView1.setTextSize(12);

                        mTab3.setPadding(dp12, dp8, dp12, dp10);
                        mTextView3.setTextSize(12);
                    }
                });
                mTab3.setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        mOnTabSelectedListener.onTabSelected(2);
                        mTab3.setPadding(dp12, dp6, dp12, dp10);
                        mTextView3.setTextSize(14);

                        mTab1.setPadding(dp12, dp8, dp12, dp10);
                        mTextView1.setTextSize(12);

                        mTab2.setPadding(dp12, dp8, dp12, dp10);
                        mTextView2.setTextSize(12);
                    }
                });
                break;
            case 4:
                mTextView1.setText(tabTxtArray.get(0));
                mTextView2.setText(tabTxtArray.get(1));
                mTextView3.setText(tabTxtArray.get(2));
                mTextView4.setText(tabTxtArray.get(3));
                mImageView1.setImageResource(tabDrawableArray.get(0));
                mImageView2.setImageResource(tabDrawableArray.get(1));
                mImageView3.setImageResource(tabDrawableArray.get(2));
                mImageView4.setImageResource(tabDrawableArray.get(3));
                mTab3.setVisibility(View.VISIBLE);
                mTab4.setVisibility(View.VISIBLE);
                mTab1.setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        mOnTabSelectedListener.onTabSelected(0);

                        mTab1.setPadding(dp12, dp6, dp12, dp10);
                        mTextView1.setTextSize(14);

                        mTab2.setPadding(dp12, dp8, dp12, dp10);
                        mTextView2.setTextSize(12);

                        mTab3.setPadding(dp12, dp8, dp12, dp10);
                        mTextView3.setTextSize(12);

                        mTab4.setPadding(dp12, dp8, dp12, dp10);
                        mTextView4.setTextSize(12);
                    }
                });
                mTab2.setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        mOnTabSelectedListener.onTabSelected(1);

                        mTab1.setPadding(dp12, dp8, dp12, dp10);
                        mTextView1.setTextSize(12);

                        mTab2.setPadding(dp12, dp6, dp12, dp10);
                        mTextView2.setTextSize(14);

                        mTab3.setPadding(dp12, dp8, dp12, dp10);
                        mTextView3.setTextSize(12);

                        mTab4.setPadding(dp12, dp8, dp12, dp10);
                        mTextView4.setTextSize(12);
                    }
                });
                mTab3.setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        mOnTabSelectedListener.onTabSelected(2);
                        mTab1.setPadding(dp12, dp8, dp12, dp10);
                        mTextView1.setTextSize(12);

                        mTab2.setPadding(dp12, dp8, dp12, dp10);
                        mTextView2.setTextSize(12);

                        mTab3.setPadding(dp12, dp6, dp12, dp10);
                        mTextView3.setTextSize(14);

                        mTab4.setPadding(dp12, dp8, dp12, dp10);
                        mTextView4.setTextSize(12);
                    }
                });
                mTab4.setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        mOnTabSelectedListener.onTabSelected(3);
                        mTab1.setPadding(dp12, dp8, dp12, dp10);
                        mTextView1.setTextSize(12);

                        mTab2.setPadding(dp12, dp8, dp12, dp10);
                        mTextView2.setTextSize(12);

                        mTab3.setPadding(dp12, dp8, dp12, dp10);
                        mTextView3.setTextSize(12);

                        mTab4.setPadding(dp12, dp6, dp12, dp10);
                        mTextView4.setTextSize(14);
                    }
                });
                break;
            case 5:
                mTextView1.setText(tabTxtArray.get(0));
                mTextView2.setText(tabTxtArray.get(1));
                mTextView3.setText(tabTxtArray.get(2));
                mTextView4.setText(tabTxtArray.get(3));
                mTextView5.setText(tabTxtArray.get(4));
                mImageView1.setImageResource(tabDrawableArray.get(0));
                mImageView2.setImageResource(tabDrawableArray.get(1));
                mImageView3.setImageResource(tabDrawableArray.get(2));
                mImageView4.setImageResource(tabDrawableArray.get(3));
                mImageView5.setImageResource(tabDrawableArray.get(4));
                mTab3.setVisibility(View.VISIBLE);
                mTab4.setVisibility(View.VISIBLE);
                mTab5.setVisibility(View.VISIBLE);
                mTab1.setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        mOnTabSelectedListener.onTabSelected(0);

                        mTab1.setPadding(dp12, dp6, dp12, dp10);
                        mTextView1.setTextSize(14);

                        mTab2.setPadding(dp12, dp8, dp12, dp10);
                        mTextView2.setTextSize(12);

                        mTab3.setPadding(dp12, dp8, dp12, dp10);
                        mTextView3.setTextSize(12);

                        mTab4.setPadding(dp12, dp8, dp12, dp10);
                        mTextView4.setTextSize(12);

                        mTab5.setPadding(dp12, dp8, dp12, dp10);
                        mTextView5.setTextSize(12);
                    }
                });
                mTab2.setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        mOnTabSelectedListener.onTabSelected(1);

                        mTab1.setPadding(dp12, dp8, dp12, dp10);
                        mTextView1.setTextSize(12);

                        mTab2.setPadding(dp12, dp6, dp12, dp10);
                        mTextView2.setTextSize(14);

                        mTab3.setPadding(dp12, dp8, dp12, dp10);
                        mTextView3.setTextSize(12);

                        mTab4.setPadding(dp12, dp8, dp12, dp10);
                        mTextView4.setTextSize(12);

                        mTab5.setPadding(dp12, dp8, dp12, dp10);
                        mTextView5.setTextSize(12);
                    }
                });
                mTab3.setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        mOnTabSelectedListener.onTabSelected(2);
                        mTab1.setPadding(dp12, dp8, dp12, dp10);
                        mTextView1.setTextSize(12);

                        mTab2.setPadding(dp12, dp8, dp12, dp10);
                        mTextView2.setTextSize(12);

                        mTab3.setPadding(dp12, dp6, dp12, dp10);
                        mTextView3.setTextSize(14);

                        mTab4.setPadding(dp12, dp8, dp12, dp10);
                        mTextView4.setTextSize(12);

                        mTab5.setPadding(dp12, dp8, dp12, dp10);
                        mTextView5.setTextSize(12);
                    }
                });
                mTab4.setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        mOnTabSelectedListener.onTabSelected(3);
                        mTab1.setPadding(dp12, dp8, dp12, dp10);
                        mTextView1.setTextSize(12);

                        mTab2.setPadding(dp12, dp8, dp12, dp10);
                        mTextView2.setTextSize(12);

                        mTab3.setPadding(dp12, dp8, dp12, dp10);
                        mTextView3.setTextSize(12);

                        mTab4.setPadding(dp12, dp6, dp12, dp10);
                        mTextView4.setTextSize(14);

                        mTab5.setPadding(dp12, dp8, dp12, dp10);
                        mTextView4.setTextSize(12);

                    }
                });
                mTab5.setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        mOnTabSelectedListener.onTabSelected(4);
                        mTab1.setPadding(dp12, dp8, dp12, dp10);
                        mTextView1.setTextSize(12);

                        mTab2.setPadding(dp12, dp8, dp12, dp10);
                        mTextView2.setTextSize(12);

                        mTab3.setPadding(dp12, dp8, dp12, dp10);
                        mTextView3.setTextSize(12);

                        mTab4.setPadding(dp12, dp8, dp12, dp10);
                        mTextView4.setTextSize(12);

                        mTab5.setPadding(dp12, dp6, dp12, dp10);
                        mTextView5.setTextSize(14);
                    }
                });
                break;
            default:
                break;
        }
    }

    private OnTabSelectedListener mOnTabSelectedListener;

    public interface OnTabSelectedListener {
        void onTabSelected(int position);

    }

    public void setTabSelectedListener(OnTabSelectedListener onTabSelectedListener) {
        mOnTabSelectedListener = onTabSelectedListener;
    }

    private int dp2px(int padding_in_dp) {
        final float scale = getResources().getDisplayMetrics().density;
        return (int) (padding_in_dp * scale + 0.5f);
    }

}
