/*
 *  *********************************************************************************
 *  Created by Tezov on 07/05/2023 13:14
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 07/05/2023 12:46
 *  First project bank / bank.lib_core_android_kotlin.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */

package com.tezov.lib_core_android_kotlin.ui.activity.sub.bottomsheet

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import com.tezov.lib_core_android_kotlin.ui.compositionTree.activity.Activity
import com.tezov.lib_core_android_kotlin.ui.compositionTree.activity.Activity.Companion.LocalLevel
import com.tezov.lib_core_android_kotlin.ui.compositionTree.activity.Activity.Companion.LocalPagesBundle
import com.tezov.lib_core_android_kotlin.ui.compositionTree.activity.sub.ActivitySubState
import com.tezov.lib_core_android_kotlin.ui.compositionTree.page.Page
import com.tezov.lib_core_android_kotlin.ui.compositionTree.page.Page.Companion.LocalPageBundle

@OptIn(ExperimentalMaterialApi::class)
class BottomSheetState private constructor(
    val bottomSheetState: ModalBottomSheetState,
    private val stateUpdated: MutableState<Int>
) : ActivitySubState {

    companion object {
        @OptIn(ExperimentalMaterialApi::class)
        @Composable
        fun create(
            bottomSheetState: ModalBottomSheetState = ModalBottomSheetState(
                initialValue = ModalBottomSheetValue.Hidden,
                animationSpec = SwipeableDefaults.AnimationSpec,
                isSkipHalfExpanded = false,
                confirmValueChange = { true }
            ),
            sheetContentUpdated: MutableState<Int> = mutableStateOf(0)
        ) = BottomSheetState(
            bottomSheetState = bottomSheetState,
            stateUpdated = sheetContentUpdated,
        )
    }

    internal var _isVisible = false

    val isVisible  get() = (stateUpdated.value > 0) && _isVisible

    private var _content: (@Composable () -> Unit) = { }

    @Composable
    internal fun content() = if(_isVisible) _content() else { }

    internal fun content(value: @Composable () -> Unit) {
        _content = {
            CompositionLocalProvider(
                LocalLevel provides 1,
                LocalPageBundle provides LocalPagesBundle.last(),
            ) {
                value()
            }
        }
    }

    internal fun show(content: (@Composable () -> Unit)?) {
        if (content == null) {
            _content = { }
            _isVisible = false
        } else {
            _content = {
                CompositionLocalProvider(
                    Activity.LocalLevel provides 1,
                    Page.LocalPageBundle provides Activity.LocalPagesBundle.last(),
                ) {
                    content()
                }
            }
            _isVisible = true
        }
        stateUpdated.value++
    }

}