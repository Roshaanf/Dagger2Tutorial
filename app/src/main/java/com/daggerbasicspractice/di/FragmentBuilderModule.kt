package com.daggerbasicspractice.di

import com.daggerbasicspractice.FirstFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentBuilderModule {

    @ContributesAndroidInjector(modules = [FirstFragmentModule::class])
    @FirstFragmentScope
    abstract fun bindFirstFragment(): FirstFragment

}