package com.example.superfilms.root

import android.app.Application
import com.example.superfilms.home.HomeModule
import com.example.superfilms.root.DaggerApplicationComponent.*

class App : Application() {

    companion object {
        lateinit var component: ApplicationComponent
    }

    override fun onCreate() {
        super.onCreate()

        component = builder()
            .applicationModule(ApplicationModule(this))
            .homeModule(HomeModule())
            .build()
    }

    fun getComponent() : ApplicationComponent {
        return component
    }

}