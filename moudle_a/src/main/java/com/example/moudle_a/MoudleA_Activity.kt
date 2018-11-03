package com.example.moudle_a

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter

@Route(path = "/moudle_a/MoudleA_Activity")
class MoudleA_Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_moudle_a_)
        var tvJumpB = findViewById<TextView>(R.id.textview)

        tvJumpB.setOnClickListener {
            ARouter.getInstance().build("/moudle_b/ActivityB")
                    .navigation()
        }
    }
}
