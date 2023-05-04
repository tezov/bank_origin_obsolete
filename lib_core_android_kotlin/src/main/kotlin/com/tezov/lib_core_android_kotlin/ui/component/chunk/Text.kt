/*
 *  *********************************************************************************
 *  Created by Tezov on 04/05/2023 20:17
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 04/05/2023 19:44
 *  First project bank / bank.lib_core_android_kotlin.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */

package com.tezov.lib_core_android_kotlin.ui.component.chunk

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
import com.tezov.lib_core_android_kotlin.ui.theme.theme.ThemeColorsExtended

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
                    ThemeColorsExtended.Dummy.textStyle
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