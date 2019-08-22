package com.daggerbasicspractice.di

import android.content.Context
import com.daggerbasicspractice.SampleClass1
import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module
object MyModule {

    @JvmStatic
    @Provides
    @MyScope
    fun provideSampleClass() = SampleClass1(8)

}