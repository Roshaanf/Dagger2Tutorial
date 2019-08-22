package com.daggerbasicspractice.di

import com.daggerbasicspractice.BuildSubComponent
import com.daggerbasicspractice.SampleClass1
import dagger.Subcomponent

@MySubComponentScope
@Subcomponent
interface MySubComponent {
    fun inject(buildSubComponent: BuildSubComponent)

    fun getSampleClass1(): SampleClass1
}