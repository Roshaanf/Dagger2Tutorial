package com.daggerbasicspractice.di

import com.daggerbasicspractice.SampleCommonDependency
import dagger.Module
import dagger.Provides

@Module
object MainActivityModule {

    @JvmStatic
    @MainActivityScope
    @Provides
    fun provideSampleClass() = SampleCommonDependency(8)

}