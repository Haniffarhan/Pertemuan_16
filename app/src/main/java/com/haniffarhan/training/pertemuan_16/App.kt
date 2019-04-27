package com.haniffarhan.training.pertemuan_16

import android.app.Application
import com.haniffarhan.training.pertemuan_16.di.AppComponent

class App : Application() {
    companion object{
        @JvmStatic lateinit var appcomponent : AppComponent
    }

    override fun onCreate() {
        super.onCreate()
        appcomponent = AppComponent.create(this, "https://api.bol.com/")
    }
}