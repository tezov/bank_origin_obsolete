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

package com.tezov.lib_core_android_kotlin.ui.compositionTree.modal.bottomSheet

import androidx.compose.runtime.*
import com.tezov.lib_core_android_kotlin.ui.compositionTree.activity.Activity
import com.tezov.lib_core_android_kotlin.ui.compositionTree.modal.Modal

interface BottomSheet<S: BottomSheetState, A: BottomSheetAction<S>>: Modal<S, A> {
    companion object{
        val LocalBottomSheet: ProvidableCompositionLocal<BottomSheet<*, *>> = compositionLocalOf {
            error("not provided")
        }
    }
    @Composable
    override fun Modal<S,A>.content(){
        CompositionLocalProvider(
            Activity.DebugLocalLevel provides 0,
            LocalBottomSheet provides (this as BottomSheet<*, *>),
        ) {
            (this as BottomSheet<S, A>).content()
        }
    }
    @Composable
    fun BottomSheet<S, A>.content()

}