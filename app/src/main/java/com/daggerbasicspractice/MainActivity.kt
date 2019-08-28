package com.daggerbasicspractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.daggerbasicspractice.di.DaggerMyComponent
import com.daggerbasicspractice.di.DaggerMySecondComponent
import com.daggerbasicspractice.di.MyComponent
import com.daggerbasicspractice.di.MySubComponent
import javax.inject.Inject
import javax.inject.Named

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var sampleClass: SampleClass1

    lateinit var myComponent: MyComponent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        myComponent = DaggerMyComponent
            .builder()
            .build()

        myComponent.inject(this)
        println("sample Class1 " + sampleClass)

        BuildSubComponent(myComponent)

    }


}

class BuildSubComponent constructor(myComponent: MyComponent) {

    lateinit var sampleClass1: SampleClass1
    @Inject
    lateinit var sampleClass2: SampleClass2

    init {
        var subComponent = myComponent.addMySubComponent()

        subComponent.inject(this)

        println("sample Class1 " + sampleClass1)
        println("sample Class2 " + sampleClass2)

        BuildSecondComponent(subComponent)
    }
}

class BuildSecondComponent constructor(mySubComponent: MySubComponent) {

    @Inject
    lateinit var sampleClass1: SampleClass1

    init {
        DaggerMySecondComponent
            .builder()
            .mySubComponent(mySubComponent)
            .build()
            .inject(this)

        println("sample Class1 " + sampleClass1)
    }
}
