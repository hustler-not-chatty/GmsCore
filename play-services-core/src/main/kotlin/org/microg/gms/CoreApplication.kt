package org.microg.gms

import android.app.Application
import com.google.android.material.color.DynamicColors

class CoreApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        DynamicColors.applyToActivitiesIfAvailable(this)
    }
}