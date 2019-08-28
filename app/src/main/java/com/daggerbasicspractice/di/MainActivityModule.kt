package com.daggerbasicspractice.di

import com.daggerbasicspractice.SampleClass
import dagger.Module
import dagger.Provides

@Module
object MainActivityModule {

    @JvmStatic
    @MainActivityScope
    @Provides
    fun provideSampleClass() = SampleClass(8)

}