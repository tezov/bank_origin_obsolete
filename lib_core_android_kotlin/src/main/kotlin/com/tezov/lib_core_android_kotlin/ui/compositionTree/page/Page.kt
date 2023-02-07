/*
 *  *********************************************************************************
 *  Created by Tezov on 07/02/2023 22:45
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 07/02/2023 22:38
 *  First project bank / bank.lib_core_android_kotlin.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */

package com.tezov.lib_core_android_kotlin.ui.compositionTree.page

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.*
import com.tezov.lib_core_android_kotlin.ui.compositionTree.activity.Activity
import com.tezov.lib_core_android_kotlin.ui.compositionTree.activity.Activity.Companion.LocalPages
import com.tezov.lib_core_android_kotlin.ui.compositionTree.base.Composition
import com.tezov.lib_core_android_kotlin.ui.compositionTree.modal.Modal
import com.tezov.lib_core_kotlin.extension.ExtensionCollection.push

interface Page<S : PageState, A : PageAction<S>> : Composition<S, A> {
    companion object {
        val LocalPage: ProvidableCompositionLocal<Page<*, *>> = staticCompositionLocalOf {
            error("not provided")
        }
        val LocalModals: ProvidableCompositionLocal<MutableList<Modal.Companion.Locals>> =
            staticCompositionLocalOf {
                error("not provided")
            }

        data class Locals(val page: Page<*, *>, val modals: ArrayDeque<Modal.Companion.Locals>)
    }

    @SuppressLint("UnrememberedMutableState")
    @Composable
    operator fun invoke(innerPadding: PaddingValues) {
        val locals = Locals(this, ArrayDeque())
        val pages = LocalPages.current
        DisposableEffect(Unit) {
            pages.push(locals)
            onDispose {
                pages.find { it.page == this@Page }?.also { pages.remove(it) }
            }
        }
        CompositionLocalProvider(
            Activity.DebugLocalLevel provides 1,
            LocalPage provides locals.page,
            LocalModals provides locals.modals
        ) {
            content(innerPadding = innerPadding)
        }
    }

    @Composable
    fun Page<S, A>.content(innerPadding: PaddingValues)

    @Composable
    fun handleOnBackPressed() = false

}
