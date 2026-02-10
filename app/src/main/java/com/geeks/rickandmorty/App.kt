package com.geeks.rickandmorty

import android.app.Application
import com.geeks.rickandmorty.data.di.dataModule
import com.geeks.rickandmorty.domain.di.domainModule
import com.geeks.rickandmorty.network.di.networkModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class App: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            androidLogger(level = Level.DEBUG)

            modules(
                dataModule, domainModule, networkModule
            )
        }
    }

}