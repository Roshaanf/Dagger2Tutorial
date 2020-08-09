package com.daggerbasicspractice.di.my_subcomponent3

import com.daggerbasicspractice.di.MySubComponentScope
import dagger.Module
import dagger.Provides

//below object code is comment out to show how module will be created
@Module
class MySubComponent3Module {

    @MySubComponentScope
    @Provides
    fun provideString() = "component3"

}

//@Module
//object MySubComponent3Module {
//
//    @MySubComponentScope
//    @Provides
//    @JvmStatic
//    fun provideBoolean() = true
//
//}