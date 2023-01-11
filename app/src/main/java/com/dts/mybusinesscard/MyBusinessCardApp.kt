package com.dts.mybusinesscard

import android.app.Application
import com.dts.mybusinesscard.di.app
import com.dts.mybusinesscard.di.viewModels
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.context.startKoin
import org.koin.core.logger.Level
import timber.log.Timber

class MyBusinessCardApp: Application() {

    override fun onCreate() {
        super.onCreate()
        setupDI()
        Timber.plant(Timber.DebugTree())
    }

    private fun setupDI() {
        startKoin {
            androidLogger(Level.ERROR)
            androidContext(this@MyBusinessCardApp)
            modules(app, viewModels)
        }
    }
}