/*
 *  *********************************************************************************
 *  Created by Tezov on 13/02/2023 21:35
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 13/02/2023 21:32
 *  First project bank / bank.app.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */

package com.tezov.bank.ui.component.leaf

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.ProvidableCompositionLocal
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.tezov.bank.R
import com.tezov.lib_core_android_kotlin.ui.theme.definition.dimensionsPaddingExtended
import com.tezov.lib_core_android_kotlin.ui.theme.definition.dimensionsSpacingExtended

object ActionRow {

    @Immutable
    data class Style(
        val colorIconInfo: Color = Color.Black,
        val dimensionIconInfo: Dp = 24.dp,
        val typography: TextStyle = TextStyle(),
        val colorIconAction: Color = Color.Black,
        val dimensionIconAction: Dp = 24.dp,
        val background: Color = Color.Transparent,
    )

    data class Data(
        val iconInfoResourceId: Int? = null,
        val title: String,
        val iconActionResourceId: Int = R.drawable.ic_arrow_cut_right_24dp,
    )

    @Composable
    operator fun invoke(
        modifier: Modifier = Modifier,
        style:Style,
        data: Data,
        onClick: () -> Unit = {}
    ) {
        Row(
            modifier = modifier
                .fillMaxWidth()
                .clickable { onClick() }
                .background(style.background)
                .padding(
                    vertical = MaterialTheme.dimensionsPaddingExtended.blockNormal_v,
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
                Spacer(modifier = Modifier.width(MaterialTheme.dimensionsSpacingExtended.normal_h))
            }
            Text(
                modifier = Modifier
                    .weight(1f),
                text = data.title,
                style = style.typography
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