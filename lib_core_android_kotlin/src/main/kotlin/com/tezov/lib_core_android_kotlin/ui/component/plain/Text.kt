/*
 *  *********************************************************************************
 *  Created by Tezov on 15/04/2023 16:15
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 15/04/2023 16:00
 *  First project bank / bank.lib_core_android_kotlin.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */

package com.tezov.lib_core_android_kotlin.ui.component.plain

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextLayoutResult
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.sp
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitTextStateColor

object Text {

    object StateColor {

        @Composable
        operator fun invoke(
            modifier: Modifier = Modifier,
            style: OutfitTextStateColor? = null,
            overflow: TextOverflow = TextOverflow.Clip,
            softWrap: Boolean = true,
            maxLines: Int = Int.MAX_VALUE,
            onTextLayout: (TextLayoutResult) -> Unit = {},
            text: AnnotatedString,
            selector: Any? = null
        ) {
            Text(
                modifier = modifier,
                text = text,
                style = style?.resolve(selector) ?: kotlin.run {
                   TextStyle(
                       color = Color.Black,
                       fontSize = 14.sp,
                   )
                },
                overflow = overflow,
                softWrap = softWrap,
                maxLines = maxLines,
                onTextLayout = onTextLayout,
            )
        }

        @Composable
        operator fun invoke(
            modifier: Modifier = Modifier,
            style: OutfitTextStateColor? = null,
            overflow: TextOverflow = TextOverflow.Clip,
            softWrap: Boolean = true,
            maxLines: Int = Int.MAX_VALUE,
            onTextLayout: (TextLayoutResult) -> Unit = {},
            text: String,
            selector: Any? = null
        ) {
            invoke(
                modifier,
                style,
                overflow,
                softWrap,
                maxLines,
                onTextLayout,
                AnnotatedString(text),
                selector,
            )
        }

        @Composable
        operator fun invoke(
            modifier: Modifier = Modifier,
            style: OutfitTextStateColor? = null,
            overflow: TextOverflow = TextOverflow.Clip,
            softWrap: Boolean = true,
            maxLines: Int = Int.MAX_VALUE,
            onTextLayout: (TextLayoutResult) -> Unit = {},
            text: Int,
            selector: Any? = null
        ) {
            invoke(
                modifier,
                style,
                overflow,
                softWrap,
                maxLines,
                onTextLayout,
                stringResource(id = text),
                selector,
            )
        }

    }

}