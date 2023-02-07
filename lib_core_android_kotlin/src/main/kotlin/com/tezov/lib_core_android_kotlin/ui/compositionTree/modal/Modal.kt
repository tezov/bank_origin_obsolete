/*
 *  *********************************************************************************
 *  Created by Tezov on 07/02/2023 22:45
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 07/02/2023 22:22
 *  First project bank / bank.lib_core_android_kotlin.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */

package com.tezov.lib_core_android_kotlin.ui.compositionTree.modal

import androidx.compose.runtime.*
import com.tezov.lib_core_android_kotlin.ui.compositionTree.base.Composition
import com.tezov.lib_core_android_kotlin.ui.compositionTree.page.Page.Companion.LocalModals

interface Modal<S: ModalState, A: ModalAction<S>>: Composition<S, A> {

    companion object{
        data class Locals(val modal:Modal<*, *>)
    }

     @Composable
    operator fun invoke() {
        val locals = Locals(this)
        val modals = LocalModals.current
        DisposableEffect(Unit){
            modals.add(locals)
            onDispose {
                modals.find { it.modal == this@Modal }?.also { modals.remove(it) }
            }
        }
        content()
    }

    @Composable
    fun Modal<S,A>.content()

}