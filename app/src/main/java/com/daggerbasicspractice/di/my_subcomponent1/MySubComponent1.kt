package com.daggerbasicspractice.di.my_subcomponent1

import com.daggerbasicspractice.BuildSubComponent1
import com.daggerbasicspractice.di.MySubComponentScope
import com.daggerbasicspractice.di.my_subcomponent3.MySubComponent3
import dagger.Subcomponent

@MySubComponentScope
@Subcomponent(modules = [MySubComponent1Module::class])
interface MySubComponent1 {
    fun inject(buildSubComponent: BuildSubComponent1)
}