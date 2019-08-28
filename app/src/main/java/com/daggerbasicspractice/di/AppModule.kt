package com.daggerbasicspractice.di

import android.app.Activity
import com.daggerbasicspractice.MainActivity
import dagger.Binds
import dagger.Module
import dagger.android.AndroidInjector
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap

@Module()
abstract class AppModule