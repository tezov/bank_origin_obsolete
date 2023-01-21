package com.tezov.lib_core_android_kotlin.ui.compositionTree.modal.dialog

import androidx.compose.runtime.*
import com.tezov.lib_core_android_kotlin.ui.compositionTree.activity.Activity
import com.tezov.lib_core_android_kotlin.ui.compositionTree.modal.Modal

interface Dialog<S: DialogState, A: DialogAction<S>>: Modal<S, A> {
    companion object{
        val LocalDialog: ProvidableCompositionLocal<Dialog<*, *>> = compositionLocalOf {
            error("not provided")
        }
    }
    @Composable
    override fun Modal<S,A>.content(){
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