package com.tezov.lib_core_android_kotlin.ui.compositionTree.modal

import androidx.compose.runtime.*
import com.tezov.lib_core_android_kotlin.ui.compositionTree.base.Composition
import com.tezov.lib_core_android_kotlin.ui.compositionTree.page.Page
import com.tezov.lib_core_android_kotlin.ui.compositionTree.page.Page.Companion.LocalModals

interface Modal<S: ModalState, A: ModalAction<S>>: Composition<S, A> {

    companion object{
        data class Locals(val page:Modal<*, *>)
    }

     @Composable
    operator fun invoke() {
        val locals = Locals(this)
        val modal = LocalModals.current.apply {
            add(locals)
        }
        DisposableEffect(Unit){
            onDispose {
                modal.find { it.page == this@Modal }?.also { modal.remove(it) }
            }
        }
        content()
    }

    @Composable
    fun Modal<S,A>.content()

}