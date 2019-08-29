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

        /*It is crucial to call AndroidInjection.inject() before super.onCreate() in an
        Activity, since the call to super attaches Fragments from the previous activity
        instance during configuration change, which in turn injects the Fragments.
        In order for the Fragment injection to succeed, the Activity must already be
        injected.
        */
        //        this will inject dependencies
        AndroidInjection.inject(this)
        
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        Log.d("MyTag", sampleClass.toString())

    }

}
