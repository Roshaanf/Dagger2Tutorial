package com.daggerbasicspractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import dagger.android.AndroidInjection
import dagger.android.DaggerActivity
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var sampleClass: SampleCommonDependency

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d("MyTag", sampleClass.toString())


        supportFragmentManager
            .beginTransaction()
            .replace(R.id.container, FirstFragment())
            .commit()


    }

}
