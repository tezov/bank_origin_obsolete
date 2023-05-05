/*
 *  *********************************************************************************
 *  Created by Tezov on 05/05/2023 20:30
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 05/05/2023 20:28
 *  First project bank / bank.lib_core_android_kotlin.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */

package com.tezov.lib_core_android_kotlin.ui.compositionTree.page

import android.annotation.SuppressLint
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.*
import com.tezov.lib_core_android_kotlin.ui.compositionTree.activity.Activity
import com.tezov.lib_core_android_kotlin.ui.compositionTree.activity.Activity.Companion.LocalActivity
import com.tezov.lib_core_android_kotlin.ui.compositionTree.activity.Activity.Companion.LocalPagesBundle
import com.tezov.lib_core_android_kotlin.ui.compositionTree.base.Composition
import com.tezov.lib_core_android_kotlin.ui.compositionTree.modal.Modal
import com.tezov.lib_core_android_kotlin.ui.di.accessor.DiAccessor
import com.tezov.lib_core_kotlin.extension.ExtensionBoolean.isFalseOrNull
import com.tezov.lib_core_kotlin.extension.ExtensionCollection.push

interface Page<S : PageState, A : PageAction<S>> : Composition<S, A>, DiAccessor.Key {

    override val diAccessorKeyId: Int
        get() = Page.hashCode()

    companion object {
        val LocalPageBundle: ProvidableCompositionLocal<Bundle> = staticCompositionLocalOf {
            error("not provided")
        }
        val LocalPage @Composable get() = LocalPageBundle.current
        val LocalModalsBundle @Composable get() =LocalPageBundle.current.modals

        data class Bundle(
            val current: Page<*, *>,
            val modals: ArrayDeque<Modal.Companion.Bundle> = ArrayDeque()
        )
    }

    @SuppressLint("RememberReturnType")
    @Composable
    operator fun invoke(innerPadding: PaddingValues) {
        val pages = LocalPagesBundle
        remember {
            val locals = Bundle(this)
            pages.push(locals)
        }
        pages.find { it.current == this@Page }?.let { bundle ->
            CompositionLocalProvider(
                Activity.LocalLevel provides 1,
                LocalPageBundle provides bundle,
            ) {
                val onBackPressedState = remember {
                    mutableStateOf(false)
                }
                BackHandler(true) {
                    onBackPressedState.value = true
                }
                onBackPressedDispatch(onBackPressedState)
                lifeCycleAware()
                content(innerPadding = innerPadding)
            }
        }
        DisposableEffect(Unit) {
            onDispose {
                pages.find { it.current == this@Page }?.also { pages.remove(it) }
            }
        }
    }

    @Composable
    fun Page<S, A>.content(innerPadding: PaddingValues)

    @SuppressLint("UnrememberedMutableState")
    @Composable
    fun onBackPressedDispatch() = onBackPressedDispatch(mutableStateOf(true))

    @Composable
    private fun onBackPressedDispatch(onBackPressedState: MutableState<Boolean>): Boolean {
        if (!onBackPressedState.value) {
            return false
        }
        var handled = false
        if (LocalModalsBundle.lastOrNull()?.current?.onBackPressedDispatch().isFalseOrNull()
            && !this.handleOnBackPressed()
        ) {
            handled = LocalActivity.current.onBackPressedDispatch()
        }
        onBackPressedState.value = false
        return handled
    }

    @Composable
    fun handleOnBackPressed() = false


}
