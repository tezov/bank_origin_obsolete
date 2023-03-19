/*
 *  *********************************************************************************
 *  Created by Tezov on 19/03/2023 12:48
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 19/03/2023 12:47
 *  First project bank / bank.lib_core_android_kotlin.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */
package com.tezov.lib_core_android_kotlin.ui.theme.style

import androidx.compose.runtime.Composable
import kotlin.reflect.KClass
import kotlin.reflect.full.isSubclassOf

//Simple
typealias OutfitStateSimple<T> = OutfitState.Simple.Style<T>
typealias OutfitStateDual<T> = OutfitState.Dual.Style<T>
typealias OutfitStateSemantic<T> = OutfitState.Semantic.Style<T>

object OutfitState {

    interface Style<out T:Any, in S:Any>{
        fun resolve(selector: S): T?
        fun <C : Any> resolve(selector: S, type: KClass<C>): C? = resolve(selector)
            ?.takeIf { it::class.isInstance(type) || it::class.isSubclassOf(type) }
            ?.let { it as C }
    }

    object Simple{

        object Selector

        open class Style<out T:Any>(
            val value: T? = null,
        ):OutfitState.Style<T, Selector> {

            companion object{

                open class Builder<T:Any> internal constructor(style: Style<T>) {
                    var value = style.value

                    internal fun get() = Style(
                        value = value,
                    )
                }

                @Composable
                fun <T:Any> Style<T>.copy(builder: @Composable Builder<T>.()->Unit = {}) = Builder(this).also {
                     it.builder()
                }.get()
            }

            constructor(style: Style<T>) : this(
                value = style.value,
            )

            override fun resolve(selector: Selector) = value

        }



    }

    object Dual{

        enum class Selector{
            Enabled, Disabled
        }

        open class Style<out T:Any>(
            val active: T? = null,
            val inactive: T? = null,
        ):OutfitState.Style<T, Selector> {

            companion object{

                open class Builder<T:Any> internal constructor(style: Style<T>) {
                    var active = style.active
                    var inactive = style.inactive

                    internal fun get() = Style(
                        active = active,
                        inactive = inactive,
                    )
                }

                @Composable
                fun <T:Any> Style<T>.copy(builder: @Composable Builder<T>.()->Unit = {}) = Builder(this).also {
                    it.builder()
                }.get()
            }

            constructor(style: Style<T>) : this(
                active = style.active,
                inactive = style.inactive,
            )

            override fun resolve(selector: Selector) = when(selector){
                Selector.Enabled -> active
                Selector.Disabled -> inactive
            }

        }

    }

    object Semantic{

        enum class Selector{
            Neutral, Info, Alert,Error, Success
        }

        open class Style<out T:Any>(
            val neutral: T? = null,
            val info: T? = null,
            val alert: T? = null,
            val error: T? = null,
            val success: T? = null,
        ):OutfitState.Style<T, Selector> {

            companion object{

                open class Builder<T:Any> internal constructor(style: Style<T>) {
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

                @Composable
                fun <T:Any> Style<T>.copy(builder: @Composable Builder<T>.()->Unit = {}) = Builder(this).also {
                    it.builder()
                }.get()
            }

            constructor(style: Style<T>) : this(
                neutral = style.neutral,
                info = style.info,
                alert = style.alert,
                error = style.error,
                success = style.success,
            )

            override fun resolve(selector: Selector) = when(selector){
                Selector.Neutral -> neutral
                Selector.Info -> info
                Selector.Alert -> alert
                Selector.Error -> error
                Selector.Success -> success
            }
        }



    }

}