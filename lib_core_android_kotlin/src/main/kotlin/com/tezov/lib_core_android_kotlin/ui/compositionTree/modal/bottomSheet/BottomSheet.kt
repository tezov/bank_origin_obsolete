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