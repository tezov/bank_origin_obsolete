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

package com.tezov.lib_core_android_kotlin.ui.component.chunk

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitState
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitText
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitTextStateColor
import com.tezov.lib_core_android_kotlin.ui.theme.theme.ThemeColorsExtended
import com.tezov.lib_core_kotlin.delegate.DelegateNullFallBack

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
            Text.Clickable(
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
                if (enabled) OutfitState.BiStable.Selector.Active else OutfitState.BiStable.Selector.Inactive,
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