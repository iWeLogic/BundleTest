package com.iwelogic.bundle_test

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController


class FirstFragment : Fragment() {

    val testObject = TestObject("007")

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_first, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<TextView>(R.id.text).text = testObject.text
        view.findViewById<View>(R.id.button).setOnClickListener {
            findNavController().navigate(R.id.action_firstFragment_to_secondFragment, bundleOf("value" to testObject))
        }
    }


}