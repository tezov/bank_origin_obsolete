/*
 *  *********************************************************************************
 *  Created by Tezov on 02/04/2023 16:46
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 02/04/2023 16:09
 *  First project bank / bank.lib_core_android_kotlin.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */
package com.tezov.lib_core_android_kotlin.ui.theme.style

import androidx.compose.runtime.Composable
import com.tezov.lib_core_kotlin.delegate.DelegateNullFallBack
import kotlin.reflect.KClass

typealias OutfitStateEmpty<T> = OutfitState.Empty.Style<T>
typealias OutfitStateSimple<T> = OutfitState.Simple.Style<T>
typealias OutfitStateDual<T> = OutfitState.Dual.Style<T>
typealias OutfitStateSemantic<T> = OutfitState.Semantic.Style<T>

object OutfitState {

    interface Style<T : Any> : DelegateNullFallBack.Setter<T> {

        fun selectorType(): KClass<*>

        fun selectorDefault(): Any

        fun resolve(selector: Any? = null): T?

        fun isSelectorValid(selector: Any? = null) =
            selector != null && selector::class == selectorType()

        @Suppress("UNCHECKED_CAST")
        fun <S : Any> resolve(selector: Any? = null, doResolve: ((selector: S) -> T?)): T? =
            runCatching {
                (selector.takeIf { isSelectorValid(it) } ?: selectorDefault()) as S
            }.getOrNull()?.let(doResolve)

        @Suppress("UNCHECKED_CAST")
        fun <C : Any> resolve(selector: Any? = null, type: KClass<C>): C? =
            resolve(selector)?.let { runCatching { it as C }.getOrNull() }
    }

    object Empty {

        class Style<T : Any> : OutfitState.Style<T> {

            companion object {

                @Composable
                fun <T : Any> Style<T>.copy() = this

            }

            override fun refs() = emptyList<T>()

            override fun selectorType() = Unit::class

            override fun selectorDefault() = Unit

            override fun resolve(selector: Any?) = null

        }

    }

    object Simple {

        object Selector

        class StyleBuilder<T : Any> internal constructor(val style: Style<T>) {
            var value = style.value

            internal fun get() = Style(
                value = value,
            ).also {
                it.nullFallback = style.nullFallback
            }
        }

        class Style<T : Any>(
            value: T? = null,
        ) : OutfitState.Style<T> {

            override fun refs() = listOf(value)

            val value: T by DelegateNullFallBack(value)

            companion object {

                @Composable
                fun <T : Any> Style<T>.copy(builder: @Composable StyleBuilder<T>.() -> Unit = {}) =
                    StyleBuilder(this).also {
                        it.builder()
                    }.get()
            }

            constructor(style: Style<T>) : this(
                value = style.value,
            ) {
                nullFallback = style.nullFallback
            }

            override fun selectorType() = Selector::class

            override fun selectorDefault() = Selector

            override fun resolve(selector: Any?) = resolve<Selector>(selector) {
                value
            }

        }

    }

    object Dual {

        enum class Selector {
            Enabled, Disabled
        }

        class StyleBuilder<T : Any> internal constructor(val style: Style<T>) {
            var active = style.active
            var inactive = style.inactive

            internal fun get() = Style(
                active = active,
                inactive = inactive,
            ).also {
                it.nullFallback = style.nullFallback
            }
        }

        class Style<T : Any>(
            active: T? = null,
            inactive: T? = null,
        ) : OutfitState.Style<T> {

            override fun refs() = listOf(active, inactive)

            val active: T by DelegateNullFallBack(active)
            val inactive: T by DelegateNullFallBack(inactive)

            companion object {

                @Composable
                fun <T : Any> Style<T>.copy(builder: @Composable StyleBuilder<T>.() -> Unit = {}) =
                    StyleBuilder(this).also {
                        it.builder()
                    }.get()
            }

            constructor(style: Style<T>) : this(
                active = style.active,
                inactive = style.inactive,
            ) {
                nullFallback = style.nullFallback
            }

            override fun selectorType() = Selector::class

            override fun selectorDefault() = Selector.Enabled

            override fun resolve(selector: Any?) = resolve<Selector>(selector) {
                when (it) {
                    Selector.Enabled -> active
                    Selector.Disabled -> inactive
                }
            }

        }

    }

    object Semantic {

        enum class Selector {
            Neutral, Info, Alert, Error, Success
        }

        class StyleBuilder<T : Any> internal constructor(val style: Style<T>) {
            var neutral = style.neutral
            var info = style.info
            var alert = style.alert
            var error = style.error
            var success = style.success

            internal fun get() = Style(
                neutral = neutral,
                info = info,
                alert = alert,
                error = error,
                success = success,
            ).also {
                it.nullFallback = style.nullFallback
            }
        }

        class Style<T : Any>(
            neutral: T? = null,
            info: T? = null,
            alert: T? = null,
            error: T? = null,
            success: T? = null,
        ) : OutfitState.Style<T> {

            override fun refs() = listOf(neutral, info, alert, error, success)

            val neutral: T by DelegateNullFallBack(neutral)
            val info: T by DelegateNullFallBack(info)
            val alert: T by DelegateNullFallBack(alert)
            val error: T by DelegateNullFallBack(error)
            val success: T by DelegateNullFallBack(success)

            companion object {

                @Composable
                fun <T : Any> Style<T>.copy(builder: @Composable StyleBuilder<T>.() -> Unit = {}) =
                    StyleBuilder(this).also {
                        it.builder()
                    }.get()
            }

            constructor(style: Style<T>) : this(
                neutral = style.neutral,
                info = style.info,
                alert = style.alert,
                error = style.error,
                success = style.success,
            ) {
                nullFallback = style.nullFallback
            }

            override fun selectorType() = Selector::class

            override fun selectorDefault() = Selector.Neutral

            override fun resolve(selector: Any?) = resolve<Selector>(selector) {
                when (it) {
                    Selector.Neutral -> neutral
                    Selector.Info -> info
                    Selector.Alert -> alert
                    Selector.Error -> error
                    Selector.Success -> success
                }
            }
        }
    }

}