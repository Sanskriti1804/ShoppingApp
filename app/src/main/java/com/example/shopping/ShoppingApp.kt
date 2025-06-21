package com.example.shopping

import android.app.Application
import com.example.shopping.di.authModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class ShoppingApp : Application(){
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@ShoppingApp)
            modules(authModule)
        }
    }
}