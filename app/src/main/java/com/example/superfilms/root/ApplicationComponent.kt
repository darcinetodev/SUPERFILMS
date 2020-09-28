package com.example.superfilms.root

import com.example.superfilms.home.HomeActivity
import com.example.superfilms.home.HomeModule
import com.example.superfilms.repository.FilmModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ApplicationModule::class, HomeModule::class, FilmModule::class])
interface ApplicationComponent {
    fun inject(target: HomeActivity)
}