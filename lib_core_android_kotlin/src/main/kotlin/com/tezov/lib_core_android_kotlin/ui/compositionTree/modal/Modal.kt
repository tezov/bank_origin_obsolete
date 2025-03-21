/*
 *  ********************************************************************************
 *  Created by Tezov under MIT LICENCE.
 *  For any request, please send me an email to tezov.app@gmail.com.
 *  I'll be glad to answer you if your request is sane :)
 *  ********************************************************************************
 *
 *
 */

/*
 *  ********************************************************************************
 *  Created by Tezov under MIT LICENCE.
 *  For any request, please send me an email to tezov.app@gmail.com.
 *  I'll be glad to answer you if your request is sane :)
 *  ********************************************************************************
 *
 *
 */

package com.tezov.lib_core_android_kotlin.ui.compositionTree.modal

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.runtime.*
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
        )

    }

    @SuppressLint("RememberReturnType")
    @Composable
    fun invokeContent() {
        val modals = LocalModalsBundle
        remember {
            val locals = Bundle(
                this,
            )
            modals.push(locals)
        }
        modals.find { it.current == this@Modal }?.let { bundle ->
            CompositionLocalProvider(
                Activity.LocalLevel provides 2,
                LocalModalBundle provides bundle,
            ) {
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