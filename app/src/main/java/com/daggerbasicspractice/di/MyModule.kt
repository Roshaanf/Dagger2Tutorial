package com.daggerbasicspractice.di

import android.content.Context
import com.daggerbasicspractice.di.my_subcomponent1.MySubComponent1
import com.daggerbasicspractice.di.my_subcomponent3.MySubComponent3
import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module(subcomponents = [MySubComponent3::class])
object MyModule {

}