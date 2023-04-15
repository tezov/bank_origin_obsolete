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

package com.tezov.lib_core_android_kotlin.ui.compositionTree.modal.dialog

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ProvidableCompositionLocal
import androidx.compose.runtime.compositionLocalOf
import com.tezov.lib_core_android_kotlin.ui.compositionTree.activity.Activity
import com.tezov.lib_core_android_kotlin.ui.compositionTree.modal.Modal

interface Dialog<S : DialogState, A : DialogAction<S>> : Modal<S, A> {
    companion object {
        val LocalDialog: ProvidableCompositionLocal<Dialog<*, *>> = compositionLocalOf {
            error("not provided")
        }
    }

    @Composable
    override fun Modal<S, A>.content() {
        CompositionLocalProvider(
            Activity.DebugLocalLevel provides 2,
            LocalDialog provides (this as Dialog<*, *>)
        ) {
            (this as Dialog<S, A>).content()
        }
    }

    @Composable
    fun Dialog<S, A>.content()

}