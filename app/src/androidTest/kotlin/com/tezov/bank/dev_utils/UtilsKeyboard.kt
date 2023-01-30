/*
 *  *********************************************************************************
 *  Created by Tezov on 30/01/2023 20:18
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 30/01/2023 20:11
 *  First project bank / bank.app.androidTest
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */

package com.tezov.bank.dev_utils

import android.graphics.Rect
import android.view.ViewTreeObserver
import androidx.compose.runtime.*
import androidx.compose.ui.platform.LocalView

object UtilsKeyboard {

    enum class Status {
        Opened, Closed
    }

    @Composable
    fun AsState(): State<Status> {
        val keyboardState = remember { mutableStateOf(Status.Closed) }
        val view = LocalView.current
        DisposableEffect(view) {
            val onGlobalListener = ViewTreeObserver.OnGlobalLayoutListener {
                val rect = Rect()
                view.getWindowVisibleDisplayFrame(rect)
                val screenHeight = view.rootView.height
                val keypadHeight = screenHeight - rect.bottom
                keyboardState.value = if (keypadHeight > screenHeight * 0.15) {
                    Status.Opened
                } else {
                    Status.Closed
                }
            }
            view.viewTreeObserver.addOnGlobalLayoutListener(onGlobalListener)
            onDispose {
                view.viewTreeObserver.removeOnGlobalLayoutListener(onGlobalListener)
            }
        }
        return keyboardState
    }

}