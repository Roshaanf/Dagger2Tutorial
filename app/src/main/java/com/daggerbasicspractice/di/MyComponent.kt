package com.daggerbasicspractice.di

import com.daggerbasicspractice.MainActivity
import dagger.Component
import javax.inject.Singleton

@MyScope
@Component(modules = [MyModule::class])
interface MyComponent {
    fun inject(mainActivity: MainActivity)

    fun addMySubComponent(): MySubComponent
}