package com.daggerbasicspractice.di

import com.daggerbasicspractice.SampleClass4
import dagger.BindsInstance
import dagger.hilt.DefineComponent
import dagger.hilt.android.components.ApplicationComponent

//Custom componet can only be build via @EntryPoint
@DefineComponent(parent = ApplicationComponent::class)
interface CustomComponent {
}

//REASON for putting builder outside componente
//Since the @DefineComponent class is referenced in many places via @InstallIn,
// it may be better to separate the builder so that dependencies in the builder do not
// become transitive dependencies of every module installed in the component.
@DefineComponent.Builder
interface CustomComponentBuilder {
    fun sampleClass4(@BindsInstance  dep:SampleClass4): CustomComponentBuilder
    fun build(): CustomComponent
}