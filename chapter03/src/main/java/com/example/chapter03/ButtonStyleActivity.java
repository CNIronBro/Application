package com.example.chapter03;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.chapter03.util.DateUtil;

public class ButtonStyleActivity extends AppCompatActivity {

    private TextView tv_result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button_style);
        tv_result = findViewById(R.id.tv_result);
    }

    public void doClick(View view){

        //View是Button的父类，View不具有获取文本的能力，先将view强制转换为Button类型后再获取按钮上的文本
        String desc = String.format("%s 点击了按钮：%s", DateUtil.getNowTime(),((Button)view).getText());
        tv_result.setText(desc);
    }
}