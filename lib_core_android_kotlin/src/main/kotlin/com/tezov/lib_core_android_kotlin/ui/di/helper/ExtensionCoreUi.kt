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

package com.tezov.lib_core_android_kotlin.ui.di.helper

import androidx.compose.runtime.Composable
import com.tezov.lib_core_android_kotlin.ui.compositionTree.base.Composition
import com.tezov.lib_core_android_kotlin.ui.compositionTree.base.CompositionAction
import com.tezov.lib_core_android_kotlin.ui.compositionTree.base.CompositionState
import com.tezov.lib_core_android_kotlin.ui.di.component.ComponentContextLazy
import com.tezov.lib_core_android_kotlin.ui.di.component.ComponentContextMap
import com.tezov.lib_core_android_kotlin.ui.di.component.ComponentLazy

object ExtensionCoreUi {

    @Suppress("UNCHECKED_CAST")
    @Composable
    inline fun <reified C : Composition<S, A>, S : CompositionState, A : CompositionAction<S>> ComponentContextMap.with(): ComponentContextLazy<S, A> =
        lazyMap()[C::class.java] as? ComponentContextLazy<S, A>
            ?: throw Exception("context not found in map")

    @Composable
    fun <S : CompositionState> ComponentContextLazy<S, *>.state() = this.lazyState().get()

    @Composable
    fun <A : CompositionAction<out CompositionState>> ComponentContextLazy<*, A>.action() =
        this.lazyAction().get()

    @Composable
    fun ComponentContextLazy<*, *>.wakeUp() {
        this.lazyState().get()
        this.lazyAction().get()
    }

    @Composable
    fun ComponentContextMap.wakeUpSub() {
        val collection = lazyMap().values.iterator()
        while (collection.hasNext()) {
            collection.next().wakeUp()
        }
    }

    @Composable
    fun <T : Any> ComponentLazy<T>.ref() = this.lazy().get()

}