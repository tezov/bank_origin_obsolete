package com.tezov.lib_core_android_kotlin.ui.di.helper

import androidx.compose.runtime.Composable
import com.tezov.lib_core_android_kotlin.ui.di.component.*
import com.tezov.lib_core_android_kotlin.ui.compositionTree.base.Composition
import com.tezov.lib_core_android_kotlin.ui.compositionTree.base.CompositionAction
import com.tezov.lib_core_android_kotlin.ui.compositionTree.base.CompositionState

object ExtensionCoreUi {

    @Composable
    inline fun <reified C:Composition<S, A>, S:CompositionState, A:CompositionAction<S>> ComponentContextMap.with():ComponentContextLazy<S, A> =
        lazyMap()[C::class.java] as? ComponentContextLazy<S, A>
            ?: throw Exception("context not found in map")

    @Composable
    fun <S:CompositionState> ComponentContextLazy<S, *>.state() = this.lazyState().get()

    @Composable
    fun <A:CompositionAction<out CompositionState>> ComponentContextLazy<*, A>.action() =
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

}