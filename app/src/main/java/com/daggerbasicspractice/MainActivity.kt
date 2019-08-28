package com.daggerbasicspractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import dagger.android.AndroidInjection
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var sampleClass: SampleClass

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        this will inject dependencies
        AndroidInjection.inject(this)

        Log.d("MyTag", sampleClass.toString())

    }

}
