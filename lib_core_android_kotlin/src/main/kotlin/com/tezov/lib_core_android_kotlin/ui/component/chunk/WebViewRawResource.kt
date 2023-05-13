/*
 *  ********************************************************************************
 *  Created by Tezov under MIT LICENCE.
 *  For any request, please send me an email to tezov.app@gmail.com.
 *  I'll be glad to answer you if your request is sane :)
 *  ********************************************************************************
 *
 *
 */

/*
 *  ********************************************************************************
 *  Created by Tezov under MIT LICENCE.
 *  For any request, please send me an email to tezov.app@gmail.com.
 *  I'll be glad to answer you if your request is sane :)
 *  ********************************************************************************
 *
 *
 */

package com.tezov.lib_core_android_kotlin.ui.component.chunk

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.util.Log
import android.view.View
import android.webkit.WebResourceRequest
import android.webkit.WebView
import androidx.compose.runtime.Composable
import androidx.compose.ui.viewinterop.AndroidView
import androidx.webkit.WebViewAssetLoader
import androidx.webkit.WebViewClientCompat


@Suppress("CAST_NEVER_SUCCEEDS")
@SuppressLint("ViewConstructor")
class WebViewRawResource private constructor(context: Context, rawHtmlResourceId: Int) :
    WebView(context) {
    private val domain = context.packageName
    private val maxHeight: Int? = null

    private var listener: ((segment: String) -> Boolean)? = null

    init {
        webViewClient = object : WebViewClientCompat() {
            val assetLoader = WebViewAssetLoader.Builder().apply {
                setDomain(domain)
                addPathHandler("/assets/", WebViewAssetLoader.AssetsPathHandler(context))
                addPathHandler("/res/", WebViewAssetLoader.ResourcesPathHandler(context))
            }.build()

            override fun shouldInterceptRequest(
                view: WebView?,
                request: WebResourceRequest?
            ) = request?.let {
                assetLoader.shouldInterceptRequest(it.url)
            }

            override fun shouldOverrideUrlLoading(
                view: WebView,
                request: WebResourceRequest
            ): Boolean {
                request.url.lastPathSegment?.let { segment ->
                    listener?.takeIf { it.invoke(segment) }?.let {
                        return true
                    }
                }
                //open in outside browser
                request.url.scheme?.takeIf {scheme ->
                    scheme == "http" || scheme == "https"
                }?.let {
                    view.context.startActivity(Intent(Intent.ACTION_VIEW, request.url))
                    return true
                }
                return false
            }

            override fun onPageFinished(view: WebView, url: String) {
                super.onPageFinished(view, url)
                val parent = parent as? View
                invalidate()
                parent?.apply {
                    invalidate()
                    requestLayout()
                } ?: run {
                    requestLayout()
                }
            }
        }
        setBackgroundColor(0x00000000)
        setLayerType(LAYER_TYPE_SOFTWARE, null)
        val name = context.resources.getResourceEntryName(rawHtmlResourceId)
        loadUrl("https://$domain/res/raw/$name.html")
    }

    @Deprecated("Deprecated in Java")
    override fun onMeasure(widthMeasureSpec: Int, _heightMeasureSpec: Int) {
        var heightMeasureSpec = _heightMeasureSpec
        if (maxHeight != null) {
            val hSize = MeasureSpec.getSize(heightMeasureSpec)
            val hMode = MeasureSpec.getMode(heightMeasureSpec)
            when (hMode) {
                MeasureSpec.AT_MOST -> heightMeasureSpec =
                    MeasureSpec.makeMeasureSpec(Math.min(hSize, maxHeight), MeasureSpec.AT_MOST)
                MeasureSpec.UNSPECIFIED -> heightMeasureSpec =
                    MeasureSpec.makeMeasureSpec(maxHeight, MeasureSpec.AT_MOST)
                MeasureSpec.EXACTLY -> heightMeasureSpec =
                    MeasureSpec.makeMeasureSpec(Math.min(hSize, maxHeight), MeasureSpec.EXACTLY)
            }
        }
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
    }

    companion object {
        @Composable
        operator fun invoke(
            rawHtmlResourceId: Int,
            listener: ((segment: String) -> Boolean)? = null
        ) {
            AndroidView(factory = {
                WebViewRawResource(it, rawHtmlResourceId).apply {
                    this.listener = listener
                }
            }, update = {
                it.listener = listener
            })
        }
    }

}