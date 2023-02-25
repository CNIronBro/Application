package com.example.chapter03;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.chapter03.util.DateUtil;

public class ButtonClickActivity extends AppCompatActivity implements View.OnClickListener{


    private TextView tv_result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button_click);

        tv_result = findViewById(R.id.tv_result);

        //单独的点击监听
        Button btn_click_single = findViewById(R.id.btn_click_single);
        btn_click_single.setOnClickListener(new MyOnClickListener(tv_result));

        //公共的点击监听
        Button btn_click_public = findViewById(R.id.btn_click_public);
        btn_click_public.setOnClickListener(this);

        //长按
        Button btn_long_click = findViewById(R.id.btn_long_click);
        btn_long_click.setOnLongClickListener(new View.OnLongClickListener() {  //匿名内部类
            @Override
            public boolean onLongClick(View view) {
                return ;
            }
        });

    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.btn_click_public){
            String desc = String.format("%s 点击了按钮：%s", DateUtil.getNowTime(),((Button)view).getText());
            tv_result.setText(desc);
        }
    }

    static class MyOnClickListener implements View.OnClickListener{

        private final TextView tv_result;

        public MyOnClickListener(TextView tv_result) {
            this.tv_result = tv_result;
        }

        @Override
        public void onClick(View view) {
            String desc = String.format("%s 点击了按钮：%s", DateUtil.getNowTime(),((Button)view).getText());
            tv_result.setText(desc);
        }
    }
}