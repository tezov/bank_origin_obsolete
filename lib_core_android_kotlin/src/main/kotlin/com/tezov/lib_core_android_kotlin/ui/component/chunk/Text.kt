/*
 *  ********************************************************************************
 *  Created by Tezov under MIT LICENCE.
 *  For any request, please send me an email to tezov.app@gmail.com.
 *  I'll be glad to answer you if your request is sane :)
 *  ********************************************************************************
 *
 *
 */

/*
 *  ********************************************************************************
 *  Created by Tezov under MIT LICENCE.
 *  For any request, please send me an email to tezov.app@gmail.com.
 *  I'll be glad to answer you if your request is sane :)
 *  ********************************************************************************
 *
 *
 */

package com.tezov.lib_core_android_kotlin.ui.component.chunk

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicText
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextLayoutResult
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.tezov.lib_core_android_kotlin.ui.theme.style.OutfitTextStateColor
import com.tezov.lib_core_android_kotlin.ui.theme.style.padding
import com.tezov.lib_core_android_kotlin.ui.theme.theme.ThemeColorsExtended

object Text {

    object Clickable {

        @Composable
        operator fun invoke(
            text: AnnotatedString,
            modifier: Modifier = Modifier,
            style: TextStyle = TextStyle.Default,
            softWrap: Boolean = true,
            overflow: TextOverflow = TextOverflow.Clip,
            maxLines: Int = Int.MAX_VALUE,
            onTextLayout: (TextLayoutResult) -> Unit = {},
            onClick: (Int) -> Unit
        ) {
            val layoutResult = remember { mutableStateOf<TextLayoutResult?>(null) }
            val pressIndicator = Modifier.pointerInput(onClick) {
                detectTapGestures { pos ->
                    layoutResult.value?.let { layoutResult ->
                        onClick(layoutResult.getOffsetForPosition(pos))
                    }
                }
            }
            BasicText(
                text = text,
                modifier = modifier
                    .then(pressIndicator),
                style = style,
                softWrap = softWrap,
                overflow = overflow,
                maxLines = maxLines,
                onTextLayout = {
                    layoutResult.value = it
                    onTextLayout(it)
                }
            )
        }

    }

    object Button {

        @Composable
        operator fun invoke(
            onClick: () -> Unit,
            modifier: Modifier = Modifier,
            enabled: Boolean = true,
            interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
            elevation: ButtonElevation? = null,
            shape: Shape = MaterialTheme.shapes.small,
            border: BorderStroke? = null,
            colors: ButtonColors = ButtonDefaults.textButtonColors(),
            contentPadding: PaddingValues = ButtonDefaults.TextButtonContentPadding,
            content: @Composable RowScope.() -> Unit
        ) {
            androidx.compose.material.Button(
                onClick = onClick,
                modifier = modifier,
                enabled = enabled,
                interactionSource = interactionSource,
                elevation = elevation,
                shape = shape,
                border = border,
                colors = colors,
                contentPadding = contentPadding,
                content = content
            )
        }
    }

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