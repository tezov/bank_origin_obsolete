/*
 *  *********************************************************************************
 *  Created by Tezov on 12/02/2023 22:23
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 12/02/2023 22:11
 *  First project bank / bank.app.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */

package com.tezov.bank.ui.component.leaf

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.ProvidableCompositionLocal
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.tezov.bank.R
import com.tezov.bank.ui.page.lobby.login.PageLoginTheme
import com.tezov.bank.ui.page.lobby.login.typographies
import com.tezov.lib_core_android_kotlin.ui.theme.definition.dimensionsPaddingExtended


infix fun CardButton.provides(value: CardButton.Style) = local provides value

object CardButton {

    internal val local: ProvidableCompositionLocal<Style> = staticCompositionLocalOf {
        Style()
    }

    enum class Template {
        Undefined,
        Button,
        Link,
    }

    @Immutable
    data class Style(
        val colorIconInfo: Color = Color.Black,
        val dimensionIconInfo: Dp = 24.dp,

        val typographyTitle: TextStyle = TextStyle(),
        val typographyText: TextStyle = TextStyle(),

        val typographyTag: TextStyle = TextStyle(),
        val shapeTag: Shape = RoundedCornerShape(4.dp),
        val borderTag: BorderStroke = BorderStroke(1.dp, Color.Black),
        val backgroundTag: Color = Color.Transparent,

        val typographyButton: TextStyle = TextStyle(),
        val shapeButton: Shape = RoundedCornerShape(12.dp),
        val borderButton: BorderStroke = BorderStroke(1.dp, Color.Gray),
        val backgroundButton: Color = Color.Transparent,

        val margin: PaddingValues = PaddingValues(horizontal = 4.dp),
        val shape: Shape = RoundedCornerShape(4.dp),
        val border: BorderStroke = BorderStroke(1.dp, Color.Black),
        val background: Color = Color.Transparent,
    )

    data class Data(
        var template: Template = Template.Undefined,
        val iconInfoResourceId: Int? = null,
        val tag: String? = null,
        val title: String,
        val text: String,
        val button: String,
    )


    @Composable
    operator fun invoke(
        modifier: Modifier = Modifier,
        data: Data,
        onClick: () -> Unit = {}
    ) {
        Content(modifier, data, onClick)
    }

    @Composable
    private fun Content(
        modifier: Modifier,
        data: Data,
        onClick: () -> Unit
    ) {
        val style = local.current
        when (data.template) {
            Template.Button, Template.Undefined -> {
                ContentButton(style, modifier, data, onClick)
            }
            Template.Link -> {
                ContentLink(style, modifier, data, onClick)
            }
        }

    }

    @Composable
    private fun ContentButton(
        style: Style,
        modifier: Modifier,
        data: Data,
        onClick: () -> Unit
    ) {
        Surface(
            modifier = modifier.padding(style.margin),
            shape = style.shape,
            border = style.border,
            color = style.background,
        ) {

            Row(modifier = Modifier.fillMaxWidth()) {
                Column(
                    modifier = Modifier
                        .weight(1f)
                        .padding(
                            horizontal = MaterialTheme.dimensionsPaddingExtended.elementNormal_h,
                            vertical = MaterialTheme.dimensionsPaddingExtended.elementNormal_v
                        )
                ) {
                    data.tag?.let {
                        Box(
                            modifier = Modifier
                                .background(style.backgroundTag)
                                .clip(style.shapeTag)
                                .padding(bottom = MaterialTheme.dimensionsPaddingExtended.textBig_v)
                                .border(style.borderTag, style.shapeTag)
                        ) {
                            Text(
                                modifier = Modifier.padding(
                                    vertical = MaterialTheme.dimensionsPaddingExtended.textSmall_v,
                                    horizontal = MaterialTheme.dimensionsPaddingExtended.textBig_h
                                ),
                                text = it,
                                style = style.typographyTag,
                            )
                        }
                    }
                    Text(
                        modifier = modifier.padding(bottom = MaterialTheme.dimensionsPaddingExtended.textBig_v),
                        text = data.title,
                        style = style.typographyTitle,
                        overflow = TextOverflow.Ellipsis
                    )
                    Text(
                        modifier = modifier.padding(bottom = MaterialTheme.dimensionsPaddingExtended.textBig_v),
                        text = data.text,
                        style = style.typographyText,
                    )
                    Button(
                        onClick = onClick,
                        shape = style.shapeButton,
                        border = style.borderButton,
                        colors = ButtonDefaults.buttonColors(
                            backgroundColor = style.backgroundButton
                        ),
                        enabled = true
                    ) {
                        Text(
                            data.button,
                            style = style.typographyButton,
                            modifier = Modifier
                                .padding(
                                    horizontal = MaterialTheme.dimensionsPaddingExtended.buttonSmall_h,
                                    vertical = MaterialTheme.dimensionsPaddingExtended.buttonSmall_v
                                )
                        )
                    }

                }
                data.iconInfoResourceId?.let {
                    Icon(
                        modifier = Modifier
                            .size(style.dimensionIconInfo)
                            .align(Alignment.Top),
                        painter = painterResource(id = it),
                        contentDescription = null,
                        tint = style.colorIconInfo
                    )
                }
            }


        }
    }

    @Composable
    private fun ContentLink(
        style: Style,
        modifier: Modifier,
        data: Data,
        onClick: () -> Unit
    ) {
        Surface(
            modifier = modifier.padding(style.margin),
            shape = style.shape,
            border = style.border,
            color = style.background,
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        horizontal = MaterialTheme.dimensionsPaddingExtended.elementNormal_h,
                        vertical = MaterialTheme.dimensionsPaddingExtended.elementNormal_v
                    )
            ) {
                data.tag?.let {
                    Box(
                        modifier = Modifier
                            .background(style.backgroundTag)
                            .clip(style.shapeTag)
                            .padding(bottom = MaterialTheme.dimensionsPaddingExtended.textBig_v)
                            .border(style.borderTag, style.shapeTag)
                    ) {
                        Text(
                            modifier = Modifier.padding(
                                vertical = MaterialTheme.dimensionsPaddingExtended.textSmall_v,
                                horizontal = MaterialTheme.dimensionsPaddingExtended.textBig_h
                            ),
                            text = it,
                            style = style.typographyTag,
                        )
                    }
                }
                Row(modifier = Modifier.fillMaxWidth()) {
                    data.iconInfoResourceId?.let {
                        Icon(
                            modifier = Modifier
                                .size(style.dimensionIconInfo)
                                .align(Alignment.Top),
                            painter = painterResource(id = it),
                            contentDescription = null,
                            tint = style.colorIconInfo
                        )
                    }
                    Text(
                        modifier = modifier.padding(bottom = MaterialTheme.dimensionsPaddingExtended.textBig_v),
                        text = data.title,
                        style = style.typographyTitle,
                    )
                }
                Text(
                    modifier = modifier.padding(bottom = MaterialTheme.dimensionsPaddingExtended.textBig_v),
                    text = data.text,
                    style = style.typographyText,
                )

                ClickableText(
                    text = AnnotatedString(data.button),
                    style = style.typographyButton,
                    modifier = Modifier
                        .padding(
                            horizontal = MaterialTheme.dimensionsPaddingExtended.buttonSmall_h,
                            vertical = MaterialTheme.dimensionsPaddingExtended.buttonSmall_v
                        )
                ) {
                    onClick()
                }

            }
        }
    }

}



