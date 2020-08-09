package com.daggerbasicspractice.di.my_subcomponent_2

import com.daggerbasicspractice.di.MySubComponentScope
import dagger.Module
import dagger.Provides

//below object code is comment out to show how module will be created
@Module
class MySubComponent2Module {

    @MySubComponentScope
    @Provides
    fun provideString() = "name"
}

//@Module
//object MySubComponent2Module {
//
//    @MySubComponentScope
//    @Provides
//    @JvmStatic
//    fun provideString() = "name"
//}