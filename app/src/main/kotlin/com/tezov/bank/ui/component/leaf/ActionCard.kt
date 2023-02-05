/*
 *  *********************************************************************************
 *  Created by Tezov on 05/02/2023 01:03
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 05/02/2023 01:01
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
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.tezov.lib_core_android_kotlin.ui.theme.definition.dimensionsPaddingExtended

infix fun ActionCard.provides(value: ActionCard.Style) = local provides value

object ActionCard {

    internal val local: ProvidableCompositionLocal<Style> = staticCompositionLocalOf {
        Style()
    }

    enum class Template {
        Undefined,
        IconTopEnd,
        IconEnd,
    }

    @Immutable
    data class Style(
        val shapeCard: Shape = RoundedCornerShape(8.dp),
        val borderCard: BorderStroke = BorderStroke(1.dp, Color.Black),
        val colorIcon: Color = Color.Black,
        val dimensionsIcon: Dp = 24.dp,
        val typographyTitle: TextStyle = TextStyle(),
        val typographySubtitle: TextStyle = TextStyle(),
        val background: Color = Color.Transparent,
    )

    data class Data(
        var template: Template = Template.Undefined,
        val title: String,
        val subtitle: String? = null,
        val iconResourceId: Int,
    )

    @Composable
    operator fun invoke(
        modifier: Modifier = Modifier,
        data: Data,
        onClick: () -> Unit
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
            Template.IconTopEnd, Template.Undefined  -> {
                ContentIconTopEnd(style, modifier, data, onClick)
            }
            Template.IconEnd -> {
                ContentIconEnd(style, modifier, data, onClick)
            }
        }
    }

    @Composable
    private fun ContentIconTopEnd(
        style: Style,
        modifier: Modifier,
        data: Data,
        onClick: () -> Unit
    ) {
        Row(
            modifier = modifier
                .border(style.borderCard, style.shapeCard)
                .clip(style.shapeCard)
                .background(style.background)
                .clickable {
                    onClick()
                }
                .padding(
                    vertical = MaterialTheme.dimensionsPaddingExtended.blockNormal_v,
                    horizontal = MaterialTheme.dimensionsPaddingExtended.blockNormal_h
                )
        ) {
            Column(
                modifier = Modifier
                    .weight(1f)
                    .align(Alignment.CenterVertically)
            ) {
                Spacer(modifier = Modifier.height(style.dimensionsIcon))
                Text(
                    text = data.title,
                    style = style.typographyTitle,
                    overflow = TextOverflow.Visible
                )
                data.subtitle?.let {
                    Text(
                        text = it,
                        style = style.typographySubtitle,
                        overflow = TextOverflow.Visible
                    )
                }
            }
            Icon(
                modifier = Modifier
                    .size(style.dimensionsIcon),
                painter = painterResource(id = data.iconResourceId),
                tint = style.colorIcon,
                contentDescription = data.title,
            )
        }

    }

    @Composable
    private fun ContentIconEnd(
        style: Style,
        modifier: Modifier,
        data: Data,
        onClick: () -> Unit
    ) {
        Row(
            modifier = modifier
                .fillMaxWidth()
                .border(style.borderCard, style.shapeCard)
                .clip(style.shapeCard)
                .background(style.background)
                .clickable { onClick() }
                .padding(
                    vertical = MaterialTheme.dimensionsPaddingExtended.blockNormal_v,
                    horizontal = MaterialTheme.dimensionsPaddingExtended.blockNormal_h
                ),
        ) {
            Column(
                modifier = Modifier
                    .align(Alignment.Bottom)
                    .weight(1f)
            ) {
                Text(
                    text = data.title,
                    style = style.typographyTitle
                )
                data.subtitle?.let {
                    Text(
                        text = it,
                        style = style.typographyTitle
                    )
                }
            }
            Icon(
                modifier = Modifier
                    .size(style.dimensionsIcon)
                    .align(Alignment.CenterVertically),
                painter = painterResource(id = data.iconResourceId),
                tint = style.colorIcon,
                contentDescription = data.title,
            )
        }
    }


}