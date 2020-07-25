package com.gnova.stackexchange_userapp.di

import android.content.Context
import com.gnova.stackexchange_userapp.di.modules.ApiModule
import com.gnova.stackexchange_userapp.di.modules.AppModule
import com.gnova.stackexchange_userapp.ui.home.HomeActivity
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(modules = [AppModule::class, ApiModule::class])
interface AppComponent {

    // Factory to create instances of the AppComponent
    @Component.Factory
    interface Factory {
        // With @BindsInstance, the Context passed in will be available in the graph
        fun create(@BindsInstance context: Context): AppComponent
    }

    fun inject(activity: HomeActivity)

}