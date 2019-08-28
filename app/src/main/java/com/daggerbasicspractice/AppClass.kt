package com.daggerbasicspractice

import android.app.Application
import com.daggerbasicspractice.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

class AppClass :
    Application(),
    HasAndroidInjector {

    /*
    * Dispatching android injector facilitates injection of android specific classes
    * such as activities fragments and broadcast receivers
    * */
    @Inject
    lateinit var androidInjector: DispatchingAndroidInjector<Any>

    override fun onCreate() {
        super.onCreate()

        DaggerAppComponent
            .factory()
            .create(this)
            .inject(this)

    }

    override fun androidInjector(): AndroidInjector<Any> = androidInjector
}