package com.daggerbasicspractice.di

import com.daggerbasicspractice.SampleFirstFragmentDependency
import dagger.Module
import dagger.Provides

@Module
object FirstFragmentModule {

    @JvmStatic
    @Provides
    @FirstFragmentScope
    fun provideSampleDependency() = SampleFirstFragmentDependency("start")
}