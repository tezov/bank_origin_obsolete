/*
 *  *********************************************************************************
 *  Created by Tezov on 06/05/2023 13:31
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 06/05/2023 13:24
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
import com.tezov.lib_core_android_kotlin.ui.compositionTree.page.Page.Companion.LocalPageBundle
import com.tezov.lib_core_android_kotlin.ui.theme.theme.colorsResource

@OptIn(ExperimentalMaterialApi::class)
class BottomSheetState private constructor(
    val bottomSheetState: ModalBottomSheetState,
    private val showState: MutableState<Boolean>,
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
                confirmStateChange = { true }
            ),
            showState: MutableState<Boolean> = mutableStateOf(false),
            sheetContentUpdated: MutableState<Int> = mutableStateOf(0)
        ) = BottomSheetState(
            bottomSheetState = bottomSheetState,
            showState = showState,
            stateUpdated = sheetContentUpdated,
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

    var isVisible = false
        get() = (stateUpdated.value > 0) && field
        private set

    var content: (@Composable () -> Unit) = { EmptyContent() }

    @OptIn(ExperimentalMaterialApi::class)
    suspend fun show(visible: Boolean) {
        if(!visible){
            content = { EmptyContent() }
        }
        isVisible = visible
        stateUpdated.value++
        if(visible){
            bottomSheetState.show()
        }
        else{
            bottomSheetState.hide()
        }
    }

}