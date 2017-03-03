package com.example.administrator.denglu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


public class MainActivity extends AppCompatActivity implements TitleBarClickListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // 隐藏标题栏
//        getSupportActionBar().hide();

    }

    @Override
    public void leftClick() {
        
    }

    @Override
    public void rightClick() {

    }
}