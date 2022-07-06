package com.iwelogic.bundle_test

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
class TestObject(
    var text: String
) : Parcelable