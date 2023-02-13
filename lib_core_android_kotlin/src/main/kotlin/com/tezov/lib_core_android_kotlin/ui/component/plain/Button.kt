/*
 *  *********************************************************************************
 *  Created by Tezov on 13/02/2023 21:35
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 13/02/2023 21:32
 *  First project bank / bank.lib_core_android_kotlin.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */

package com.tezov.lib_core_android_kotlin.ui.component.plain

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.tezov.lib_core_android_kotlin.ui.component.branch.KeyBoard
import com.tezov.lib_core_android_kotlin.ui.component.plain.Button.TextFill.copy

object Button {

    object TextFill{

        private val default = Style(
            textStyle = null,
            elevation = null,
            shape = null,
            border = null,
            borderColorActive = Color.Black,
            borderColorInactive = Color.Black.copy(alpha = 0.25f),
            textColorActive = Color.Black,
            textColorInactive = Color.Black.copy(alpha = 0.5f),
            backgroundColorActive = Color.Gray,
            backgroundColorInactive = Color.Gray.copy(alpha = 0.25f),
        )

        @Immutable
        open class Style(
            val textStyle: TextStyle? = default.textStyle,
            val elevation: Dp? = default.elevation,
            val shape: Shape? = default.shape,
            val border: Dp? = default.border,
            val borderColorActive: Color = default.borderColorActive,
            val borderColorInactive: Color = default.borderColorInactive,
            val textColorActive: Color = default.textColorActive,
            val textColorInactive: Color = default.textColorInactive,
            val backgroundColorActive: Color = default.backgroundColorActive,
            val backgroundColorInactive: Color = default.backgroundColorActive,
        ){
            constructor(style: Style) : this(
                textStyle = style.textStyle,
                elevation = style.elevation,
                shape = style.shape,
                border = style.border,
                borderColorActive = style.borderColorActive,
                borderColorInactive = style.borderColorInactive,
                textColorActive = style.textColorActive,
                textColorInactive = style.textColorInactive,
                backgroundColorActive = style.backgroundColorActive,
                backgroundColorInactive = style.backgroundColorInactive,
            )
        }

        fun Style.copy(
            textStyle: TextStyle? = null,
            elevation: Dp? = null,
            shape: Shape? = null,
            border: Dp? = null,
            borderColorActive: Color? = null,
            borderColorInactive: Color? = null,
            textColorActive: Color? = null,
            textColorInactive: Color? = null,
            backgroundColorActive: Color? = null,
            backgroundColorInactive: Color? = null,
        ) = Style(
            textStyle = textStyle ?: this.textStyle,
            elevation = elevation ?: this.elevation,
            shape = shape ?: this.shape,
            border = border ?: this.border,
            borderColorActive = borderColorActive ?: this.borderColorActive,
            borderColorInactive = borderColorInactive ?: this.borderColorInactive,
            textColorActive = textColorActive ?: this.textColorActive,
            textColorInactive = textColorInactive ?: this.textColorInactive,
            backgroundColorActive = backgroundColorActive ?: this.backgroundColorActive,
            backgroundColorInactive = backgroundColorInactive ?: this.backgroundColorInactive,
        )

        @Composable
        operator fun invoke(
            text:String,
            onClick: () -> Unit,
            modifierButton: Modifier = Modifier,
            modifierText: Modifier = Modifier,
            enabled: State<Boolean> = mutableStateOf(true),
            interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
            style:Style = Style(),
            contentPadding: PaddingValues = ButtonDefaults.ContentPadding,
        ){
            Button(
                onClick = onClick,
                modifier = modifierButton,
                enabled = enabled.value,
                interactionSource = interactionSource,
                elevation = style.elevation?.let { ButtonDefaults.elevation(it,it,it,it,it) },
                shape = style.shape ?: MaterialTheme.shapes.small,
                border =  style.border?.let {
                    BorderStroke(it, if(enabled.value) style.borderColorActive else style.borderColorInactive)
                },
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = style.backgroundColorActive,
                    disabledBackgroundColor = style.backgroundColorInactive,
                ),
                contentPadding = contentPadding,
            ) {
                Text(
                    text,
                    style = style.textStyle ?: TextStyle(),
                    color = if(enabled.value) style.textColorActive else style.textColorInactive,
                    modifier = modifierText
                )
            }

        }

    }

    object TextOutlined{

        private val default = Style(
            textStyle = null,
            elevation = null,
            shape = null,
            border = null,
            borderColorActive = Color.Black,
            borderColorInactive = Color.Black.copy(alpha = 0.25f),
            textColorActive = Color.Black,
            textColorInactive = Color.Black.copy(alpha = 0.5f),
        )

        @Immutable
        open class Style(
            val textStyle: TextStyle? = null,
            val elevation: Dp? = null,
            val shape: Shape? = null,
            val border: Dp? = null,
            val borderColorActive: Color = Color.Black,
            val borderColorInactive: Color = Color.Black.copy(alpha = 0.25f),
            val textColorActive: Color = Color.Black,
            val textColorInactive: Color = Color.Black.copy(alpha = 0.5f),
        ){
            constructor(style: Style) : this(
                textStyle = style.textStyle,
                elevation = style.elevation,
                shape = style.shape,
                border = style.border,
                borderColorActive = style.borderColorActive,
                borderColorInactive = style.borderColorInactive,
                textColorActive = style.textColorActive,
                textColorInactive = style.textColorInactive,
            )
        }

        fun Style.copy(
            textStyle: TextStyle? = null,
            elevation: Dp? = null,
            shape: Shape? = null,
            border: Dp? = null,
            borderColorActive: Color? = null,
            borderColorInactive: Color? = null,
            textColorActive: Color? = null,
            textColorInactive: Color? = null,
        ) = Style(
            textStyle = textStyle ?: this.textStyle,
            elevation = elevation ?: this.elevation,
            shape = shape ?: this.shape,
            border = border ?: this.border,
            borderColorActive = borderColorActive ?: this.borderColorActive,
            borderColorInactive = borderColorInactive ?: this.borderColorInactive,
            textColorActive = textColorActive ?: this.textColorActive,
            textColorInactive = textColorInactive ?: this.textColorInactive,
        )

        @Composable
        operator fun invoke(
            text:String,
            onClick: () -> Unit,
            modifierButton: Modifier = Modifier,
            modifierText: Modifier = Modifier,
            enabled: State<Boolean> = mutableStateOf(true),
            interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
            style:Style = Style(),
            contentPadding: PaddingValues = ButtonDefaults.ContentPadding,
        ){
            OutlinedButton(
                onClick = onClick,
                modifier = modifierButton,
                enabled = enabled.value,
                interactionSource = interactionSource,
                elevation = style.elevation?.let { ButtonDefaults.elevation(it,it,it,it,it) },
                shape = style.shape ?: MaterialTheme.shapes.small,
                border = style.border?.let {
                    BorderStroke(it, if(enabled.value) style.borderColorActive else style.borderColorInactive)
                } ?: ButtonDefaults.outlinedBorder,
                colors = ButtonDefaults.outlinedButtonColors(
                    backgroundColor = Color.Transparent,
                ),
                contentPadding = contentPadding,
            ) {
                Text(
                    text,
                    style = style.textStyle ?: TextStyle(),
                    color = if(enabled.value) style.textColorActive else style.textColorInactive,
                    modifier = modifierText
                )
            }

        }

    }







}