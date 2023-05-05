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

package com.tezov.lib_core_android_kotlin.ui.compositionTree.modal

import android.annotation.SuppressLint
import androidx.activity.compose.BackHandler
import androidx.compose.runtime.*
import com.tezov.lib_core_android_kotlin.ui.common.Event
import com.tezov.lib_core_android_kotlin.ui.compositionTree.activity.Activity
import com.tezov.lib_core_android_kotlin.ui.compositionTree.base.Composition
import com.tezov.lib_core_android_kotlin.ui.compositionTree.page.Page
import com.tezov.lib_core_android_kotlin.ui.compositionTree.page.Page.Companion.LocalModalsBundle
import com.tezov.lib_core_android_kotlin.ui.di.accessor.DiAccessor
import com.tezov.lib_core_kotlin.extension.ExtensionCollection.push
import com.tezov.lib_core_kotlin.type.collection.ListEntry

interface Modal<S : ModalState, A : ModalAction<S>> : Composition<S, A>, DiAccessor.Key {

    override val diAccessorKeyId: Int
        get() = Modal.hashCode()

    companion object {
        val LocalModalBundle: ProvidableCompositionLocal<Bundle> = staticCompositionLocalOf {
            error("not provided")
        }
        val LocalModal @Composable get() = LocalModalBundle.current

        data class Bundle(
            val current: Modal<*, *>,
//            val eventListener: ListEntry<Event, @Composable () -> Unit> = ListEntry(),
        )

//        val LocalEventListener: ProvidableCompositionLocal<ListEntry<Event, @Composable () -> Unit>> =
//            compositionLocalOf {
//                error("not provided")
//            }

    }

    @SuppressLint("RememberReturnType")
    @Composable
    operator fun invoke() {
        val modals = LocalModalsBundle
        remember {
            val locals = Bundle(this)
            modals.push(locals)
        }
        modals.find { it.current == this@Modal }?.let { bundle ->
            CompositionLocalProvider(
                Activity.LocalLevel provides 2,
                LocalModalBundle provides bundle,
            ) {
                val onBackPressedState = remember {
                    mutableStateOf(false)
                }
                BackHandler(true) {
                    onBackPressedState.value = true
                }
                lifeCycleAware()
                content()
            }
        }
        DisposableEffect(Unit) {
            onDispose {
                modals.find { it.current == this@Modal }?.also { modals.remove(it) }
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