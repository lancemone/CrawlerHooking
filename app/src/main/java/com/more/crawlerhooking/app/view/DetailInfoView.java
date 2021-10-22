package com.more.crawlerhooking.app.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.more.crawlerhooking.R;

public class DetailInfoView extends LinearLayout {

    private String mTitleText;
    private float mTitleTextSize;
    private int mTitleTextColor;
    private String mContentText;
    private float mContentTextSize;
    private int mContentTextColor;
    private TextView titleView;
    private TextView contentView;

    public DetailInfoView(Context context) {
        super(context);
        initView(context);
    }

    public DetailInfoView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initAttr(context, attrs);
        initView(context);
    }

    public DetailInfoView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initAttr(context, attrs);
        initView(context);
    }

    private void initView(Context context){
        View.inflate(context, R.layout.view_detail_info, this);
        titleView = this.findViewById(R.id.view_detail_info_title);
        contentView = this.findViewById(R.id.view_detail_info_content);
        titleView.setText(mTitleText);
        titleView.setTextColor(mTitleTextColor);
        titleView.setTextSize(mTitleTextSize);
        contentView.setText(mContentText);
        contentView.setTextColor(mContentTextColor);
        contentView.setTextSize(mContentTextSize);
    }

    private void initAttr(Context context, AttributeSet attributeSet){
        TypedArray typedArray = context.obtainStyledAttributes(attributeSet, R.styleable.DetailInfoView);
        mTitleText = typedArray.getString(R.styleable.DetailInfoView_title);
        mTitleTextColor = typedArray.getColor(R.styleable.DetailInfoView_titleTextColor, Color.BLACK);
        mTitleTextSize = typedArray.getDimension(R.styleable.DetailInfoView_titleTextSize, 16);
        mContentText = typedArray.getString(R.styleable.DetailInfoView_contentText);
        mContentTextColor = typedArray.getColor(R.styleable.DetailInfoView_contentTextColor, Color.GRAY);
        mContentTextSize = typedArray.getDimension(R.styleable.DetailInfoView_contentTextSize, 10);
        typedArray.recycle();
    }

    public void setTitle(String title){
        titleView.setText(title);
    }

    public void setTitleTextColor(int color){
        titleView.setTextColor(color);
    }

    public void setTitleTextSize(float size){
        titleView.setTextSize(size);
    }

    public void setContent(String content){
        contentView.setText(content);
    }

    public void setContentTextSize(float size){
        contentView.setTextSize(size);
    }

    public void setContentTextColor(int color) {
        contentView.setTextColor(color);
    }
}
