/*
 *  *********************************************************************************
 *  Created by Tezov on 08/04/2023 21:07
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 08/04/2023 21:05
 *  First project bank / bank.lib_core_android_kotlin.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */

package com.tezov.lib_core_android_kotlin.ui.component.plain

import androidx.compose.material.LocalTextStyle
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextLayoutResult
import androidx.compose.ui.text.style.TextOverflow
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
                style = style?.resolve(selector) ?: LocalTextStyle.current,
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
                modifier = modifier,
                style = style,
                overflow = overflow,
                softWrap = softWrap,
                maxLines = maxLines,
                onTextLayout = onTextLayout,
                text = AnnotatedString(text),
                selector = selector,
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
            textResourceId: Int,
            selector: Any? = null
        ) {
            invoke(
                modifier = modifier,
                style = style,
                overflow = overflow,
                softWrap = softWrap,
                maxLines = maxLines,
                onTextLayout = onTextLayout,
                text = stringResource(id = textResourceId),
                selector = selector,
            )
        }

    }

}