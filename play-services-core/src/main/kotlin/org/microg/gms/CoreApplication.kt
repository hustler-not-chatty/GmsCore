package org.microg.gms

import androidx.multidex.MultiDexApplication
import com.google.android.material.color.DynamicColors

class CoreApplication : MultiDexApplication() {
    override fun onCreate() {
        super.onCreate()
        DynamicColors.applyToActivitiesIfAvailable(this)
    }
}