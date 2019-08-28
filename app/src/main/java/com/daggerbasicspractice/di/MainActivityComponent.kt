package com.daggerbasicspractice.di

import com.daggerbasicspractice.MainActivity
import dagger.BindsInstance
import dagger.Component
import dagger.Subcomponent
import dagger.android.AndroidInjector
import dagger.android.ContributesAndroidInjector

@MainActivityScope
@Subcomponent(modules = [MainActivityModule::class])
interface MainActivityComponent : AndroidInjector<MainActivity> {

    /*
    *  Factory can not have any method for binding instances this is the drawback of using
    *  Subcomponent.Factory with dagger.android, if you want bind instances then dont use android.dagger
    *  way for creating subcomponent(i.e assing subcomponet to module) instead use normal Factory method in
    *  parent component and return subcomponent from it.
     */
    @Subcomponent.Factory
    abstract class Factory : AndroidInjector.Factory<MainActivity> {
    }
}