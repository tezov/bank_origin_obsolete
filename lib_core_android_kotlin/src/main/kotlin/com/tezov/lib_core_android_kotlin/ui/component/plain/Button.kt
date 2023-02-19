/*
 *  *********************************************************************************
 *  Created by Tezov on 19/02/2023 18:23
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 19/02/2023 18:23
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
import androidx.compose.ui.unit.Dp
import com.tezov.lib_core_android_kotlin.ui.theme.style.*
import com.tezov.lib_core_android_kotlin.ui.theme.theme.shapesExtended

object Button {

    object TextFilled{

        @Immutable
        open class Style(
            val outfitFrame: OutfitFrameState = Default.outfitFrame,
            val outfitText: OutfitTextState = Default.outfitText,
            val elevation: Dp? = Default.elevation,
         ){
            companion object{
                internal val Default = Style(
                    outfitFrame = OutfitFrameState(
//                        border = OutfitBorderState.Transparent
                    ),
                    outfitText = OutfitTextState(),
                    elevation = null,
                )

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
                shape = style.outfitFrame.outfitShape.get() ?: MaterialTheme.shapesExtended.roundedCornerNormal,
                border =  style.outfitFrame.border.get(enabled),
                colors = style.outfitFrame.outfitShape.outfitColor.colorButton(),
                contentPadding = contentPadding,
                onClick = onClick,
            ) {
                Text(
                    text,
                    style = style.outfitText.text,
                    color = style.outfitText.outfitColor.resolve(enabled),
                    modifier = modifierText
                )
            }
        }

    }

    object TextOutlined{

        @Immutable
        open class Style(
            val outfitFrame: OutfitFrameState = Style.Default.outfitFrame,
            val outfitText: OutfitTextState = Style.Default.outfitText,
            val elevation: Dp? = Default.elevation,
        ){
            companion object{
                internal val Default = Style(
                    outfitFrame = OutfitFrameState(
                        outfitShape = OutfitShapeState.Transparent
                    ),
                    outfitText = OutfitTextState(),
                    elevation = null,
                )

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
                shape = style.outfitFrame.outfitShape.get() ?: MaterialTheme.shapesExtended.roundedCornerNormal,
                border = style.outfitFrame.border.get(enabled),
                colors = style.outfitFrame.outfitShape.outfitColor.colorButton(),
                contentPadding = contentPadding,
                onClick = onClick,
            ) {
                Text(
                    text,
                    style = style.outfitText.text,
                    color = style.outfitText.outfitColor.resolve(enabled),
                    modifier = modifierText
                )
            }
        }

    }

}