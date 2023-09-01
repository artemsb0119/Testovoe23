package com.example.testovoe23

import android.app.Application
import com.onesignal.OneSignal

const val ONESIGNAL_APP_ID = "11ed44ff-d47d-4524-a00d-f1880aca0b16"

class ApplicationClass : Application() {
    override fun onCreate() {
        super.onCreate()

        // Logging set to help debug issues, remove before releasing your app.
        OneSignal.setLogLevel(OneSignal.LOG_LEVEL.VERBOSE, OneSignal.LOG_LEVEL.NONE)

        // OneSignal Initialization
        OneSignal.initWithContext(this)
        OneSignal.setAppId(ONESIGNAL_APP_ID)
    }
}