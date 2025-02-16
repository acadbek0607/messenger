package org.acad.messenger.app

import android.app.Application
import org.acad.messenger.di.apiModule
import org.acad.messenger.di.appModule
import org.acad.messenger.di.repoModule
import org.acad.messenger.di.storeModule
import org.acad.messenger.di.useCaseModule
import org.acad.messenger.di.vmModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.logger.AndroidLogger
import org.koin.core.context.startKoin

/**
 * Created by Acad Bek on 2/15/2025
 */
class App : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            AndroidLogger()
            androidContext(this@App)
            modules(
                appModule,
                repoModule,
                useCaseModule,
                storeModule,
                apiModule,
                vmModule
            )
        }
    }
}