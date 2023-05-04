/*
 *  *********************************************************************************
 *  Created by Tezov on 04/05/2023 20:17
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 04/05/2023 19:49
 *  First project bank / bank.lib_core_android_kotlin.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */

package com.tezov.lib_core_android_kotlin.ui.component.chunk

import androidx.compose.foundation.text.ClickableText
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.sp
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitState
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitState.Simple.Style.Companion.asStateSimple
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitText
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitText.StateColor.Style.Companion.copy
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitTextStateColor
import com.tezov.lib_core_android_kotlin.ui.theme.theme.ThemeColorsExtended
import com.tezov.lib_core_kotlin.delegate.DelegateNullFallBack
import androidx.compose.ui.graphics.Color as ColorImport

object Link {

    object StateColor {

        class StyleBuilder internal constructor(style: Style) {
            var outfitText = style.outfitText

            internal fun get() = Style(
                outfitText = outfitText,
            )
        }

        class Style(
            outfitText: OutfitText.StateColor.Style? = null,
        ) {

            val outfitText: OutfitTextStateColor by DelegateNullFallBack.Ref(
                outfitText,
                fallBackValue = {
                    ThemeColorsExtended.Dummy.outfitTextState
                })

            companion object {

                @Composable
                fun Style.copy(builder: @Composable StyleBuilder.() -> Unit = {}) =
                    StyleBuilder(this).also {
                        it.builder()
                    }.get()

            }

            constructor(style: Style) : this(
                outfitText = style.outfitText,
            )
        }

        @Composable
        operator fun invoke(
            modifier: Modifier = Modifier,
            style: Style = Style(),
            text: AnnotatedString,
            enabled: Boolean = true,
            selector: Any? = null,
            onClick: () -> Unit = {},
        ) {
            ClickableText(
                modifier = modifier,
                text = text,
                style = style.outfitText.resolve(selector),
            ) {
                if (enabled) {
                    onClick()
                }
            }
        }

        @Composable
        operator fun invoke(
            modifier: Modifier = Modifier,
            style: Style = Style(),
            text: String,
            enabled: Boolean = true,
            selector: Any? = null,
            onClick: () -> Unit = {},
        ) {
            invoke(
                modifier,
                style,
                AnnotatedString(text),
                enabled,
                selector,
                onClick
            )
        }

        @Composable
        operator fun invoke(
            modifier: Modifier = Modifier,
            style: Style = Style(),
            enabled: Boolean = true,
            text: Int,
            selector: Any? = null,
            onClick: () -> Unit = {},
        ) {
            invoke(
                modifier,
                style,
                stringResource(id = text),
                enabled,
                selector,
                onClick
            )
        }

//        *** selector dual shortcut

        @Composable
        operator fun invoke(
            modifier: Modifier = Modifier,
            style: Style = Style(),
            text: AnnotatedString,
            enabled: Boolean = true,
            onClick: () -> Unit = {},
        ) {
            invoke(
                modifier,
                style,
                text,
                enabled,
                if (enabled) OutfitState.BiStable.Selector.Enabled else OutfitState.BiStable.Selector.Disabled,
                onClick
            )
        }

        @Composable
        operator fun invoke(
            modifier: Modifier = Modifier,
            style: Style = Style(),
            text: String,
            enabled: Boolean = true,
            onClick: () -> Unit = {},
        ) {
            invoke(
                modifier,
                style,
                AnnotatedString(text),
                enabled,
                onClick
            )
        }

        @Composable
        operator fun invoke(
            modifier: Modifier = Modifier,
            style: Style = Style(),
            text: Int,
            enabled: Boolean = true,
            onClick: () -> Unit = {},
        ) {
            invoke(
                modifier,
                style,
                stringResource(id = text),
                enabled,
                onClick
            )
        }

    }

}