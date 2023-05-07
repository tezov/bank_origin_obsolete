/*
 *  *********************************************************************************
 *  Created by Tezov on 07/05/2023 13:14
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 07/05/2023 12:39
 *  First project bank / bank.lib_core_android_kotlin.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */

package com.tezov.lib_core_android_kotlin.ui.activity.sub.dialog

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import com.tezov.lib_core_android_kotlin.ui.compositionTree.activity.Activity
import com.tezov.lib_core_android_kotlin.ui.compositionTree.activity.sub.ActivitySubState
import com.tezov.lib_core_android_kotlin.ui.compositionTree.page.Page

class DialogState private constructor(
    val stateUpdated: MutableState<Int>,
) : ActivitySubState {

    companion object {
        @Composable
        fun create(
            dialogContentUpdated: MutableState<Int> = mutableStateOf(0)
        ) = DialogState(
            stateUpdated = dialogContentUpdated,
        )
    }

    var isVisible = false
        get() = (stateUpdated.value > 0) && field
        private set

    private var _content: (@Composable () -> Unit) = { }

    @Composable
    internal fun content() = _content()

    internal fun show(content: (@Composable () -> Unit)?) {
        if (content == null) {
            _content = { }
            isVisible = false
        } else {
            _content = {
                CompositionLocalProvider(
                    Activity.LocalLevel provides 1,
                    Page.LocalPageBundle provides Activity.LocalPagesBundle.last(),
                ) {
                    content()
                }
            }
            isVisible = true
        }
        stateUpdated.value++
    }

}