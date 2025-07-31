package org.acad.messengerapp.app

import android.app.Application
import org.acad.messengerapp.di.appModule
import org.acad.messengerapp.di.localModule
import org.acad.messengerapp.di.remoteModule
import org.acad.messengerapp.di.repoModule
import org.acad.messengerapp.di.useCaseModule
import org.acad.messengerapp.di.vmModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

/**
 * Created by Acad Bek on 7/31/2025
 */
class App : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@App)
            modules(
                repoModule,
                useCaseModule,
                localModule,
                remoteModule,
                vmModule,
                appModule
            )
        }
    }
}