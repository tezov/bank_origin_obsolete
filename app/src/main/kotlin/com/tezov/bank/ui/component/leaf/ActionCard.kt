/*
 *  *********************************************************************************
 *  Created by Tezov on 04/02/2023 18:53
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 04/02/2023 18:37
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
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.Dimension
import com.tezov.lib_core_android_kotlin.ui.theme.definition.dimensionsPaddingExtended

infix fun ActionCard.Simple.provides(value: ActionCard.Simple.Style) = local provides value

object ActionCard {

    object Simple {
        internal val local: ProvidableCompositionLocal<Style> = staticCompositionLocalOf {
            Style()
        }

        enum class Template {
            IconTopEnd,
            IconEnd,
        }

        @Immutable
        data class Style(
            val shapeCard: Shape = RoundedCornerShape(8.dp),
            val borderCard: BorderStroke = BorderStroke(1.dp, Color.Black),
            val colorIcon: Color = Color.Black,
            val dimensionsIcon: Dp = 24.dp,
            val typography: TextStyle = TextStyle(),
            val background: Color = Color.Transparent,
        )

        data class Data(
            val title: String,
            val iconResourceId: Int,
        )

        @Composable
        operator fun invoke(
            modifier: Modifier = Modifier,
            template: Template = Template.IconTopEnd,
            data: Data,
            onClick: () -> Unit
        ) {
            Content(modifier, template, data, onClick)
        }

        @Composable
        private fun Content(
            modifier: Modifier,
            template: Template,
            data: Data,
            onClick: () -> Unit
        ) {
            val style = local.current
            when (template) {
                Template.IconTopEnd -> {
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
            val iconSize = style.dimensionsIcon
            val ID_ICON = "icon"
            val ID_TEXT = "text"
            val constraintSet = ConstraintSet {
                val refIcon = createRefFor(ID_ICON)
                val refText = createRefFor(ID_TEXT)
                constrain(refIcon) {
                    top.linkTo(parent.top)
                    end.linkTo(parent.end)
                    width = Dimension.value(iconSize)
                    height = Dimension.value(iconSize)
                }
                constrain(refText) {
                    top.linkTo(refIcon.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(refIcon.start)
                    bottom.linkTo(parent.bottom)
                    width = Dimension.fillToConstraints
                    height = Dimension.wrapContent
                }
            }
            ConstraintLayout(
                constraintSet = constraintSet,
                modifier = modifier
                    .fillMaxWidth()
                    .border(style.borderCard, style.shapeCard)
                    .clip(style.shapeCard)
                    .background(style.background)
                    .clickable {
                        onClick()
                    }
                    .padding(
                        vertical = MaterialTheme.dimensionsPaddingExtended.blockNormal_v,
                        horizontal = MaterialTheme.dimensionsPaddingExtended.blockNormal_h
                    ),
            ) {
                Icon(
                    modifier = Modifier.layoutId(ID_ICON),
                    painter = painterResource(id = data.iconResourceId),
                    tint = style.colorIcon,
                    contentDescription = data.title,
                )
                Text(
                    modifier = Modifier.layoutId(ID_TEXT),
                    text = data.title,
                    style = style.typography,
                    overflow = TextOverflow.Visible
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
                Text(
                    modifier = Modifier
                        .weight(1f)
                        .align(Alignment.Bottom),
                    text = data.title,
                    style = style.typography
                )
                Icon(
                    modifier = Modifier
                        .size(style.dimensionsIcon),
                    painter = painterResource(id = data.iconResourceId),
                    tint = style.colorIcon,
                    contentDescription = data.title,
                )
            }
        }

    }


}