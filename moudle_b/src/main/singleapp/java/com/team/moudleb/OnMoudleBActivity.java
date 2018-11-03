package com.team.moudleb;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.dongnao.module2.R;

//成为一个单独的app的时候
public class OnMoudleBActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mooudleb);
        TextView tvBBB = findViewById(R.id.tvOnMoudleB);
        tvBBB.setText(getResources().getString(R.string.app_moudleb));

    }
}
