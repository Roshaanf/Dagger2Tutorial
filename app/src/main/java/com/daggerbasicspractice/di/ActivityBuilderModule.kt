package com.daggerbasicspractice.di

import com.daggerbasicspractice.MainActivity
import dagger.Binds
import dagger.Module
import dagger.android.AndroidInjector
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap

@Module
abstract class ActivityBuilderModule {

    /*
        this will tell dagger that MainActivity is injectable,
        behind the scene dagger will create a subcomponent assign MainActivityModule to that
        subcomponent and will create Component.Factory inside that subcomponent and then will add
        that Component.Factory to multi bindings, same procedure we did before using ContributesAndroidInjector
        dagger will perform itself
     */
    @ContributesAndroidInjector(modules = [MainActivityModule::class, FragmentBuilderModule::class])
    @MainActivityScope
    abstract fun bindMainActivity(): MainActivity

}