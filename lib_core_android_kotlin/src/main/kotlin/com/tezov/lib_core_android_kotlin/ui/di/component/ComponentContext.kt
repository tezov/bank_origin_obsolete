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

package com.tezov.lib_core_android_kotlin.ui.di.component

import com.tezov.lib_core_android_kotlin.ui.compositionTree.base.Composition
import com.tezov.lib_core_android_kotlin.ui.compositionTree.base.CompositionAction
import com.tezov.lib_core_android_kotlin.ui.compositionTree.base.CompositionState
import com.tezov.lib_core_android_kotlin.ui.di.helper.ComposableHolder


interface ComponentLazy<T : Any> {

    fun lazy(): ComposableHolder<T>

    companion object {

        fun <T : Any> make(
            ref: ComposableHolder<T>,
        ): ComponentLazy<T> = object : ComponentLazy<T> {

            override fun lazy() = ref

        }
    }
}

interface ComponentContextLazy<S : CompositionState, A : CompositionAction<S>> {

    fun lazyState(): ComposableHolder<S>

    fun lazyAction(): ComposableHolder<A>

    fun dispose() = lazyState().dispose() or lazyAction().dispose()

    companion object {

        fun <S : CompositionState, A : CompositionAction<S>> make(
            state: ComposableHolder<S>,
            action: ComposableHolder<A>,
        ): ComponentContextLazy<S, A> = object : ComponentContextLazy<S, A> {

            override fun lazyState() = state

            override fun lazyAction() = action

        }
    }
}

interface ComponentContextMap {

    fun lazyMap(): Map<Class<out Composition<*, *>>, ComponentContextLazy<*, *>>

    fun dispose() = lazyMap().values.fold(false){ acc, value -> acc or value.dispose() }

        companion object {

        fun make(vararg pairs: Pair<Class<out Composition<*, *>>, ComponentContextLazy<*, *>>): ComponentContextMap =
            object : ComponentContextMap {
                override fun lazyMap() = pairs.toMap()
            }
    }

}

