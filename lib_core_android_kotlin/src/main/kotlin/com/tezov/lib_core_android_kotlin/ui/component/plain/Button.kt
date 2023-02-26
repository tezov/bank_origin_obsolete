/*
 *  *********************************************************************************
 *  Created by Tezov on 26/02/2023 12:51
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 26/02/2023 12:03
 *  First project bank / bank.lib_core_android_kotlin.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */

package com.tezov.lib_core_android_kotlin.ui.component.plain

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.tezov.lib_core_android_kotlin.ui.theme.style.*

object Button {

    object TextFilled{

        open class Style(
            val outfitFrame: OutfitFrameState = OutfitFrameState(
                outfitShape = OutfitShapeState(
                    size = CornerSize(8.dp),
                    outfitColor = OutfitColorsSimple(
                        active = Color.Gray,
                        inactive = Color.Gray.copy(alpha = 0.25f),
                    )
                )
            ),
            val outfitText: OutfitTextState = OutfitTextState(),
            val elevation: Dp? = null,
         ){
            companion object{

                fun Style.copy(
                    outfitFrame: OutfitFrameState? = null,
                    outfitText: OutfitTextState? = null,
                    elevation: Dp? = null,
                ) = Style(
                    outfitFrame = outfitFrame ?: this.outfitFrame,
                    outfitText = outfitText ?: this.outfitText,
                    elevation = elevation ?: this.elevation,
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
            text:String,
            modifierButton: Modifier = Modifier,
            modifierText: Modifier = Modifier,
            enabled: Boolean = true,
            interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
            style:Style = Style(),
            contentPadding: PaddingValues = ButtonDefaults.ContentPadding,
            onClick: () -> Unit,
        ){
            Button(
                modifier = modifierButton,
                enabled = enabled,
                interactionSource = interactionSource,
                elevation = style.elevation?.let { ButtonDefaults.elevation(it,it,it,it,it) },
                shape = style.outfitFrame.outfitShape.resolveOrDefault(),
                border =  style.outfitFrame.outfitBorder.resolve(enabled),
                colors = style.outfitFrame.outfitShape.outfitColor.colorButton(),
                contentPadding = contentPadding,
                onClick = onClick,
            ) {
                Text(
                    text,
                    style = style.outfitText.resolve(enabled),
                    modifier = modifierText
                )
            }
        }

    }

    object TextOutlined{

        open class Style(
            val outfitFrame: OutfitFrameState = OutfitFrameState(
                outfitShape = OutfitShapeState(
                    size = CornerSize(8.dp),
                    outfitColor = OutfitColorsSimple()
                ),
                outfitBorder = OutfitBorderState(
                    size = 1.dp,
                    outfitColor = OutfitColorsSimple(
                        active = Color.Gray,
                        inactive = Color.Gray.copy(alpha = 0.25f),
                    )
                )
            ),
            val outfitText: OutfitTextState = OutfitTextState(),
            val elevation: Dp? = null,
        ){
            companion object{

                fun Style.copy(
                    outfitFrame: OutfitFrameState? = null,
                    outfitText: OutfitTextState? = null,
                    elevation: Dp? = null,
                ) = Style(
                    outfitFrame = outfitFrame ?: this.outfitFrame,
                    outfitText = outfitText ?: this.outfitText,
                    elevation = elevation ?: this.elevation,
                )
            }

            constructor(style: TextFilled.Style) : this(
                outfitFrame = style.outfitFrame,
                outfitText = style.outfitText,
                elevation = style.elevation,
            )
        }

        @Composable
        operator fun invoke(
            text:String,
            modifierButton: Modifier = Modifier,
            modifierText: Modifier = Modifier,
            enabled: Boolean = true,
            interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
            style:Style = Style(),
            contentPadding: PaddingValues = ButtonDefaults.ContentPadding,
            onClick: () -> Unit,
        ){
            OutlinedButton(
                modifier = modifierButton,
                enabled = enabled,
                interactionSource = interactionSource,
                elevation = style.elevation?.let { ButtonDefaults.elevation(it,it,it,it,it) },
                shape = style.outfitFrame.outfitShape.resolveOrDefault(),
                border = style.outfitFrame.outfitBorder.resolve(enabled),
                colors = style.outfitFrame.outfitShape.outfitColor.colorButton(),
                contentPadding = contentPadding,
                onClick = onClick,
            ) {
                Text(
                    text,
                    style = style.outfitText.resolve(enabled),
                    modifier = modifierText
                )
            }
        }

    }

}