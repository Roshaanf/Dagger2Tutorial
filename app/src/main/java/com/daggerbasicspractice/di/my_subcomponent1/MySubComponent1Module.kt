package com.daggerbasicspractice.di.my_subcomponent1

import com.daggerbasicspractice.di.MySubComponentScope
import dagger.Module
import dagger.Provides

//below object code is comment out to show how module will be created
@Module
class MySubComponent1Module {

    @MySubComponentScope
    @Provides
    fun provideInt() = 9
}

//@Module
//object MySubComponent1Module {
//
//    @MySubComponentScope
//    @Provides
//    @JvmStatic
//    fun provideInt() = 9
//}