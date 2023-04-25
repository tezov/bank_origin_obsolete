/*
 *  *********************************************************************************
 *  Created by Tezov on 25/04/2023 21:10
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 25/04/2023 20:39
 *  First project bank / bank.lib_core_android_kotlin.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */

package com.tezov.lib_core_android_kotlin.ui.compositionTree.modal

import androidx.activity.compose.BackHandler
import androidx.compose.runtime.*
import com.tezov.lib_core_android_kotlin.ui.compositionTree.activity.Activity
import com.tezov.lib_core_android_kotlin.ui.compositionTree.base.Composition
import com.tezov.lib_core_android_kotlin.ui.compositionTree.page.Page
import com.tezov.lib_core_android_kotlin.ui.compositionTree.page.Page.Companion.LocalModals
import com.tezov.lib_core_kotlin.extension.ExtensionCollection.push

interface Modal<S : ModalState, A : ModalAction<S>> : Composition<S, A> {

    companion object {
        data class Locals(val modal: Modal<*, *>)
    }

    @Composable
    operator fun invoke() {
        val modals = LocalModals.current
        remember {
            val locals = Locals(this)
            modals.add(locals)
        }
        content()
        DisposableEffect(Unit) {
            onDispose {
                modals.find { it.modal == this@Modal }?.also { modals.remove(it) }
            }
        }
    }

    @Composable
    fun Modal<S, A>.content()

    @Composable
    fun onBackPressedDispatch() = handleOnBackPressed()

    @Composable
    fun handleOnBackPressed() = false

}