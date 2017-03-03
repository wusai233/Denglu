package com.example.administrator.denglu;

/**
 * 定义按钮点击接口，实现回调机制，通过映射的接口对象调用接口中的方法
 * 而不用去考虑如何实现，具体实现由调用者去创建
 */
public interface TitleBarClickListener {
    void leftClick();   //左侧按钮点击事件

    void rightClick();  //右侧按钮点击事件
}