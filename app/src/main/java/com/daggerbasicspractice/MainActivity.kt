package com.daggerbasicspractice

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.daggerbasicspractice.di.CustomComponent
import com.daggerbasicspractice.di.CustomComponentBuilder
import dagger.hilt.EntryPoint
import dagger.hilt.EntryPoints
import dagger.hilt.InstallIn
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.EntryPointAccessors
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var sampleClass: SampleClass1

    @Inject
    lateinit var sampleClass1: SampleClass1

    @Inject
    lateinit var buildCustomComponent: BuildCustomComponent


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        println("print  " + sampleClass)
        println("print  " + sampleClass1)

        val entryPointTest = BuildEntryPoint()
        entryPointTest.attachSampleClass3(applicationContext)
        entryPointTest.attachSampleClass2(applicationContext)


        buildCustomComponent.execute()
    }


}

class BuildEntryPoint {

    //    Entry point is used for classes in which injection is not supported by hilt
//    via default components like ActivityComponent AppComponent etc
    @EntryPoint
    @InstallIn(ApplicationComponent::class)
    interface SampleClassInterface {
        fun getSampleClass3(): SampleClass3
        fun getSampleClass2(): SampleClass2
    }

    fun attachSampleClass3(context: Context) {
//        this  fromApplication function is just like get function inside component if scoped will always give
//        same instance within single build otherwise different instance eveyrtime

        //        this way is recommended to get entry ponint as it is more type safe
        val sampleClass =
            EntryPointAccessors.fromApplication(context, SampleClassInterface::class.java)
                .getSampleClass3()

        val sampleClassCheckingMultiInstance =
            EntryPointAccessors.fromApplication(context, SampleClassInterface::class.java)
                .getSampleClass3()

        println("PRINT ${sampleClass}")
        println("PRINT ${sampleClassCheckingMultiInstance}")

    }

    fun attachSampleClass2(context: Context) {
//        this get is just like get function inside component if scoped will always give
//        same instance within single build otherwise different instance eveyrtime
        val sampleClass =
            EntryPoints.get(context, SampleClassInterface::class.java).getSampleClass2()

        println("PRINT ${sampleClass}")
    }
}

@ActivityScoped
class BuildCustomComponent @Inject constructor(private val componentBuilder: CustomComponentBuilder) {

    @EntryPoint
    @InstallIn(CustomComponent::class)
    interface SampleClassInterface {
        fun getSampleClass4(): SampleClass4
        fun getSampleClass5(): SampleClass5
    }


    fun execute() {

        val component = componentBuilder.sampleClass4(SampleClass4()).build()

        val sampleClassProvider =
            EntryPoints.get(
                component,
                SampleClassInterface::class.java
            )

//        this get is just like get function inside component if scoped will always give
//        same instance within single build otherwise different instance eveyrtime
        println("PRINT ${sampleClassProvider.getSampleClass4()}")
        println("PRINT ${sampleClassProvider.getSampleClass5()}")

    }
}
