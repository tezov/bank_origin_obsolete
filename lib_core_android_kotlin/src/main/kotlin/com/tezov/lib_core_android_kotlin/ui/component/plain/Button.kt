/*
 *  *********************************************************************************
 *  Created by Tezov on 13/03/2023 20:43
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 13/03/2023 20:43
 *  First project bank / bank.lib_core_android_kotlin.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */

package com.tezov.lib_core_android_kotlin.ui.component.plain

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import com.tezov.lib_core_android_kotlin.ui.theme.style.*

object Button {

    object TextFilled {

        open class Style<T, S : OutfitState.Selector, OT : OutfitState.Style<T, S>>(
            val outfitFrame: OutfitFrameState<T, S, OT>? = null,
            val outfitText: OutfitTextState<T, S, OT>? = null,
            val elevation: Dp? = null,
        ) {
            companion object {

                open class Builder<T, S : OutfitState.Selector, OT : OutfitState.Style<T, S>> internal constructor(
                    style: Style<T, S, OT>
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

                @Composable
                fun <T, S : OutfitState.Selector, OT : OutfitState.Style<T, S>> Style<T, S, OT>.copy(
                    builder: @Composable Builder<T, S, OT>.() -> Unit = {}
                ) = Builder(this).also {
                    it.builder()
                }.get()

            }

            constructor(style: Style<T, S, OT>) : this(
                outfitFrame = style.outfitFrame,
                outfitText = style.outfitText,
                elevation = style.elevation,
            )
        }

        @Composable
        operator fun <T, S : OutfitState.Selector, OT : OutfitState.Style<T, S>> invoke(
            enabled: Boolean = true,
            text: String,
            modifierButton: Modifier = Modifier,
            modifierText: Modifier = Modifier,
            selector: S,
            interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
            style: Style<T, S, OT> = Style(),
            contentPadding: PaddingValues = ButtonDefaults.ContentPadding,
            onClick: () -> Unit = {},
        ) {
            Button(
                modifier = modifierButton,
                enabled = enabled,
                interactionSource = interactionSource,
                elevation = style.elevation?.let { ButtonDefaults.elevation(it, it, it, it, it) },
                shape = style.outfitFrame?.outfitShape?.resolveOrDefault() ?: MaterialTheme.shapes.small,
                border = style.outfitFrame?.outfitBorder?.resolve(selector),
                colors = style.outfitFrame?.outfitShape.outfitColor.buttonColorsOrDefault(),
                contentPadding = contentPadding,
                onClick = onClick,
            ) {
                Text.State(
                    text = text,
                    style = style.outfitText,
                    modifier = modifierText,
                    enabled = enabled,
                )
            }
        }

    }

    object TextOutlined {

        open class Style(
            val outfitFrame: OutfitFrameState = OutfitFrameState(
                outfitShape = OutfitShapeState(
                    sketch = 8.outfitShapeSketch,
                ),
                outfitBorder = OutfitBorderState(
                    sketch = 1.outfitBorderSketch,
                    outfitColor = OutfitColorsState(
                        active = Color.Gray,
                        inactive = Color.Gray.copy(alpha = 0.25f),
                    )
                )
            ),
            val outfitText: OutfitTextState = OutfitTextState(),
            val elevation: Dp? = null,
        ) {
            companion object {

                open class Builder internal constructor(style: Style) {
                    var outfitFrame = style.outfitFrame
                    var outfitText = style.outfitText
                    var elevation = style.elevation

                    internal fun get() = Style(
                        outfitFrame = outfitFrame,
                        outfitText = outfitText,
                        elevation = elevation,
                    )
                }

                @Composable
                fun Style.copy(builder: @Composable Builder.() -> Unit = {}) = Builder(this).also {
                    it.builder()
                }.get()

            }

            constructor(style: TextFilled.Style) : this(
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
            enabled: Boolean = true,
            interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
            style: Style = Style(),
            contentPadding: PaddingValues = ButtonDefaults.ContentPadding,
            onClick: () -> Unit = {},
        ) {
            OutlinedButton(
                modifier = modifierButton,
                enabled = enabled,
                interactionSource = interactionSource,
                elevation = style.elevation?.let { ButtonDefaults.elevation(it, it, it, it, it) },
                shape = style.outfitFrame.outfitShape.resolveOrDefault(),
                border = style.outfitFrame.outfitBorder.resolve(enabled),
                colors = style.outfitFrame.outfitShape.outfitColor.buttonColorsOrDefault(),
                contentPadding = contentPadding,
                onClick = onClick,
            ) {
                Text.State(
                    text = text,
                    style = style.outfitText,
                    modifier = modifierText,
                    enabled = enabled,
                )
            }
        }

    }

}