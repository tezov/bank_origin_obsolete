/*
 *  *********************************************************************************
 *  Created by Tezov on 08/02/2023 21:11
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 08/02/2023 20:19
 *  First project bank / bank.lib_core_android_kotlin.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */

package com.tezov.lib_core_android_kotlin.ui.di.component

import com.tezov.lib_core_android_kotlin.ui.di.helper.ComposableHolder
import com.tezov.lib_core_android_kotlin.ui.compositionTree.base.Composition
import com.tezov.lib_core_android_kotlin.ui.compositionTree.base.CompositionAction
import com.tezov.lib_core_android_kotlin.ui.compositionTree.base.CompositionState


interface ComponentLazy<T:Any> {

    fun lazy():ComposableHolder<T>

    companion object {

        fun <T:Any> make(
            ref:ComposableHolder<T>,
        ):ComponentLazy<T> = object:ComponentLazy<T> {

            override fun lazy() = ref

        }
    }
}

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

