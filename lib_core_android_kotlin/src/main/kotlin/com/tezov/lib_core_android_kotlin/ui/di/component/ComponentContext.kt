package com.tezov.lib_core_android_kotlin.ui.di.component

import com.tezov.lib_core_android_kotlin.ui.di.helper.ComposableHolder
import com.tezov.lib_core_android_kotlin.ui.compositionTree.base.Composition
import com.tezov.lib_core_android_kotlin.ui.compositionTree.base.CompositionAction
import com.tezov.lib_core_android_kotlin.ui.compositionTree.base.CompositionState

interface ComponentContextLazy<S:CompositionState, A:CompositionAction<S>> {

    fun lazyState():ComposableHolder<S>

    fun lazyAction():ComposableHolder<A>

    companion object {

        fun <S:CompositionState, A:CompositionAction<S>> make(
            state:ComposableHolder<S>,
            action:ComposableHolder<A>,
        ):ComponentContextLazy<S, A> = object:ComponentContextLazy<S, A> {

            override fun lazyState() = state

            override fun lazyAction() = action

        }
    }

}

interface ComponentContextMap {

    fun lazyMap():Map<Class<out Composition<*, *>>, ComponentContextLazy<*, *>>

    companion object {

        fun make(vararg pairs:Pair<Class<out Composition<*, *>>, ComponentContextLazy<*, *>>):ComponentContextMap =
            object:ComponentContextMap {
                override fun lazyMap() = pairs.toMap()
            }
    }

}

