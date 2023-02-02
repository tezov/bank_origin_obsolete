/*
 *  *********************************************************************************
 *  Created by Tezov on 02/02/2023 22:16
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 02/02/2023 22:16
 *  First project bank / bank.app.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */

package com.tezov.bank.ui.component.leaf

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.tezov.bank.R
import com.tezov.lib_core_android_kotlin.ui.theme.definition.*

infix fun ActionRow.provides(value: ActionRow.Style) = local provides value

object ActionRow {

    internal val local: ProvidableCompositionLocal<Style> = staticCompositionLocalOf {
        error("not provided")
    }

    @Immutable
    data class Style(
        val colorIconInfo: Color = Color.Transparent,
        val dimensionIconInfo: Dp = 0.dp,
        val textStyleContent: TextStyle,
        val colorIconAction: Color = Color.Black,
        val dimensionIconAction: Dp = 24.dp,
    )

    data class Data(
        val iconInfoResourceId: Int? = null,
        val title: String,
        val iconActionResourceId: Int = R.drawable.ic_arrow_cut_right_24dp,
    )

    @Composable
    operator fun invoke(
        data: Data,
        onClick: () -> Unit
    ) {
        Content(data, onClick)
    }

    @Composable
    private fun Content(
        data: Data,
        onClick: () -> Unit
    ) {
        val style = local.current
        Row(
            modifier = Modifier
                .clickable { onClick() }
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(
                    vertical = MaterialTheme.dimensionsPaddingExtended.blockNormal_v,
                    horizontal = MaterialTheme.dimensionsPaddingExtended.blockNormal_h
                ),
            verticalAlignment = Alignment.CenterVertically
        ) {
            data.iconInfoResourceId?.let {
                Icon(
                    modifier = Modifier
                        .size(style.dimensionIconInfo),
                    painter = painterResource(id = it),
                    tint = style.colorIconInfo,
                    contentDescription = null,
                )
            }
            Spacer(modifier = Modifier.width(MaterialTheme.dimensionsSpacingExtended.normal_h))
            Text(
                modifier = Modifier
                    .wrapContentHeight()
                    .weight(1f),
                text = data.title,
                style = style.textStyleContent
            )
            Icon(
                modifier = Modifier
                    .size(style.dimensionIconAction),
                painter = painterResource(id = data.iconActionResourceId),
                tint = style.colorIconAction,
                contentDescription = data.title,
            )
        }
    }
}