package com.daggerbasicspractice

import android.app.Application
import com.daggerbasicspractice.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

class AppClass :
    DaggerApplication() {
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> =
        DaggerAppComponent
        .factory()
        .create(this)


    override fun onCreate() {
        super.onCreate()

        DaggerAppComponent
            .factory()
            .create(this)
            .inject(this)

    }

}