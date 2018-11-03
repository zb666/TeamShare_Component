package com.example.mechrevo.teamshare_component

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.moudle_a.MoudleA_Activity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var intent = Intent()
        intent.setClass(this,MoudleA_Activity::class.java)
        startActivity(intent)
    }

}
