package com.example.moudle_b;

import android.app.Application;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.mediacompat.BuildConfig;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;

@Route(path = "/moudle_b/ActivityB")
public class ActivityB extends AppCompatActivity {
    //method
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);
        TextView textView = findViewById(R.id.tvB);
        textView.setText("成为一个Moudle的时候");
//        if (BuildConfig.isMoudle){
//            //单独作为模块的时候 str ->a c d
//        }else{
//            //app
//            //从自己的res 或者common
//        }
    }
}
