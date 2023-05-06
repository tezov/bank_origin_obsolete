/*
 *  *********************************************************************************
 *  Created by Tezov on 06/05/2023 14:54
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 06/05/2023 14:43
 *  First project bank / bank.lib_core_android_kotlin.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */

package com.tezov.lib_core_android_kotlin.ui.compositionTree.page

import android.annotation.SuppressLint
import android.util.Log
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.*
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.lifecycle.LifecycleEventObserver
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
        ){
            val modals by lazy{ ArrayDeque<Modal.Companion.Bundle>() }
        }
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

    @Composable
    private fun onBackPressedDispatch(onBackPressedState: MutableState<Boolean>) {
        if (!onBackPressedState.value) {
            return
        }
        if (LocalModalsBundle.lastOrNull()?.current?.onBackPressedDispatch().isFalseOrNull()
            && !this.handleOnBackPressed()
        ) {
            LocalActivity.current.onBackPressedDispatch()
        }
        onBackPressedState.value = false
    }

    @Composable
    fun handleOnBackPressed() = false


}
