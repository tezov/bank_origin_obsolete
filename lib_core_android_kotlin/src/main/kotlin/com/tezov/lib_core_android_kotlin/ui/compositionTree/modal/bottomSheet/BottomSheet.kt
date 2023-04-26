/*
 *  *********************************************************************************
 *  Created by Tezov on 26/04/2023 21:07
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 26/04/2023 21:01
 *  First project bank / bank.lib_core_android_kotlin.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */

package com.tezov.lib_core_android_kotlin.ui.compositionTree.modal.bottomSheet

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ProvidableCompositionLocal
import androidx.compose.runtime.compositionLocalOf
import com.tezov.lib_core_android_kotlin.ui.compositionTree.activity.Activity
import com.tezov.lib_core_android_kotlin.ui.compositionTree.modal.Modal
import com.tezov.lib_core_android_kotlin.ui.compositionTree.modal.dialog.Dialog
import com.tezov.lib_core_android_kotlin.ui.compositionTree.page.Page
import com.tezov.lib_core_android_kotlin.ui.compositionTree.page.Page.Companion.LocalModals

interface BottomSheet<S : BottomSheetState, A : BottomSheetAction<S>> : Modal<S, A> {
    companion object {
        val LocalBottomSheet: ProvidableCompositionLocal<BottomSheet<*, *>> = compositionLocalOf {
            error("not provided")
        }
    }

    @Composable
    override fun Modal<S, A>.content() {
        val modals = LocalModals.current
        modals.find { it.modal == this@BottomSheet }?.let {
            this as BottomSheet<S, A>
            CompositionLocalProvider(
                Activity.DebugLocalLevel provides 2,
                LocalBottomSheet provides this
            ) {
                enableLifeCycle()
                this.content()
            }
        }
    }

    @Composable
    fun BottomSheet<S, A>.content()

}