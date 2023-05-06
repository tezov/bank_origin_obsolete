/*
 *  *********************************************************************************
 *  Created by Tezov on 06/05/2023 13:31
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 06/05/2023 13:18
 *  First project bank / bank.lib_core_android_kotlin.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */

package com.tezov.lib_core_android_kotlin.ui.activity.sub.dialog

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.tezov.lib_core_android_kotlin.ui.compositionTree.activity.sub.ActivitySubState
import com.tezov.lib_core_android_kotlin.ui.theme.theme.colorsResource

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

    var content: (@Composable () -> Unit) = { }

    internal fun show(visible: Boolean) {
        if(!visible){
            content = { }
        }
        isVisible = visible
        stateUpdated.value++
    }

}