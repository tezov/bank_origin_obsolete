/*
 *  *********************************************************************************
 *  Created by Tezov on 16/04/2023 22:13
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 16/04/2023 18:13
 *  First project bank / bank.lib_core_android_kotlin.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */

package com.tezov.lib_core_android_kotlin.ui.component.chunk

import android.annotation.SuppressLint
import android.content.Context
import android.view.View
import android.webkit.WebResourceRequest
import android.webkit.WebResourceResponse
import android.webkit.WebView
import androidx.compose.runtime.Composable
import androidx.compose.ui.viewinterop.AndroidView
import androidx.webkit.WebViewAssetLoader
import androidx.webkit.WebViewClientCompat

@SuppressLint("ViewConstructor")
class WebViewRawResource private constructor(context: Context, rawHtmlResourceId: Int) :
    WebView(context) {
    private val domain = context.packageName
    private val maxHeight: Int? = null

    init {
        val assetLoader = WebViewAssetLoader.Builder().apply {
            setDomain(domain)
            addPathHandler("/assets/", WebViewAssetLoader.AssetsPathHandler(context))
            addPathHandler("/res/", WebViewAssetLoader.ResourcesPathHandler(context))
        }.build()
        webViewClient = object : WebViewClientCompat() {
            override fun shouldInterceptRequest(
                view: WebView?,
                request: WebResourceRequest?
            ): WebResourceResponse? {
                request?.let {
                    return assetLoader.shouldInterceptRequest(it.url)
                } ?: kotlin.run {
                    return super.shouldInterceptRequest(view, request)
                }
            }

            override fun onPageFinished(view: WebView, url: String) {
                super.onPageFinished(view, url)
                val parent = parent as? View
                invalidate()
                if (parent != null) {
                    parent.invalidate()
                    parent.requestLayout()
                } else {
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
        operator fun invoke(rawHtmlResourceId: Int) {
            AndroidView(factory = {
                WebViewRawResource(it, rawHtmlResourceId)
            }, update = {

            })
        }
    }

}