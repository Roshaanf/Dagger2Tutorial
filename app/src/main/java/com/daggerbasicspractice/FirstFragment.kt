package com.daggerbasicspractice


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import dagger.android.support.DaggerFragment
import javax.inject.Inject


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class FirstFragment : DaggerFragment() {

    @Inject
    lateinit var sampleFragmentDependency: SampleFirstFragmentDependency
    @Inject
    lateinit var sampleFirstFragmentDependency:SampleFirstFragmentDependency

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        Log.d("MyTag", sampleFragmentDependency.toString()+" "+ sampleFragmentDependency.toString())
        Log.d("MyTag", sampleFirstFragmentDependency.toString())
    }

}
