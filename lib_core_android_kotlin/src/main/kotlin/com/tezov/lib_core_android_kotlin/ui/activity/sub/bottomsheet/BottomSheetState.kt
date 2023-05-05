/*
 *  *********************************************************************************
 *  Created by Tezov on 05/05/2023 20:30
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 05/05/2023 20:24
 *  First project bank / bank.lib_core_android_kotlin.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */

package com.tezov.lib_core_android_kotlin.ui.activity.sub.bottomsheet

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.tezov.lib_core_android_kotlin.ui.compositionTree.activity.Activity
import com.tezov.lib_core_android_kotlin.ui.compositionTree.activity.Activity.Companion.LocalLevel
import com.tezov.lib_core_android_kotlin.ui.compositionTree.activity.sub.ActivitySubState
import com.tezov.lib_core_android_kotlin.ui.compositionTree.page.Page
import com.tezov.lib_core_android_kotlin.ui.compositionTree.page.Page.Companion.LocalPage
import com.tezov.lib_core_android_kotlin.ui.compositionTree.page.Page.Companion.LocalPageBundle
import com.tezov.lib_core_android_kotlin.ui.theme.theme.colorsResource

@OptIn(ExperimentalMaterialApi::class)
class BottomSheetState private constructor(
    val bottomSheetState: ModalBottomSheetState,
    private val showState: MutableState<Boolean>,
    private val sheetContentUpdated: MutableState<Int>
) : ActivitySubState {


    companion object {
        @OptIn(ExperimentalMaterialApi::class)
        @Composable
        fun create(
            bottomSheetState: ModalBottomSheetState = ModalBottomSheetState(
                initialValue = ModalBottomSheetValue.Hidden,
                animationSpec = SwipeableDefaults.AnimationSpec,
                isSkipHalfExpanded = false,
                confirmStateChange = { true }
            ),
            showState: MutableState<Boolean> = mutableStateOf(false),
            sheetContentUpdated: MutableState<Int> = mutableStateOf(0)
        ) = BottomSheetState(
            bottomSheetState = bottomSheetState,
            showState = showState,
            sheetContentUpdated = sheetContentUpdated,
        )
    }

    @Composable
    internal fun EmptyContent() {
        Box(
            Modifier
                .background(MaterialTheme.colorsResource.transparent)
                .fillMaxWidth()
                .height(1.dp)
        )
    }

    private var _sheetContent: (@Composable () -> Unit) = {
        //hack content bottomsheet can't be null even if not showing
        EmptyContent()
    }

    fun isVisible() = showState.value
    fun show(visible: Boolean) {
        showState.value = visible
    }

    @Composable
    internal fun sheetContent() {
        if (isVisible() && sheetContentUpdated.value >= 0) {
            CompositionLocalProvider(
                LocalLevel provides 1,
                LocalPageBundle provides Activity.LocalPagesBundle.last(),
            ) {
                _sheetContent()
            }
        } else {
            EmptyContent()
        }
    }

    internal fun sheetContent(content: @Composable () -> Unit) {
        _sheetContent = content
        sheetContentUpdated.value++
    }

}