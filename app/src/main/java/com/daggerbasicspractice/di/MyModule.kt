package com.daggerbasicspractice.di

import android.content.Context
import com.daggerbasicspractice.SampleClass1
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Named

@Module
@InstallIn(ActivityComponent::class)
object MyModule {

    @JvmStatic
    @Provides
    @ActivityScoped
    fun provideSampleClass() = SampleClass1(8)

}