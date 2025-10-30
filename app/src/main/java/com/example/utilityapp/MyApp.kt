package com.example.utilityapp

import android.app.Application

//import com.example.image_preview.utils.NetworkMonitor

class MyApp: Application() {

    override fun onCreate() {
        super.onCreate()
//        NetworkMonitor.startMonitoring(this)
    }
}