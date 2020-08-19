package com.daggerbasicspractice.di

import com.daggerbasicspractice.SampleClass5
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn

@InstallIn(CustomComponent::class)
@Module
object CustomModule {

    @JvmStatic
    @Provides
    fun provideSampleClass5() = SampleClass5()
}