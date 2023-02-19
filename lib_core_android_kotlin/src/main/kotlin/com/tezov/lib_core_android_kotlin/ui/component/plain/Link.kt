/*
 *  *********************************************************************************
 *  Created by Tezov on 19/02/2023 03:45
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 19/02/2023 03:45
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
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp

object Link {

    object Underlined{

        @Immutable
        open class Style(
            val textStyle: TextStyle? = Default.textStyle,
        ){
            companion object{
                internal val Default = Style(
                    textStyle = null,
                )

                fun Style.copy(
                    textStyle: TextStyle? = null,
                ) = Style(
                    textStyle = textStyle ?: this.textStyle,
                )
            }

            constructor(style: Style) : this(
                textStyle = style.textStyle,
            )
        }

        @Composable
        operator fun invoke(
            text:String,
            modifier: Modifier = Modifier,
            style:Style = Style(),
            onClick: () -> Unit,
        ){
            ClickableText(
                modifier = modifier,
                text = AnnotatedString(text),
                style = style.textStyle ?: TextStyle()
            ) {
                onClick()
            }
        }

    }











}