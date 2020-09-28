package com.example.superfilms.home
import dagger.Module
import dagger.Provides

@Module
class HomeModule {

    @Provides
    fun provideHomeActivityPresenter(model: HomeActivityMVP.Model) : HomeActivityMVP.Presenter {
        return HomeActivityPresenter(model)
    }

    @Provides
    fun provideHomeActivityModel(): HomeActivityMVP.Model {
        return HomeActivityModel()
    }
}