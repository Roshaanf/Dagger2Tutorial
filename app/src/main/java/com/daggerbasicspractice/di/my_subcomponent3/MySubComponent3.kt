package com.daggerbasicspractice.di.my_subcomponent3

import com.daggerbasicspractice.BuildSubComponent2
import com.daggerbasicspractice.BuildSubComponent3
import com.daggerbasicspractice.di.MySubComponentScope
import com.daggerbasicspractice.di.my_subcomponent_2.MySubComponent2
import com.daggerbasicspractice.di.my_subcomponent_2.MySubComponent2Module
import dagger.Subcomponent

@MySubComponentScope
@Subcomponent(modules = [MySubComponent3Module::class])
interface MySubComponent3 {
    fun inject(buildSubComponent3: BuildSubComponent3)

    @Subcomponent.Builder
    interface Builder {
        fun mySubComponent3Module(module: MySubComponent3Module): Builder
        fun build(): MySubComponent3

    }
}