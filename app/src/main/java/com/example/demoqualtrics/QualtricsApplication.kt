package com.example.demoqualtrics

import android.app.Application
import com.qualtrics.digital.Qualtrics
import com.qualtrics.digital.QualtricsLogLevel

class QualtricsApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        initializeQualtrics()
    }

    private fun initializeQualtrics() {
        Qualtrics.instance().setLogLevel(QualtricsLogLevel.INFO)
        Qualtrics.instance().initializeProject(
            Constants.BRAND_ID,
            Constants.PROJECT_ID,
            Constants.INTERCEPT_ID,
            applicationContext
        )
    }
}