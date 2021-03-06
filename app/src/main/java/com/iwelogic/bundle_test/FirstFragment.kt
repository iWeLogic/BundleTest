package com.iwelogic.bundle_test

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController


class FirstFragment : Fragment() {

    private lateinit var testObject: TestObject

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        testObject = savedInstanceState?.getParcelable("FirstFragmentValue") ?: TestObject("007")
    }

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

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putParcelable("FirstFragmentValue", testObject)
    }
}