package com.mesutemre.androidjetpackroom

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class AndroidJetpackRoomApplication: Application() {

    override fun onCreate() {
        super.onCreate()
    }
}