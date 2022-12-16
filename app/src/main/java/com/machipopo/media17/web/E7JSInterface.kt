package com.machipopo.media17.web

import android.util.Log
import android.webkit.JavascriptInterface


class E7JSInterface {

    companion object {
        const val INTERFACE_NAME = "androidApp"
    }

    @JavascriptInterface
    fun onAnimationEnd(message: String?) {
        Log.e("E7", "JS onAnimationEnd=${message}")
    }
}