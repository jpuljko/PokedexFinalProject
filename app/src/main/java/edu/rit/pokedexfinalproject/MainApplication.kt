package edu.rit.pokedexfinalproject

import android.app.Application
import edu.rit.pokedexfinalproject.module.appModule
import org.koin.core.context.startKoin


class MainApplication: Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin{
            modules(listOf(appModule))
        }
    }

}