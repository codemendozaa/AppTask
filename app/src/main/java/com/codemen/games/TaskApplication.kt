package com.codemen.games

import android.app.Application
import com.codemen.games.di.taskModules
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

/**
 ** create by ErixJavier on  26/04/20.
 */
class TaskApplication:Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(taskModules)
            androidContext(this@TaskApplication)
        }
    }

}

