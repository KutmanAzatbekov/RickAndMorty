package com.geeks.rickandmorty

import android.app.Application
import com.geeks.character.data.di.characterDataModule
import com.geeks.character.domain.di.characterDomainModule
import com.geeks.character.ui.di.characterUiModule
import com.geeks.episode.ui.di.episodeUiModule
import com.geeks.episode.data.di.episodeDataModule
import com.geeks.episode.domain.di.episodeDomainModule
import com.geeks.rickandmorty.core.network.di.networkModule

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
                characterDataModule, characterDomainModule, networkModule, characterUiModule,
                episodeDataModule, episodeDomainModule, episodeUiModule
            )
        }
    }

}