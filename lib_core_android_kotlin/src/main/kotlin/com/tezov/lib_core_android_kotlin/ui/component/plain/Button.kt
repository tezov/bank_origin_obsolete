/*
 *  *********************************************************************************
 *  Created by Tezov on 04/04/2023 15:07
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 04/04/2023 15:07
 *  First project bank / bank.lib_core_android_kotlin.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */

package com.tezov.lib_core_android_kotlin.ui.component.plain

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.tezov.lib_core_android_kotlin.ui.theme.style.*
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitShape.asSize
import androidx.compose.ui.graphics.Color as ColorImport
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitFrame.StateColor.Style.Nucleus as FrameNucleus

object Button {

    object StateColor {

        class StyleBuilder internal constructor(
            style: Style
        ) {
            var outfitFrame = style.outfitFrame
            var outfitText = style.outfitText
            var elevation = style.elevation

            internal fun get() = Style(
                outfitFrame = outfitFrame,
                outfitText = outfitText,
                elevation = elevation,
            )
        }

        class Style(
            val outfitFrame: OutfitFrameStateColor = OutfitFrameStateColor(),
            val outfitText: OutfitTextStateColor = OutfitTextStateColor(),
            val elevation: Dp? = null,
        ) {

            object Nucleus {

                class Color(
                    val nucleusFrame: FrameNucleus.Color = FrameNucleus.Color(),
                    val nucleusText: OutfitState.Style<ColorImport> = OutfitStateEmpty(),
                )

                inline val FrameNucleus.Color.asButtonNucleus get() = Color(nucleusFrame = this)
                inline val OutfitState.Style<Color>.asButtonNucleus get() = Color(nucleusText = this)

                class Typography(
                    val nucleusText: TextStyle = TextStyle(),
                )

                inline val TextStyle.asButtonNucleus get() = Typography(nucleusText = this)

            }

            companion object {

                @Composable
                fun Style.copy(
                    builder: @Composable StyleBuilder.() -> Unit = {}
                ) = StyleBuilder(this).also {
                    it.builder()
                }.get()

            }

            constructor(style: Style) : this(
                outfitFrame = style.outfitFrame,
                outfitText = style.outfitText,
                elevation = style.elevation,
            )
        }

        @Composable
        operator fun invoke(
            text: String,
            modifierButton: Modifier = Modifier,
            modifierText: Modifier = Modifier,
            interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
            style: Style = Style(),
            contentPadding: PaddingValues = ButtonDefaults.ContentPadding,
            enabled: Boolean = true,
            selector: Any? = null,
            onClick: () -> Unit = {},
        ) {
            Button(
                modifier = modifierButton,
                interactionSource = interactionSource,
                elevation = style.elevation?.let { ButtonDefaults.elevation(it, it, it, it, it) },
                shape = style.outfitFrame.getShape() ?: MaterialTheme.shapes.small,
                border = style.outfitFrame.resolveBorder(selector),
                colors = style.outfitFrame.resolveColor(selector)?.let {
                    ButtonDefaults.buttonColors(
                        backgroundColor = it,
                        disabledBackgroundColor = it,
                    )
                } ?: ButtonDefaults.buttonColors(
                    backgroundColor = Color1.Transparent,
                    disabledBackgroundColor = Color1.Transparent,
                ),
                contentPadding = contentPadding,
                enabled = enabled,
                onClick = onClick,
            ) {
                Text.StateColor(
                    modifier = modifierText,
                    text = text,
                    style = style.outfitText,
                    selector = selector
                )
            }
        }

        @Composable
        operator fun invoke(
            text: String,
            modifierButton: Modifier = Modifier,
            modifierText: Modifier = Modifier,
            interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
            style: Style = Style(),
            contentPadding: PaddingValues = ButtonDefaults.ContentPadding,
            enabled: Boolean = true,
            onClick: () -> Unit = {},
        ) {
            invoke(
                text,
                modifierButton,
                modifierText,
                interactionSource,
                style,
                contentPadding,
                enabled,
                if (enabled) OutfitState.Dual.Selector.Enabled else OutfitState.Dual.Selector.Disabled,
                onClick
            )
        }

    }

}