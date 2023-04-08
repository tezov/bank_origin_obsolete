/*
 *  *********************************************************************************
 *  Created by Tezov on 08/04/2023 14:32
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 08/04/2023 00:00
 *  First project bank / bank.lib_core_android_kotlin.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */
package com.tezov.lib_core_android_kotlin.ui.theme.style

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.tezov.lib_core_kotlin.delegate.DelegateNullFallBack
import com.tezov.lib_core_kotlin.extension.ExtensionCollection.firstNotNull
import com.tezov.lib_core_kotlin.type.collection.ListEntry
import java.time.format.TextStyle
import kotlin.reflect.KClass

typealias OutfitStateNull<T> = OutfitState.Null.Style<T>
typealias OutfitStateSimple<T> = OutfitState.Simple.Style<T>
typealias OutfitStateDual<T> = OutfitState.Dual.Style<T>
typealias OutfitStateSemantic<T> = OutfitState.Semantic.Style<T>

object OutfitState {

    interface Style<T : Any> : DelegateNullFallBack.Group<T> {

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

    object Null {

        class Style<T : Any> : OutfitState.Style<T> {

            companion object {

                @Composable
                fun <T : Any> Style<T>.copy() = this

            }

            override fun groupFallBackRefs() = emptyList<T>()

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
            )
        }

        class Style<T : Any>(
            val value: T,
        ) : OutfitState.Style<T> {

            override fun groupFallBackRefs() = listOf(value)

            companion object {

                @Composable
                fun <T : Any> Style<T>.copy(builder: @Composable StyleBuilder<T>.() -> Unit = {}) =
                    StyleBuilder(this).also {
                        it.builder()
                    }.get()

                inline val Color.asStateSimple: OutfitStateSimple<Color> get() = OutfitStateSimple(value = this)
                inline val TextStyle.asStateSimple: OutfitStateSimple<TextStyle> get() = OutfitStateSimple(value = this)
            }

            constructor(style: Style<T>) : this(
                value = style.value,
            )

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
            )
        }

        class Style<T : Any>(
            active: T? = null,
            inactive: T? = null,
        ) : OutfitState.Style<T> {

            override fun groupFallBackRefs() = listOf(active, inactive)

            val active: T by DelegateNullFallBack(active)
            val inactive: T by DelegateNullFallBack(inactive)

            init {
                groupFallBackRefs().firstNotNull()?.let {
                    groupLazyFallBackValue = { it }
                }
            }

            companion object {

                @Composable
                fun <T : Any> Style<T>.copy(builder: @Composable StyleBuilder<T>.() -> Unit = {}) =
                    StyleBuilder(this).also {
                        it.builder()
                    }.get()

                inline val Color.asStateDual: OutfitStateDual<Color> get() = OutfitStateDual(active = this)
                inline val TextStyle.asStateDual: OutfitStateDual<TextStyle> get() = OutfitStateDual(active = this)
            }

            constructor(style: Style<T>) : this(
                active = style.active,
                inactive = style.inactive,
            )

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
            )
        }

        class Style<T : Any>(
            neutral: T? = null,
            info: T? = null,
            alert: T? = null,
            success: T? = null,
            error: T? = null,
        ) : OutfitState.Style<T> {

            override fun groupFallBackRefs() = listOf(neutral, info, alert, success, error)

            val neutral: T by DelegateNullFallBack(neutral)
            val info: T by DelegateNullFallBack(info)
            val alert: T by DelegateNullFallBack(alert)
            val error: T by DelegateNullFallBack(error)
            val success: T by DelegateNullFallBack(success)

            init {
                groupFallBackRefs().firstNotNull()?.let {
                    groupLazyFallBackValue = { it }
                }
            }

            companion object {

                @Composable
                fun <T : Any> Style<T>.copy(builder: @Composable StyleBuilder<T>.() -> Unit = {}) =
                    StyleBuilder(this).also {
                        it.builder()
                    }.get()

                inline val Color.asStateSemantic: OutfitStateSemantic<Color> get() = OutfitStateSemantic(neutral = this)
                inline val TextStyle.asStateSemantic: OutfitStateSemantic<TextStyle> get() = OutfitStateSemantic(neutral = this)
            }

            constructor(style: Style<T>) : this(
                neutral = style.neutral,
                info = style.info,
                alert = style.alert,
                error = style.error,
                success = style.success,
            )

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