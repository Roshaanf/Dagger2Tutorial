package com.daggerbasicspractice.di

import com.daggerbasicspractice.MainActivity
import dagger.Binds
import dagger.Module
import dagger.android.AndroidInjector
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap

@Module(subcomponents = [MainActivityComponent::class])
abstract class ActivityBuilderModule {

//    this will tell dagger that main activity is injectable
    @Binds
    @IntoMap
    @ClassKey(MainActivity::class)
    abstract fun bindMainActivity(builder: MainActivityComponent.Factory): AndroidInjector.Factory<*>

}