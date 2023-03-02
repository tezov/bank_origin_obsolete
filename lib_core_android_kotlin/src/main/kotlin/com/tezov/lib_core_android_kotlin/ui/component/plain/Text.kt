/*
 *  *********************************************************************************
 *  Created by Tezov on 02/03/2023 21:57
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 02/03/2023 21:57
 *  First project bank / bank.lib_core_android_kotlin.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */

package com.tezov.lib_core_android_kotlin.ui.component.plain

import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextLayoutResult
import androidx.compose.ui.text.style.TextOverflow
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitTextSimple
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitTextState

object Text {

    object Simple{

        @Composable
        operator fun invoke(
            modifier: Modifier = Modifier,
            style:OutfitTextSimple = OutfitTextSimple(),
            overflow: TextOverflow = TextOverflow.Clip,
            softWrap: Boolean = true,
            maxLines: Int = Int.MAX_VALUE,
            onTextLayout: (TextLayoutResult) -> Unit = {},
            text:AnnotatedString,
        ){
            Text(
                modifier = modifier,
                text = text,
                style = style.resolve(),
                overflow = overflow,
                softWrap = softWrap,
                maxLines = maxLines,
                onTextLayout = onTextLayout,
            )
        }

        @Composable
        operator fun invoke(
            modifier: Modifier = Modifier,
            style:OutfitTextSimple = OutfitTextSimple(),
            overflow: TextOverflow = TextOverflow.Clip,
            softWrap: Boolean = true,
            maxLines: Int = Int.MAX_VALUE,
            onTextLayout: (TextLayoutResult) -> Unit = {},
            textResourceId:Int,
        ){
            invoke(
                modifier = modifier,
                style = style,
                overflow = overflow,
                softWrap = softWrap,
                maxLines = maxLines,
                onTextLayout = onTextLayout,
                text = stringResource(id = textResourceId),
            )
        }

        @Composable
        operator fun invoke(
            modifier: Modifier = Modifier,
            style:OutfitTextSimple = OutfitTextSimple(),
            overflow: TextOverflow = TextOverflow.Clip,
            softWrap: Boolean = true,
            maxLines: Int = Int.MAX_VALUE,
            onTextLayout: (TextLayoutResult) -> Unit = {},
            text:String,
        ){
            Text(
                modifier = modifier,
                text = text,
                style = style.resolve(),
                overflow = overflow,
                softWrap = softWrap,
                maxLines = maxLines,
                onTextLayout = onTextLayout,
            )
        }

    }

    object State{

        @Composable
        operator fun invoke(
            modifier: Modifier = Modifier,
            style:OutfitTextState = OutfitTextState(),
            overflow: TextOverflow = TextOverflow.Clip,
            softWrap: Boolean = true,
            maxLines: Int = Int.MAX_VALUE,
            onTextLayout: (TextLayoutResult) -> Unit = {},
            text:AnnotatedString,
            enabled:Boolean,
        ){
            Text(
                modifier = modifier,
                text = text,
                style = style.resolve(enabled),
                overflow = overflow,
                softWrap = softWrap,
                maxLines = maxLines,
                onTextLayout = onTextLayout,
            )
        }

        @Composable
        operator fun invoke(
            modifier: Modifier = Modifier,
            style:OutfitTextState = OutfitTextState(),
            overflow: TextOverflow = TextOverflow.Clip,
            softWrap: Boolean = true,
            maxLines: Int = Int.MAX_VALUE,
            onTextLayout: (TextLayoutResult) -> Unit = {},
            textResourceId:Int,
            enabled:Boolean,
        ){
            invoke(
                modifier = modifier,
                style = style,
                overflow = overflow,
                softWrap = softWrap,
                maxLines = maxLines,
                onTextLayout = onTextLayout,
                text = stringResource(id = textResourceId),
                enabled = enabled,
            )
        }

        @Composable
        operator fun invoke(
            modifier: Modifier = Modifier,
            style:OutfitTextState = OutfitTextState(),
            overflow: TextOverflow = TextOverflow.Clip,
            softWrap: Boolean = true,
            maxLines: Int = Int.MAX_VALUE,
            onTextLayout: (TextLayoutResult) -> Unit = {},
            text:String,
            enabled:Boolean,
        ){
            Text(
                modifier = modifier,
                text = text,
                style = style.resolve(enabled),
                overflow = overflow,
                softWrap = softWrap,
                maxLines = maxLines,
                onTextLayout = onTextLayout,
            )
        }

    }

}