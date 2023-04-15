/*
 *  *********************************************************************************
 *  Created by Tezov on 15/04/2023 19:41
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 15/04/2023 18:52
 *  First project bank / bank.lib_core_android_kotlin.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */

package com.tezov.lib_core_android_kotlin.ui.activity.sub.dialog

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.tezov.lib_core_android_kotlin.ui.compositionTree.activity.Activity
import com.tezov.lib_core_android_kotlin.ui.compositionTree.activity.sub.ActivitySubState
import com.tezov.lib_core_android_kotlin.ui.compositionTree.page.Page
import com.tezov.lib_core_android_kotlin.ui.theme.theme.colorsResource

class DialogState private constructor(
    private val showState: MutableState<Boolean>,
    private val dialogContentUpdated: MutableState<Int>,
) : ActivitySubState {

    companion object {
        @Composable
        fun create(
            showState: MutableState<Boolean> = mutableStateOf(false),
            dialogContentUpdated: MutableState<Int> = mutableStateOf(0)
        ) = DialogState(
            showState = showState,
            dialogContentUpdated = dialogContentUpdated,
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

    private var _dialogContent: (@Composable () -> Unit) = {
        //hack content dialog can't be null even if not showing
        EmptyContent()
    }

    fun isVisible() = showState.value
    fun show(visible: Boolean) {
        showState.value = visible
    }

    @Composable
    internal fun dialogContent() {
        //todo animation show/hide
        if (isVisible() && dialogContentUpdated.value >= 0) {
            val locals = Activity.LocalPages.current.last()
            CompositionLocalProvider(
                Activity.DebugLocalLevel provides 1,
                Page.LocalPage provides locals.page,
                Page.LocalModals provides locals.modals
            ) {
                _dialogContent()
            }
        }
    }

    internal fun dialogContent(content: @Composable () -> Unit) {
        _dialogContent = content
        dialogContentUpdated.value++
    }

}