package com.iwelogic.bundle_test

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment


class SecondFragment : Fragment() {

    lateinit var testObject: TestObject

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_second, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        testObject = requireArguments().getParcelable<TestObject>("value")!!
        view.findViewById<TextView>(R.id.text).text = testObject.text

        view.findViewById<View>(R.id.button).setOnClickListener {
            testObject.text = (0..999999).random().toString()
            view.findViewById<TextView>(R.id.text).text = testObject.text
        }
    }

}