package com.daggerbasicspractice.di

import com.daggerbasicspractice.MainActivity
import com.daggerbasicspractice.di.my_subcomponent1.MySubComponent1
import com.daggerbasicspractice.di.my_subcomponent_2.MySubComponent2
import dagger.Component

@MyScope
@Component(modules = [MyModule::class])
interface MyComponent {
    fun inject(mainActivity: MainActivity)

    fun addMySubComponent1(): MySubComponent1
    fun mySubComponent2Builder(): MySubComponent2.Builder
}