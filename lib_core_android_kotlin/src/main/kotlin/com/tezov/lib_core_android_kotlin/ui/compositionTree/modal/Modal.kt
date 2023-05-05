/*
 *  *********************************************************************************
 *  Created by Tezov on 05/05/2023 23:33
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 05/05/2023 23:29
 *  First project bank / bank.lib_core_android_kotlin.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */

package com.tezov.lib_core_android_kotlin.ui.compositionTree.modal

import android.annotation.SuppressLint
import androidx.activity.compose.BackHandler
import androidx.annotation.CallSuper
import androidx.compose.runtime.*
import com.tezov.lib_core_android_kotlin.ui.common.Event
import com.tezov.lib_core_android_kotlin.ui.common.EventListener
import com.tezov.lib_core_android_kotlin.ui.compositionTree.activity.Activity
import com.tezov.lib_core_android_kotlin.ui.compositionTree.base.Composition
import com.tezov.lib_core_android_kotlin.ui.compositionTree.page.Page.Companion.LocalModalsBundle
import com.tezov.lib_core_android_kotlin.ui.di.accessor.DiAccessor
import com.tezov.lib_core_kotlin.extension.ExtensionCollection.push

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
            val scope: Scope? = null,
        ) {
            internal val eventListener by lazy { ArrayList<EventListener>() }
        }

        class Scope {
            var actionOnShowed: (@Composable (modal: Modal<*, *>) -> Unit)? = null
            var actionOnClosed: (@Composable (modal: Modal<*, *>) -> Unit)? = null

            fun onShowed(action: @Composable (modal: Modal<*, *>) -> Unit) {
                actionOnShowed = action
            }

            fun onClosed(action: @Composable (modal: Modal<*, *>) -> Unit) {
                actionOnClosed = action
            }
        }

    }

    @Composable
    fun registerListener(listener: EventListener) {
        LocalModalBundle.current.eventListener.add(listener)
    }

    @Composable
    fun unregisterListener(listener: EventListener) {
        LocalModalBundle.current.eventListener.remove(listener)
    }

    @Composable
    fun notify(event: Event?) {
        val iterator = LocalModalBundle.current.eventListener.iterator()
        while (iterator.hasNext()) {
            val next = iterator.next()
            next.notify(event = event)
            if (!next.isValid) {
                iterator.remove()
            }
        }
    }

    @SuppressLint("RememberReturnType")
    @Composable
    operator fun invoke(scope: (Scope.() -> Unit)? = null) {
        val modals = LocalModalsBundle
        remember {
            val locals = Bundle(
                this,
                scope?.let { Scope().apply { it.invoke(this) } }
            )
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

    @CallSuper
    @Composable
    override fun onShow() {
        super.onShow()
        LocalModal.scope?.actionOnShowed?.invoke(this)
    }

    @CallSuper
    @Composable
    override fun onHide() {
        LocalModal.scope?.actionOnClosed?.invoke(this)
        super.onHide()
    }

}