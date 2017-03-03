package com.example.administrator.denglu;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;


/**
 * Created by Hankkin on 15/10/23.
 */

public class TitleBarView extends RelativeLayout {

    private String title;   //标题文字
    private String leftBtnText;     //左侧按钮文字
    private String rightBtnText;    //右侧按钮文字
    private int titleTextColor;   //标题文字颜色
    private Drawable leftBtnBackground; //左侧按钮背景
    private Drawable rightBtnBackground;    //右侧按钮背景
    private float leftBtnTextSize;  //左侧文字大小
    private float titleTextSize;    //标题文字大小
    private float rightBtnTextSize; //右侧文字大小
    private Button leftBtn; //左侧按钮控件
    private Button rightBtn;    //右侧按钮控件
    private TextView titleTv;   //标题文本控件
    private RelativeLayout.LayoutParams leftParams;  //左侧控件布局参数
    private RelativeLayout.LayoutParams rightParams; //右侧控件布局参数
    private RelativeLayout.LayoutParams titleParams; //标题文本布局参数
    public TitleBarClickListener listener;

    public TitleBarView(Context context) {
        super(context);
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    public TitleBarView(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.Title_bar);
        init(context, typedArray);
    }

    /**
     * 初始化参数，获取属性值
     *
     * @param context 上下文
     * @param ta
     */

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    private void init(Context context, TypedArray ta) {
        title = ta.getString(R.styleable.Title_bar_titleText);
        leftBtnText = ta.getString(R.styleable.Title_bar_leftBtnText);
        leftBtnBackground = ta.getDrawable(R.styleable.Title_bar_leftBtnBackground);
        rightBtnText = ta.getString(R.styleable.Title_bar_rightBtnText);
        rightBtnBackground = ta.getDrawable(R.styleable.Title_bar_rightBtnBackground);
        titleTextSize = ta.getDimension(R.styleable.Title_bar_titleTextSize, 10);
        leftBtnTextSize = ta.getDimension(R.styleable.Title_bar_leftBtnTextSize, 8);
        rightBtnTextSize = ta.getDimension(R.styleable.Title_bar_rightBtnTextSize, 8);
        titleTextColor = ta.getColor(R.styleable.Title_bar_titleColor, 0);
        ta.recycle();

        titleTv = new TextView(context);
        leftBtn = new Button(context);
        rightBtn = new Button(context);
        /*设置标题文本*/
        titleTv.setTextSize(titleTextSize);
        titleTv.setText(title);
        titleTv.setTextColor(titleTextColor);
        /*设置左侧按钮*/
        leftBtn.setText(leftBtnText);
        leftBtn.setTextSize(leftBtnTextSize);
        leftBtn.setBackground(leftBtnBackground);
        /*设置右侧按钮*/
        rightBtn.setText(rightBtnText);
        rightBtn.setTextSize(rightBtnTextSize);
        rightBtn.setBackground(rightBtnBackground);
        /*设置控件参数*/
        leftParams = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT);
        leftParams.addRule(ALIGN_PARENT_LEFT, TRUE);
        addView(leftBtn, leftParams);
        rightParams = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT);
        rightParams.addRule(ALIGN_PARENT_RIGHT, TRUE);
        addView(rightBtn, rightParams);
        titleParams = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT);
        titleParams.addRule(CENTER_IN_PARENT, TRUE);
        titleParams.addRule(CENTER_VERTICAL);
        addView(titleTv, titleParams);

        leftBtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.leftClick();
            }
        });
        rightBtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.rightClick();
            }
        });

    }


    /**
     * 通过接口来获得回调者对接口的实现
     *
     * @param listener
     */
    public void setOnTitleBarClickListener(TitleBarClickListener listener) {

        this.listener = listener;
    }


    /**
     * 设置左侧按钮是否可见
     *
     * @param flag 是否可见
     */
    public void setLeftBtnVisable(boolean flag) {
        if (flag) {
            leftBtn.setVisibility(VISIBLE);
        } else {
            leftBtn.setVisibility(GONE);
        }
    }

    /**
     * 设置右侧按钮是否可见
     *
     * @param flag 是否可见
     */
    public void setRightBtnVisable(boolean flag) {
        if (flag) {
            rightBtn.setVisibility(VISIBLE);
        } else {
            rightBtn.setVisibility(GONE);
        }
    }

}