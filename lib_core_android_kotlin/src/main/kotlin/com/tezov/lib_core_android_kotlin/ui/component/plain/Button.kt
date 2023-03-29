/*
 *  *********************************************************************************
 *  Created by Tezov on 29/03/2023 22:26
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 29/03/2023 22:26
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.tezov.lib_core_android_kotlin.ui.theme.style.*

object Button {

    object StateColor{

        class Style(
            val outfitFrame: OutfitFrame.StateColor = OutfitFrame.StateColor(),
            val outfitText: OutfitText.StateColor = OutfitText.StateColor(),
            val elevation: Dp? = null,
        ) {

            companion object {

                open class Builder internal constructor(
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

                @Composable
                fun Style.copy(
                    builder: @Composable Builder.() -> Unit = {}
                ) = Builder(this).also {
                    it.builder()
                }.get()

                val TextFilled
                    get() = Style(
                        outfitFrame = OutfitFrame.StateColor(
                            outfitShape = OutfitShape.StateColor(
                                size = 12.asOutfitShapeSize,
                                outfitState = OutfitStateDual(
                                    active = Color.Gray,
                                    inactive = Color.Gray.copy(alpha = 0.25f),
                                )
                            )
                        ),
                        outfitText = OutfitText.StateColor(
                            outfitState = OutfitStateDual(
                                active = Color.Black,
                                inactive = Color.Black.copy(alpha = 0.65f)
                            )
                        )
                    )

                val TextOutlined
                    get() = Style(
                        outfitFrame = OutfitFrame.StateColor(
                            outfitShape = OutfitShape.StateColor(
                                size = 12.asOutfitShapeSize,
                            ),
                            outfitBorder = OutfitBorder.StateColor(
                                size = 2.2.dp,
                                outfitState = OutfitStateDual(
                                    active = Color.Black,
                                    inactive = Color.Black.copy(alpha = 0.65f),
                                )
                            )
                        ),
                        outfitText = OutfitText.StateColor(
                            outfitState = OutfitStateDual(
                                active = Color.Black,
                                inactive = Color.Black.copy(alpha = 0.65f)
                            )
                        )
                    )

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
                    backgroundColor = Color.Transparent,
                    disabledBackgroundColor = Color.Transparent,
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