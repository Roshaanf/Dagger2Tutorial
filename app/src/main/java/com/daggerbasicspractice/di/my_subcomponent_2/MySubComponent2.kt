package com.daggerbasicspractice.di.my_subcomponent_2

import com.daggerbasicspractice.BuildSubComponent1
import com.daggerbasicspractice.BuildSubComponent2
import com.daggerbasicspractice.di.MySubComponentScope
import dagger.Subcomponent

@MySubComponentScope
@Subcomponent(modules = [MySubComponent2Module::class])
interface MySubComponent2 {
    fun inject(buildSubComponent2: BuildSubComponent2)

    @Subcomponent.Builder
    interface Builder {
        fun mySubComponent2Module(module: MySubComponent2Module): Builder
        fun build(): MySubComponent2

    }
}