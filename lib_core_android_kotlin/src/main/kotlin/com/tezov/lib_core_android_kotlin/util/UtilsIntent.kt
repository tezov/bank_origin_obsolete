/*
 *  *********************************************************************************
 *  Created by Tezov on 30/01/2023 20:18
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 30/01/2023 20:11
 *  First project bank / bank.lib_core_android_kotlin.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */

package com.tezov.lib_core_android_kotlin.util

import android.content.Intent
import android.net.Uri
import androidx.activity.ComponentActivity
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner
import com.tezov.lib_core_kotlin.file.UtilsFile
import kotlin.coroutines.suspendCoroutine


object UtilsIntent {

    suspend fun emailTo(
        activity: ComponentActivity,
        target: String,
        subject: String? = null,
        body: String? = null
    ) = suspendCoroutine { continuation ->
        val mailto = StringBuilder().apply {
            append("mailto:").append(target).append("?")
            subject?.let {
                append("subject=").append(Uri.encode(it)).append("&")
            }
            body?.let {
                append("body=").append(Uri.encode(it)).append("&")
            }
            replace(length - 1, length, "")
        }
        val intent = Intent()
        intent.action = Intent.ACTION_SENDTO
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY)
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_DOCUMENT)
        intent.addFlags(Intent.FLAG_ACTIVITY_MULTIPLE_TASK)
        intent.data = Uri.parse(mailto.toString())
        activity.lifecycle.addObserver(object : DefaultLifecycleObserver {
            override fun onResume(owner: LifecycleOwner) {
                activity.lifecycle.removeObserver(this)
                continuation.resumeWith(Result.success(Unit))
            }
        })
        activity.startActivity(intent)
    }

    suspend fun sendTo(activity: ComponentActivity, subject: String? = null, text: String) =
        suspendCoroutine { continuation ->
            val intent = Intent()
            intent.action = Intent.ACTION_SEND
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY)
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_DOCUMENT)
            intent.addFlags(Intent.FLAG_ACTIVITY_MULTIPLE_TASK)
            subject?.let {
                intent.putExtra(Intent.EXTRA_SUBJECT, it)
            }
            intent.putExtra(Intent.EXTRA_TEXT, text)
            intent.type = UtilsFile.MINE_TYPE_PLAIN_TEXT
            activity.lifecycle.addObserver(object : DefaultLifecycleObserver {
                override fun onResume(owner: LifecycleOwner) {
                    activity.lifecycle.removeObserver(this)
                    continuation.resumeWith(Result.success(Unit))
                }
            })
            activity.startActivity(intent)
        }

    suspend fun callTo(activity: ComponentActivity, target: String) =
        suspendCoroutine { continuation ->
            val intent = Intent()
            intent.action = Intent.ACTION_DIAL
            intent.data = Uri.parse("tel:$target")
            activity.lifecycle.addObserver(object : DefaultLifecycleObserver {
                override fun onResume(owner: LifecycleOwner) {
                    activity.lifecycle.removeObserver(this)
                    continuation.resumeWith(Result.success(Unit))
                }
            })
            activity.startActivity(intent)
        }

    suspend fun openLink(activity: ComponentActivity, uri: Uri) = suspendCoroutine { continuation ->
        val intent = Intent()
        intent.action = Intent.ACTION_VIEW
        intent.data = uri
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY)
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_DOCUMENT)
        intent.addFlags(Intent.FLAG_ACTIVITY_MULTIPLE_TASK)
        activity.lifecycle.addObserver(object : DefaultLifecycleObserver {
            override fun onResume(owner: LifecycleOwner) {
                activity.lifecycle.removeObserver(this)
                continuation.resumeWith(Result.success(Unit))
            }
        })
        activity.startActivity(intent)
    }
}