package com.daggerbasicspractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.daggerbasicspractice.di.DaggerMyComponent
import com.daggerbasicspractice.di.MyComponent
import com.daggerbasicspractice.di.my_subcomponent1.MySubComponent1
import com.daggerbasicspractice.di.my_subcomponent3.MySubComponent3
import com.daggerbasicspractice.di.my_subcomponent3.MySubComponent3Module
import com.daggerbasicspractice.di.my_subcomponent_2.MySubComponent2
import com.daggerbasicspractice.di.my_subcomponent_2.MySubComponent2Module
import javax.inject.Inject
import javax.inject.Named

class MainActivity : AppCompatActivity() {


    lateinit var myComponent: MyComponent

    @Inject
    lateinit var subComponent3Builder: MySubComponent3.Builder

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        myComponent = DaggerMyComponent
            .builder()
            .build()

        myComponent.inject(this)

        BuildSubComponent1(myComponent)
        BuildSubComponent2(myComponent)
        BuildSubComponent3(subComponent3Builder)

    }


}

class BuildSubComponent1 constructor(myComponent: MyComponent) {

    @Inject
    lateinit var a: Integer

    init {
        var subComponent = myComponent.addMySubComponent1()

        subComponent.inject(this)

        println("SUBCOMPONENT 1 ${a}")
    }
}

class BuildSubComponent2 constructor(myComponent: MyComponent) {
    @Inject
    lateinit var a: String

    init {
        var subComponent = myComponent.mySubComponent2Builder()
            .mySubComponent2Module(MySubComponent2Module())
            .build()

        subComponent.inject(this)

        println("SUBCOMPONENT 2 ${a}")
    }
}

class BuildSubComponent3 constructor(myComponent: MySubComponent3.Builder) {


    @Inject
    lateinit var a: String


    init {

        myComponent
            .mySubComponent3Module(MySubComponent3Module())
            .build()
            .inject(this)

        println("SUBCOMPONENT 3 ${a}")
    }
}
