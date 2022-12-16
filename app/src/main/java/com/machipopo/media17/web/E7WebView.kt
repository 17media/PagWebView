package com.machipopo.media17.web

import android.annotation.SuppressLint
import android.content.Context
import android.util.AttributeSet
import android.util.Base64
import android.util.Log
import android.view.View
import android.webkit.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.io.InputStream


@SuppressLint("JavascriptInterface")
class E7WebView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null
) : WebView(context, attrs) {

    init {
        val webSettings = settings
        webSettings.javaScriptEnabled = true
        webSettings.useWideViewPort = true
        webSettings.loadWithOverviewMode = true
        webSettings.domStorageEnabled = true
        webSettings.allowFileAccess = false
        webSettings.allowContentAccess = false
        webSettings.mixedContentMode = WebSettings.MIXED_CONTENT_ALWAYS_ALLOW
        webSettings.cacheMode = WebSettings.LOAD_NO_CACHE
        addJavascriptInterface(E7JSInterface(), E7JSInterface.INTERFACE_NAME)
        setLayerType(View.LAYER_TYPE_HARDWARE, null)

        webChromeClient = object : WebChromeClient() {
            override fun onConsoleMessage(consoleMessage: ConsoleMessage): Boolean {
                Log.e("Zack", consoleMessage.message())
                return true
            }
        }

        webViewClient = object : WebViewClient() {
        }

        loadUrl("https://cdn.17app.co/zack_anim_phoenix.html")

        setBackgroundColor(0)
        background.alpha = 0

    }

    private fun executeFile(byteStr: String) {
        CoroutineScope(Dispatchers.Main).launch {
            evaluateJavascript("javascript:executeFile('${byteStr}');", null)
        }
    }

    fun executeAnimation(url: String) {
        evaluateJavascript("javascript:executeAnimation('${url}');", null)
    }

    fun readPagFile(fileName: String) {
        CoroutineScope(Dispatchers.IO).launch(Dispatchers.IO) {
            val inputStream: InputStream = context.assets.open(fileName)
            val size: Int = inputStream.available()
            val buffer = ByteArray(size)
            inputStream.read(buffer)
            executeFile(Base64.encodeToString(buffer, Base64.NO_WRAP))
        }
    }
}