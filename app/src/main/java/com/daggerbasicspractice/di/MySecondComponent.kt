package com.daggerbasicspractice.di

import com.daggerbasicspractice.BuildSecondComponent
import dagger.Component

@MySecondComponentScope
@Component(dependencies = [MySubComponent::class])
interface MySecondComponent {
    fun inject(buildSecondComponent: BuildSecondComponent)
}