/*
 *  *********************************************************************************
 *  Created by Tezov on 04/02/2023 18:53
 *  Copyright (c) 2023 . All rights reserved.
 *  Last modified 04/02/2023 18:52
 *  First project bank / bank.app.main
 *  This file is private and it is not allowed to use it, copy it or modified it
 *  without the permission granted by the owner Tezov. For any request request,
 *  please send an email to tezov.app@gmail.com
 *  *********************************************************************************
 */

package com.tezov.bank.ui.component.branch

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
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
import com.tezov.bank.ui.component.leaf.ActionRow
import com.tezov.lib_core_android_kotlin.ui.theme.definition.dimensionsPaddingExtended
import com.tezov.lib_core_android_kotlin.ui.theme.definition.dimensionsSpacingExtended

infix fun SectionActionRow.provides(value: SectionActionRow.Style) = local provides value

object SectionActionRow {

    internal val local: ProvidableCompositionLocal<Style> = staticCompositionLocalOf {
        Style()
    }

    @Immutable
    data class Style(
        val colorIcon: Color = Color.Black,
        val dimensionIcon: Dp = 24.dp,
        val typographyHeader: TextStyle = TextStyle(),
        val colorBackgroundHeader: Color = Color.Transparent,
        val colorBackgroundBody: Color = Color.Transparent,
        val colorDivider: Color = Color.Gray,
        val dimensionDivider: Dp = 1.dp,
    )

    data class Data(
        val iconResourceId: Int? = null,
        val title: String? = null,
        val rows: List<ActionRow.Data>
    )

    @Composable
    operator fun invoke(
        modifier: Modifier = Modifier,
        data: Data,
        onClick: (Int) -> Unit
    ) {
        Content(modifier, data, onClick)
    }

    @Composable
    private fun Content(
        modifier: Modifier,
        data: Data,
        onClick: (Int) -> Unit
    ) {
        if (data.rows.isEmpty()) {
            return
        }
        val style = local.current
        Column(
            modifier = modifier
                .fillMaxWidth()
        ) {
            data.title?.let { text ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(style.colorBackgroundHeader)
                        .padding(vertical = MaterialTheme.dimensionsPaddingExtended.elementNormal_v),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Spacer(modifier = modifier.width(MaterialTheme.dimensionsPaddingExtended.elementNormal_h))
                    data.iconResourceId?.let {
                        Icon(
                            modifier = Modifier
                                .padding(end = MaterialTheme.dimensionsPaddingExtended.elementBig_h)
                                .size(style.dimensionIcon),
                            painter = painterResource(id = it),
                            tint = style.colorIcon,
                            contentDescription = text,
                        )
                    }
                    Text(
                        text = text,
                        style = style.typographyHeader
                    )
                }
            }
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(style.colorBackgroundBody)
                    .padding(vertical = MaterialTheme.dimensionsPaddingExtended.blockNormal_h),
                verticalArrangement = Arrangement.spacedBy(MaterialTheme.dimensionsSpacingExtended.small_h),
            ) {
                data.rows.forEachIndexed { index, row ->
                    ActionRow(data = row) {
                        onClick(index)
                    }
                    if (style.dimensionDivider > 0.dp && index != data.rows.lastIndex) {
                        Divider(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(start = MaterialTheme.dimensionsPaddingExtended.blockBig_h),
                            color = style.colorDivider,
                            thickness = style.dimensionDivider,
                        )
                    }
                }
            }
        }
    }

}