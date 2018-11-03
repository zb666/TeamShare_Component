package com.example.mechrevo.teamshare_component

import android.app.Application
import com.alibaba.android.arouter.launcher.ARouter

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG){
            ARouter.openLog()
            ARouter.openDebug()
        }
        ARouter.init(this)
    }
}