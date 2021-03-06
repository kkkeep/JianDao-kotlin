package com.mr.k.mvp.widget.bottomtab;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

/*
 * created by Cherry on 2020-01-06
 **/
public class BottomTab extends LinearLayout {

    private OnClickListener onClickListener;
    private TabIcon mIcon;
    private TextView mTitle;


    public BottomTab(Context context) {
        super(context);
    }

    public BottomTab(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public BottomTab(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    public void setOnClickListener(@Nullable OnClickListener l) {
        super.setOnClickListener(l);
        onClickListener = l;
    }


    public OnClickListener getOnClickListener() {
        return onClickListener;
    }

    public void select(boolean select) {
      //加入当期那tab 已经是选中状态了，外面再次调用该方法并且传入 true,那么是不是没有必要在改变状态。
        if (mIcon.isChecked() == select) {
            return;
        }


        mIcon.setChecked(select);

        if (select) {
            mTitle.setTextColor(Color.BLACK);

        } else {
            mTitle.setTextColor(Color.GRAY);
        }

    }

    public void setTitle(String title) {
        mTitle.setText(title);
    }

    public boolean isSelect() {
        return mIcon.isChecked();
    }


    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        View child;
        for (int i = 0; i < getChildCount(); i++) {
            child = getChildAt(i);
            if (child instanceof ImageView) {
                mIcon = (TabIcon) child;
            } else {
                mTitle = (TextView) child;
            }
        }
    }
}
